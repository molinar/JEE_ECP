<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>AutorizarView</title>
</head>
<body>
	<h2>
		Autorización <b>Usuario</b>
	</h2>
	<c:set var="autorizarView" scope="request" value="${autorizar}" />
	<form action="/Web/jsp/autorizar" method="post">
		<p>
			Código autorización: <input name="codigo" type="text"
				value="${autorizarView.codigo}" /></p>
		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>
	<p>
		<a href="/Web/jsp/home">Volver a Home</a>
	</p>
</body>
</html>