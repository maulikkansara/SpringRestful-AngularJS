<html ng-app="masterApp">
	<head>
		<script src="/UserManagementPortal/static/js/commons/angular.min.js"></script>
		<script src="/UserManagementPortal/static/js/commons/angular-route.min.js"></script>
		<script src="/UserManagementPortal/static/js/commons/angular-resource.min.js"></script>
		<script src="/UserManagementPortal/static/js/commons/ngDialog.min.js"></script>
		<script src="/UserManagementPortal/static/js/commons/angular-storage.min.js"></script>	
		<script src="/UserManagementPortal/static/js/commons/jquery.min.js"></script>	
		<script src="/UserManagementPortal/static/js/commons/jquery-ui.min.js"></script>	
		<link rel="stylesheet" href="/UserManagementPortal/static/css/jquery-ui.min.css" />
	</head>
	<body ng-app="masterApp">
		<div ng-view></div>
		<script src="/UserManagementPortal/static/js/usermanagement/um-config-masterConfig.js"></script>
		<script src="/UserManagementPortal/static/js/usermanagement/um-controller-userController.js"></script>
		<script src="/UserManagementPortal/static/js/usermanagement/um-service-userService.js"></script>
		<script src="/UserManagementPortal/static/js/usermanagement/dirPagination.js"></script>
	</body>
</html>
