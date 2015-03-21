<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Ver votos</title>
</head>
<body>
	<h2>
		Ver <b>Votos</b>
	</h2>
	<c:set var="mostrarVotacionesView" scope="request"
		value="${mostrarVotos}" />
	<c:forEach var="votos" items="${mostrarVotacionesView.votos}">
		<table>
			<tr>
				<th>Nombre</th>
				<th>Número de votos</th>
				<th>Votación media</th>
			</tr>
			<tr>
				<td>${votos.tema.nombre}</td>
				<td>${votos.numeroVotos}</td>
				<td><c:forEach var="media" items="${votos.recopilacionMedias}">
				    <table>
				        <tr>
				            <td>${media.mediaVotos}</td>
  					        <td>${media.nivelEstudios}</td>
				        </tr>
				    </table>
				</c:forEach></td>
			</tr>
		</table>
	</c:forEach>
	<p>
		<a href="/Web/jsp/home">Volver a Home</a>
	</p>
</body>
</html>