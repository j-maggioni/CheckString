<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <div class="margini">
            <div class="row g-3 col-md-12">
                <div class="col-md-6">
                    <table class="table">
                        <tbody>
                        <tr>
                            <td>Nome</td>
                            <td id="nome">${utente.nome}</td>
                        </tr>
                        <tr>
                            <td>Cognome</td>
                            <td id="cognome">${utente.cognome}</td>
                        </tr>
                        <tr>
                            <td>Nazione</td>
                            <td id="nazione">${utente.nazione}</td>
                        </tr>
                        <tr>
                            <td>Numero di Telefono</td>
                            <td id="telefono">${utente.telefono}</td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td id="email">${utente.email}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>

                <div class="col-md-6 d-flex flex-column align-items-center justify-content-center">
                    <div class="w-100 d-flex justify-content-end" style = "margin-right: 290px;">
                        <div>
                            <h4 style = "margin-left: 65px;">Riepilogo risultati giochi</h4>
                            <div class="row justify-content-center" style="margin-top: 30px; margin-left: 30px;">
                                <div class="col-auto btn-spacing">
                                    <button class="btn gioco" type="button" data-toggle="collapse" data-target="#collapseExample1" aria-expanded="false" aria-controls="collapseExample1">
                                    Indovina la bandiera
                                    </button>
                                </div>
                                <div class="col-auto">
                                    <button class="btn gioco" type="button" data-toggle="collapse" data-target="#collapseExample2" aria-expanded="false" aria-controls="collapseExample2">
                                    Indovina la capitale
                                    </button>
                                </div>
                                <div class="col-auto">
                                    <button class="btn gioco" type="button" data-toggle="collapse" data-target="#collapseExample3" aria-expanded="false" aria-controls="collapseExample3">
                                    Indovina la nazione
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <br>
                    <!-- Collapse panels with data-parent -->
                    <div id="accordion">
                        <div class="collapse" id="collapseExample1" data-parent="#accordion">
                            <div class="card card-body">
                                <table class="table">
                                    <p class = "titoloGioco">Indovina la bandiera</p>
                                    <tbody>
                                    <tr>
                                        <th> </th>
                                        <th>Punti</th>
                                        <th>Data</th>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=X6CJMckcVrBj&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['IndovinaBandiera'][0].punti}</td>
                                        <td>${giochi['IndovinaBandiera'][0].data}</td>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=dgAxfaiZaNr6&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['IndovinaBandiera'][1].punti}</td>
                                        <td>${giochi['IndovinaBandiera'][1].data}</td>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=lMwvkoCmvpSJ&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['IndovinaBandiera'][2].punti}</td>
                                        <td>${giochi['IndovinaBandiera'][2].data}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="collapse" id="collapseExample2" data-parent="#accordion">
                            <div class="card card-body">
                                <p class = "titoloGioco">Indovina la capitale</p>
                                <table class="table">
                                    <tbody>
                                    <tr>
                                        <th> </th>
                                        <th>Punti</th>
                                        <th>Data</th>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=X6CJMckcVrBj&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['IndovinaCapitale'][0].punti}</td>
                                        <td>${giochi['IndovinaCapitale'][0].data}</td>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=dgAxfaiZaNr6&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['IndovinaCapitale'][1].punti}</td>
                                        <td>${giochi['IndovinaCapitale'][1].data}</td>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=lMwvkoCmvpSJ&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['IndovinaCapitale'][2].punti}</td>
                                        <td>${giochi['IndovinaCapitale'][2].data}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="collapse" id="collapseExample3" data-parent="#accordion">
                            <div class="card card-body">
                                 <p class = "titoloGioco">Indovina la nazione</p>
                                <table class="table">
                                    <tbody>
                                    <tr>
                                        <th> </th>
                                        <th>Punti</th>
                                        <th>Data</th>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=X6CJMckcVrBj&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['IndovinaNazione'][0].punti}</td>
                                        <td>${giochi['IndovinaNazione'][0].data}</td>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=dgAxfaiZaNr6&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['IndovinaNazione'][1].punti}</td>
                                        <td>${giochi['IndovinaNazione'][1].data}</td>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=lMwvkoCmvpSJ&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['IndovinaNazione'][2].punti}</td>
                                        <td>${giochi['IndovinaNazione'][2].data}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="btn-group mr-2" style="margin-top: 30px; margin-left: 25px">
                <div class="mr-2">
                    <button type="button" class="btn bottone" id="btnModifica" onclick="location.href = 'modifica_profilo'">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                        <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                    </svg>
                    Modifica
                </button>
                </div>

                <div class="mr-2">
                    <button type="button" class="btn esci" id="eliminaB" onclick="location.href = 'elimina_utente'">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
                        <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5M11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47M8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5"/>
                    </svg>
                    Elimina
                    </button>
                </div>
            </div>
        </div>


    </div>
    <script src="./resources/js/ControlliModificaProfilo.js"></script>
</body>
</html>