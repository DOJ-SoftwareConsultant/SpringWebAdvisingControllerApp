<!DOCTYPE h1 PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
	<head>
		<title><tiles:insertAttribute name="title"/></title>
		<style>
		    .error {
		        color: red; font-weight: bold;
		    }
		</style>
	</head>
	<body style="text-align: center;">
		<div id="header" style="height: 10%;background-color: gray;"><tiles:insertAttribute name="header"/></div>
		<div id="body" style="height: 70%; background-color: aqua;padding-top: 40px;"><tiles:insertAttribute name="body"/></div>
		<div id="footer" style="height: 10%;background-color: gray;"><tiles:insertAttribute name="footer"/></div>
	</body>
</html>
