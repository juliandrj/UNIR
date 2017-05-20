<?php
namespace Sudoku\Model;

class Maquina {
	public $id;
	public $codigo_maquina;
	public function exchangeArray($data) {
		$this->id = (! empty ( $data ['id'] )) ? $data ['id'] : null;
		$this->codigo_maquina = (! empty ( $data ['codigo_maquina'] )) ? $data ['codigo_maquina'] : null;
	}
}