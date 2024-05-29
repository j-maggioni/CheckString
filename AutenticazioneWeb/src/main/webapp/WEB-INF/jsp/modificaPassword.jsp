<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="navBar.jsp"></jsp:include>

<!DOCTYPE html>
<html>
    <head>
        <title>Modifica password utente</title>
        <%@ include file="includes.jsp" %>
    </head>
    <body>
        <div id="carouselExampleInterval" class="carousel slide carousel-container" data-ride="carousel"
            data-pause="false" data-interval="6000">
            <div class="carousel-inner"></div>
        </div>
        <div class="overlay">
            <button type="button" class="btn close-btn" onclick="history.back()" style = "margin-left: 660px;">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
                    <path d="M4.646 4.646a.5.5 0 011 0L8 7.293l2.354-2.647a.5.5 0 010 1L9 8l2.354 2.354a.5.5 0 11-1 1L8 9.707l-2.354 2.647a.5.5 0 01-1-1L7 8 4.646 5.646a.5.5 0 010-1z"/>
                </svg>
            </button>
             <h3 class = "permanent-marker-regular">Modifica password</h3>
               <div class="margini">
                   <form:form method="POST" action="modifica_password" modelAttribute="formPasswordModificata" class="row g-3 col-md-12" id="formModificaPassword">
                       <div class="col-md-12">
                           <form:label for="password" path="password" class="form-label">Password</form:label>
                           <form:password path="password" id="password" class="form-control" placeholder="Password"/>
                           <form:errors path="password" cssClass="error"/>
                       </div>
                       <div class="col-md-12">
                           <form:label for="confermaPassword" path="confermaPassword" class="form-label">Conferma password</form:label>
                           <form:password path="confermaPassword" id="confermaPassword" class="form-control" placeholder="Conferma Password"/>
                           <form:errors path="confermaPassword" cssClass="error"/>
                       </div>
                       <div class="col-8" style="margin-top: 30px;">
                           <button class="btn bottone" type="submit" id="salvaPassword">Salva Password</button>
                       </div>
                   </form:form>
            </div>
        </div>
        <script src="./resources/js/ControlliModificaProfilo.js"></script>
    </body>
</html>