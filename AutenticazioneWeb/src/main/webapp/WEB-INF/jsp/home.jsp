<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import ="com.corso.model.*, java.util.*" %>
<!DOCTYPE html>
    <html lang="it">
    <head>
        <meta charset="UTF-8">
        <title>Home</title>
        <%@ include file="includes.jsp" %>
        <%@ include file="navBar.jsp" %>
        <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css" />
                <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
        </head>
        <body>
        <%@ include file="../../resources/html/home.html" %>
        <script src="./resources/js/MostraMappa.js"></script>
        </body>
</html>

