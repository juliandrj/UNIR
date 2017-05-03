<!doctype html>
<html lang="es">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Calculadora</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style type="text/css">
		.btn {
			width: 100%;
		}
		input.form-control {
			height: 2.5em;
			font-size: 3em;
			font-weight: bold;
		}
	</style>
</head>
<body class="container">
	<header class="page-header">
		<h1>Calculadora <small>by Juli&aacute;n Rojas</small></h1>
	</header>
	<section>
		<div class="row">
			<div class="col-sm-offset-2 col-sm-8">
				<div class="jumbotron">
					<h1 data-bind="text: expresion"></h1>
				</div>
				<table class="table">
					<tbody>
						<tr>
							<td class="text-center"><button type="button" class="btn btn-default" data-bind="click: function() { $root.agregar('7'); }">7</button></td>
							<td class="text-center"><button type="button" class="btn btn-default" data-bind="click: function() { $root.agregar('8'); }">8</button></td>
							<td class="text-center"><button type="button" class="btn btn-default" data-bind="click: function() { $root.agregar('9'); }">9</button></td>
							<td class="text-center"><button type="button" class="btn btn-success" data-bind="click: function() { $root.agregar('+'); }"><i class="fa fa-plus" aria-hidden="true"></i></button></td>
							<td class="text-center"><button type="button" class="btn btn-success" data-bind="click: function() { $root.agregar('-'); }"><i class="fa fa-minus" aria-hidden="true"></i></button></td>
						</tr>
						<tr>
							<td class="text-center"><button type="button" class="btn btn-default" data-bind="click: function() { $root.agregar('4'); }">4</button></td>
							<td class="text-center"><button type="button" class="btn btn-default" data-bind="click: function() { $root.agregar('5'); }">5</button></td>
							<td class="text-center"><button type="button" class="btn btn-default" data-bind="click: function() { $root.agregar('6'); }">6</button></td>
							<td class="text-center"><button type="button" class="btn btn-success" data-bind="click: function() { $root.agregar('*'); }"><i class="fa fa-times" aria-hidden="true"></i></button></td>
							<td class="text-center"><button type="button" class="btn btn-success" data-bind="click: function() { $root.agregar('/'); }"><b>/</b></button></td>
						</tr>
						<tr>
							<td class="text-center"><button type="button" class="btn btn-default" data-bind="click: function() { $root.agregar('1'); }">1</button></td>
							<td class="text-center"><button type="button" class="btn btn-default" data-bind="click: function() { $root.agregar('2'); }">2</button></td>
							<td class="text-center"><button type="button" class="btn btn-default" data-bind="click: function() { $root.agregar('3'); }">3</button></td>
							<td class="text-center" colspan="2"><button type="button" class="btn btn-danger" data-bind="enable: totalizable, click: calcular"><b>=</b></button></td>
						</tr>
						<tr>
							<td class="text-center" colspan="3"><button type="button" class="btn btn-default" data-bind="disable: esDiv, click: function() { $root.agregar('0'); }">0</button></td>
							<td class="text-center" colspan="2"><button type="button" class="btn btn-warning" data-bind="click: limpiar"><i class="fa fa-trash" aria-hidden="true"></i></button></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</section>
	<footer>
		<div class="row">
			<div class="col-sm-offset-2 col-sm-8 text-center">
				<h4>UNIR - Plataformas de Desarrollo de Software - Caso pr&aacute;ctico 01</h4>
				<p>Profesora Nadia Gamez Gomez</p>
				<p>todos los derechos reservados | Bogot&aacute; - Colombia</p>
			</div>
		</div>
	</footer>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore-min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/knockout/3.4.2/knockout-min.js"></script>
	<script type="text/javascript" src="js/calculadora.js"></script>
</body>
</html>
