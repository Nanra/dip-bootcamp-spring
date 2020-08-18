

var dtTableExportButtons = [];


// DATA TABLE BUTTON EXPORT CONFIGURATION
if (typeof dtTableExportOpt !== 'undefined') {
    dtTableExportButtons = [
        {
            extend: 'excelHtml5',
            title: dtTableExportOpt.title,
            text: 'Export to Excel',
            // text: '<i class="fa fa-file-excel-o fa-lg"></i>',
            titleAttr: 'Excel',
            exportOptions: {columns: dtTableExportOpt.columns}
        }
    ];
}

function generateButtonExport() {
    $(".dataTables_wrapper div.dt-buttons").addClass("pull-right").css({"position": "initial"});
}

function generateButtonExportOnLeft() {
    $(".dataTables_wrapper div.dt-buttons").css({"position": "initial"});
}


let dipAjax = {
    post(urlEndpoint, dataParam) {
        return $.ajax({
            url: urlEndpoint,
            type: "POST",
            dataType: "JSON",
            cache: false,
            contentType: "application/json",
            data: JSON.stringify(dataParam),
        });
    },

    getAll(urlEndpoint, element) {

        if (element == "") {
            element = "#wrapper"
        }

        return $.ajax({
            url: urlEndpoint,
            type: "GET",
            dataType: "JSON",
            cache: false,
            contentType: "application/json",
            beforeSend: function () {
                console.log("Before Show Loading");
                $(element).LoadingOverlay("show", {
                    image: '',
                    background: "rgba(165, 168, 172, 0)",
                    size: "60",
                    maxSize: "60",
                    minSize: "50",
                });
            },
            complete: function (e) {
                $(element).LoadingOverlay("hide", true);
            },

        });
    },

    getByFilter(urlEndpoint, dataParam) {
        return $.ajax({
            url: urlEndpoint,
            type: "POST",
            dataType: "JSON",
            cache: false,
            contentType: "application/json",
            data: JSON.stringify(dataParam),
        });
    },

};

