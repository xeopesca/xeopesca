<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="iconheader">
	<a href="/xeopesca/listaUsuarios" > <img src="/images/home.png" /></a>
	<a href="/xeopesca/editarConta">    <img src="/images/perfil.png" /></a>
	<a href="<c:url value="j_spring_security_logout"/>" > <img src="/images/on_off.png" /></a>
	
</div>


<div class="menu">
<ul class="menu" id="menu">
		
	<li><a href="#" class="menulink">Xestionar Usuarios</a>
		<ul>
			<li><a href="/xeopesca/admin/novoUsuario">Novo Usuario</a></li>
			<li><a href="/xeopesca/admin/buscadorUsuario">Buscar Usuario</a></li>
			<li><a href="/xeopesca/admin/listaUsuarios">Lista Usuarios</a></li>
		</ul>
	</li>
	<!-- -->
	<li><a href="#" class="menulink">Xestionar Especies</a>
	<ul>
			<li><a href="/xeopesca/admin/novaEspecie">Nova Especie</a></li>
			<li><a href="/xeopesca/admin/buscadorEspecie">Buscar Especies	</a></li>
			<li><a href="/xeopesca/admin/listaEspecies">Lista Especies</a></li>
			<li><a href="/xeopesca/admin/novoNomePopular">Novo nome popular</a></li>
			<li><a href="/xeopesca/admin/listaNomePopular">Lista nome popular</a></li>
			<li><a href="/xeopesca/admin/buscadorNomePopular">Buscar nome popular</a></li>
			
			
			
		</ul>
	</li>
	<li><a href="#" class="menulink">Xestionar Artes</a>
	<ul>
			<li><a href="/xeopesca/admin/novoArte">Novo Arte</a></li>
			<li><a href="/xeopesca/admin/buscadorArte">Buscar Arte</a></li>
			<li><a href="/xeopesca/admin/listaArte">Lista Artes</a></li>
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