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
    <spring:url value="/banner" var="urlBanners"></spring:url>
    <spring:url value="/banner/update" var="urlUpdate"></spring:url>
    <spring:url value="/banner/delete" var="urlDelete"></spring:url>
    <spring:url value="/resources" var="urlPublic"/>
    
    <title>Listado de imagenes del banner</title>
    
    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
    
  </head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <h3>Listado de imagenes del Banner</h3>
      <c:if test="${mensaje != null }">
      <div class="alert alert-success" role="alert">${mensaje}</div>
      </c:if>
      <a href="${urlBanners}/create" class="btn btn-success" role="button" title="Nuevo Banner" >Nuevo</a><br><br>

      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Id</th>
                <th>Titulo</th>                           
                <th>Fecha Publicacion</th>              
                <th>Nombre Archivo</th>
                <th>Estatus</th>
                <th>Opciones</th>              
            </tr>
            <c:forEach items="${listBaner.content}" var="banner">
            <tr>
                <td>${banner.id}</td>
                <td>${banner.titulo}</td>
                <td> <fmt:formatDate pattern="dd-MM-yyyy" value="${banner.fecha}"/></td>   
                <td>${banner.archivo}</td>                         
                <td>
                <span class="label label-success ${banner.estatus ? 'show' :'hide' }">Activa</span>
                <span class="label label-danger ${!banner.estatus ?'show':'hide'}">Inactiva</span>
                </td>
                <td>
                    <a href="${urlUpdate}/${banner.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="${urlDelete}/${banner.id}" onclick='return confirm("¿Estas seguro que deseas eliminar el registro del banner?")' class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
            </c:forEach>        
        </table>
        <nav aria-label="">
				<ul class="pager">
					<li><a
						href="${urlBanners}/indexPaginate?page=${listBaner.number -1 }">Anterior</a></li>
					<li><a
						href="${urlBanners}/indexPaginate?page=${listBaner.number + 1 }">Siguiente</a></li>
				</ul>
			</nav>
      </div>  
      <hr class="featurette-divider">

      <!-- FOOTER -->
      <jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>     
  </body>
</html>