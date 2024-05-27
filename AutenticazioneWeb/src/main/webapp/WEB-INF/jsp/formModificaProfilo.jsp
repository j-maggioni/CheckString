<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="navBar.jsp"></jsp:include>

<!DOCTYPE html>
<html>
    <head>
        <title>Modifica dati utente</title>
        <%@ include file="includes.jsp" %>
    </head>
    <body>
        <div id="carouselExampleInterval" class="carousel slide carousel-container" data-ride="carousel"
            data-pause="false" data-interval="4000">
            <div class="carousel-inner"></div>
        </div>
        <div class="overlay">
            <button type="button" class="btn close-btn" onclick="history.back()" style = "margin-left: 660px;">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
                    <path d="M4.646 4.646a.5.5 0 011 0L8 7.293l2.354-2.647a.5.5 0 010 1L9 8l2.354 2.354a.5.5 0 11-1 1L8 9.707l-2.354 2.647a.5.5 0 01-1-1L7 8 4.646 5.646a.5.5 0 010-1z"/>
                </svg>
            </button>

            <h3>Modifica dati utente</h3>
            <div class="margini">
                <form:form method="POST" action="modifica"
                modelAttribute="utente" class="row g-3 col-md-12" id="formModificaProfilo">
                    <div class="alert alert-success d-flex align-items-center col-md-6" role="alert" id="alertModificaDati"
                        style = "margin-left: 160px; display: ${editOK} !important; margin-top: 30px">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16">
                           <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
                        </svg>
                        Modifica avvenuta con successo
                    </div>
                    <div class="col-md-6">
                        <form:label for="nome" path="nome" class="form-label">Nome</form:label>
                        <form:input path="nome" id="nome" class="form-control" placeholder="Nome"/>
                        <form:errors path="nome" cssClass="error"/>
                    </div>
                    <div class="col-md-6">
                        <form:label for="cognome" path="cognome" class="form-label">Cognome</form:label>
                        <form:input path="cognome" id="cognome" class="form-control" placeholder="Cognome"/>
                        <form:errors path="cognome" cssClass="error"/>
                    </div>
                    <div class="col-md-12">
                        <form:label for="password" path="password" class="form-label">Password</form:label>
                        <form:password path="password" id="password" class="form-control" placeholder="Password"/>
                        <div class="progress p2">
                            <div id = "progress" class="progress-bar progress-bar-striped progress2" role="progressbar"
                            aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                        <form:errors path="password" cssClass="error"/>
                    </div>
                    <div class="col-md-12">
                        <form:label for="confermaPassword" path="confermaPassword" class="form-label">Conferma password</form:label>
                        <form:password path="confermaPassword" id="confermaPassword" class="form-control" placeholder="Password"/>
                        <form:errors path="confermaPassword" cssClass="error"/>
                    </div>
                    <div class="col-md-12">
                        <form:label for="nazione" path="nazione" class="form-label">Nazione</form:label>
                        <form:input path="nazione" id="nazione" class="form-control" placeholder="Nazione"/>
                        <form:errors path="nazione" cssClass="error"/>
                    </div>
                    <div class="col-md-12">
                        <form:label for="telefono" path="telefono" class="form-label">Numero di telefono</form:label>
                        <div class="input-group">
                            <form:input path="prefisso" id="prefisso" class="form-control" placeholder="Prefisso" value="+39"/>
                            <form:input path="telefono" id="telefono" class="form-control" placeholder="Numero di telefono"/>
                      </div>
                      <form:errors path="telefono" cssClass="error"/>
                    </div>
                    <div class="col-8" style = "margin-top: 30px;">
                        <button class="btn bottone" type="submit" id="salva">Salva</button>
                    </div>
                </form:form>
            </div>
        </div>
        <script src="./resources/js/ControlliModificaProfilo.js"></script>
    </body>
</html>