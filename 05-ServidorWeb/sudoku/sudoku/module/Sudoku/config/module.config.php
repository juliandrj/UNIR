<?php
return array (
		'controllers' => array (
				'invokables' => array (
						'Sudoku\Controller\Sudoku' => 'Sudoku\Controller\SudokuController' 
				) 
		),
		'router' => array (
				'routes' => array (
						'sudoku' => array (
								'type' => 'segment',
								'options' => array (
										'route' => '/sudoku[/:action][/:id]',
										'constraints' => array (
												'action' => '[a-zA-Z][a-zA-Z0-9_-]*',
												'id' => '[a-zA-Z][a-zA-Z0-9_-]*'
										),
										'defaults' => array (
												'controller' => 'Sudoku\Controller\Sudoku',
												'action' => 'index' 
										) 
								) 
						) 
				) 
		),
		'view_manager' => array (
				'template_path_stack' => array (
						'sudoku' => __DIR__ . '/../view' 
				),
				'strategies' => array(
						'ViewJsonStrategy'
				),
		) 
);