<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.corso.model.*, java.util.*" %>
<% Utente utente = (Utente) session.getAttribute("utente");%>
<jsp:include page="navBar.jsp"></jsp:include>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profilo utente</title>
    <%@ include file="includes.jsp" %>
</head>
<body>
    <div id="carouselExampleInterval" class="carousel slide carousel-container" data-ride="carousel"
        data-pause="false" data-interval="4000">
        <div class="carousel-inner"></div>
    </div>
    <div class="overlayP">
        <%@include  file="../../resources/html/profilo.html" %>    </div>
    <script src="./resources/js/ControlliModificaProfilo.js"></script>
</body>
</html>