<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Trabajo: Mi segunda p&aacute;gina web</title>

<!-- Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>
<body class="container">
	<header class="page-header">
		<div class="jumbotron">
			<div class="container">
				<h1>Trabajo: Mi segunda p&aacute;gina web.</h1>
				<h2>Computaci&oacute;n en el Servidor Web</h2>
				<h3>Juli&aacute;n David Rojas Jim&eacute;nez</h3>
			</div>
		</div>
	</header>
	<section>
		<h2>Matrices aleatorias de 4x4</h2>
<?php
$a = array();
$b = array();
for ($i = 0; $i < 4; $i++) {
	$a[] = array();
	$b[] = array();
	for ($j = 0; $j < 4; $j++) {
		$a[$i][] = rand(0, 10);
		$b[$i][] = rand(0, 10);
	}
}
function imprimirMatriz($m, $titulo) {
	echo '<table class="table table-bordered"><thead><tr><th class="text-center" colspan="' . count($m) . '">' . $titulo . '</th></tr></thead><tbody>';
	for ($i = 0; $i < count($m); $i ++) {
		echo '<tr' . ($i % 2 == 0 ? ' class="active"' : '') . '>';
		for ($j = 0; $j < count($m[$i]); $j ++) {
			echo '<td class="text-center">' . $m[$i][$j] . '</td>';
		}
		echo '</tr>';
	}
	echo '</tbody></table>';
}
?>
		<div class="row">
			<div class="col-xs-6"><?php imprimirMatriz($a, 'A');?></div>
			<div class="col-xs-6"><?php imprimirMatriz($b, 'B');?></div>
		</div>
	</section>
	<section>
		<h2>Suma de matrices</h2>
<?php
$c = array();
for ($i = 0; $i < 4; $i++) {
	$c[] = array();
	for ($j = 0; $j < 4; $j++) {
		$c[$i][] = $a[$i][$j] + $b[$i][$j];
	}
}
?>
		<div class="row">
			<div class="col-xs-12"><?php imprimirMatriz($c, 'A + B = C');?></div>
		</div>
	</section>
	<section>
		<h2>Multiplicaci&oacute;n de matrices</h2>
<?php
$d = array();
for ($i = 0; $i < 4; $i++) {
	$d[] = array();
	for ($j = 0; $j < 4; $j++) {
		$x = 0;
		for ($k = 0; $k < 4; $k++) {
			$x += $a[$i][$k] * $b[$k][$j];
		}
		$d[$i][] = $x;
	}
}
?>
		<div class="row">
			<div class="col-xs-12"><?php imprimirMatriz($d, 'A * B = D');?></div>
		</div>
	</section>
	<hr>
	<section>
		<h2>Manejo de texto</h2>
<?php
$lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec condimentum nisl ut lorem dignissim fringilla interdum vel sapien. Morbi turpis libero, pretium tempor tellus quis, convallis gravida libero. Proin facilisis libero ut magna tincidunt, quis imperdiet eros porta. Nunc nisl orci, dignissim quis viverra id, sagittis sed ante. Aliquam erat volutpat. Nullam at augue convallis, mollis sem eu, tincidunt nunc. Morbi pulvinar posuere justo et fringilla.";
$cadena = str_repeat(chr(rand(ord('a'), ord('z'))), rand(3, 9));
$buscar = chr(rand(ord('a'), ord('z')));
$newLorem = str_replace($buscar, '<b class="text-danger">' . $cadena . '</b>', $lorem);
?>
		<h3>Cambiar todas las <b class="text-success"><?php echo $buscar;?></b> en el primer texto y reemplazar por <b class="text-danger"><?php echo $cadena;?></b></h3>
		<div class="well">
			<h4>Original</h4>
			<p><?php echo $lorem;?></p>
		</div>
		<div class="well">
			<h4>Modificado</h4>
			<p><?php echo $newLorem;?></p>
		</div>
	</section>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
