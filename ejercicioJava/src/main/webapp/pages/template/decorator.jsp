<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title><decorator:title></decorator:title></title>
<!-- Google Font Roboto! -->
<link href='http://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>

<!-- JQuery JS-->
<script src="external/jquery/jquery-1.11.1.min.js"
	type="text/javascript"></script>

<!-- JQueryUI JS-->
<script src="external/jqueryui/jquery-ui.js" type="text/javascript"></script>
<!-- JQueryUI CSS-->
<link href="external/jqueryui/jquery-ui.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="external/jqueryui/jquery-ui.structure.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="external/jqueryui/jquery-ui.theme.css" rel="stylesheet"
	type="text/css" media="all" />

<!-- JQueryUI Form-->
<script src="external/jqueryform/jquery.form.min.js" type="text/javascript"></script>

<!-- Sidebar JS -->
<script src="external/jquerymenu/jquery.multilevelpushmenu.js"
	type="text/javascript"></script>
<!-- Sidebar CSS -->
<link href="external/jquerymenu/jquery.multilevelpushmenu.css"
	rel="stylesheet" type="text/css" media="all" />

<!--  -->
<link href="external/font-awesome-4.2.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" media="all" />
<!-- JS -->
<script type="text/javascript" src="js/jquery-table-handle.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<!-- CSS -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<decorator:head></decorator:head>
</head>

<body>
	<div id="menuContainer">
		<jsp:include page="includes/common_menu.jsp" />
	</div>
	<div id="mainContainer">
		<decorator:body></decorator:body>
	</div>
</body>
</html>