
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

    getAll(urlEndpoint) {
        return $.ajax({
            url: urlEndpoint,
            type: "GET",
            dataType: "JSON",
            cache: false,
            contentType: "application/json",
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

