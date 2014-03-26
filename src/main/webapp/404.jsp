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


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="error.page.404"/></title>
<link rel="stylesheet" href="/css/estilo.css" type="text/css" />
</head>
<body>

<div class="ReportHeader" id="ReportHeader">
	<h1><fmt:message key="site.title"/> </h1>	
</div>

<div id="container">

        <h2 class="form-signin-heading"><fmt:message key="error.page.404"/></h2>
		
		<p><fmt:message key="error.page.404.message"/>  <button class="btn btn-large btn-primary" type="submit">	<fmt:message key="error.page.404.button.home"/> 
		</button></p>
	
</div>



<div id="ReportFooter"><fmt:message key="site.footer"/>  </div>
</body>
</html>