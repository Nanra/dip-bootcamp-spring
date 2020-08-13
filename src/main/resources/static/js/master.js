
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

