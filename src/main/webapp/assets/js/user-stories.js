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

            var html = [];
            for (var j = 0; j < story4.length; j++){
                html.push("<tr><td>" +
                    story4[j].eventCauseID.eventID + "</td><td>" +
                    story4[j].eventCauseID.causeCode + "</td><td>" +
                    story4[j].description + "</td></tr>"
                )
            }
            $('#results').append(html.join(''));
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

            var html = [];
            for (var j = 0; j < story6.length; j++){
                html.push("<tr><td>" +
                    story6[j][0].eventCauseID.causeCode + "</td><td>" +
                    story6[j][1] + "</td></tr>"
                )
            }
            $('#results').append(html.join(''));
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
                "<th onclick = 'sortTable(4)'>" + "Operator" + "</th>" +
                "<th onclick = 'sortTable(5)'>" + "Failure Class" + "</th>" +
                "<th onclick = 'sortTable(6)'>" + "Manufacturer" + "</th>"
            );
            //document.getElementById("searched").innerHTML = "Searched: " + imsi + "<br>";
            document.getElementById("searched").innerHTML += story7.length + " results found!";

            var html = [];
            for (var j = 0; j < story7.length; j++) {
                html.push("<tr><td>" +
                    getDate(story7[j].dateTime) + "</td><td>" +
                    story7[j].imsi + "</td><td>" +
                    story7[j].eventCause.description + "</td><td>" +
                    story7[j].marketOperator.country + "</td><td>" +
                    story7[j].marketOperator.operator + "</td><td>" +
                    story7[j].failureClass.description + "</td><td>" +
                    story7[j].userEventType.manufacturer + "</td></tr>"
                )
            }
            $('#results').append(html.join(''));
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

                var duration = [];
                var imsiTotals = [];

                if( story9.length > 500 ){
                    for( var x = 0; x < 750; x++){
                        duration.push(parseInt(story9[x][2]));
                        imsiTotals.push( story9[x][0] + "/" + parseInt(story9[x][1]) );
                    }
                }else{
                    $.each(story9, function (index, value) {
                        duration.push(parseInt(value[2]));
                        imsiTotals.push( value[0] + "/" + parseInt(value[1]) );
                    });
                }

                var data = [{
                    values: duration,
                    labels: imsiTotals,
                    type: 'pie',
                    textinfo: 'none'
                }];


                Plotly.newPlot('query_output', data );

            }else {
                $("#results").append(
                    "<th onclick = 'sortTable(0)'>" +
                    "IMSI " + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' + "</th>" +
                    "<th onclick = 'sortTable(1)'>" +
                    "Number of failures " + "</th>" +
                    "<th>" +
                    "Total duration " +
                    "</th>");
                //var shade = false;
                document.getElementById("searched").innerHTML = "Searched range: " + startDate + " to " + endDate + "<br>";
                document.getElementById("searched").innerHTML += story9.length + " results found!";

                var html = [];
                for (var j = 0; j < story9.length; j++){
                    html.push('<tr><td>' +
                        story9[j][0] + '</td><td>' +
                        story9[j][1] + '</td><td>' +
                        story9[j][2] + '</td></tr>'
                    );
                }
                $('#results').append(html.join(''));

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

                var html = [];
                for (var j = 0; j < story10.length; j++) {
                    html.push("<tr><td>" +
                        story10[j][0].eventCauseID.eventID + "</td><td>" +
                        story10[j][0].eventCauseID.causeCode + "</td><td>" +
                        story10[j][0].description + "</td><td>" +
                        story10[j][1] + "</td></tr>"
                    )
                }
                $('#results').append(html.join(''));
            }
        }
    });
}

