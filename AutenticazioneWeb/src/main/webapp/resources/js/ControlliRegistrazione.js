function updateProgressBar() {
    const password = document.getElementById('password').value;
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
    const progressBar = document.getElementById('progress');
    progressBar.style.width = strength + '%';
}

document.getElementById('password').addEventListener('input', updateProgressBar);

document.getElementById('registrati').addEventListener('click', function(event) {
	event.preventDefault();

    setTimeout(function() {
        var form = document.getElementById("formRegistrazione");
        form.submit();
    }, 1800);
});