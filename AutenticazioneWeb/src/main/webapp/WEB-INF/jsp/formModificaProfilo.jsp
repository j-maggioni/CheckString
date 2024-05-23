<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Modifica dati utente</title>
        <link rel="stylesheet" href="./resources/css/style.css">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

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

            <button type="button" class="btn esci" onclick="history.back()">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-skip-backward-fill" viewBox="0 0 16 16">
                    <path d="M.5 3.5A.5.5 0 0 0 0 4v8a.5.5 0 0 0 1 0V8.753l6.267 3.636c.54.313 1.233-.066 1.233-.697v-2.94l6.267 3.636c.54.314 1.233-.065 1.233-.696V4.308c0-.63-.693-1.01-1.233-.696L8.5 7.248v-2.94c0-.63-.692-1.01-1.233-.696L1 7.248V4a.5.5 0 0 0-.5-.5"/>
                </svg>
            </button>
            <h3 style = "margin-left: 50px;">Modifica dati utente</h3>
            <div class="alert alert-success d-flex align-items-center col-md-4" role="alert"
            id = "alertModificaDati" style = "margin-left: 160px; display: none !important">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16">
                    <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                </svg>
                <div>Modifica avvenuta con successo</div>
            </div>
            <div class="margini">
                <form:form method="POST" action="modificaProfilo"
                    modelAttribute="utenteModificato" class="row g-3 col-md-10" id="formModificaProfilo">
                    <%@ include file="../../resources/html/formModificaProfilo.html" %>
                </form:form>
            </div>
        </div>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/blueimp-md5/2.18.0/js/md5.min.js"></script>
        <script src="./resources/js/ControlliModificaProfilo.js"></script>
    </body>
</html>