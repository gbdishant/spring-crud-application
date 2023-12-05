let dt;
$(document).ready(function () {
    dt = $('#userTable').DataTable({
        ajax: {
            url: '/datatable',
            method: 'POST',
            contentType: 'application/json',
            data: function (d) {
                return JSON.stringify(d);
            },
            'serverSide': true,
        },
        columns: [
            {"data": "id"},
            {"data": "email"},
            {"data": "gender"},
            {"data": "name"},
            {"data": "status"},
            {
                "data": "id",
                "render": function (data, type, row, meta) {
                    var editButton = '<a href="/edit-form/' + data + '"><button class="btn btn-primary btn-edit">Edit</button></a>';
                    var deleteButton = '<button class="btn btn-danger btn-delete" onclick="deleteById(' + data + ')">Delete</button>';
                    return editButton + ' ' + deleteButton;
                }
            }
        ]
    });
});

function deleteById(id) {
    $.ajax({
        url: '/users/' + id,
        type: 'DELETE',
        success: function (result) {
            dt.ajax.reload();
        },
        error: function (error) {
        }
    });
}