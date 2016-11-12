<head>
	<title>Create User</title>	
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
<body ng-app="masterApp">
	<div>
		<form name="userForm" novalidate ng-controller="userController">
			<table cellspacing='0' border="1">
				<tr>
					<th colspan="4" style="text-align: center;"><h1>Create User</h1></th>
				</tr>
				<tr>
					<td>
						<label for="">First Name</label> 
					</td>
					<td>
						<input id="firstName" class="form-control" type="text" name="firstName" placeholder="Enter First Name" ng-model="user.firstName" ng-pattern="/^[a-zA-Z]+$/" required></input>
						<span style="color: red; display: block; margin-top: 5px;margin-left: -50px;" display: block;" ng-show="userForm.firstName.$error.pattern && userForm.invalid">First Name is not valid!</span> 
						<span style="color: red; display: block; margin-top: 5px;margin-left: -50px;" ng-show="userForm.firstName.$error.required && userForm.invalid">First Name is required!</span>
					</td>
					<td>
						<label for="">Middle Name</label>
					</td>
					<td>
						<input id="middleName" class="form-control" type="text" name="middleName" placeholder="Enter Middle Name" ng-model="user.middleName" ng-pattern="/^[a-zA-Z]+$/"></input>
						<span style="color: red" ng-show="userForm.middleName.$error.pattern && userForm.invalid">Middle Name is not valid!</span>
					</td>
				</tr>
				<tr>
					<td>
						<label for="">Last Name</label>
					</td>
					<td>
						<input id="lastName" class="form-control" type="text" name="lastName" placeholder="Enter Last Name" ng-model="user.lastName" required ng-pattern="/^[a-zA-Z]+$/" ></input>
						<span style="color: red; display: block; margin-top: 5px;margin-left: -50px;" ng-show="userForm.lastName.$error.pattern && userForm.invalid">Last Name is not valid!</span> 
						<span style="color: red; display: block; margin-top: 5px;margin-left: -50px;" ng-show="userForm.lastName.$error.required && userForm.invalid">Last Name is required!</span>
					</td>
					<td>
						<label for="">Email</label>
					</td>
					<td>
						<input id="email" type="email" class="form-control" name="email" placeholder="Enter Email" ng-model="user.email" required></input>
						<span style="color: red; display: block; margin-top: 5px;margin-left: -80px;" ng-show="userForm.email.$error.email && userForm.invalid">Not valid email!</span> 
						<span style="color: red; display: block; margin-top: 5px;margin-left: -80px;" ng-show="userForm.email.$error.required && userForm.invalid">Email is required</span>
					</td>
				</tr>
				<tr>
					<td>
						<label for="">User Name</label> 		
					</td>
					<td>
						<input id="userName" class="form-control" type="text" name="userName" placeholder="Enter User Name" ng-model="user.userName" required></input> 
						<span style="color: red; display: block; margin-top: 5px;margin-left: -50px;" ng-show="userForm.userName.$error.required && userForm.invalid">User Name is required</span>
					</td>
					<td>
						<label for="">Password</label>
					</td>
					<td>
						<input id="password" type="password" class="form-control" name="password" placeholder="Enter Password" ng-model="user.password" required></input> 
						<span style="color: red; display: block; margin-top: 5px;margin-left: -55px;" ng-show="userForm.password.$error.required && userForm.invalid">Password is required!</span>
					</td>
				</tr>				
				<tr>
					<td>
						<label for="">Contact No</label> 
					</td>
					<td>
						<input id="contactNo1" class="form-control" type="text" name="contactNo1" placeholder="Enter Contact No" ng-model="user.contactNo1" required ng-pattern="/^[0-9]+$/" ng-maxlength="10"></input>
						<span style="color: red; display: block; margin-top: 5px;margin-left: -50px;" ng-show="userForm.contactNo1.$error.pattern && userForm.invalid">Contact No is not valid!</span> 
						<span style="color: red; display: block; margin-top: 5px;margin-left: -50px;" ng-show="userForm.contactNo1.$error.maxlength && userForm.invalid">Contact No has no valid length!</span>
						<span style="color: red; display: block; margin-top: 5px;margin-left: -50px;" ng-show="userForm.contactNo1.$error.required && userForm.invalid">Contact No is required!</span>
					</td>
					<td>
						<label for="">Alternate Contact No</label> 
					</td>
					<td>
						<input id="contactNo2" class="form-control" type="text" name="contactNo2" placeholder="Enter Contact No" ng-model="user.contactNo2" ng-pattern="/^[0-9]+$/" ng-maxlength="10"></input>
						<span style="color: red; display: block; margin-top: 5px;margin-left: -50px;" ng-show="userForm.contactNo2.$error.maxlength && userForm.invalid">Alternate Contact No has no valid length!</span>
						<span style="color: red; display: block; margin-top: 5px;margin-left: -50px;" ng-show="userForm.contactNo2.$error.pattern && userForm.invalid">Alternate No is valid!</span>
					</td>
				</tr>
				<tr>
					<td>
						<label for="">Address</label>
					</td>
					<td>
						<textarea my-maxlength="150" id="address" class="form-control" name="address" placeholder="Enter Address" ng-model="user.address"></textarea>
						<span style="color: red; display: block; margin-top: 5px;margin-left: -50px;" ng-show="userForm.address.$error.maxlength && userForm.invalid">Address has no valid length!</span>
					</td>
					<td>
						<label for="">Gender</label>
					</td>
					<td>
						<select name="gender" ng-model="user.gender" required class="form-control" style="width: 100%">
							<option value="Select" ng-selected="true">--Select--</option>
							<option value="MALE">MALE</option>
							<option value="FEMALE" >FEMALE</option>
						</select>
						<span style="color: red; display: block; margin-top: 5px;margin-left: -70px;" ng-show="userForm.gender.$error.required  && userForm.invalid">Gender is required!</span>		
					</td>
				</tr>			
				<tr>
					<td colspan="4" style="text-align: center;">
						<button ng-click="doSaveUser()">Save</button>&nbsp;&nbsp;
						<button ng-click="doReset()">Reset</button>&nbsp;&nbsp;
						<button ng-click="doCancel()">Cancel</button>
					</td>
				</tr>	
			</table>	      
		</form>
	</div>
</body>