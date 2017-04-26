
function userStory4(){
    var imsi = document.getElementById('imsi_text').value;
    $("#results").html("");
    $.ajax({
        type: 'GET',
        url: 'api/data/event_cause_per_imsi/' + imsi,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            var story4 = aList;
            $("#results").append(
                "<th onclick = 'sortTable(0)'>" +
                "Event Id " +
                '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' +
                "</th>" +
                "<th onclick = 'sortTable(1)'>" +
                "Cause Code "  + "</th>" + "<th>" +
                "Description " + "</th>" + "<th onclick = 'sortTable(3)'>");
            document.getElementById("searched").innerHTML = "Searched: " + imsi + "<br>";
            document.getElementById("searched").innerHTML += story4.length + " results found!";
            $.each(story4, function (index, value) {
                $("#results").append("<tr><td>" +
                    value.eventCauseID.eventID  + "</td><td>" +
                    value.eventCauseID.causeCode + "</td><td>" +
                    value.description + "</td></tr>");
            });
        }
    });
}

function userStory5(){
    var startDate = $('#fromDate').val();
    var endDate = $('#toDate').val();
    if( startDate === "" || startDate === null || endDate === "" || endDate === null){
        return;
    }
    var imsi = document.getElementById('imsi_text').value;
    $("#results").html("");
    $.ajax({
        type: 'GET',
        url: 'api/data/specific_failure_per_period/' + startDate + '/' + endDate + '/' + imsi,
        contentType: 'application/json',
        success: function (aList) {
            $("#results").append("<th onclick = 'sortTable(0)'>" + "Total" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' +  "</th>" );
            document.getElementById("searched").innerHTML = "Searched: " + imsi + "<br>";
            console.log(aList);
            $("#results").append("<tr><td>" +
                aList + "</td></tr>");
        }
    });
}

function userStory6(){
    var imsi = document.getElementById('imsi_text').value;
    $("#results").html("");
    $.ajax({
        type: 'GET',
        url: 'api/data/event_cause/by_imsi/' + imsi,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            var story6 = aList;
            $("#results").append("<th onclick = 'sortTable(0)'>" + "Cause Code" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' +  "</th>" + "<th onclick = 'sortTable(1)'>"+ "Count" + "</th>" );
            document.getElementById("searched").innerHTML = "Searched: " + imsi + "<br>";
            document.getElementById("searched").innerHTML += story6.length + " results found!";
            $.each(story6, function (index, value) {
                var eventCause = value[0];
                $("#results").append("<tr><td>" +
                    eventCause.eventCauseID.causeCode + "</td><td>" +
                    value[1] + "</td></tr>");
            });
        }
    });
}

function userStory7(){
    var startDate = $('#fromDate').val();
    var endDate = $('#toDate').val();
    if( startDate === "" || startDate === null || endDate === "" || endDate === null){
        return;
    }
    console.log(startDate + ":" + endDate);
    $("#results").html("");
    $.ajax({
        type: 'GET',
        url: 'api/data/imsi_per_period/' + startDate + '/' + endDate,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            var story7 = aList;
            $("#results").append(
                "<th onclick = 'sortTable(0)'>" + "Date" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' +  "</th>" +
                "<th onclick = 'sortTable(1)'>" + "IMSI" + "</th>" +
                "<th onclick = 'sortTable(2)'>" + "Event Cause" + "</th>" +
                "<th onclick = 'sortTable(3)'>" + "Country" + "</th>" +
                "<th onclick = 'sortTable(3)'>" + "Operator" + "</th>" +
                "<th onclick = 'sortTable(4)'>" + "Failure Class" + "</th>" +
                "<th onclick = 'sortTable(5)'>" + "Manufacturer" + "</th>");
            //document.getElementById("searched").innerHTML = "Searched: " + imsi + "<br>";
            document.getElementById("searched").innerHTML += story7.length + " results found!";

            //var cellID, date, duration, eventCause, failureClass, id, imsi, marketOperator, neVersion, userEventType;

            $.each(story7, function (index, value) {
                $("#results").append("<tr><td>" +
                    getDate(value.dateTime) + "</td><td>" +
                    value.imsi + "</td><td>" +
                    value.eventCause.description + "</td><td>" +
                    value.marketOperator.country + "</td><td>" +
                    value.marketOperator.operator + "</td><td>" +
                    value.failureClass.description + "</td><td>" +
                    value.userEventType.manufacturer + "</td></tr>");
            });
        }
    });
}

