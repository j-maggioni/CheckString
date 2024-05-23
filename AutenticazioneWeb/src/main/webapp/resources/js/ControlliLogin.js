document.getElementById('accedi').addEventListener('click', function(event) {
    event.preventDefault();
    var form = document.getElementById("formLogin");
    document.getElementById("psw").value = md5(document.getElementById("psw").value);
    form.submit();

});