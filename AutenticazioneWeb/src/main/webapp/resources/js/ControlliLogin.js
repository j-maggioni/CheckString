
function controlloNome() {
	nome = document.getElementById('nome');
	nomeErrore = document.getElementById('nomeErrore');

	nome.addEventListener('input', function() {
	  if (nome.value !== "") {
		nome.style.borderColor = "";
		nomeErrore.style.display = "none";
	  }
	});

	if (nome.value == "") {
		nome.style.borderColor = "red";
		nomeErrore.style.display = "inline";
		return false;
	} else {
		nomeErrore.style.display = "none";
	}
	return true;
}

function controlloCognome() {
	cognome = document.getElementById('cognome');
	cognomeErrore = document.getElementById('cognomeErrore');

	cognome.addEventListener('input', function() {
	  if (cognome.value !== "") {
		cognome.style.borderColor = "";
		cognomeErrore.style.display = "none";
	  }
	});

	if (cognome.value == "") {
		cognome.style.borderColor = "red";
		cognomeErrore.style.display = "inline";
		return false;
	} else {
		cognomeErrore.style.display = "none";
	}
	return true;
}

function controlloEmail() {
	email = document.getElementById('email');
	emailErrore = document.getElementById('emailErrore');
	regexEmail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

	email.addEventListener('input', function() {
			email.style.borderColor = "";
			emailErrore.style.display = "none";
	});

	if (!regexEmail.test(email.value)) {
		email.style.borderColor = "red";
		emailErrore.style.display = "inline";
		return false;
	} else {
		email.style.borderColor = "";
		emailErrore.style.display = "none";
		return true;
	}
}

function controlloPassword() {
	psw = document.getElementById('password');
	pswErrore = document.getElementById('pswErrore');
	regexPsw = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$/; //min 8 caratteri, una lettera e un numero
	Cpsw = document.getElementById('Cpassword');
	CError = document.getElementById('CpswErrore');

	psw.addEventListener('input', function() {
			psw.style.borderColor = "";
			pswErrore.style.display = "none";
	});

	if (!regexPsw.test(psw.value)) {
		psw.style.borderColor = "red";
		pswErrore.style.display = "inline";
		return false;
	} else {
		psw.style.borderColor = "";
		pswErrore.style.display = "none";
		return true;
	}
}

function controlloCPassword() {
	psw = document.getElementById('password');
	Cpsw = document.getElementById('Cpassword');
	CError = document.getElementById('CpswErrore');

	Cpsw.addEventListener('input', function() {
			Cpsw.style.borderColor = "";
			CError.style.display = "none";
	});

	if (psw.value != Cpsw.value) {
		Cpsw.style.borderColor = "red";
		CError.style.display = "inline";
		return false;
	} else {
		Cpsw.style.borderColor = "";
		CError.style.display = "none";
		return true;
	}

}

function controlloCity() {
	city = document.getElementById('city');
	cityErrore = document.getElementById('cityErrore');

	city.addEventListener('input', function() {
	  if (city.value !== "") {
		city.style.borderColor = "";
		cityErrore.style.display = "none";
	  }
	});

	if (city.value == "") {
		city.style.borderColor = "red";
		cityErrore.style.display = "inline";
		return false;
	} else {
		cityErrore.style.display = "none";
	}
	return true;
}

function controlloTelefono() {
	b = true;
	pref = document.getElementById('prefisso')
	tel = document.getElementById('telefono');
	telErrore = document.getElementById('telefonoErrore');
	regexTel = /^(\d{3,4}\s?){2,3}\d{3,4}$/;
	regexPref = /^(\+\d{1,3}\s?)/;

	tel.addEventListener('input', function() {
		tel.style.borderColor = "";
		telErrore.style.display = "none";
	});

	pref.addEventListener('input', function() {
		pref.style.borderColor = "";
		telErrore.style.display = "none";
	});

  if (!regexTel.test(tel.value)) {
    tel.style.borderColor = "red";
    b = false;
  } else {
    tel.style.borderColor = "";
  }

  if (!regexPref.test(pref.value)) {
    pref.style.borderColor = "red";
    b = false;
  } else {
    pref.style.borderColor = "";
  }

  if (b) {
	telErrore.style.display = "none";
  } else {
	telErrore.style.display = "inline";
  }
  return b;
}

function controlloTermini() {
	const checkbox = document.getElementById('termini');
	const c = document.getElementById('terminiErrore');

  	if (checkbox.checked) {
	  	c.style.display = "none";
    	return true;
  	} else {
	  	c.style.display = "inline";
    	return false;
  	}
}

document.getElementById('registrati').addEventListener('click', function(event) {
	event.preventDefault();
	const nomeValido = controlloNome();
	const cognomeValido = controlloCognome();
	const emailValido = controlloEmail();
	const cityValido = controlloCity();
	const telValido = controlloTelefono();
	const terminiValido = controlloTermini();
	const pswValido = controlloPassword();
	const ripeti = controlloCPassword();

	if (nomeValido && cognomeValido && emailValido && cityValido && telValido && terminiValido && pswValido && ripeti) {
	  document.getElementById('alert').style.display = "inline";
	  // Nascondi l'alert dopo 3 secondi
	  setTimeout(function() {
		document.getElementById('alert').style.display = "none";
		window.location.href = 'login.html';
	  }, 1800);
	}

});
