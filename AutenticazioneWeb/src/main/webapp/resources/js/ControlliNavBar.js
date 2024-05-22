function hideButtons() {
    // Supponiamo che lo stato di accesso dell'utente sia memorizzato in localStorage
    const isLoggedIn = false;

    const loginBtn = document.querySelector('.nav-link[data-target="#loginModal"]');
    const registerBtn = document.querySelector('.nav-link[href="formRegistrazione.html"]');
    const profileBtn = document.querySelector('.nav-link[href="profilo.html"]');

    if (isLoggedIn) {
        // Nascondi i bottoni "Accedi" e "Registrati"
        if (loginBtn) loginBtn.style.display = 'none';
        if (registerBtn) registerBtn.style.display = 'none';
        // Mostra il bottone "Profilo"
        if (profileBtn) profileBtn.style.display = 'block';
    } else {
        // Mostra i bottoni "Accedi" e "Registrati"
        if (loginBtn) loginBtn.style.display = 'block';
        if (registerBtn) registerBtn.style.display = 'block';
        // Nascondi il bottone "Profilo"
        if (profileBtn) profileBtn.style.display = 'none';
    }
}

document.addEventListener('DOMContentLoaded', function() {
    // Funzione per includere il contenuto di navBar.html
    fetch('./resources/html/navBar.html')
        .then(response => response.text())
        .then(data => {
            document.getElementById('navbar-container').innerHTML = data;
            // Chiama hideButtons dopo che la navbar è stata caricata
            //hideButtons();
        })
        .catch(error => console.error('Error fetching the navbar:', error));
});