function userStory11( charts ){
    var startDate = $('#fromDate').val();
    var endDate = $('#toDate').val();
    if( startDate === "" || startDate === null || endDate === "" || endDate === null){
        return;
    }
    $("#results").html("");
    $('#searched').innerHTML = "";
    $.ajax({
        type: 'GET',
        url: 'api/data/top_ten_per_period/' + startDate + '/' + endDate,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            var story11 = aList;
            if( charts === "charts" ){
                var mccCombos = [];
                var totals = [];

                $.each(story11, function (index, value) {
                    mccCombos.push( value[0].country
                        + "/" + value[0].market + "/" + parseInt(value[1]) );
                    totals.push(parseInt(value[2]));
                });

                var data = [{
                    values: totals,
                    labels: mccCombos,
                    type: 'pie'
                }];
                Plotly.newPlot('query_output', data);

            }else {

                $("#results").append(
                    "<th onclick = 'sortTable(0)'>" + "Number" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' + "</th>" +
                    "<th onclick = 'sortTable(1)'>" + "MCC" + "</th>" +
                    "<th onclick = 'sortTable(2)'>" + "MNC" + "</th>" +
                    "<th onclick = 'sortTable(3)'>" + "Cell ID" + "</th>" +
                    "<th onclick = 'sortTable(4)'>" + "Total" + "</th>");

                document.getElementById("searched").innerHTML += story11.length + " results found!";

                var html = [];
                for (var j = 0; j < story11.length; j++){
                    html.push("<tr><td>" +
                            (j + 1) + "</td><td>" +
                        story11[j][0].operatorCode.marketCode + "</td><td>" +
                        story11[j][0].operatorCode.operatorCode + "</td><td>" +
                        story11[j][1] + "</td><td>" +
                        story11[j][2] + "</td></tr>"
                    )
                }
                $('#results').append(html.join(''));
            }
        }
    });

}

function userStory12( charts ){
    var startDate = $('#fromDate').val();
    var endDate = $('#toDate').val();
    if( startDate === "" || startDate === null || endDate === "" || endDate === null){
        return;
    }
    $("#results").html("");
    $.ajax({
        type: 'GET',
        url: 'api/data/call_data_per_period/top_ten/' + startDate + "/" + endDate,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            var story12 = aList;
            if( charts === "charts" ){
                var imsis = [];
                var totals = [];

                $.each(story12, function (index, value) {
                    imsis.push(parseInt(value[0]));
                    totals.push(parseInt(value[1]));
                });

                var data = [{
                    values: totals,
                    labels: imsis,
                    type: 'pie'
                }];
                Plotly.newPlot('query_output', data);

            }else {

                $("#results").append(
                    "<th onclick = 'sortTable(0)'>" +
                    "IMSI" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' + "</th>" +
                    "<th onclick = 'sortTable(1)'>" +
                    "TOTAL" + "</th>");

                document.getElementById("searched").innerHTML = story12.length + " results found!";

                var html = [];
                for (var j = 0; j < story12.length; j++) {
                    html.push("<tr><td>" +
                        story12[j][0] + "</td><td>" +
                        story12[j][1] + "</td></tr>")
                }
                $('#results').append(html.join(''));
            }
        }
    });
}

function userStory13( charts ){
    $("#results").html("");
    $('#searched').innerHTML = "";
    $.ajax({
        type: 'GET',
        url: 'api/data/top_ten_node',
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            var story13 = aList;
            if( charts === "charts" ){

                var totals = [];
                var percentages = [];
                var combos = [];

                $.each(story13, function (index, value) {
                    combos.push(value[0].country +
                        "/" + value[0].operator +
                        "/" + parseInt(value[1]));
                    totals.push(parseInt(value[2]));
                    percentages.push(parseInt(value[3]));
                });

                var data = [{
                    values: percentages,
                    labels: combos,
                    type: 'pie'
                }];
                Plotly.newPlot('query_output', data);
            }else {
                $("#results").append(
                    "<th onclick = 'sortTable(0)'>" + "Number" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' + "</th>" +
                    "<th onclick = 'sortTable(1)'>" + "MCC"  + "</th>" +
                    "<th onclick = 'sortTable(2)'>" + "MNC"  + "</th>" +
                    "<th onclick = 'sortTable(3)'>" + "Cell ID"  + "</th>" +
                    "<th onclick = 'sortTable(4)'>" + "Total"  + "</th>" +
                    "<th onclick = 'sortTable(3)'>" + "%"  + "</th>");

                document.getElementById("searched").innerHTML += story13.length + " results found!";

                var html = [];
                for (var j = 0; j < story13.length; j++) {
                    html.push("<tr><td>" +
                        (j + 1) + "</td><td>" +
                        story13[j][0].operatorCode.marketCode + "</td><td>" +
                        story13[j][0].operatorCode.operatorCode + "</td><td>" +
                        story13[j][1] + "</td><td>" +
                        story13[j][2] + "</td><td>" +
                        story13[j][3] + "</td></tr>"
                    )
                }
                $('#results').append(html.join(''));
            }
        }
    });

}

