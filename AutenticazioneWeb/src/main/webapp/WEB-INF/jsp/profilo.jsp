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
    <button type="button" class="btn close-btn" onclick="history.back()" style = "margin-left: 1250px;">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
                    <path d="M4.646 4.646a.5.5 0 011 0L8 7.293l2.354-2.647a.5.5 0 010 1L9 8l2.354 2.354a.5.5 0 11-1 1L8 9.707l-2.354 2.647a.5.5 0 01-1-1L7 8 4.646 5.646a.5.5 0 010-1z"/>
                </svg>
            </button>
           <h3 style = "margin-left: 50px">Profilo utente</h3>
        <%@include  file="../../resources/html/profilo.html" %>
        <!--%@include  file="../../resources/html/formModificaProfilo.html" %-->

    </div>
    <script src="./resources/js/ControlliModificaProfilo.js"></script>
</body>
</html>