<?php
namespace Sudoku\Form;

use Zend\Form\Form;

class PartidaForm extends Form {
	
	public function __construct($name = null) {
		parent::__construct('sudoku');
		$this->add(array(
				'name' => 'partida',
				'type' => 'Text',
		));
	}
	
}