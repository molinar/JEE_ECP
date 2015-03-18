<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>EView</title>
</head>
<body>
    <h2>
        Eliminar un <b>Tema</b>
    </h2>
    <c:set var="mostrarTemasView" scope="request" value="${mostrarTemasBorrar}" />
    
    <table>
        <c:forEach var="tema" items="${mostrarTemasView.temas}">
            <tr>
                <td>${tema.nombre}</td>
                <td>${tema.pregunta}</td>
                <td>Eliminar</td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <a href="/Web/jsp/home">Volver a Home</a>
    </p>
</body>
</html>