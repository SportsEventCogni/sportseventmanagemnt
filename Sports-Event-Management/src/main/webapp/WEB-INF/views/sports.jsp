<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700"
	rel="stylesheet">
<title>Register</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	color: #999;
	background-image: url("drawable/sportsAdd.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	font-family: 'Roboto', sans-serif;
}

.form-control, .form-control:focus, .input-group-addon {
	border-color: #e1e1e1;
	border-radius: 9px;
}

.signup-form {
	width: 390px;
	margin: 0 auto;
	padding: 30px 0;
	border-radius: 9px;
	margin-top:80px;
}

.signup-form h2 {
	color: #636363;
	margin: 0 0 15px;
	text-align: center;
}

.signup-form .lead {
	font-size: 14px;
	margin-bottom: 30px;
	text-align: center;
}

.signup-form form {
	border-radius: 1px;
	margin-bottom: 15px;
	background: #fff;
	border: 1px solid #f3f3f3;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.signup-form .form-group {
	margin-bottom: 20px;
}

.btn {
	
}

.btn:hover {
	
}

.signup-form label {
	font-weight: normal;
	font-size: 13px;
}

.signup-form .form-control {
	min-height: 38px;
	box-shadow: none !important;
	border-width: 0 0 1px 0;
}

.signup-form .input-group-addon {
	max-width: 42px;
	text-align: center;
	background: none;
	border-width: 0 0 1px 0;
	padding-left: 5px;
}

.signup-form .btn {
	font-size: 16px;
	font-weight: bold;
	background: linear-gradient(to bottom left, #EF8D9C 40%, #FFC39E 100%);
	border-color: light grey;
	border-radius: 20px;
	border: none;
	min-width: 140px;
	outline: none !important;
}

.signup-form .btn:hover, .signup-form .btn:focus {
	background: linear-gradient(to top right, #EF8D9C 40%, #FFC39E 100%);
}

.signup-form a {
	color: #19aa8d;
	text-decoration: none;
}

.signup-form a:hover {
	text-decoration: underline;
}

.signup-form .fa {
	font-size: 21px;
}

.signup-form .fa-paper-plane {
	font-size: 17px;
}

.signup-form .fa-check {
	color: #fff;
	left: 9px;
	top: 18px;
	font-size: 7px;
	position: absolute;
}
</style>

<script>
	function validatingForm() {
		if (document.form.sportsName.value == "") {
			alert("Please update the highlighted field");
			document.loginform.userName.focus();
			return false;
		}
		if (document.form.sportsType.value == "") {
			alert("Please update the highlighted field");
			document.userform.password.focus();
			return false;
		}
		if (document.form.noOfPlayers.value == "") {
			alert("Please update the highlighted field");
			document.loginform.userName.focus();
			return false;
		}
		if (document.form.timeOfMatch.value == "") {
			alert("Please update the highlighted field");
			document.loginform.userName.focus();
			return false;
		}

		if (document.form.sportsId.value == "") {
			alert("Please update the highlighted field");
			document.loginform.userName.focus();
			return false;
		}

	}
</script>


</head>
<body>
<%@include file="header.html" %>
	<div class="signup-form">
		<form:form name="form" action="sportRegister" method="get" modelAttribute="sports" onsubmit="return validatingForm();">
			<h2>Sport Registration</h2>
			<table>
				<tr>
					<td><div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<form:input path="sportsName" class="form-control"
									name="sportsName" placeholder="Sports Name" />
								<td><form:errors path="sportsName"></form:errors></td>
							</div>
						</div></td>
				</tr>
				<tr>
					<td><div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user"></i></span>
								<form:input path="sportsType" class="form-control"
									name="sportsType" placeholder="Sports Type" />
								<td><form:errors path="sportsType"></form:errors></td>
							</div>
						</div></td>
				</tr>
				<tr>
					<td><div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
								<form:input type="text" path="noOfPlayers" class="form-control"
									name="noOfPlayers" placeholder="No of Players"
									 />
								<td><form:errors path="noOfPlayers"></form:errors></td>
							</div>
						</div></td>
				</tr>


				<tr>
					<td><div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-phone"></i></span>
								<form:input path="timeOfMatch" class="form-control"
									name="timeOfMatch" placeholder="Time Of Match"
								 />
								<td><form:errors path="timeOfMatch"></form:errors></td>
							</div>
						</div></td>
				</tr>

				<tr>
					<td><div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-phone"></i></span>
								<form:input path="sportsId" class="form-control" name="sportsId"
									placeholder="Sports Id" />
								<td><form:errors path="sportsId"></form:errors></td>


							</div>
						</div></td>
				</tr>
				<tr class="form-group">
					<td><input type="Submit" name="submit"
						class="btn btn-primary btn-block btn-lg" name="Register"
						value="Register" /></td>
					<td></td>
				</tr>


				<div>${successful}</div>

				</div>
				<table>
					</form:form>


					</div>
</body>
</html>
