<!-- 
/* --------------------------------------------------------------------
This file is part of xeoPesca

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
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
 
<div class="iconheader">
	<a href="/xeopesca/patron"> <img src="/images/home.png" /></a> <a
		href="/xeopesca/patron/editarConta"> <img src="/images/perfil.png" /></a>
	<a href="j_spring_security_logout"> <img src="/images/on_off.png" /></a>

</div>

<div class="menu">
	<ul class="menu" id="menu">

		<li><a href="#" class="menulink"><fmt:message key="patron.menu.buscador"/> </a>
			<ul>
				<li><a href="/xeopesca/patron/buscadorFaena" >
					<fmt:message key="patron.menu.bfaena"/> </a></li>
				<li><a href="/xeopesca/patron/buscadorpesca">
				<fmt:message key="patron.menu.bpesca"/>
				</a></li>
			</ul></li>


		<li><a href="/xeopesca/patron/novaFaena" class="menulink">
			<fmt:message key="patron.menu.novafaena"/>
		</a>
		<li><a href="/xeopesca/patron/listaFaena" class="menulink">
		<fmt:message key="patron.menu.lfaena"/>
		</a>
	</ul>
</div>
<br>
<br>

<script type="text/javascript" src="/js/script.js"></script>
<script type="text/javascript" src="/js/tab.js"></script>

<script type="text/javascript">
	var menu = new menu.dd("menu");
	menu.init("menu", "menuhover");
</script>