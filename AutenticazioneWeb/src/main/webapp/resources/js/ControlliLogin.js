document.getElementById('accedi').addEventListener('click', function(event) {
    event.preventDefault();

    setTimeout(function() {
        var form = document.getElementById("formLogin");
        var passwordField = document.getElementById("psw");
            if (passwordField.value.trim() !== "") {
                passwordField.value = md5(passwordField.value);
            }
        form.submit();
    }, 1800);
});