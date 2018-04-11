function register() {
    var firstName = $('#signupFirstName').val();
    var lastName = $('#signupLastName').val();
    var username = $('#signupUsername').val();
    var password = $('#signupPassword').val();
    $.post('registerUser', {firstName, lastName, username, password}, res => {
        console.log(res);
    });
}

function getItems() {

}