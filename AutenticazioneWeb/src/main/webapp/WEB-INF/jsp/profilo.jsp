<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.corso.model.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profilo utente</title>
<link rel="stylesheet" href="./resources/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<%@include  file="./html/profilo.html" %>
</body>
<script>
    function fillTable(){
        <% Utente utente = (Utente) request.getAttribute("utente");%>
        alert(<%= utente%>)
        document.getElementById('nome').innerHTML = <%= utente.getNome() %>;
        document.getElementById('cognome').innerHTML = <%= utente.getCognome() %>;
        document.getElementById('nazione').innerHTML = <%= utente.getNazione() %>;
        document.getElementById('telefono').innerHTML = <%= utente.getTelefono() %>;
        document.getElementById('email').innerHTML = <%= utente.getEmail() %>;
        document.getElementById('password').innerHTML = <%= utente.getPassword() %>;
    }
    fillTable();
</script>

</html>