angular.module("TaskApp", []).value('urlBase', 'http://localhost:8080/TaskList/rest/').controller("TaskController",
		function($scope,$http, urlBase) {
			var self = this;
			self.usuario = 'Murilo da Silva';

			self.tasks = [];
			self.task = undefined;				
		    self.status= [
		         {'id' : '', 'description' : 'Selecione..'},         
		         {'id' : 1, 'description' : 'Pendente'},
		         {'id' : 2, 'description' : 'Fechado'},
		       ];
		    
		    
			
			self.novo = function() {
				self.task = {};
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
					console.log(response.data);
					self.ocorreuErro();
				});
			};

			self.alterar = function(task) {
				self.task = task;
				if(task.dtCriacao)
					self.task.dtCriacao = new Date(task.dtCriacao);
				if(task.dtConclusao)
					self.task.dtConclusao = new Date(task.dtConclusao);
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
