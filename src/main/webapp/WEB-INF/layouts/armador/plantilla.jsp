<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />

<title>Administrador</title>
<link rel="stylesheet" href="/css/estilo.css" type="text/css" />
<link rel="stylesheet" href="/css/tabs.css" type="text/css" />
<link rel="stylesheet" type="text/css" media="all" href="/js/calendar/jsDatePick_ltr.min.css" />


<script type="text/javascript" src="/js/script.js"></script>
<script type="text/javascript" src="/js/tab.js"></script>


<script src="http://www.openlayers.org/api/OpenLayers.js"></script>
<script type="text/javascript" src="/js/calendar/jsDatePick.min.1.3.js"></script>
<script src="http://maps.google.com/maps/api/js?v=3.3&sensor=false"></script>


</head>
<body>


<div id="ReportHeader">
	<h1>xeoPesca </h1>	
	<tiles:insertAttribute name="menu" />


</div>

	<tiles:insertAttribute name="body" />
	<!--<tiles:insertAttribute name="footer" />-->


</body>
</html>












