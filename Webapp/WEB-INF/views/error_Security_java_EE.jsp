<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<spring:url value="/resources" var="urlPublic"></spring:url>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">    
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Error | Login</title>

		<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">    
		<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
		<link href="${urlPublic}/bootstrap/css/signin.css" rel="stylesheet">

	</head>

	<body>

		<!-- Fixed navbar -->
		<jsp:include page="includes/menu.jsp"></jsp:include>

		<div class="container theme-showcase" role="main">
			<hr class="featurette-divider">
			<img src="${urlPublic}/images/login.png" width="136" height="136" class="center">
			<img src="${urlPublic}/images/error.png" width="48" height="48" class="center">
			
         <form class="form-signin" action="j_security_check" method="post">   
				<h4 class="form-signin-heading" style="color:red">Acceso denegado</h4>
				<h3 class="form-signin-heading">CineSite | Administracion</h3>        
				<label for="j_username" class="sr-only">Usuario</label>
				<input type="text" id="j_username" name="j_username" class="form-control" placeholder="Usuario" required autofocus>
				<label for="j_password" class="sr-only">Contraseña</label>
				<input type="password" id="j_password" name="j_password" class="form-control" placeholder="Password" required>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
			</form>

		</div> <!-- /container -->
		<!-- Bootstrap core JavaScript
		================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="${urlPublic}/bootstrap/js/bootstrap.min.js" ></script>
	</body>
</html>
