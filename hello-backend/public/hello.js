$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/greeting"
    }).then(function(data, status, jqxhr) {
       $('.hello-all').append(JSON.stringify(data));
       $('.hello-id').append(data.id);
       $('.hello-content').append(data.content);
       console.log(jqxhr);
    });
});