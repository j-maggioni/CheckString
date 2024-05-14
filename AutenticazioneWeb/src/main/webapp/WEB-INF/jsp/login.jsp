<%-- esempio di commento --%>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title> Login CheckString</title>
        <link rel="stylesheet" href="./resources/css/style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
        <div class="margini">
            <form class="row g-3 col-md-10">
                <div class="col-md-8">
                    <label class="form-label">E-mail</label>
                    <input type="text" class="form-control" id="email" placeholder="E-mail">
                </div>
                <div class="col-md-8">
                    <label class="form-label">Password</label>
                    <input type="password" class="form-control" id="psw" placeholder="Password">
                </div>
                <div class="col-8">
                    <button type="button" class="btn btn-primary" onclick="location.href = 'Accedi.html'">Accedi</button>
                    <button class="btn btn-link" type="button" id = "registrati" onclick="location.href = 'registrati.html'">Registrati</button>
                </div>
            </form>
        </div>
    </body>
</html>