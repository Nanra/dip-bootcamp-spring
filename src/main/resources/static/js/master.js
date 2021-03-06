

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

// AJAX CONFIGURATION
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


// MODALS CONFIGURATION
function showModal(url, title, postdata) {
    if (postdata) {
        $.ajax({
            url: url,
            type: "POST",
            dataType: "html",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(postdata),
            success: function (html) {
                $('#dynamicModal .modal-title').text(title);
                $('#dynamicModal .modal-body').html(html);
                $('#dynamicModal').modal('show', {
                    backdrop: 'static',
                    keyboard: false
                });
            }
        });
    } else {
        $.ajax({
            url: url,
            success: function (html) {
                $('#dynamicModal .modal-title').text(title);
                $('#dynamicModal .modal-body').html(html);
                $('#dynamicModal').modal('show', {
                    backdrop: 'static',
                    keyboard: false
                });
            }
        });
    }
}

function setModalWidth(w) {
    $('#dynamicModal').on('shown.bs.modal', function () {
        if (w == -1) {
            $(this).find('.modal-dialog').css({
                width: '100%', //probably not needed
                height: 'auto', //probably not needed
                'max-height': '100%'
            });
        } else {

            $(this).find('.modal-dialog').css({
                width: w + 'px', //probably not needed
                height: 'auto', //probably not needed
                'max-height': '100%'
            });
        }
    });
}

