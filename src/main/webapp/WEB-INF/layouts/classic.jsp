<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Administrador</title>
<link rel="stylesheet" href="./../css/estilo.css" type="text/css" />

<script type="text/javascript" src="./../js/script.js"></script>
</head>
<body>


<div id="ReportHeader">
	<h1>xeoPesca </h1>	



<div class="menu">
<ul class="menu" id="menu">
	<li><a href="#" class="menulink">Xestionar Usuarios</a>
		<ul>
			<li><a href="#">Novo Usuario</a></li>
			<li><a href="#">Buscar Usuario</a></li>
			<li><a href="#">Lista Usuarios</a></li>
		</ul>
	</li>
	<!-- -->
	<li><a href="#" class="menulink">Xestionar Especies</a>
	<ul>
			<li><a href="#">Nova Especie</a></li>
			<li><a href="#">Buscar Especie</a></li>
			<li><a href="#">Lista Especies</a></li>
		</ul>
	</li>
	<li><a href="#" class="menulink">Xestionar Aparellos</a>
	<ul>
			<li><a href="#">Novo Aparello</a></li>
			<li><a href="#">Buscar Aparello</a></li>
			<li><a href="#">Lista Aparellos</a></li>
		</ul>
	</li>
	<li><a href="#" class="menulink">Editar Perfil</a>
	<li><a href="#" class="menulink">Inicio</a>
	
</ul>
</div> <br> <br> </div>




    
<script type="text/javascript">
	var menu=new menu.dd("menu");
	menu.init("menu","menuhover");
</script>
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />


</body>
</html>












