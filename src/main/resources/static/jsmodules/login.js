

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
            swal({
                title: "Login Success!",
                text: "You have Authenticated!",
                icon: "success",
                timer: 3000,
                button: false
            }).then(() => {
                window.location = "/dashboard";
            });
        } else {
            console.log(result);
            swal({
                title: "Login Failed!",
                text: "Invalid User Name or Password",
                icon: "error",
                button: "Ok",
                timer: 5000
            });
            return false;
        }
    });
});


