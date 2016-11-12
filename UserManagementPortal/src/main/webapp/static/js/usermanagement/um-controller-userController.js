angular.module('masterApp').controller("userController",  function($window, $rootScope, $routeParams,$route, $scope, $location, userService) {
	$scope.userDTOs = [];
	$scope.user = {};
	$scope.userForm={};	
	$scope.userForm.invalid = false;
	
	if(true) {				
		if($scope.user == null){
			$scope.user={};
		}
		$scope.userDTOs = userService.searchUser($scope.user,
				$scope, function(response) {
					$scope.userDTOs = response.body;
						angular.forEach($scope.userDTOs, function(value, index) {
					})
		});
		
		if ($routeParams.id) {
			console.log("User ID in Controller: route " + $routeParams.id);
			userService.editUser($routeParams.id, $scope, function(response) {
					$scope.user = response.body;
					var $tag_obj = $('#form-field-tags').data('tag');
				});
		}
	}
	
	$scope.doSaveUser = function() {
		console.log("Called Save User Fuction..");
		if ($scope.userForm.$valid) {
			$scope.userDTO = userService.saveUser($scope.user, $scope,
					function(response) {
						$scope.userDTO = response.body;
						if ($scope.userDTO == null) {
							$scope.userForm.invalid = true;
						} else {
							$location.path('user/search');
						}
					});
		} else {
			$scope.userForm.invalid = true;
		}
	}
	
	$scope.deleteUser = function(id) {
		if(confirm("Are you sure you want to delete this user? ")){
			userService.deleteUser(id, $scope, function(response) {
				$scope.idRe = response.body;
				$scope.userDTOs = userService.getAllUsers($scope, function(response) {
					$scope.userDTOs = response.body;					
				});
			});
		}
	}
	
	$scope.editUser = function(userId) {
		$location.path('user/edit/'+userId);
	}

	$scope.searchUser = function() {		
		$scope.userDTOs = userService.searchUser($scope.user, $scope, function(response) {			
			if (response.body != null) {
				$scope.userDTOs = response.body;
				$("#messageDiv").hide();
				$("#paginationDiv").show();
			} else {
				$("#paginationDiv").hide();
				$("#messageDiv").show();				
				$('.replaceme').html(response.message);
			}
		});		
	}

	$scope.autoSearchUser = function(name) {		
		userService.autoSearchUser(name, $scope, function(response) {
			$scope.userDTOs1 = response.body;
			$("#tags").autocomplete({
				source : $scope.userDTOs1
			});
		});
	}

	$scope.doReset = function() {
		$scope.user = {};
	}
	
	$scope.doCancel = function() {
		$location.path('user/search');
	}
});    