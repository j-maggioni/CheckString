<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.corso.model.*, java.util.*" %>
<% Utente utente = (Utente) request.getAttribute("utente");%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profilo utente</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./resources/css/style.css">
    <script src="${pageContext.request.contextPath}/resources/js/ControlliSfondoHome.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/ControlliNavBar.js"></script>
</head>
<body>
    <div id="navbar-container"></div>
    <div id="carouselExampleInterval" class="carousel slide carousel-container" data-ride="carousel"
        data-pause="false" data-interval="4000">
        <div class="carousel-inner"></div>
    </div>
    <div class="overlay">
        <%@include  file="../../resources/html/profilo.html" %>
        <!--%@include  file="../../resources/html/formModificaProfilo.html" %-->

        <div class="btn-group" style="margin-left: 70px; margin-top: 30px;">
            <button type="button" class="btn bottone" id="btnModifica" onclick="location.href = 'formModificaProfilo.html'">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                    <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                    <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                </svg>
                Modifica
            </button>


        </div>

    </div>
    <script src="./resources/js/ControlliModificaProfilo.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>

</html>