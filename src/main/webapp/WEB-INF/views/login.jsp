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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- novas -->
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<c:if test="${param.error == 'true'}">
	<div class="container">
		<div class="span7 offset2">
			<div class="alert">
				<a class="close" data-dismiss="alert-error">x</a> <strong>Erro!</strong>
				Datos de acceso incorrectos comprobe contrasinal e usuario.

			</div>
		</div>
	</div>

</c:if>

<div id="container">

	<form class="form-signin" name="f" action="<c:url value='j_spring_security_check'/>"
		method="POST">
        <h2 class="form-signin-heading">Identif&#237cate</h2>
		

		<input class="input-block-level" placeholder="Conta de usuario" type='text' name='j_username' id="user" value=''/>
		 <input class="input-block-level" placeholder="Contrasinal" type='password' name='j_password' id="pass">

	
	<button class="btn btn-large btn-primary" type="submit">Entrar</button>
</form>
</div>




	<script src="/bootstrap/js/bootstrap-alert.js"></script> 
	<script src="/bootstrap/js/jquery.js"></script> 
    


