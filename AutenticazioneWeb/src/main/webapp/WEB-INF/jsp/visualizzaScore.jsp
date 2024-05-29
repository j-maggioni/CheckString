<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    ${classificaGenerale}
    ${storicoPersonale}
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Riepilogo Risultati Giochi</title>
    <%@ include file="includes.jsp" %>

    <style>
        .container {
            text-align: center;
            margin: 20px;
        }
        .btn-spacing {
            margin: 10px;
        }
        .highlight {
            background-color: yellow; /* Cambia il colore a tuo piacimento */
        }
    </style>
</head>
<body>
    <div class="container">
    <h1>Risultati</h1>

    <h2>Il tuo punteggio &egrave; stato di <span id="current-score">${partita.punti}</span></h2>

        <div class="row justify-content-center" style="margin-top: 30px;">
                   <div class="col-auto btn-spacing">
                       <button class="btn btn-primary" type="button"
                        data-toggle="collapse" data-target="#collapseGenerale"
                         aria-expanded="false" aria-controls="collapseGenerale">
                           Classifica Generale
                       </button>
                   </div>
                   <div class="col-auto btn-spacing">
                       <button class="btn btn-secondary" type="button"
                       data-toggle="collapse" data-target="#collapsePersonale"
                        aria-expanded="false" aria-controls="collapsePersonale">
                           Classifica Personale
                       </button>
                   </div>
               </div>

                <div class="collapse" id="collapseGenerale">
                    <div class="card card-body">
                    <div id="classificaGenerale" style="display: none;">
                                <h2>Classifica Generale</h2>
                                <table id="game-scores">
                                    <tr>
                                        <th>Posizione</th>
                                        <th>Punteggio</th>
                                        <th>Nome Utente</th>
                                    </tr>
                                    <c:forEach var="scoreData" items="${classificaGenerale}">
                                        <tr>
                                            <td>1</td>
                                            <td>${scoreData.punti}</td>
                                            <td>${scoreData.utente}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>

                    </div>
                </div>
                <div class="collapse" id="collapsePersonale">
                    <div class="card card-body">
                    <div id="classificaPersonale" style="display: none;">
                                <h2>Classifica Personale</h2>
                                <table id="personal-scores">
                                    <tr>
                                        <th>Posizione</th>
                                        <th>Punteggio</th>
                                        <th>Data</th>
                                    </tr>
                                    <c:forEach var="personalScoreData" items="${storicoPersonale}">
                                        <tr>
                                            <td>1</td>
                                             <td>${personalscoreData.punti}</td>
                                             <td>${personalscoreData.utente}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>

                    </div>
                </div>


    </div>

    <script>
        function showGenerale() {
            document.getElementById('classificaGenerale').style.display = 'block';
            document.getElementById('classificaPersonale').style.display = 'none';
        }

        function showPersonale() {
            document.getElementById('classificaGenerale').style.display = 'none';
            document.getElementById('classificaPersonale').style.display = 'block';
        }
    </script>
    <script>
    // Evidenzia l'ultimo punteggio
    let scoreCells = document.querySelectorAll('.score');
    scoreCells.forEach(cell => {
        if (cell.getAttribute('data-score') == currentScore) {
            cell.parentElement.classList.add('highlight');
        }
    });
};

displayCurrentScore('current-score');
});
</script>
</body>
</html>


        <button class="btn btn-primary" type="button" id="tryAgain"
        onclick="location.href = '${gioco_prec}'">Gioca di nuovo</button>
        </div>




