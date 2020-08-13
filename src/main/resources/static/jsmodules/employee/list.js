

$(document).ready(function() {
        console.log("Masuk AJAX Get");

    $.when(dipAjax.get("/api/employee/list", "")).done(function (result) {
        console.log(result);
    })

});