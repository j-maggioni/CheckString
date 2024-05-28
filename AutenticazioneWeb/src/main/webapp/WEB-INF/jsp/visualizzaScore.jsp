<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="navBar.jsp"></jsp:include>

<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Risultati del Gioco</title>
    <style>
        .container {
            text-align: center;
            margin: 20px;
        }
        .btn {
            margin: 10px;
        }
        table {
            width: 50%;
            margin: 0 auto 20px;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Risultati</h1>

        <h2>Il tuo punteggio è stato di <span id="current-score"></span></h2>
        <table id="game-scores">  ////////// <!--${score}-->
            <tr>
                <th>Posizione</th>
                <th>Punteggio</th>
                <th>Data</th>
            </tr>
            <tr><td>1</td><td></td><td></td></tr>
            <tr><td>2</td><td></td><td></td></tr>
            <tr><td>3</td><td></td><td></td></tr>
            <tr><td>4</td><td></td><td></td></tr>
            <tr><td>5</td><td></td><td></td></tr>
        </table>

        <button class="btn close-btn btn-lg" type="button" onclick="restartGame()" style="background-color: rgb(183, 79, 79); color: white; font-family: cursive">Rigioca</button>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", () => {
            const displayScores = (gameId, tableId) => {
                let scores = JSON.parse(localStorage.getItem(gameId)) || [];
                let table = document.getElementById(tableId);

                scores.forEach((scoreData, index) => {
                    if (index < 5) {
                        let row = table.rows[index + 1];
                        let cell2 = row.cells[1];
                        let cell3 = row.cells[2];
                        cell2.textContent = scoreData.score;
                        cell3.textContent = new Date(scoreData.date).toLocaleDateString('it-IT');
                    }
                });
            };

            const displayCurrentScore = (scoreId) => {
                let currentScore = localStorage.getItem(scoreId) || 0;
                document.getElementById('current-score').textContent = currentScore;
            };

            const restartGame = () => {
                window.location.href = 'gioco2.jsp'; <!--penso non ne sono sicurio-->
            };

            displayCurrentScore('current-score');
            displayScores('game-scores', 'game-scores');
        });
    </script>
</body>
</html>



