<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import ="com.corso.model.*, java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
         <%@ include file="includes.jsp" %>
    </head>
    <body>
        <%@ include file="navBar.jsp" %>
        <div id="carouselExampleInterval" class="carousel slide carousel-container" data-ride="carousel"
            data-pause="false" data-interval="4000">
            <div class="carousel-inner"></div>
        </div>
        <div class="overlay">
            <button type="button" class="btn close-btn" onclick="history.back()" style = "margin-left: 600px;">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
                                <path d="M4.646 4.646a.5.5 0 011 0L8 7.293l2.354-2.647a.5.5 0 010 1L9 8l2.354 2.354a.5.5 0 11-1 1L8 9.707l-2.354 2.647a.5.5 0 01-1-1L7 8 4.646 5.646a.5.5 0 010-1z"/>
                            </svg>
            </button>
            <h3>Login</h3>
            <div class="alert alert-danger d-flex align-items-center col-md-8" role="alert" id = "loginAlert"
                style = "margin-left: 100px; display: none !important; margin-top: 30px">
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