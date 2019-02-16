$(document).ready(function() {
    $.ajax({
        url: "http://localhost:9000/hello"
    }).then(function(data, status, jqxhr) {
       $('.hello-all').append(JSON.stringify(data));
       $('.hello-id').append(data.id);
       $('.hello-content').append(data.content);
       console.log(jqxhr);
    });
});