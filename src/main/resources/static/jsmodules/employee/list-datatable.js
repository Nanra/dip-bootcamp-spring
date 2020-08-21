console.log("list-datatables.js");

let tblName = $("#tableEmployee");


$(document).ready(function() {
    initDatatable(dataEmployeeParse);
});

// Datatable Init
function initDatatable(dataParam) {
    return tblName.DataTable({

        "order": [],
        "ordering": true,
        "searching": true,
        "pageLength": 10,
        "data": dataParam,
        "lengthChange": false,
        "paging": true,
        "destroy": true,
        "scrollX": true,
        "responsive": true,
        'autoWidth': false,
        "dom": 'Bfrtip',
        "buttons": [],
        "processing": true,
        "columns":[
            {
                "data":"id",
                "width":"3%",
            },
            {
                "data":"name",
                "width":"7%",
                "render": data => {
                    if (data === null) {
                        return "-"
                    } else {
                        return data
                    }
                }
            },
            {
                "data":"address",
                "width":"5%"
            },
            {
                "data":"phone",
                "width":"5%"
            },
            {
                "data":"email",
                "width":"7%"
            },
            {
                "data":"createBy",
                "width":"7%",
                "render": data => {
                    if (data === null) {
                        return "-"
                    } else {
                        return data
                    }
                }
            },
            {
                "searchable": false,
                "orderable": false,
                "width": "4%",
                "data": null,
                render: function (data, type, row) {
                    console.log(data.id);
                    let btnLink = "";
                    btnLink = btnLink + '<a class="btn btn-info" type="button"  href="/employee/edit-employee?idEmployee=' + data.id + '">Edit</a>  ';
                    btnLink = btnLink + ' <a href="javascript:void(0)" type="button" data-id_delete="' + data.id + '" id="btn-delete" class="btn btn-danger">Delete</a>';
                    return btnLink;
                }
            },

        ],
        // "aoColumns": [
        //     {
        //         "width": "2%",
        //         "mData": "id"
        //     },
        //     {
        //         "width": "6%",
        //         "mData": "name"
        //     },
        //     {
        //         "width": "6%",
        //         "mData": "address"
        //     },
        //     {
        //         "width": "6%",
        //         "mData": "phone"
        //     },
        //     {
        //         "width": "6%",
        //         "mData": "email"
        //     },
        //     {
        //         "searchable": false,
        //         "orderable": false,
        //         "width": "4%",
        //         "data": null,
        //         render: function (data, type, row) {
        //             console.log(data.id);
        //             let btnLink = "";
        //             btnLink = btnLink + '<a class="btn btn-info" type="button"  href="/employee/edit-employee?idEmployee=' + data.id + '">Edit</a>  ';
        //             btnLink = btnLink + ' <a href="javascript:void(0)" type="button" data-id_delete="' + data.id + '" id="btn-delete" class="btn btn-danger">Delete</a>';
        //             return btnLink;
        //         }
        //     },
        // ],
    });
}


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
                        initDatatable();
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