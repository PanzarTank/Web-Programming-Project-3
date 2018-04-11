function register() {
    var firstName = $('#signupFirstName').val();
    var lastName = $('#signupLastName').val();
    var username = $('#signupUsername').val();
    var password = $('#signupPassword').val();
    console.log(firstName);
    console.log(lastName);
    console.log(username);
    console.log(password);
    $.post('registerUser', {firstName, lastName, username, password}, res => {
        console.log(res);
    })
}