var masterApp = angular.module("masterApp", ['ngRoute',
                                             'ngResource', 'angularUtils.directives.dirPagination']);
masterApp.config(function($routeProvider) {
	$routeProvider
	.when('/user', {
		templateUrl : '/UserManagementPortal/views/user/createUser.jsp',
		controller : 'userController'		
	})
	.when('/user/search', {
		templateUrl : '/UserManagementPortal/views/user/searchUser.jsp',
		controller : 'userController'		
	})
	.when('/user/edit/:id', {
		templateUrl : '/UserManagementPortal/views/user/createUser.jsp',
		controller : 'userController'
	})
	.otherwise({
        redirectTo: '/user/search'
    });
});

var um = {};
var API_BASE_URL = '';
um.apiBaseUrl = function(url) {
	return API_BASE_URL + url;
};