function userStory14(){
    var failure_class = $('#failure_class_text').val();
    $("#results").html("");
    $.ajax({
        type: 'GET',
        url: 'api/data/failure_class/get_imsis/' + failure_class,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            var story14 = aList;
            $("#results").append(
                "<th onclick = 'sortTable(0)'>" + "Date" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' + "</th>" +
                "<th onclick = 'sortTable(1)'>" + "IMSI" + "</th>" +
                "<th onclick = 'sortTable(2)'>" + "Event Cause" + "</th>" +
                "<th onclick = 'sortTable(3)'>" + "Country" + "</th>" +
                "<th onclick = 'sortTable(4)'>" + "Operator" + "</th>" +
                "<th onclick = 'sortTable(5)'>" + "Failure Class" + "</th>" +
                "<th onclick = 'sortTable(6)'>" + "Manufacturer" + "</th>");

            document.getElementById("searched").innerHTML = "Searched: " + failure_class + "<br>";
            document.getElementById("searched").innerHTML += story14.length + " results found!";

            $.each(story14, function (index, value) {
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

function showEventCauseTable() {
    $('#results').innerHTML = "";
    $.ajax({
        type: 'GET',
        url: 'api/data/event_causes',
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            $("#results").append(
                "<th>" + "Cause Code" + "</th>" +
                "<th>" + "Event ID"  + "</th>" +
                "<th>" + "Description"  + "</th>"
            );
            $.each(aList, function (index, value) {
                $("#results").append("<tr><td>" +
                    value.eventCauseID.causeCode + "</td><td>" +
                    value.eventCauseID.eventID + "</td><td>" +
                    value.description + "</td></tr>"
                );
            });
        }
    });
}

function showFailureClassTable() {
    $('#results').innerHTML = "";
    $.ajax({
        type: 'GET',
        url: 'api/data/failure_classes',
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            $("#results").append(
                "<th>" + "Failure Class" + "</th>" +
                "<th>" + "Description"  + "</th>"
            );
            $.each(aList, function (index, value) {
                $("#results").append("<tr><td>" +
                    value.failureClass + "</td><td>" +
                    value.description + "</td></tr>"
                );
            });
        }
    });
}

function showUserEventTypeTable() {
    $('#results').innerHTML = "";
    $.ajax({
        type: 'GET',
        url: 'api/data/user_event_types',
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            $("#results").append(
                "<th>" + "Failure Class" + "</th>" +
                "<th>" + "Marketing Name" + "</th>" +
                "<th>" + "Manufacturer" + "</th>" +
                "<th>" + "Access Capability" + "</th>" +
                "<th>" + "Model" + "</th>" +
                "<th>" + "Vendor Name" + "</th>" +
                "<th>" + "UE Device" + "</th>" +
                "<th>" + "OS" + "</th>" +
                "<th>" + "Input Mode" + "</th>"
            );
            $.each(aList, function (index, value) {
                $("#results").append(
                    "<tr><td>" +
                    value.tac + "</td><td>" +
                    value.marketingName + "</td><td>" +
                    value.manufacturer + "</td><td>" +
                    value.accessCapability + "</td><td>" +
                    value.model + "</td><td>" +
                    value.vendorName + "</td><td>" +
                    value.ueDevice + "</td><td>" +
                    value.operatingSystem + "</td><td>" +
                    value.inputMode +
                    "</td></tr>"
                );
            });
        }
    });
}

function showMarketOperatorTable() {
    $('#results').innerHTML = "";
    $.ajax({
        type: 'GET',
        url: 'api/data/market_operators',
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            $("#results").append(
                "<th>" + "MCC" + "</th>" +
                "<th>" + "MNC" + "</th>" +
                "<th>" + "Country" + "</th>" +
                "<th>" + "Operator" + "</th>"
            );
            $.each(aList, function (index, value) {
                $("#results").append(
                    "<tr><td>" +
                    value.operatorCode.marketCode + "</td><td>" +
                    value.operatorCode.operatorCode + "</td><td>" +
                    value.country + "</td><td>" +
                    value.operator + "</td><td>" +
                    "</td></tr>"
                );
            });
        }
    });
}


function pagination(currentResults, resultsPerPage, resultCount, nItems)
{
    // Consider adding an ID to your table
    // incase a second table ever enters the picture.
    var items = nItems/*$("table tr")*/;

    var numItems = items.length;

    for( var i = 0; i < resultsPerPage; i++ ){
        $("#results").append("<tr><td>" +
            items[i][0] + "</td><td>" +
            items[i][1] + "</td><td>" +
            items[i][2] + "</td></tr>");
    }

    // Only show the first 2 (or first `per_page`) items initially.
    items.slice(resultsPerPage).hide();

    // Now setup the pagination using the `.pagination-page` div.
    $("#results_div").pagination({
        items: numItems,
        itemsOnPage: resultsPerPage,
        cssStyle: "light-theme",

        // This is the actual page changing functionality.
        onPageClick: function (pageNumber) {
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