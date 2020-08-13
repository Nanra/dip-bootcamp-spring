

$(document).off("click", "#btn-login");
$(document).on("click", "#btn-login", function(e) {

    console.log("Masuk Button Login");

   let dataBody = {
        username: $("#username").val(),
        password: $("#password").val(),
    }

    console.log(dataBody);

    $.when(dipAjax.post('/check-login', dataBody)).done(function(result) {
        if (result.message !== "error") {
            console.log(result);
            alert("Login Success");
        } else {
            console.log(result);
            alert("Login Failed");
            return false;
        }
    });
});


