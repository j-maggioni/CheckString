<!DOCTYPE html>
<html>
<head>
    <title>Profilo utente</title>
    <link rel="stylesheet" href="style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="margini">
    <form class="row g-3 col-md-10">
        <div class="col-md-8">
            <h3>Profilo utente</h3>
            <table class="table">
                <tbody>
                <tr>
                    <td>Nome</td>
                    <td id="nome"></td>
                </tr>
                <tr>
                    <td>Cognome</td>
                    <td id="cognome"></td>
                </tr>
                <tr>
                    <td>Nazione</td>
                    <td id="nazione"></td>
                </tr>
                <tr>
                    <td>Numero di Telefono</td>
                    <td id="telefono"></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td id="email"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td id="password"></td>
                </tr>
                </tbody>
            </table>
        </div>
    </form>
</div>
</body>
<script>
    function fillTable(){
        document.getElementById('nome').innerHTML = "NOME INSERITO";
        document.getElementById('cognome').innerHTML = "COGNOME INSERITO";
        document.getElementById('nazione').innerHTML = "NAZIONE INSERITA";
        document.getElementById('telefono').innerHTML = "TELEFONO INSERITO";
        document.getElementById('email').innerHTML = "EMAIL INSERITA";
        document.getElementById('password').innerHTML = "PASSWORD INSERITA";
    }
    fillTable();
</script>
</html>