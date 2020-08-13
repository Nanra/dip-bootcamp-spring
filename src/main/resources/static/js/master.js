
let dipAjax = {
    post(destination, data) {
        return $.ajax({
            url: destination,
            type: "POST",
            dataType: "JSON",
            cache: false,
            contentType: "application/json",
            data: JSON.stringify(data),
        });
    },
};

