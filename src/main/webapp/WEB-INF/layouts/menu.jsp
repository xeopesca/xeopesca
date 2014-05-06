<!-- 
/* --------------------------------------------------------------------
Copyright (C) 2013 - Pablo Belay Fernández 
This program is free software: you can redistribute it
and/or modify it under the terms of the GNU General
Public License as published by the Free Software
Foundation, either version 3 of the License, or (at your
option) any later version.
This program is distributed in the hope that it will be
useful, but WITHOUT ANY WARRANTY; without even the
implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE. See the GNU General Public License
for more details.
You should have received a copy of the GNU General Public
License along with this program. If not, see
http://www.gnu.org/licenses/gpl-3.0-standalone.html
--------------------------------------------------------------------*/

 -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="iconheader">
	<a href="/xeopesca/admin/listaUsuarios" > <img src="/images/home.png" title='<fmt:message key="admin.menu.button.sair"/>' /></a>
	<a href="/xeopesca/editarConta">    <img src="/images/perfil.png" title='<fmt:message key="admin.menu.button.conta"/>' /></a>
	<a href="<c:url value="j_spring_security_logout"/>" > <img src="/images/on_off.png" title='<fmt:message key="admin.menu.button.sair"/>' /></a>
	
</div>


<div class="menu">
<ul class="menu" id="menu">
		
	<li><a href="#" class="menulink"><fmt:message key="admin.menu.xestionarUsuario"/></a>
		<ul>
			<li><a href="/xeopesca/admin/novoUsuario"><fmt:message key="admin.menu.xestionarUsuario.novo"/></a></li>
			<li><a href="/xeopesca/admin/buscadorUsuario"><fmt:message key="admin.menu.xestionarUsuario.buscar"/></a></li>
			<li><a href="/xeopesca/admin/listaUsuarios"><fmt:message key="admin.menu.xestionarUsuario.lista"/></a></li>
		</ul>
	</li>
	<!-- -->
	<li><a href="#" class="menulink"><fmt:message key="admin.menu.xestionarEspecies"/></a>
	<ul>
			<li><a href="/xeopesca/admin/novaEspecie"><fmt:message key="admin.menu.xestionarEspecies.nova"/></a></li>
			<li><a href="/xeopesca/admin/buscadorEspecie"><fmt:message key="admin.menu.xestionarEspecies.buscar"/></a></li>
			<li><a href="/xeopesca/admin/listaEspecies"><fmt:message key="admin.menu.xestionarEspecies.lista"/></a></li>
			<li><a href="/xeopesca/admin/novoNomePopular"><fmt:message key="admin.menu.xestionarEspecies.popular.novo"/></a></li>
			<li><a href="/xeopesca/admin/listaNomePopular"><fmt:message key="admin.menu.xestionarEspecies.popular.lista"/></a></li>
			<li><a href="/xeopesca/admin/buscadorNomePopular"><fmt:message key="admin.menu.xestionarEspecies.popular.buscar"/></a></li>
			
			
			
		</ul>
	</li>
	<li><a href="#" class="menulink"><fmt:message key="admin.menu.xestionarArtes"/></a>
	<ul>
			<li><a href="/xeopesca/admin/novoArte"><fmt:message key="admin.menu.xestionarArtes.nova"/></a></li>
			<li><a href="/xeopesca/admin/buscadorArte"><fmt:message key="admin.menu.xestionarArtes.buscar"/></a></li>
			<li><a href="/xeopesca/admin/listaArte"><fmt:message key="admin.menu.xestionarArtes.lista"/></a></li>
		</ul>
	</li>
	
	<!--  
	<li>
		<a href="#" > <img src="/images/home.png" /></a>	
	</li>
	<li>
		<a href="#" > <img src="/images/on_off.png" /></a>	
	</li>-->	
	
	
	
	
	
</ul>
</div> <br> <br> 




    
<script type="text/javascript">
	var menu=new menu.dd("menu");
	menu.init("menu","menuhover");
</script>