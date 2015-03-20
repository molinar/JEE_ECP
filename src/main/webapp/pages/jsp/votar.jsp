<?xml version="1.0" encoding="UTF-8"  ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Votar Tema</title>
</head>
<body>
    <h2>
        Votar un <b>Tema</b>
    </h2>
    <c:set var="temaVotarView" scope="request" value="${mostrarTema}" />
     
    <table>
        <form action="/Web/jsp/votar" method="post"> 
            <input type="hidden" value="${temaVotarView.tema.id}" name="id" />
            <tr>
                <td>${temaVotarView.tema.nombre}</td>
                <td>${temaVotarView.tema.pregunta}</td>
                <td>N. Estudios: 
                    <select name="nivelEstudios">
                    <c:forEach var="nivelEstudios" items="${temaVotarView.nivelEstudios}">
                        <option value="${nivelEstudios}"}>${temaVotarView.nivelEstudios}</option>
                    </c:forEach>
                    </select>
                </td>
                <td>Valoracion: 
                    <select name="valoracion">
                    <c:forEach var="num" begin="0" end="10">
                        <option value="${num}"}>${num}</option>
                    </c:forEach>
                    </select>
                </td>              
                <td><input type="submit" value="Votar"/></td>
            </tr>
        </form>
    </table>
    <p>
        <a href="/Web/jsp/home">Volver a Home</a>
    </p>
</body>
</html>