//Adds to empty table results of query, based on input in text field.



function userStory9(){
    var startDate = document.getElementById('fromDate').value;
    console.log(startDate);
    var endDate = document.getElementById('toDate').value;
    $("#results").html("");
    $.ajax({
        type: 'GET',
        url: 'api/data/call_data_per_period/' + startDate + '/' + endDate,
        contentType: 'application/json',
        success: function (aList) {
          //  console.log("Started");
            story9 = aList;
            console.log("Size: " + story9.length);

            //$("#innerText").append("</table>");

            //$("#results").empty();

            $("#results").append("<th onclick = 'sortTable(0)'>" + "IMSI " + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' + "</th>" + "<th onclick = 'sortTable(1)'>" + "Number of failures "  + "</th>" + "<th>" + "Total duration " + "</th>");
            //var shade = false;
            document.getElementById("searched").innerHTML = "Searched range: " + startDate + " to " + endDate +"<br>";
            document.getElementById("searched").innerHTML += story9.length + " results found!";
            $.each(story9, function (index, value) {
                $("#results").append("<tr><td>" + value[0] + "</td><td>" + value[1] + "</td><td>" + value[2] + "</td></tr>");
            });

        },error: function () {
            console.log("Error");
        }
    });
}

function userStory10(){
    var ueType = document.getElementById('uetype_text').value;
    $("#results").html("");
    $.ajax({
        type: 'GET',
        //url: 'api/data/event_cause/by_ue_type/' + ueType,
        url: 'http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/event_cause/by_ue_type/' + ueType,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            story10 = aList;
            //$("#innerText").append("<table>");
            //$("#results").append("<th onclick = 'sortTable(0)'>" + "UE Type(TAC)" +"</th>" + "<th onclick = 'sortTable(1)'>" + "Event Id" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' + "</th>" + "<th onclick = 'sortTable(2)'>" + "Cause Code" + "</th>" + "<th onclick = 'sortTable(3)'>" + "Count" + "</th>" );
            $("#results").append("<th onclick = 'sortTable(0)'>" + "Event Id " + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' + "</th>" + "<th onclick = 'sortTable(1)'>" + "Cause Code "  + "</th>" + "<th>" + "Descripton " + "</th>" + "<th onclick = 'sortTable(3)'>" + "Count " + "</th>" );
            //var shade = false;
            document.getElementById("searched").innerHTML = "Searched: " + ueType + "<br>";
            document.getElementById("searched").innerHTML += story10.length + " results found!";
            $.each(story10, function (index, value) {
                $("#results").append("<tr><td>" + value[0] + "</td><td>" + value[1] + "</td><td>" + value[2] + "</td><td>" + value[3] + "</td></tr>");
                //if(shade == false) {
                //    $("#results").append("<tr><td>" + value[0] + "</td><td>" + value[1] + "</td><td>" + value[2] + "</td><td>" + value[3] + "</td></tr>");
                //	shade = true;
                //}
                //else
                //{
                //    $("#results").append("<tr class='active'><td>" + value[0] + "</td><td>" + value[1] + "</td><td>" + value[2] + "</td><td>" + value[3]+ "</td></tr>");
                //	shade = false;
                //}

            });
            //$("#innerText").append("</table>");
        }
    });

}

function userStory14(){
    var failure_class = document.getElementById('failure_class_text').value;
    $("#results").html("");
    $.ajax({
        type: 'GET',
        //url: 'api/data/failure_class/get_imsis/' + failure_class,
        url: 'http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/failure_class/get_imsis/' + failure_class,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            story14 = aList;
            //$("#innerText").append("<table>");
            $("#results").append("<th onclick = 'sortTable(0)'>" + "IMSI" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' + "</th>");

            document.getElementById("searched").innerHTML = "Searched: " + failure_class + "<br>";
            document.getElementById("searched").innerHTML += story14.length + " results found!";
            $.each(story14, function (index, value) {
                $("#results").append("<tr><td>" + value + "</td></tr>");
            });
            //$("#innerText").append("</table>");
        }
    });

}