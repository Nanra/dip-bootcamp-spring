//
//
// $(document).ready(function() {
//
//         console.log("Masuk AJAX Get");
//
//         let dataParam = {
//             name: "Nanra"
//         };
//
//     $.when(dipAjax.getAll("/api/employee/list", "page-wrapper")).done(function (result) {
//         console.log("All Employee");
//         console.log(result);
//     });
//
//     $.when(dipAjax.getByFilter("/api/employee/search", dataParam)).done(function (result) {
//         console.log("Search");
//         console.log(result);
//     });
//
// });
//
//
// $(document).off("click", "#btn-delete");
// $(document).on("click", "#btn-delete", function(e) {
//
//     console.log("Masuk Button Delete");
//
//     let dataBody = {
//         id: $("#form-employee #id").val()
//     }
//
//     console.log(dataBody);
//
//     $.when(dipAjax.post('/api/employee/delete', dataBody)).done(function(result) {
//         if (result.statusCode === "201") {
//             console.log(result);
//             swal({
//                 title: "Save Success!",
//                 text: "Your data has been saved",
//                 icon: "success",
//                 timer: 3000,
//                 button: false
//             }).then(() => {
//                 window.location = "/employee/list";
//             });
//         } else {
//             console.log(result);
//             swal({
//                 title: "Failed!",
//                 text: "Failed to Save Data",
//                 icon: "error",
//                 button: "OK",
//                 timer: 5000
//             });
//             return false;
//         }
//     });
//
//
// });