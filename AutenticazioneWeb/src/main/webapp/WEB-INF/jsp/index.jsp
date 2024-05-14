<%-- esempio di commento --%>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title> Home CheckString </title>
<link rel="stylesheet" href="./resources/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<style>
        .custom-btn {
            background-color: #20c997;
            color: #fff;
        }
	</style>
</head>
<body>
<div class="position-absolute top-50 start-50 translate-middle">
	<div class="d-grid gap-2">
		<button class="btn btn-lg custom-btn" type="button" onclick="location.href = 'login.html'">Accedi</button>
		<button class="btn btn-lg custom-btn" type="button" onclick="location.href = 'registrati.html'">Registrati</button>
	</div>
</div>
</body>
</html>