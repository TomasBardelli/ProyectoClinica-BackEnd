$(document).ready(function() {
    $("#add_new_paciente").submit(function(evt){
        evt.preventDefault();

        let formaData = {
            nombre: $("#nombre").val(),
            apellido: $("#apellido").val(),
            mail: $("#mail").val(),
            dni: $("#dni").val()
        }
        $.ajax({
            url: '/pacientes/registrar',
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(formaData),
            dataType: 'json',
            async: false,
            cache: false,
            success: function(response) {
                let paciente = response
                console.log(response)
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                '<strong></strong> paciente agregado </div>'
                $('#response').append(successAlert);
                $('#response').css({"display":"block"});
                resetUploadForm();
            },
                error: function(response) {
                    let successAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong> Error intente nuevamente</strong> </div>'
                resetUploadForm();
                }
        });

    });
    function resetUploadForm(){
        $("#nombre").val("");
        $("#apellido").val("");
        $("#mail").val("");
        $("#dni").val("");
    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            $(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/pacientes.html"){
             $(".nav .nav-item a:last").addClass("active");
        }
    });

})