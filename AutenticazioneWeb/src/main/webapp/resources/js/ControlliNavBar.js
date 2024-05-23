function hideButtons() {
    // Supponiamo che lo stato di accesso dell'utente sia memorizzato in localStorage
    const isLoggedIn = false;

    const gioco1Btn = document.getElementById('gioco1Btn');
    const gioco2Btn = document.getElementById('gioco2Btn');
    const gioco3Btn = document.getElementById('gioco3Btn');

    const loginBtn = document.getElementById('loginBtn');
    const registerBtn = document.getElementById('registerBtn');
    const profileBtn = document.getElementById('profileBtn');
    const logoutBtn = document.getElementById('logoutBtn');

    if (isLoggedIn) {
        // Nascondi i bottoni "Accedi" e "Registrati"
        if (loginBtn) loginBtn.style.display = 'none';
        if (registerBtn) registerBtn.style.display = 'none';
        // Mostra i bottoni "Profilo" e "Logout" e "Giochi"
        if (profileBtn) profileBtn.style.display = 'block';
        if (logoutBtn) logoutBtn.style.display = 'block';
        if (gioco1Btn) gioco1Btn.style.display = 'block';
        if (gioco2Btn) gioco2Btn.style.display = 'block';
        if (gioco3Btn) gioco3Btn.style.display = 'block';
    } else {
        // Mostra i bottoni "Accedi" e "Registrati"
        if (loginBtn) loginBtn.style.display = 'block';
        if (registerBtn) registerBtn.style.display = 'block';
        // Nascondi il bottone "Profilo" e "Logout" e "Giochi"
        if (profileBtn) profileBtn.style.display = 'none';
        if (logoutBtn) logoutBtn.style.display = 'none';
        if (gioco1Btn) gioco1Btn.style.display = 'none';
        if (gioco2Btn) gioco2Btn.style.display = 'none';
        if (gioco3Btn) gioco3Btn.style.display = 'none';
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

