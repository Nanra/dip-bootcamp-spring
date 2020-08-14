console.log("List.js");

$(document).on("click", "#btn-delete", function(e) {
    let id = $(this).data("id_delete");

    console.log("ID DELETE : " + id);

    let dataBody = {
        id: id
    }
    swal({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover this data!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    }).then((willDelete) => {
            if (willDelete) {

                $.when(dipAjax.post('/api/employee/delete', dataBody)).done(function(result) {
                    if (result.statusCode === "201") {
                        console.log(result);
                        swal({
                            title: "Delete Success!",
                            text: "Your data has been deleted",
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
            } else {
                return false;
            }
        });
});
