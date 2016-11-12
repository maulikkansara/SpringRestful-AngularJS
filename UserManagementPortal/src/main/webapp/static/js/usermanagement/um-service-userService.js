angular.module('masterApp').factory('userService', [ '$resource', function( $resource ){
	return new UserService($resource);
}] );

function UserService($resource) {
	var service = this;	
	service.saveUser = function (user, $scope, fnCallback){	
		var User = $resource('http://localhost:8080/UserManagementPortal/user/save.ajax', null, {
			saveUser: {
				method: 'POST'
			}
		});
		User.saveUser(user, fnCallback);		
	}
	
	service.deleteUser = function(id, $scope, fnCallback) {
		var User = $resource('http://localhost:8080/UserManagementPortal/user/deleteUser.ajax', {id : '@id'}, {
			deleteUser : {
				method : 'GET'
			}
		});
		User.deleteUser({id : id}, fnCallback);
	}
	
	service.editUser = function(id, $scope, fnCallback) {
		console.log('Inside User service edit' + id);
		var User = $resource('http://localhost:8080/UserManagementPortal/user/editUser.ajax', {id : '@id'}, {
			editUser : {
				method : 'GET'
			}
		});
		User.editUser({id : id}, fnCallback);
	}
	
	service.searchUser = function(user, $scope, fnCallback) {
		var User = $resource('http://localhost:8080/UserManagementPortal/user/search.ajax', null, {
			searchUser : {
				method : 'POST'
			}
		});
		User.searchUser(user, fnCallback);
	}

	service.autoSearchUser = function(searchString, $scope, fnCallback) {
		var User = $resource('http://localhost:8080/UserManagementPortal/user/autoSearch.ajax', {
			searchString : '@searchString'
		}, {
			autoSearchUser : {
				method : 'GET'
			}
		});
		User.autoSearchUser({
			searchString : searchString
		}, fnCallback);
	}
	
	service.getUserBySearchString=function(searchString, $scope, fnCallback) {
		var User = $resource('http://localhost:8080/UserManagementPortal/user/getUserBySearchString.ajax', {searchString : '@searchString'}, {
			getUserBySearchString : {
				method : 'GET'
			}
		});
		User.getUserBySearchString({searchString : searchString}, fnCallback);
	}
	
	service.getAllUsers = function($scope, fnCallback) {
		var User = $resource('http://localhost:8080/UserManagementPortal/user/getAllUsers.ajax', null, {
			getAllUsers : {
				method : 'GET'
			}
		});
		User.getAllUsers(fnCallback);
	}
	return service;
};


