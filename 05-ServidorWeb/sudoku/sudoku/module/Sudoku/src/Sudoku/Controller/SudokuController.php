<?php
namespace Sudoku\Controller;

use Zend\Mvc\Controller\AbstractActionController;
use Zend\Session\Container;
use Zend\View\Model\ViewModel;
use Zend\View\Model\JsonModel;
use Sudoku\Model\Maquina;
use Sudoku\Model\Partida;
use Sudoku\Form\PartidaForm;

class SudokuController extends AbstractActionController {
	
	protected $maquinaTable;
	protected $partidaTable;
	
	public function indexAction() {
		$maquina = null;
		if (isset($_COOKIE['sudoku_tp02'])) {
			try {
				$maquina = $this->getMaquinaTable()->getMaquinaXCodigo($_COOKIE["sudoku_tp02"]);
			} catch (\Exception $ex) {
				unset($_COOKIE['sudoku_tp02']);
			}
		}
		if ($maquina == null) {
			$maquina = new Maquina();
			$maquina->id = 0;
			$maquina->codigo_maquina = $this->generateRandomString();
			$this->getMaquinaTable()->saveMaquina($maquina);
			setcookie('sudoku_tp02', $maquina->codigo_maquina);
			$maquina = $this->getMaquinaTable()->getMaquinaXCodigo($maquina->codigo_maquina);
		}
		$container = new Container('namespace');
		$container->maquina = $maquina;
		return new ViewModel(array(
				'maquina' => $maquina,
		));
	}
	
	public function saveAction() {
		try {
			$container = new Container('namespace');
			$form = new PartidaForm();
			$request = $this->getRequest();
			if ($request->isPost()) {
				$partida = new Partida();
				$form->setInputFilter($partida->getInputFilter());
				$form->setData($request->getPost());
				if ($form->isValid()) {
					$partida->exchangeArray($form->getData());
					$partida->id = 0;
					$partida->maquina_id = $container->maquina->id;
					$partida->fecha = date('Y-m-d H:i:s');
					$this->getPartidaTable()->savePartida($partida);
					return new JsonModel(['status'=>'ok','mensaje'=>'partida almacenada']);
				} else {
					throw new \Exception ("Datos incorrectos");
				}
			} else {
				throw new \Exception ("Metodo de envio no valido");
			}
		} catch (\Exception $ex) {
			return new JsonModel(['status'=>'fail','mensaje'=>$ex->getMessage()]);
		}
	}
	
	public function listAction() {
		$container = new Container('namespace');
		$resulset = $this->getPartidaTable()->getPartidasXMaquina($container->maquina->id);
		//json_decode(json_encode($container->maquina), true)
		return new JsonModel(json_decode(json_encode($resulset), true));
	}
	
	public function getMaquinaTable() {
		if (!$this->maquinaTable) {
			$sm = $this->getServiceLocator();
			$this->maquinaTable = $sm->get('Sudoku\Model\MaquinaTable');
		}
		return $this->maquinaTable;
	}
	
	public function getPartidaTable() {
		if (!$this->partidaTable) {
			$sm = $this->getServiceLocator();
			$this->partidaTable = $sm->get('Sudoku\Model\PartidaTable');
		}
		return $this->partidaTable;
	}
	
	private function generateRandomString($length = 32) {
		$characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
		$charactersLength = strlen($characters);
		$randomString = '';
		for ($i = 0; $i < $length; $i++) {
			$randomString .= $characters[rand(0, $charactersLength - 1)];
		}
		return $randomString;
	}
	
}