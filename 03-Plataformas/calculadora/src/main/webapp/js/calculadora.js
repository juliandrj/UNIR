var valExp = new RegExp('^(-){0,1}([\\.0-9]+(\\+|-|\\*|/){1})+[\\.0-9]+$','i');
var valOpr = new RegExp('^.*(\\+|-|\\*|/){1}$','i');
var valDiv = new RegExp('^.*(/){1}$','i');
var valNum = new RegExp('^[\\.0-9]+$','i');
var CalcVM = function () {
	var self = this;
	self.expresion = ko.observable('');
	self.agregar = function (valor) {
		console.log(valOpr.test(self.expresion()));
		console.log(valNum.test(valor));
		if (valNum.test(valor) || !valOpr.test(self.expresion())) {
			self.expresion(self.expresion() + valor);
		}
	};
	self.esDiv = ko.computed(function () {
		return valDiv.test(self.expresion());
	}, self);
	self.totalizable = ko.computed(function () {
		return valExp.test(self.expresion());
	}, self);
	self.calcular = function () {
		var exp = self.expresion();
		self.expresion('calculando...');
		$.post("calcular.json", {expresion: exp}, function(data) {
			if (data.status == 'ok') {
				self.expresion(data.resultado);
			} else {
				console.error(data.mensaje);
			}
		}, 'json');
	};
	self.limpiar = function () {
		self.expresion('');
	};
};
var calc = new CalcVM();
$(document).ready(function () {
	ko.applyBindings(calc);
	calc.expresion('');
});