<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" ng-app="masterApp" ng-view>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />	
		<link rel="stylesheet" type="text/css" href="/UserManagementPortal/static/css/bootstrap.min.css" />
   		<link rel="stylesheet" type="text/css" href="/UserManagementPortal/static/css/bootstrap-theme.min.css" />
  		<link rel="stylesheet" type="text/css" href="/UserManagementPortal/static/css/styles.css" />  		
		<style type="text/css">
			body, html  { height: 100%; }
			html, body, div, span, applet, object, iframe, p, blockquote, pre,
			a, abbr, acronym, address, big, cite, code,
			del, dfn, em, font, img, ins, kbd, q, s, samp,
			small, strike, strong, sub, sup, tt, var,
			b, u, i, center,
			dl, dt, dd, ol, ul, li,
			fieldset, form, label, legend,
			table, caption, tbody, tfoot, thead, tr, th, td {
				margin: 0;
				padding: 0;
				border: 0;
				outline: 0;
				font-size: 100%;
				vertical-align: baseline;
				background: transparent;
			}
			body { line-height: 1; }
			ol, ul { list-style: none; }
			blockquote, q { quotes: none; }
			blockquote:before, blockquote:after, q:before, q:after { content: ''; content: none; }
			:focus { outline: 0; }
			del { text-decoration: line-through; }
			table {border-spacing: 0; } 
		
			body{
				font-family:Arial, Helvetica, sans-serif;
				background: url(/UserManagementPortal/images/background.jpg);
				margin:0 auto;
				width:850px;
			}
			a:link {
				color: #666;
				font-weight: bold;
				text-decoration:none;
			}
			a:visited {
				color: #666;
				font-weight:bold;
				text-decoration:none;
			}
			a:active,
			a:hover {
				color: #bd5a35;
				text-decoration:underline;
			}
			
			
			/*
			Table Style - This is what you want
			------------------------------------------------------------------ */
			table a:link {
				color: #666;
				font-weight: bold;
				text-decoration:none;
			}
			table a:visited {
				color: #999999;
				font-weight:bold;
				text-decoration:none;
			}
			table a:active,
			table a:hover {
				color: #bd5a35;
				text-decoration:underline;
			}
			table {
				font-family:Arial, Helvetica, sans-serif;
				color:#666;
				font-size:12px;
				text-shadow: 1px 1px 0px #fff;
				background:#eaebec;
				margin:20px;
				border:#ccc 1px solid;
			
				-moz-border-radius:3px;
				-webkit-border-radius:3px;
				border-radius:3px;
			
				-moz-box-shadow: 0 1px 2px #d1d1d1;
				-webkit-box-shadow: 0 1px 2px #d1d1d1;
				box-shadow: 0 1px 2px #d1d1d1;
			}
			table th {
				padding:21px 25px 22px 25px;
				border-top:1px solid #fafafa;
				border-bottom:1px solid #e0e0e0;
			
				background: #ededed;
				background: -webkit-gradient(linear, left top, left bottom, from(#ededed), to(#ebebeb));
				background: -moz-linear-gradient(top,  #ededed,  #ebebeb);
			}
			table th:first-child{
				text-align: left;
				padding-left:20px;
			}
			table tr:first-child th:first-child{
				-moz-border-radius-topleft:3px;
				-webkit-border-top-left-radius:3px;
				border-top-left-radius:3px;
			}
			table tr:first-child th:last-child{
				-moz-border-radius-topright:3px;
				-webkit-border-top-right-radius:3px;
				border-top-right-radius:3px;
			}
			table tr{
				text-align: center;
				padding-left:20px;
			}
			table tr td:first-child{
				text-align: left;
				padding-left:20px;
				border-left: 0;
			}
			table tr td {
				padding:18px;
				border-top: 1px solid #ffffff;
				border-bottom:1px solid #e0e0e0;
				border-left: 1px solid #e0e0e0;
				
				background: #fafafa;
				background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb), to(#fafafa));
				background: -moz-linear-gradient(top,  #fbfbfb,  #fafafa);
			}
			table tr.even td{
				background: #f6f6f6;
				background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8), to(#f6f6f6));
				background: -moz-linear-gradient(top,  #f8f8f8,  #f6f6f6);
			}
			table tr:last-child td{
				border-bottom:0;
			}
			table tr:last-child td:first-child{
				-moz-border-radius-bottomleft:3px;
				-webkit-border-bottom-left-radius:3px;
				border-bottom-left-radius:3px;
			}
			table tr:last-child td:last-child{
				-moz-border-radius-bottomright:3px;
				-webkit-border-bottom-right-radius:3px;
				border-bottom-right-radius:3px;
			}
			table tr:hover td{
				background: #f2f2f2;
				background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#f0f0f0));
				background: -moz-linear-gradient(top,  #f2f2f2,  #f0f0f0);	
			}
		</style>		
	</head>
	<body ng-controller="userController" style="margin:0 auto;">				
		<form novalidate="novalidate" class="form-horizontal" name="userForm" method="post">
			<table cellspacing='0'>
				<tr>
					<td>Search By Email: </td>
					<td>
						<input id="tags" type="text" ng-model="user.email" placeholder="Search By Email" name="email" />
					</td>
					<td>
						<button ng-click="searchUser()" type="submit">Search</button>					
					</td>
					<td>
						<a href="#/user" style="color:blue;">Add New User</a>
					</td>
				</tr>
			</table>			
		</form>
		<table cellspacing='0'>
			<tr>
				<th>Sr.No</th>
				<th>Name</th>
				<th>Email ID</th>
				<th>Gender</th>
				<th>Contact No</th>
				<th>Address</th>
				<th>Action</th>
			</tr>
		    <tr class="ng-scope" dir-paginate="userDTO in userDTOs|itemsPerPage:5">
				<td>{{$index+1}}</td>		
				<td>{{ userDTO.firstName + " " + userDTO.lastName}}</td>
				<td>{{ userDTO.email }}</td>
				<td>{{ userDTO.gender }}</td>
				<td>{{ userDTO.contactNo1 }}</td>
				<td>{{ userDTO.address }}</td>
				<td>						
					<a style="color: #69aa46 !important" ng-click="editUser(userDTO.id)">Edit</a> 
					<a style="color: #dd5a43 !important" ng-click="deleteUser(userDTO.id)">Delete</a>
				</td>
			</tr>	
			<tr id="paginationDiv">
				<td colspan="7" style="text-align: center;">
					<span>
						<dir-pagination-controls max-size="5" direction-links="true" boundary-links="true" />		
					</span>
				</td>
			</tr>		
			<tr style="display: none;" id="messageDiv">
				<td colspan="7" style="text-align: center; font-size: 20px; color:green;"><span class="replaceme"></span></td>
			</tr>
		</table>							
	</body>
</html>
