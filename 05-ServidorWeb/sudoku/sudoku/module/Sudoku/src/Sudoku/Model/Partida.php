<?php
namespace Sudoku\Model;

use Zend\InputFilter\InputFilter;
use Zend\InputFilter\InputFilterAwareInterface;
use Zend\InputFilter\InputFilterInterface;

class Partida implements InputFilterAwareInterface{
	public $id;
	public $maquina_id;
	public $partida;
	public $fecha;
	protected $inputFilter;
	public function exchangeArray($data) {
		$this->id = (! empty ( $data ['id'] )) ? $data ['id'] : null;
		$this->maquina_id= (! empty ( $data ['maquina_id'] )) ? $data ['maquina_id'] : null;
		$this->partida= (! empty ( $data ['partida'] )) ? $data ['partida'] : null;
		$this->fecha= (! empty ( $data ['fecha'] )) ? $data ['fecha'] : null;
	}
	public function setInputFilter(InputFilterInterface $inputFilter) {
		throw new \Exception("Not used");
	}
	public function getInputFilter() {
		if (!$this->inputFilter) {
			$inputFilter = new InputFilter();
			$inputFilter->add(array(
					'name'     => 'partida',
					'required' => true,
					'filters'  => array(),
					'validators' => array(),
			));
			$this->inputFilter = $inputFilter;
		}
		return $this->inputFilter;
	}
}