function userStory8(){
    var startDate = $('#fromDate').val();
    var endDate = $('#toDate').val();
    if( startDate === "" || startDate === null || endDate === "" || endDate === null){
        return;
    }
    var phoneModel = document.getElementById('phone_model_text').value;
    $("#results").empty();
    $.ajax({
        type: 'GET',
        url: 'api/data/count_per_phone_model/' + startDate + '/' + endDate + '/' + phoneModel,
        contentType: 'application/json',
        success: function (aList) {
            $("#results").append("<th onclick = 'sortTable(0)'>" + "Total" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' +  "</th>" );
            document.getElementById("searched").innerHTML = "Searched: " + phoneModel + "<br>";
            $("#results").append("<tr><td>" +
                aList + "</td></tr>");
        }
    });
}

//Adds to empty table results of query, based on input in text field.
function userStory9( chart ){
    var startDate = $('#fromDate').val();
    var endDate = $('#toDate').val();
    if( startDate === "" || startDate === null || endDate === "" || endDate === null){
        return;
    }
    $("#results").html("");
    $.ajax({
        type: 'GET',
        url: 'api/data/call_data_per_period/' + startDate + '/' + endDate,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            var story9 = aList;
            if( chart === "charts" ){
                var totalDuration = [];
                var numFailures = [];
                var failures = []

                $.each(story9, function (index, value) {
                    totalDuration.push(parseInt(value[1]));
                    numFailures.push(parseInt(value[2]));
                    failures.push(value[0].toString());
                });

                var data = [{
                    x: totalDuration,
                    y: numFailures,
                    text: failures,
                    type: 'bar'
                }];
                var layout = {
                    xaxis:{title: 'Total Duration'},
                    yaxis:{title: 'Number of Failures'}
                };
                Plotly.newPlot('query_output', data, layout);

            }else {
                $("#results").append("<th onclick = 'sortTable(0)'>" + "IMSI " + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' + "</th>" + "<th onclick = 'sortTable(1)'>" + "Number of failures " + "</th>" + "<th>" + "Total duration " + "</th>");
                //var shade = false;
                document.getElementById("searched").innerHTML = "Searched range: " + startDate + " to " + endDate + "<br>";
                document.getElementById("searched").innerHTML += story9.length + " results found!";
                $.each(story9, function (index, value) {
                    $("#results").append("<tr><td>" +
                        value[0] + "</td><td>" +
                        value[1] + "</td><td>" +
                        value[2] + "</td></tr>");
                });

                // Consider adding an ID to your table
                // incase a second table ever enters the picture.
                var items = $("table tr");

                var numItems = items.length;

                // Only show the first 2 (or first `per_page`) items initially.
                items.slice(resultsPerPage).hide();

                // Now setup the pagination using the `.pagination-page` div.
                $("#results_div").pagination({
                    items: numItems,
                    itemsOnPage: resultsPerPage,
                    cssStyle: "light-theme",

                    // This is the actual page changing functionality.
                    onPageClick: function(pageNumber) {
                        // We need to show and hide `tr`s appropriately.
                        var showFrom = resultsPerPage * (pageNumber - 1);
                        var showTo = showFrom + resultsPerPage;

                        // We'll first hide everything...
                        items.hide()
                        // ... and then only show the appropriate rows.
                            .slice(showFrom, showTo).show();
                    }
                });
            }
        },error: function () {
            console.log("Error");
        }
    });
}

function userStory10( chart ){
    console.log(chart);
    var phoneModel = document.getElementById('phone_model_text').value;
    $("#results").html("");
    $.ajax({
        type: 'GET',
        url: 'api/data/event_cause/by_ue_type/' + phoneModel,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            var story10 = aList;
            if( chart === "charts" ){
                var eventcause = [];
                var counts = [];

                $.each(story10, function (index, value) {
                    eventcause.push(value[0].eventCauseID.eventID + "/" + value[0].eventCauseID.causeCode);
                    counts.push(parseInt(value[1]));
                });

                var data = [{
                    x: eventcause,
                    y: counts,
                    type: 'scatter'
                }];
                var layout = {
                        xaxis:{title: 'Event Cause Combinations'},
                        yaxis:{title: 'Occurances'}
                };
                Plotly.newPlot('query_output', data, layout);

            }else {

                $("#results").append("<th onclick = 'sortTable(0)'>" +
                    "Event Id " +
                    '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' +
                    "</th>" + "<th onclick = 'sortTable(1)'>" +
                    "Cause Code "  + "</th>" + "<th>" +
                    "Descripton " + "</th>" + "<th onclick = 'sortTable(3)'>" +
                    "Count " + "</th>" );

                document.getElementById("searched").innerHTML = "Searched: " + phoneModel + "<br>";
                document.getElementById("searched").innerHTML += story10.length + " results found!";
                $.each(story10, function (index, value) {
                    var eventCause = value[0];
                    $("#results").append("<tr><td>" +
                        eventCause.eventCauseID.eventID + "</td><td>" +
                        eventCause.eventCauseID.causeCode + "</td><td>" +
                        eventCause.description + "</td><td>" +
                        value[1] + "</td></tr>");
                });
            }
        }
    });
}

