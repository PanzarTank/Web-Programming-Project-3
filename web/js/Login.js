function login() {
    var username = $('#loginUsername').val();
    var password = $('#signupPassword').val();
    $.post('authUser', {username, password}, res => {
        console.log(res);
    });

    var userChecked = (document.getElementById("userRadio").checked);
    var adminChecked = (document.getElementById("adminRadio").checked);

    if ((res == true) && (userChecked == true)) {
        window.location.href("index.html");
    } else if ((res == true) && (adminChecked == true)) {
        window.location.href("index.html"); //Admin page??
    } else {
        return false;
        alert("Either Username or Password is incorrect!")
    }
}
