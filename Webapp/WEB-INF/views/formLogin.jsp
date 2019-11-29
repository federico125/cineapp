<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">    
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Login</title>
		<spring:url value="/" var="urlRoot"></spring:url>
		<spring:url value="/admin" var= "urlFormulario"></spring:url>
		<spring:url value="/resources" var="urlPublic"></spring:url>
		<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
		<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
		<link href="${urlPublic}/bootstrap/css/signin.css" rel="stylesheet">
	</head>
	<body>
		<!-- Fixed navbar -->
		<jsp:include page="includes/menu.jsp"/>
		<div class="container theme-showcase" role="main">
			<hr class="featurette-divider">
			<img src="${urlPublic}/images/login.png" width="136" height="136" class="center">
			<form class="form-signin" name ="form" action="${urlRoot}login" method="post">        
				<h3 class="form-signin-heading">CineSite | Administracion</h3>        
				<label for="j_username" class="sr-only">Usuario</label>
				<input type="text" id="username" name="username" class="form-control" placeholder="Usuario" required autofocus>
				<label for="j_password" class="sr-only">Contraseña</label>
				<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<button class="btn btn-lg btn-primary btn-block" type="submit" name="submit">Logout</button>
			</form>

		</div> <!-- /container -->
		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="${urlPublic}/bootstrap/js/bootstrap.min.js" ></script>
	</body>
</html>
