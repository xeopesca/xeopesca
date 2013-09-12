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
<div class="iconheader">
	<a href="/xeopesca/armador" > <img src="/images/home.png" /></a>
	<a href="/xeopesca/armador/editarConta">    <img src="/images/perfil.png" /></a>
	<a href="j_spring_security_logout" > <img src="/images/on_off.png" /></a>
	
</div>

<div class="menu">
<ul class="menu" id="menu">
	<li><a href="/xeopesca/armador/buscador" class="menulink">Buscar faenas</a>
	</li>
	<!-- -->
	<li><a href="#" class="menulink">Xestionar barco</a>
	<ul>
			<li><a href="/xeopesca/armador/novoBarco">Novo barco</a></li>
			<li><a href="/xeopesca/armador/listaBarco">Lista de barcos</a></li>
			<li><a href="/xeopesca/armador/buscadorBarco">Buscador de barcos</a></li>
		</ul>
	</li>
	<li><a href="#" class="menulink">Xestionar patr&#243n</a>
	<ul>
			<li><a href="/xeopesca/armador/novoPatron">Novo patr&#243n</a></li>
			<li><a href="/xeopesca/armador/listaPatron">Lista de patr&#243ns</a></li>
			<li><a href="/xeopesca/armador/buscadorPatron">Buscar  patr&#243ns</a></li>
		</ul>
	</li>
	
</ul>
</div> <br> <br> 

<script type="text/javascript">
	var menu=new menu.dd("menu");
	menu.init("menu","menuhover");
</script>