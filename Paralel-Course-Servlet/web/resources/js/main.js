
var clickedButton;


$(function () {
    $('#idStudentsButton').click(function () {
        getStudentsTable("/ns?action=getAllStudents");
    });
    $('#idTeachersButton').click(function () {
        getStudentsTable("/ns?action=getAllTeachers");
    });
});

function getStudentsTable(myUrl) {
    $.ajax({
        url: myUrl,
        type: 'GET',
        dataType: 'html',
        success: function (data) {
            $('#idTable').empty();
            $('#idTable').html(data);
            $('#idTable').show();
        }
    })
}