<%-- esempio di commento --%>
<%@page contentType="text/html; charset=UTF-8" %>
<html>
<head>
<title> Registrati CheckString </title>
<link rel="stylesheet" href="./resources/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="margini">
<form class="row g-3 col-md-10">
	<div class="col-md-4">
		<label class="form-label">Nome</label>
		<input type="text" class="form-control" id="nome" placeholder="Nome">
		<span class="errorMessage" id = "nomeErrore">Inserisci un nome</span>
	</div>
	<div class="col-md-4">
		<label class="form-label">Cognome</label>
		<input type="text" class="form-control" id="cognome" placeholder="Cognome">
		<span class="errorMessage" id = "cognomeErrore">Inserisci un cognome</span>
	</div>
	<div class="col-md-8">
		<label class="form-label">E-mail</label>
		<input type="text" class="form-control" id="email" placeholder="E-mail">
		<span class="errorMessage" id = "emailErrore">Inserisci una e-mail valida</span>
	</div>
	<div class="col-md-8">
		<label class="form-label">Password</label>
		<input type="password" class="form-control" id="password" placeholder="Password">
		<span class="errorMessage" id = "pswErrore">La password deve avere almeno 8 caratteri e contenere almeno una lettera maiuscola, minuscola, numero e carattere speciale</span>
	</div>
	<div class="col-md-8">
		<label class="form-label">Conferma password</label>
		<input type="password" class="form-control" id="Cpassword" placeholder="Password">
		<span class="errorMessage" id = "CpswErrore">Le password sono diverse</span>
	</div>
	<div class="col-md-8">
		<label class="form-label">Nazione</label>
		<input type="text" class="form-control" id="city" placeholder="Nazione">
		<span class="errorMessage" id = "cityErrore">Inserisci una nazione</span>
	</div>
	<div class="col-md-8">
    <label class="form-label">Numero di Telefono</label>
    <div class="input-group">
        <input type="text" class="form-control" id="prefisso" placeholder="Prefisso" value = "+39">
        <input type="text" class="form-control" id="telefono" placeholder="Numero di telefono">
    </div>
	<span class="errorMessage" id="telefonoErrore">Inserisci un numero di telefono valido</span>
</div>
	<div class="col-8" style="margin-top: 50px;">
	<div class="form-check">
      <input class="form-check-input" type="checkbox" id="termini">
      <label class="form-check-label">Accetta i termini e le condizioni</label><br>
	  <span class="errorMessage" id="terminiErrore">Devi accettare i termini e le condizioni per proseguire</span>
    </div>
	</div>
	<div class="col-8">
		<button class="btn btn-primary" type="submit" id = "registrati">Registrati</button>
		<button type="button" class="btn btn-link" onclick="location.href = 'login.html'">Accedi</button>
	</div>

	<div class="alert alert-success d-flex align-items-center" role="alert" id = "alert" style = "display: none !important">
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16">
			<path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0m-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
		  </svg>
		<div> &nbsp;&nbsp;Registrazione avvenuta con successo</div>
		</div>
</form>
</div>
<script src="./resources/js/ControlliLogin.js"></script>
</body>
</html>