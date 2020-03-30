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
	background: #f5f5f5;
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

.error {
	color: red;
}

</style>
<script>
	function verify() {
		if (document.frm.firstName.value == ""
				|| document.frm.lastName.value == ""
				|| document.frm.age.value == ""
				|| document.frm.contact.value == ""
				|| document.frm.coachId.value == ""
				|| document.frm.password.value == "") {
			alert('Please update the highlighted mandatory fields');
		}

	}

	function validateForm() {

		if (document.frm.firstName.value == "") {

			document.frm.username.focus();
			return false;
		} else if (document.frm.lastName.value == "") {

			document.frm.pwd.focus();
			return false;
		} else if (document.frm.age.value == "") {

			document.frm.age.focus();
			return false;
		} else if (document.frm.contact.value == "") {

			document.frm.contact.focus();
			return false;
		} else if (document.frmcoachId.value == "") {

			document.frm.coachId.focus();
			return false;
		}

		else if (document.frm.password.value == "") {

			document.frm.password.focus();
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div class="signup-form">
		<form:form name="frm" action="coachRegisterUser" method="post"
			modelAttribute="coach" onSubmit="return validateForm()">
			<h2>Coach Registration</h2>
			<table>
				<tr>
					<td><div class="form-group">
							<div class="input-group">

								<form:input path="firstName" class="form-control"
									name="firstName" placeholder="First Name" />
							</div>
						</div></td>

					<td><form:errors path="firstName" class="error"></form:errors></td>
				</tr>
				<tr>
					<td><div class="form-group">
							<div class="input-group">

								<form:input class="form-control" path="lastName" name="lastName"
									placeholder="Last Name" />
							</div>
						</div></td>

					<td><form:errors path="lastName" class="error"></form:errors></td>
				</tr>
				<tr>
					<td><div class="form-group">
							<div class="input-group">

								<form:input class="form-control" path="age" name="age"
									placeholder="Age" />
							</div>
						</div></td>
					<td><form:errors path="age" class="error"></form:errors></td>
				</tr>
				<tr>
					<td><div class="form-group">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-mars"></i></span>
								<div class="form-control form-check-inline">
									<label class="form-check-label"> <form:radiobutton
											path="gender" id="gender" checked="true" value="Male"
											class="form-check-input" name="optradio" />Male
									</label>
								</div>

								<span class="input-group-addon"><i class="fa fa-venus"></i></span>
								<div class="form-control form-check-inline">
									<label class="form-check-label"> <form:radiobutton
											path="gender" id="gender" value="Female"
											class="form-check-input" name="optradio" />Female
									</label>
								</div></td>

					<td><form:errors path="gender"></form:errors></td>

					</div>

					</div>
				</tr>

				<tr>
					<td><div class="form-group">
							<div class="input-group">

								<form:input class="form-control" name="contact" path="contact"
									placeholder="Contact Number" />
							</div>
						</div></td>

					<td><form:errors path="contact" class="error"></form:errors></td>
				</tr>
				<tr>
					<td><div class="form-group">
							<div class="input-group">

								<form:input path="coachId" class="form-control" name="coachId"
									placeholder="Coach Id" />
							</div>
						</div></td>
					<td><form:errors path="coachId" class="error"></form:errors></td>
				</tr>
				<tr>
					<td><div class="form-group">
							<div class="input-group">

								<form:input path="password" class="form-control" name="password"
									placeholder="Password" />
							</div>
						</div></td>

					<td><form:errors path="password" class="error"></form:errors></td>
				</tr>
				<tr>
					<td><div class="form-group">
							<input type="submit" name="Register" value="Register"
								onClick="verify()" class="btn btn-primary btn-block btn-lg" />
						</div></td>
				</tr>
				<table>
					</form:form>

					<div class="text-center">
						Already have an account? <a href="coachLogin">Login here</a>.
					</div>
					</div>
</body>
</html>