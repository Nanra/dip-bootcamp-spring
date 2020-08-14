
$(document).off("click", "#btn-save");
$(document).on("click", "#btn-save", function(e) {

    console.log("Masuk Button Save");

    let dataBody = {
        name: $("#form-employee #name").val(),
        email: $("#form-employee #email").val(),
        phone: $("#form-employee #phone").val(),
        address: $("#form-employee #address").val(),
    }

    console.log(dataBody);

    $.when(dipAjax.post('/api/employee/save', dataBody)).done(function(result) {
        if (result.statusCode === "201") {
            console.log(result);
            swal({
                title: "Save Success!",
                text: "Your data has been saved",
                icon: "success",
                timer: 3000,
                button: false
            }).then(() => {
                window.location = "/employee/list";
            });
        } else {
            console.log(result);
            swal({
                title: "Failed!",
                text: "Failed to Save Data",
                icon: "error",
                button: "OK",
                timer: 5000
            });
            return false;
        }
    });


});
