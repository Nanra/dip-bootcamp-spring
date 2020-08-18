let tblName = $("#tableEmployee");


$(document).ready(function() {
    var nButtons = [];
    dtTableExportButtons.splice(0, 0, nButtons);
    tbl = initDatatable();
    // generateButtonExport();
    // generateButtonExportOnLeft();
});


function initDatatable() {
    var grid = tblName.DataTable({

        "sAjaxSource": "/api/employee/list",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
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
        "buttons": dtTableExportButtons,
        "processing": true,
        "aoColumns": [
            { "mData": "id"},
            { "mData": "name" },
            { "mData": "address" },
            { "mData": "phone" },
            { "mData": "email" },
            {
                "searchable": false,
                "orderable": false,
                "width": "8%",
                "data": null,
                render: function(data, type, row) {
                    console.log(data.id);
                    let btnLink = "";
                    btnLink = btnLink + '<a class="btn btn-info" type="button"  href="/employee/edit-employee?idEmployee='+data.id+'">Edit</a>';
                    btnLink = btnLink + '<a href="javascript:void(0)" type="button" th:attr="data-id_delete='+data.id+'" id="btn-delete" class="btn btn-danger">Delete</a>';
                    return btnLink;
                }
            },
        ],
    });

    return grid;
}