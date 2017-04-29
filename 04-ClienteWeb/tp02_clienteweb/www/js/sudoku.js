$(document).ready(function () {
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
			$renglon.append('<td class="row_' + j + ' col_' + i + ' cell_' + n + m + ' ' + (x ? 'active' : '') + '"><input class="form-control text-center" type="text" value="" maxlength="1"/></td>');
		}
	}
	$('#tablero input.form-control').keydown(function (e) {
		if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
			(e.keyCode === 65 && (e.ctrlKey === true || e.metaKey === true)) || 
			(e.keyCode >= 35 && e.keyCode <= 40)) {
				return;
		}
		if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
			e.preventDefault();
		}
	});
});