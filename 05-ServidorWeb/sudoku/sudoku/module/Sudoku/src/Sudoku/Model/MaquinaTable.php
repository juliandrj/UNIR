<?php
namespace Sudoku\Model;

use Zend\Db\TableGateway\TableGateway;

class MaquinaTable {
	protected $tableGateway;
	public function __construct(TableGateway $tableGateway) {
		$this->tableGateway = $tableGateway;
	}
	public function fetchAll() {
		$resultSet = $this->tableGateway->select ();
		return $resultSet;
	}
	public function getMaquina($id) {
		$id = ( int ) $id;
		$rowset = $this->tableGateway->select ( array (
				'id' => $id 
		) );
		$row = $rowset->current ();
		if (! $row) {
			throw new \Exception ( "Maquina no encontrada: $id" );
		}
		return $row;
	}
	public function getMaquinaXCodigo($cod) {
		$rowset = $this->tableGateway->select ( array (
				'codigo_maquina' => $cod
		) );
		$row = $rowset->current ();
		if (! $row) {
			throw new \Exception ( "Maquina no encontrada: $cod" );
		}
		return $row;
	}
	public function saveMaquina(Maquina $maquina) {
		$data = array (
				'codigo_maquina' => $maquina->codigo_maquina
		);
		
		$id = ( int ) $maquina->id;
		if ($id == 0) {
			$this->tableGateway->insert ( $data );
		} else {
			if ($this->getMaquina ( $id )) {
				$this->tableGateway->update ( $data, array (
						'id' => $id 
				) );
			} else {
				throw new \Exception ( 'Maquina no registrada' );
			}
		}
	}
	public function deletePartida($id) {
		$this->tableGateway->delete ( array (
				'id' => ( int ) $id 
		) );
	}
}