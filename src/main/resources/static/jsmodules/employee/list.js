

$(document).ready(function() {

        console.log("Masuk AJAX Get");

        let dataParam = {
            name: "Nanra"
        };

    $.when(dipAjax.getAll("/api/employee/list", "page-wrapper")).done(function (result) {
        console.log("All Employee");
        console.log(result);
    });

    $.when(dipAjax.getByFilter("/api/employee/search", dataParam)).done(function (result) {
        console.log("Search");
        console.log(result);
    });

});