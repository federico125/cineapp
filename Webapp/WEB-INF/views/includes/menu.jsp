 <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <spring:url value="/" var="urlRoot"></spring:url>
 <!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${urlRoot}">My CineSite</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">    
            <li><a href="${urlRoot}peliculas/indexPaginate?page=0">Peliculas</a></li>
            <li><a href="${urlRoot}horarios/indexPaginate?page=0">Horarios</a></li>
            <li><a href="${urlRoot}banner/indexPaginate?page=0">Banners</a></li>
            <li><a href="${urlRoot}noticias/paginateIndex?page=0">Noticias</a></li>       
            <li><a href="${urlRoot}acerca">Acerca</a></li>
            <li><a href="#">Login</a></li>            
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>