function userStory11(){
    var startDate = $('#fromDate').val();
    var endDate = $('#toDate').val();
    if( startDate === "" || startDate === null || endDate === "" || endDate === null){
        return;
    }
    $("#results").html("");
    $.ajax({
        type: 'GET',
        url: 'api/data/top_ten_per_period/' + startDate + '/' + endDate,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            var story11 = aList;

            $("#results").append(
                "<th onclick = 'sortTable(0)'>" + "Number" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' + "</th>" +
                "<th onclick = 'sortTable(1)'>" + "MCC"  + "</th>" +
                "<th onclick = 'sortTable(2)'>" + "MNC"  + "</th>" +
                "<th onclick = 'sortTable(3)'>" + "Cell ID"  + "</th>" +
                "<th onclick = 'sortTable(4)'>" + "Total"  + "</th>" );

            document.getElementById("searched").innerHTML += story11.length + " results found!";
            $.each(story11, function (index, value) {
                $("#results").append("<tr><td>" +
                    (index + 1) + "</td><td>" +
                    value[0].operatorCode.marketCode + "</td><td>" +
                    value[0].operatorCode.operatorCode + "</td><td>" +
                    value[1] + "</td><td>" +
                    value[2] + "</td></tr>"
                );
            });
        }
    });

}

function userStory12(){
    var startDate = $('#fromDate').val();
    var endDate = $('#toDate').val();
    if( startDate === "" || startDate === null || endDate === "" || endDate === null){
        return;
    }
    $("#results").html("");
    $.ajax({
        type: 'GET',
        url: 'api/data/call_data_per_period/top_ten/' + startDate + endDate,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            var story12 = aList;
            $("#results").append(
                "<th onclick = 'sortTable(0)'>" + "IMSI" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' + "</th>" +
                "<th onclick = 'sortTable(1)'>" + "TOTAL"  + "</th>");

            document.getElementById("searched").innerHTML += story12.length + " results found!";
            $.each(story12, function (index, value) {
                console.log(value);
                $("#results").append("<tr><td>" +
                    value[0] + "</td><td>" +
                    value[1] + "</td></tr>");
            });
        }
    });

}

function userStory13(){
    $("#results").html("");
    $.ajax({
        type: 'GET',
        url: 'api/data/top_ten_node',
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            var story13 = aList;

            $("#results").append(
                "<th onclick = 'sortTable(0)'>" + "Number" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' + "</th>" +
                "<th onclick = 'sortTable(1)'>" + "MCC"  + "</th>" +
                "<th onclick = 'sortTable(2)'>" + "MNC"  + "</th>" +
                "<th onclick = 'sortTable(3)'>" + "Cell ID"  + "</th>" +
                "<th onclick = 'sortTable(4)'>" + "Total"  + "</th>" +
                "<th onclick = 'sortTable(3)'>" + "%"  + "</th>");

            document.getElementById("searched").innerHTML += story13.length + " results found!";
            $.each(story13, function (index, value) {
                $("#results").append("<tr><td>" +
                    (index + 1) + "</td><td>" +
                    value[0].operatorCode.marketCode + "</td><td>" +
                    value[0].operatorCode.operatorCode + "</td><td>" +
                    value[1] + "</td><td>" +
                    value[2] + "</td><td>" +
                    value[3] + "</td></tr>"
                );
            });
        }
    });

}

function userStory14(){
    var failure_class = document.getElementById('failure_class_text').value;
    $("#results").html("");
    $.ajax({
        type: 'GET',
        url: 'api/data/failure_class/get_imsis/' + failure_class,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            story14 = aList;
            //$("#innerText").append("<table>");
            $("#results").append("<th onclick = 'sortTable(0)'>" + "IMSI" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' + "</th>");

            document.getElementById("searched").innerHTML = "Searched: " + failure_class + "<br>";
            document.getElementById("searched").innerHTML += story14.length + " results found!";
            $.each(story14, function (index, value) {
                $("#results").append("<tr><td>" +
                    value + "</td></tr>");
            });
            //$("#innerText").append("</table>");
        }
    });

}


function getDate( date ) {

    var today = new Date(date);
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!

    var yyyy = today.getFullYear();
    if(dd < 10){
        dd = '0' + dd;
    }
    if(mm<10){
        mm = '0' + mm;
    }
    return dd + '/' + mm + '/' + yyyy;
}

/*
function querySpecifcStructure(heading, description, label_text, input_id,
        placeholder_text, button_method)
{
    //Query Info
    $("#info_heading").append(heading);
    $("#info_description").append(description);

    //Query Input
    var text_field = document.getElementById("query_field");
    text_field.setAttribute("id", input_id);

    if(placeholder_text != null) {
        text_field.placeholder = placeholder_text;
    }

    var label = document.getElementById("query_label");
    label.setAttribute("for", "uetype_text");
    label.innerHTML = label_text;

    var queryBtn = document.getElementById("queryBtn");
    queryBtn.setAttribute("onclick", button_method);

}*/