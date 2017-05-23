angular.module("TaskApp", []).value('urlBase', 'http://localhost:8080/TaskList/rest/').controller("TaskController",
		function($http, urlBase) {
			var self = this;
			self.usuario = 'Murilo da Silva';

			self.tasks = [];
			self.task = undefined;

			self.novo = function() {
				self.task = {};
				console.log(self.task);
			};

			self.salvar = function() {
				var metodo = 'POST';
				if (self.task.idTask) {
					metodo = 'PUT';
				}

				$http({
					method : metodo,
					url : urlBase + 'task/',
					data : self.task
				}).then(function successCallback(response) {
					self.atualizarTabela();
				}, function errorCallback(response) {
					console.log("teste");
					console.log(response);
					self.ocorreuErro();
				});
			};

			self.alterar = function(task) {
				self.task = task;
			};

			self.deletar = function(task) {
				self.task = task;

				$http({
					method : 'DELETE',
					url : urlBase + 'task/' + self.task.idTask + '/'
				}).then(function successCallback(response) {
					self.atualizarTabela();
				}, function errorCallback(response) {
					self.ocorreuErro();
				});
			};

			self.concluir = function(task) {
				self.task = task;

				$http({
					method : 'PUT',
					url : urlBase + 'task/' + self.task.idTask + '/'
				}).then(function successCallback(response) {
					self.atualizarTabela();
				}, function errorCallback(response) {
					self.ocorreuErro();
				});
			};

			self.ocorreuErro = function() {
				alert("Ocorreu um erro inesperado!");
			};

			self.atualizarTabela = function() {
				$http({
					method : 'GET',
					url : urlBase + 'task/'
				}).then(function successCallback(response) {
					self.tasks = response.data;
					console.log(self.tasks);
					self.task = undefined;
				}, function errorCallback(response) {
					self.ocorreuErro();
				});
			};

			self.activate = function() {
				self.atualizarTabela();
			};
			self.activate();
		});
