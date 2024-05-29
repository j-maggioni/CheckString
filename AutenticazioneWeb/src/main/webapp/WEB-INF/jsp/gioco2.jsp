<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="navBar.jsp"></jsp:include>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Indovina Capitale</title>
    <%@ include file="includes.jsp" %>
    <style>
        .container {
            text-align: center;
            margin: 20px;
        }
        .btn {
            margin: 10px;
        }
    </style>
</head>
<body style="background: linear-gradient(45deg, #8BC6FF, #BCEAFF);">
    <div class="modal fade" id="gameOverModal_gioco2" tabindex="-1" aria-labelledby="gameOverModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content" style="border-radius: 15px; box-shadow: 0 5px 15px rgba(0,0,0,0.5);">
                    <div class="modal-header">
                        <h5 class="modal-title" id="gameOverModalLabel">Partita terminata</h5>
                    </div>
                    <div class="modal-body text-center">
                        &Egrave; scaduto il tempo!
                        Scopri il punteggio che hai totalizzato e la tua posizione in classifica!
                    </div>
                    <div class="modal-footer justify-content-center">


                    <form:form id="giocoVO_gioco2" method="POST" action="salvaScore" modelAttribute="partita">
                        <form:input for="data" path="data" value="${partita.data}" type="hidden"/>
                        <form:input for="punti" path="punti" type="hidden"/>
                        <form:input for="gioco" path="gioco" value="${partita.gioco}" type="hidden"/>
                        <button class="btn btn-secondary" type="submit" id="viewLeaderboardButton_gioco2">Vedi il tuo punteggio</button>
                    </form:form>
                    </div>
                </div>
            </div>
        </div>
    <div>
        <div class="row mt-2 d-flex justify-content-center">
                <h3  class="col-6, montserrat" id = "titoloGiochi"> Score : <span id="score" class="score">0</span> punti</h3>
                <h3 class= "col-6" id="timer">00:00</h3>
        </div>
        <div class="col-12 d-flex justify-content-center align-items-center" style = "margin-top: 30px; text-align: center;">
            <h1 id="nazione" style="margin: 0;">Italia</h1>
        </div>
        <!-- Buttons -->
        <div class="row mt-5 gap-2 align-items-center justify-content-center">
            <div class="col-6 col-md-3">
                <button type="button" class="btn gioco btn-outline-secondary btn-lg btn-block" id="capitale1"></button>
                <button type="button" class="btn gioco btn-outline-secondary btn-lg btn-block" id="capitale2"></button>
            </div>
            <div class="col-6 col-md-3">
                <button type="button" class="btn gioco btn-outline-secondary btn-lg btn-block" id="capitale3"></button>
                <button type="button" class="btn gioco btn-outline-secondary btn-lg btn-block" id="capitale4"></button>
            </div>
        </div>
    </div>
    <form id="nextQuestion" class="mt-4" style="text-align: center; margin-top: 20px !important;">
        <button class="btn esci btn-lg" type="button">Next
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right" viewBox="0 0 16 16">
                <path fill-rule="evenodd" d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8"/>
            </svg>
        </button>
    </form>
    <script src="./resources/js/gioco2.js"></script>

</body>
</html>