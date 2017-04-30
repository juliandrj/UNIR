var RENGLON = 0;
var COLUMNA = 1;
var CUADRANTE = 2;
var validarIlera = function (posicion, tipoEstructura, marcar) {
	var tipo = undefined;
	switch (tipoEstructura) {
	case RENGLON:
		tipo = 'row_';
		break;
	case COLUMNA:
		tipo = 'col_';
		break;
	case CUADRANTE:
		tipo = 'cell_';
		break;
	default:
		return false;
	}
	var valores = [];
	$('.' + tipo + posicion + ' input').each(function () {
		if ($(this).val() != '') {
			valores.push($(this).val());
		}
	});
	if (valores.length <= 1) {
		return true;
	}
	valores = valores.sort();
	for (var i = 1; i < valores.length; i++) {
		if (valores[i-1] == valores[i]) {
			if (marcar) {
				$('.' + tipo + posicion).addClass('has-error');
			}
			return false;
		}
	}
	return true;
};
var limpiarTablero = function () {
	$('#tablero td').each(function () {
		var input = $('input', $(this));
		if (_.isUndefined(input.attr('readonly'))) {
			input.val('');
		}
	});
};
var agregarValoresAleatorios = function (x, y) {
	//indices aleatorios
	var index = [];
	for (var i = 0; i < _.random(1, 5); i++) {
		index.push(_.random(1, 9));
	}
	//retiro duplicados
	index = _.uniq(index).sort();
	var n = 0;
	var i = 0;
	//recorrer celda de 3x3
	$('td.cell_' + x + y).each(function () {
		var clases = $(this).attr('class');
		var input = $('input', $(this))
		if (index[n] == i) {
			input.attr('readonly', true);
			do {
				input.val(_.random(1, 9));
				//Se repite hasta que el valor cumpla con todas las reglas.
			} while (!(validarIlera($(this).attr('data-row'), RENGLON, false) &&
					validarIlera($(this).attr('data-col'), COLUMNA, false) &&
					validarIlera(x + '' + y, CUADRANTE, false)));
			n++;
		}
		i++;
	});
};
var resolver = function (posicion, tipoEstructura) {
	var tipo = undefined;
	switch (tipoEstructura) {
	case RENGLON:
		tipo = 'row_';
		break;
	case COLUMNA:
		tipo = 'col_';
		break;
	case CUADRANTE:
		tipo = 'cell_';
		break;
	default:
		return false;
	}
	var intentos = 0;
	do {
		var vacios = false;
		var start = _.random(1, 9);
		$('.' + tipo + posicion).each(function () {
			var input = $('input', $(this));
			if (_.isUndefined(input.attr('readonly'))) {
				for (var i = start; i <= start + 9; i++) {
					input.val((i % 9) + 1);
					if (validarIlera($(this).attr('data-row'), RENGLON, false) && validarIlera($(this).attr('data-col'), COLUMNA, false) && validarIlera($(this).attr('data-cell'), CUADRANTE, false)) {
						return true;
					}
				}
				input.val('');
				vacios = true;
			}
		});
		intentos++;
	} while (intentos < 50);
	return !vacios;
};
$(document).ready(function () {
	//CREACION DEL TABLERO
	$('#tablero').append('<table class="table table-bordered"></table>');
	var $tb = $('#tablero table').append('<tbody/>');
	var y = false;
	var x = false;
	var m = 0;
	for (var i = 0; i < 9; i++) {
		$tb.append('<tr/>');
		if (i % 3 == 0) {
			y = !y;
			m ++;
		}
		x = y;
		var n = 0;
		var $renglon = $('tr', $tb).last();
		for (var j = 0; j < 9; j++) {
			if (j % 3 == 0) {
				x = !x;
				n ++;
			}
			//Cada celda se agrega con su respectiva cordenada
			$renglon.append('<td class="row_' + i + ' col_' + j + ' cell_' + n + m + ' ' + (x ? 'active' : '') + '" data-row="' + i + '" data-col="' + j + '" data-cell="' + n + m + '"><input class="form-control text-center" type="text" value="" maxlength="1"/></td>');
		}
	}
	for (var i = 1; i <= 3; i++) {
		for (var j = 1; j <= 3; j++) {
			agregarValoresAleatorios(i, j);
		}
	}
	//FIN TABLERO
	var inputs = $('#tablero td input.form-control');
	//Esta porcion evita que se digiten caracteres diferentes a numeros.
	inputs.keydown(function (e) {
		if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
			(e.keyCode === 65 && (e.ctrlKey === true || e.metaKey === true)) || 
			(e.keyCode >= 35 && e.keyCode <= 40)) {
				return;
		}
		if ((e.shiftKey || (e.keyCode < 49 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
			e.preventDefault();
		}
	});
	var anterior = undefined;
	inputs.focus(function () {
		$('td').removeClass('has-error');
		if (!_.isUndefined(anterior)) {
			validarIlera(anterior.row, RENGLON, true);
			validarIlera(anterior.col, COLUMNA, true);
			validarIlera(anterior.cell, CUADRANTE, true);
			anterior = undefined;
		}
	});
	//Esto alerta al usuario de un valor que no cumple
	inputs.on('blur', function (e) {
		var celda = $(this).parent();
		anterior = {row:celda.attr('data-row'), col:celda.attr('data-col'), cell:celda.attr('data-cell')};
	});
	$('#btn-resolver').on('click', function () {
		$('td').removeClass('has-error');
		var $btn = $(this).button('loading');
		limpiarTablero();
		var vacios = false;
		for (var i = 0; i < 9; i++) {
			if (!resolver(i, COLUMNA)) {
				vacios = true;
			}
		}
		if (vacios) {
			limpiarTablero();
			vacios = false;
			for (var i = 0; i < 9; i++) {
				if (!resolver(i, RENGLON)) {
					vacios = true;
				}
			}
			if (vacios) {
				limpiarTablero();
				vacios = false;
				for (var i = 1; i <= 3; i++) {
					for (var j = 1; j <= 3; j++) {
						if (!resolver(i + '' + j, CUADRANTE)) {
							vacios = true;
						}
					}
				}
			} 
		}
		if (vacios) {
			$('#fail').modal();
		} else {
			$('#pass').modal();
		}
		$btn.button('reset');
	});
	$('#btn-limpiar').on('click', function () {
		$('td').removeClass('has-error');
		limpiarTablero();
	});
	$('#btn-validar').on('click', function () {
		$('#tablero td').each(function () {
			if (!validarIlera($(this).attr('data-row'), RENGLON, true) || !validarIlera($(this).attr('data-col'), COLUMNA, true) || !validarIlera($(this).attr('data-cell'), CUADRANTE, true)) {
				return;
			}
		});
	});
	$('[data-toggle="tooltip"]').tooltip()
});