function controlloNome() {
	nome = document.getElementById('nomeM');
	nomeErrore = document.getElementById('nomeErroreM');

	nome.addEventListener('input', function() {
	  if (nome.value !== "") {
		nome.style.borderColor = "";
		nomeErrore.style.display = "none";
	  }
	});

	if (nome.value == "") {
	console.log("nome vuoto")
		nome.style.borderColor = "red";
		nomeErrore.style.display = "inline";
		return false;
	} else {
	console.log(nome.value)
		nomeErrore.style.display = "none";
	}
	return true;
}

function controlloCognome() {
	cognome = document.getElementById('cognomeM');
	cognomeErrore = document.getElementById('cognomeErroreM');

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

function controlloPassword() {
	psw = document.getElementById('passwordM');
	pswErrore = document.getElementById('pswErroreM');
	regexPsw = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
	Cpsw = document.getElementById('confermaPasswordM');
	CError = document.getElementById('CpswErroreM');

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

function controlloconfermaPassword() {
	psw = document.getElementById('passwordM');
	Cpsw = document.getElementById('confermaPasswordM');
	CError = document.getElementById('CpswErroreM');

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

function controllonazione() {
	nazione = document.getElementById('nazioneM');
	nazioneErrore = document.getElementById('nazioneErroreM');

	nazione.addEventListener('input', function() {
	  if (nazione.value !== "") {
		nazione.style.borderColor = "";
		nazioneErrore.style.display = "none";
	  }
	});

	if (nazione.value == "") {
		nazione.style.borderColor = "red";
		nazioneErrore.style.display = "inline";
		return false;
	} else {
		nazioneErrore.style.display = "none";
	}
	return true;
}

function controlloTelefono() {
	b = true;
	pref = document.getElementById('prefissoM')
	tel = document.getElementById('telefonoM');
	telErrore = document.getElementById('telefonoErroreM');
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

function updateProgressBar() {
    const password = document.getElementById('passwordM').value;
    let strength = 0;

    // Check for uppercase letter
    if (/[A-Z]/.test(password)) {
        strength += 20;
    }

    // Check for lowercase letter
    if (/[a-z]/.test(password)) {
        strength += 20;
    }

    // Check for number
    if (/\d/.test(password)) {
        strength += 20;
    }

    // Check for special character
    if (/[^A-Za-z0-9]/.test(password)) {
        strength += 20;
    }

    // Check for minimum length of 8 characters
    if (password.length >= 8) {
        strength += 20;
    }

    // Update progress bar width
    const progressBar = document.getElementById('progressM');
    progressBar.style.width = strength + '%';
}

document.getElementById('passwordM').addEventListener('input', updateProgressBar);

document.getElementById('salva').addEventListener('click', function(event) {
	event.preventDefault();
	const nomeValido = controlloNome();
	const cognomeValido = controlloCognome();
	const nazioneValido = controllonazione();
	const telValido = controlloTelefono();
	const pswValido = controlloPassword();
	const ripeti = controlloconfermaPassword();

	if (nomeValido && cognomeValido && nazioneValido && telValido && pswValido && ripeti) {
        document.getElementById('alertModificaDati').style.display = "inline";
        // Nascondi l'alert dopo 3 secondi
        setTimeout(function() {
            document.getElementById('alertModificaDati').style.display = "none";
            var form = document.getElementById("formModificaProfilo");
            document.getElementById("passwordM").value = md5(document.getElementById("passwordM").value);
            form.submit();
        }, 1800);

    }

 });