$(function () {
    $("#submitButton").click(function (ev) {
        ev.preventDefault();
        var $form = $("#formId");
        var url = $form.attr('action');
        $.ajax({
            type: "POST",
            url: url,
            contentType: "application/json",
            data: getFormData($form),
            success: function (data) {
                alert("Form Submited Successfully" + data);
                window.location.href = '/';
            },
            error: function (data) {
                alert("some Error");
            }
        });
    });

    function getFormData($form) {
        var unindexed_array = $form.serializeArray();
        var indexed_array = {};

        $.map(unindexed_array, function (n, i) {
            indexed_array[n['name']] = n['value'];
        });
        return JSON.stringify(indexed_array);
    }

    $("#editForm").validate({
        rules: {
            id: {
                required: true,
                number: true
            },
            email: {
                required: true,
                email: true
            }
        },
        messages: {
            id: {
                required: "Please enter ID",
                number: "Please enter a valid number"
            },
            email: {
                required: "Please enter email",
                email: "Please enter a valid email address"
            }
        },
        submitHandler: function (form) {
            $.ajax({
                type: "POST",
                url: "/editForm",
                data: $(form).serialize(),
                success: function (response) {
                    window.location.href="/"
                },
                error: function (error) {
                    // Handle the error response
                    console.error(error);
                }
            });
        }
    });
});
