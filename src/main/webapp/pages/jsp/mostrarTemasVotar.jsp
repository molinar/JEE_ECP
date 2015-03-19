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
    <c:set var="mostrarTemasVotarView" scope="request" value="${mostrarTemasVotar}" />
    
    <table>
        <form action="/Web/jsp/mostrarFormularioVotacion" method="post"> 
            <tr>
                <td>
                    <select name= tema>
                        <c:forEach var="tema" items="${mostrarTemasVotarView.temas}">
                            <option value="${tema.id}">${tema.nombre}</option>
                        </c:forEach>
                    </select>
                </td>
                <td><input type="submit" value="Seleccionar"/></td>
            </tr>
        </form>
    </table>
    <p>
        <a href="/Web/jsp/home">Volver a Home</a>
    </p>
</body>
</html>