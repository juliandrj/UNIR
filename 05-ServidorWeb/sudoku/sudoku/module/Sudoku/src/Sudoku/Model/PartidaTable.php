<?php
namespace Sudoku\Model;

use Zend\Db\TableGateway\TableGateway;
use Zend\Db\Sql\Select;

class PartidaTable {
	protected $tableGateway;
	public function __construct(TableGateway $tableGateway) {
		$this->tableGateway = $tableGateway;
	}
	public function fetchAll() {
		$resultSet = $this->tableGateway->select ();
		return $resultSet;
	}
	public function getPartida($id) {
		$id = ( int ) $id;
		$rowset = $this->tableGateway->select ( array (
				'id' => $id
		) );
		$row = $rowset->current ();
		if (! $row) {
			throw new \Exception ( "Partida no encontrada: $id" );
		}
		return $row;
	}
	public function getPartidasXMaquina($maquina_id) {
		$select = new Select();
		$select->from('partida')->where('maquina_id = \'' . $maquina_id . '\'')->order('fecha desc');
		$resultSet = $this->tableGateway->selectWith($select);
		$retorno = array();
		foreach ($resultSet as $row) {
			$partida = new Partida();
			$partida->exchangeArray((array)$row);
			$retorno[] = $partida;
		}
		return $retorno;
	}
	public function savePartida(Partida $partida) {
		$data = array (
				'maquina_id' => $partida->maquina_id,
				'partida' => $partida->partida,
				'fecha' => $partida->fecha
		);
		
		$id = ( int ) $partida->id;
		if ($id == 0) {
			$this->tableGateway->insert ( $data );
		} else {
			if ($this->getPartida( $id )) {
				$this->tableGateway->update ( $data, array (
						'id' => $id
				) );
			} else {
				throw new \Exception ( 'Partida no registrada' );
			}
		}
	}
	public function deletePartida($id) {
		$this->tableGateway->delete ( array (
				'id' => ( int ) $id
		) );
	}
}
