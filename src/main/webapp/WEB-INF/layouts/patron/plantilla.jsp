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

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<title><fmt:message key="patron.head"/></title>
<link rel="stylesheet" type="text/css" media="all" href="/js/calendar/jsDatePick_ltr.min.css" />
<link rel="stylesheet" href="/css/estilo.css" type="text/css" />
<link rel="stylesheet" href="/css/tabs.css" type="text/css" />



<script src="http://www.openlayers.org/api/OpenLayers.js"></script>
<script type="text/javascript" src="/js/calendar/jsDatePick.min.1.3.js"></script>
<script src="http://maps.google.com/maps/api/js?v=3.3&sensor=false"></script>


</head>
  <body>

<div id="ReportHeader">
	<h1><fmt:message key="site.title"/> </h1>	
	<tiles:insertAttribute name="menu" />

</div>

	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />


</body>
</html>












