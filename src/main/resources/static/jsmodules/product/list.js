
let tblName = $("#tableProduct");

$(document).ready(function() {
    initDatatable();
});

// Datatable Init
function initDatatable() {
    return tblName.DataTable({

        "sAjaxSource": "/api/product/list",
        "sAjaxDataProp": "",
        "order": [],
        "ordering": true,
        "searching": true,
        "pageLength": 10,
        "lengthChange": false,
        "paging": true,
        "destroy": true,
        "scrollX": true,
        "responsive": true,
        'autoWidth': false,
        "dom": 'Bfrtip',
        "buttons": [],
        "processing": true,
        "aoColumns": [
            {
                "width": "2%",
                "mData": "id"
            },
            {
                "width": "6%",
                "mData": "name"
            },
            {
                "width": "6%",
                "mData": "sku"
            },
            {
                "width": "6%",
                "mData": "quantity"
            },
            {
                "width": "6%",
                "mData": "price"
            },
            {
                "width": "6%",
                "mData": "createBy"
            },
            {
                "searchable": false,
                "orderable": false,
                "width": "2%",
                "data": null,
                render: function (data) {
                    console.log(data.id);
                    let btnLink = "";
                    btnLink = btnLink + '<a title="Edit" class="btn btn-info" type="button"  href="/employee/edit-employee?idEmployee=' + data.id + '"><i class="fa fa-pencil"></i></a>  ';
                    btnLink = btnLink + ' <a title="Delete" href="javascript:void(0)" type="button" data-id_delete="' + data.id + '" id="btn-delete" class="btn btn-danger"><i class="fa fa-trash"></i></a>';
                    return btnLink;
                }
            },
        ],
    });
}


// $(document).on("click", "#btn-delete", function(e) {
//     let id = $(this).data("id_delete");
//
//     console.log("ID DELETE : " + id);
//
//     let dataBody = {
//         id: id
//     }
//     swal({
//         title: "Are you sure?",
//         text: "Once deleted, you will not be able to recover this data!",
//         icon: "warning",
//         buttons: true,
//         dangerMode: true,
//     }).then((willDelete) => {
//         if (willDelete) {
//
//             $.when(dipAjax.post('/api/employee/delete', dataBody)).done(function(result) {
//                 if (result.statusCode === "201") {
//                     console.log(result);
//                     swal({
//                         title: "Delete Success!",
//                         text: "Your data has been deleted",
//                         icon: "success",
//                         timer: 3000,
//                         button: false
//                     }).then(() => {
//                         initDatatable();
//                     });
//                 } else {
//                     console.log(result);
//                     swal({
//                         title: "Failed!",
//                         text: "Failed to Save Data",
//                         icon: "error",
//                         button: "OK",
//                         timer: 5000
//                     });
//                     return false;
//                 }
//             });
//         } else {
//             return false;
//         }
//     });
// });