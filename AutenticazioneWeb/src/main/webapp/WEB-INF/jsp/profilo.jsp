<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="navBar.jsp"></jsp:include>
 ${giochi}
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
        data-pause="false" data-interval="6000">
        <div class="carousel-inner"></div>
    </div>
    <div class="overlayP">
    <button type="button" class="btn close-btn" onclick="history.back()" style = "margin-left: 1250px;">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
                    <path d="M4.646 4.646a.5.5 0 011 0L8 7.293l2.354-2.647a.5.5 0 010 1L9 8l2.354 2.354a.5.5 0 11-1 1L8 9.707l-2.354 2.647a.5.5 0 01-1-1L7 8 4.646 5.646a.5.5 0 010-1z"/>
                </svg>
            </button>
           <h3 style = "margin-left: 50px" class = "permanent-marker-regular">Profilo utente</h3>
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
                    <div class="w-100 d-flex justify-content-end" style = "margin-left: 40px;">
                        <div>
                            <h4 style = "text-align: center" class = "permanent-marker-regular">Riepilogo risultati giochi</h4>
                            <div class="row justify-content-center" style="margin-top: 30px; margin-right: 3px">
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
                                <table class="table" id = "table1" style = "display: none">
                                    <tbody>
                                    <tr>
                                        <th> </th>
                                        <th>Punti</th>
                                        <th>Data</th>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=X6CJMckcVrBj&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['indovina_bandiera'][0].punti}</td>
                                        <td>${giochi['indovina_bandiera'][0].data}</td>
                                    </tr>
                                   
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=dgAxfaiZaNr6&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['indovina_bandiera'][1].punti}</td>
                                        <td>${giochi['indovina_bandiera'][1].data}</td>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=lMwvkoCmvpSJ&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['indovina_bandiera'][2].punti}</td>
                                        <td>${giochi['indovina_bandiera'][2].data}</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div id = "link1" style = "display: none !important">
                                    <a class="nav-link" href="indovina_bandiera" id="gioco1Btn">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-flag-fill" viewBox="0 0 16 16">
                                            <path d="M14.778.085A.5.5 0 0 1 15 .5V8a.5.5 0 0 1-.314.464L14.5 8l.186.464-.003.001-.006.003-.023.009a12 12 0 0 1-.397.15c-.264.095-.631.223-1.047.35-.816.252-1.879.523-2.71.523-.847 0-1.548-.28-2.158-.525l-.028-.01C7.68 8.71 7.14 8.5 6.5 8.5c-.7 0-1.638.23-2.437.477A20 20 0 0 0 3 9.342V15.5a.5.5 0 0 1-1 0V.5a.5.5 0 0 1 1 0v.282c.226-.079.496-.17.79-.26C4.606.272 5.67 0 6.5 0c.84 0 1.524.277 2.121.519l.043.018C9.286.788 9.828 1 10.5 1c.7 0 1.638-.23 2.437-.477a20 20 0 0 0 1.349-.476l.019-.007.004-.002h.001"/>
                                        </svg> Indovina la bandiera
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="collapse" id="collapseExample2" data-parent="#accordion">
                            <div class="card card-body">
                                <table class="table" id = "table2" style = "display: none !important">
                                    <tbody>
                                    <tr>
                                        <th> </th>
                                        <th>Punti</th>
                                        <th>Data</th>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=X6CJMckcVrBj&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['indovina_capitale'][0].punti}</td>
                                        <td>${giochi['indovina_capitale'][0].data}</td>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=dgAxfaiZaNr6&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['indovina_capitale'][1].punti}</td>
                                        <td>${giochi['indovina_capitale'][1].data}</td>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=lMwvkoCmvpSJ&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['indovina_capitale'][2].punti}</td>
                                        <td>${giochi['indovina_capitale'][2].data}</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div id = "link2" style = "display: none !important">
                                    <a class="nav-link" href="indovina_capitale" id="gioco2Btn">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-geo-alt-fill" viewBox="0 0 16 16">
                                            <path d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10m0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6"/>
                                        </svg> Indovina la capitale
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="collapse" id="collapseExample3" data-parent="#accordion">
                            <div class="card card-body">
                                <table class="table" id = "table3" style = "display: none !important">
                                    <tbody>
                                    <tr>
                                        <th> </th>
                                        <th>Punti</th>
                                        <th>Data</th>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=X6CJMckcVrBj&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['indovina_nazione'][0].punti}</td>
                                        <td>${giochi['indovina_nazione'][0].data}</td>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=dgAxfaiZaNr6&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['indovina_nazione'][1].punti}</td>
                                        <td>${giochi['indovina_nazione'][1].data}</td>
                                    </tr>
                                    <tr>
                                        <td><img src = "https://img.icons8.com/?size=100&id=lMwvkoCmvpSJ&format=png&color=000000" width="30" height="30" ></td>
                                        <td style = "text-align: center;">${giochi['indovina_nazione'][2].punti}</td>
                                        <td>${giochi['indovina_nazione'][2].data}</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div id = "link3" style = "display: none !important">
                                   <a class="nav-link" href="indovina_nazione" id="gioco3Btn">
                                      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-globe-americas" viewBox="0 0 16 16">
                                          <path d="M8 0a8 8 0 1 0 0 16A8 8 0 0 0 8 0M2.04 4.326c.325 1.329 2.532 2.54 3.717 3.19.48.263.793.434.743.484q-.121.12-.242.234c-.416.396-.787.749-.758 1.266.035.634.618.824 1.214 1.017.577.188 1.168.38 1.286.983.082.417-.075.988-.22 1.52-.215.782-.406 1.48.22 1.48 1.5-.5 3.798-3.186 4-5 .138-1.243-2-2-3.5-2.5-.478-.16-.755.081-.99.284-.172.15-.322.279-.51.216-.445-.148-2.5-2-1.5-2.5.78-.39.952-.171 1.227.182.078.099.163.208.273.318.609.304.662-.132.723-.633.039-.322.081-.671.277-.867.434-.434 1.265-.791 2.028-1.12.712-.306 1.365-.587 1.579-.88A7 7 0 1 1 2.04 4.327Z"/>
                                      </svg>
                                      Indovina la nazione</a>
                                </div>
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
    <script>

   var gioco1 = ${giochi['indovina_bandiera'][0]};
   var gioco2 = ${giochi['indovina_capitale'][0]};
   var gioco3 = ${giochi['indovina_nazione'][0]};

    if (gioco1) {
        document.getElementById('table1').style.display = "inline"
    } else {
        document.getElementById('link1').style.display = "inline"
    }

    if (gioco2) {
            document.getElementById("table2").style.display = "inline"
    } else {
        document.getElementById("link2").style.display = "inline"
    }

    if (gioco3) {
            document.getElementById("table3").style.display = "inline"
    } else {
        document.getElementById("link3").style.display = "inline"
    }

    </script>
</body>
</html>