<?php
namespace Sudoku;

use Zend\ModuleManager\Feature\AutoloaderProviderInterface;
use Zend\ModuleManager\Feature\ConfigProviderInterface;
use Sudoku\Model\Maquina;
use Sudoku\Model\MaquinaTable;
use Sudoku\Model\Partida;
use Sudoku\Model\PartidaTable;
use Zend\Db\ResultSet\ResultSet;
use Zend\Db\TableGateway\TableGateway;

class Module implements AutoloaderProviderInterface, ConfigProviderInterface {
	public function getAutoloaderConfig() {
		return array (
				'Zend\Loader\ClassMapAutoloader' => array (
						__DIR__ . '/autoload_classmap.php' 
				),
				'Zend\Loader\StandardAutoloader' => array (
						'namespaces' => array (
								__NAMESPACE__ => __DIR__ . '/src/' . __NAMESPACE__ 
						) 
				) 
		);
	}
	public function getConfig() {
		return include __DIR__ . '/config/module.config.php';
	}
	public function getServiceConfig() {
		return array (
				'factories' => array (
						'Sudoku\Model\MaquinaTable' => function ($sm) {
							$tableGateway = $sm->get ( 'MaquinaTableGateway' );
							$table = new MaquinaTable ( $tableGateway );
							return $table;
						},
						'MaquinaTableGateway' => function ($sm) {
							$dbAdapter = $sm->get ( 'Zend\Db\Adapter\Adapter' );
							$resultSetPrototype = new ResultSet ();
							$resultSetPrototype->setArrayObjectPrototype ( new Maquina () );
							return new TableGateway ( 'maquina', $dbAdapter, null, $resultSetPrototype );
						},
						'Sudoku\Model\PartidaTable' => function ($sm) {
							$tableGateway = $sm->get ( 'PartidaTableGateway' );
							$table = new PartidaTable ( $tableGateway );
							return $table;
						},
						'PartidaTableGateway' => function ($sm) {
							$dbAdapter = $sm->get ( 'Zend\Db\Adapter\Adapter' );
							$resultSetPrototype = new ResultSet ();
							$resultSetPrototype->setArrayObjectPrototype ( new Partida () );
							return new TableGateway ( 'partida', $dbAdapter, null, $resultSetPrototype );
						} 
				) 
		);
	}
}