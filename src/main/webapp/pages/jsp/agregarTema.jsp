<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>AgregarTemaView</title>
</head>
<body>
	<h2>
		Añadir un <b>Tema</b>
	</h2>
	<c:set var="temaView" scope="request" value="${agregarTema}" />
	<form action="/Web/jsp/agregarTema" method="post">
		<p>
			Nombre: <input name="nombre" type="text"
				value="${temaView.tema.nombre}" /></p>
		<p>
			Pregunta: <input name="pregunta" type="text"
				value="${temaView.tema.pregunta}" /></p>
		<p>
			<input type="submit" value="Enviar" />
		</p>
	</form>
	<p>
		<a href="/Web/jsp/home">Volver a Home</a>
	</p>
</body>
</html>