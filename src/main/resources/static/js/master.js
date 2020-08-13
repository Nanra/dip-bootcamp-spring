
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

    get(urlEndpoint, dataParam) {
        return $.ajax({
            url: urlEndpoint,
            type: "GET",
            dataType: "JSON",
            cache: false,
            contentType: "application/json",
            data: JSON.stringify(dataParam),
        });
    },
};

