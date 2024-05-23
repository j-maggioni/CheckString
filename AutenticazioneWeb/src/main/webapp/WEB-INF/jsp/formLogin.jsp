<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import ="com.corso.model.*, java.util.*" %>
<% Utente utente = (Utente) request.getAttribute("utente");%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
         <%@ include file="includes.jsp" %>
    </head>
    <body>
        <div id="navbar-container"></div>
        <div id="carouselExampleInterval" class="carousel slide carousel-container" data-ride="carousel"
            data-pause="false" data-interval="4000">
            <div class="carousel-inner"></div>
        </div>
        <div class="overlay">
            <button type="button" class="btn esci" onclick="history.back()" style = "margin-left: 600px;">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-skip-backward-fill" viewBox="0 0 16 16">
                    <path d="M.5 3.5A.5.5 0 0 0 0 4v8a.5.5 0 0 0 1 0V8.753l6.267 3.636c.54.313 1.233-.066 1.233-.697v-2.94l6.267 3.636c.54.314 1.233-.065 1.233-.696V4.308c0-.63-.693-1.01-1.233-.696L8.5 7.248v-2.94c0-.63-.692-1.01-1.233-.696L1 7.248V4a.5.5 0 0 0-.5-.5"/>
                </svg>
            </button>
            <h3>Login</h3>
            <div class="alert alert-danger d-flex align-items-center col-md-4" role="alert" id = "loginAlert"
                style = "margin-left: 160px; display: none !important">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-exclamation-circle-fill" viewBox="0 0 16 16">
                  <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0M8 4a.905.905 0 0 0-.9.995l.35 3.507a.552.552 0 0 0 1.1 0l.35-3.507A.905.905 0 0 0 8 4m.002 6a1 1 0 1 0 0 2 1 1 0 0 0 0-2"/>
                </svg>
                <div>Accesso non eseguito! Email e/o password errate.</div>
            </div>
            <div class="margini">
                <form:form method="POST" action="login"
                modelAttribute="loginUtente" class="row g-3 col-md-12" id="formLogin">
                    <%@ include file="../../resources/html/formLogin.html" %>
                </form:form>
            </div>
        </div>
        <script src="./resources/js/ControlliLogin.js"></script>
    </body>
</html>