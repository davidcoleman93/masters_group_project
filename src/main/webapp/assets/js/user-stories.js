
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


                if( story4.length < 250 ){
                    $.each(story4, function (index, value) {
                        $("#results").append("<tr><td>" +
                            value.eventCauseID.eventID + "</td><td>" +
                            value.eventCauseID.causeCode + "</td><td>" +
                            value.description + "</td></tr>");
                    });
                }else{
                    for( var i = 0; i < 50; i++ ){
                        $("#results").append("<tr><td>" +
                            story4[i].eventCauseID.eventID + "</td><td>" +
                            story4[i].eventCauseID.causeCode + "</td><td>" +
                            story4[i].description + "</td></tr>");
                    }
                }
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

            if( story6.length < 250 ){
                $.each(story6, function (index, value) {
                    var eventCause = value[0];
                    $("#results").append("<tr><td>" +
                        eventCause.eventCauseID.causeCode + "</td><td>" +
                        value[1] + "</td></tr>");
                });
            }else {
                for( var i = 0; i < 50; i++ ){
                    var eventCause = story6[i][0];
                    $("#results").append("<tr><td>" +
                        eventCause.eventCauseID.causeCode + "</td><td>" +
                        story6[i][1] + "</td></tr>");
                }
            }

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

            //var cellID, date, duration, eventCause, failureClass, id, imsi, marketOperator, neVersion, userEventType;

            if( story7.length < 250 ){
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
            }else {
                for( var i = 0; i < 50; i++ ){
                    $("#results").append("<tr><td>" +
                        getDate(value.dateTime) + "</td><td>" +
                        story7[i].imsi + "</td><td>" +
                        story7[i].eventCause.description + "</td><td>" +
                        story7[i].marketOperator.country + "</td><td>" +
                        story7[i].marketOperator.operator + "</td><td>" +
                        story7[i].failureClass.description + "</td><td>" +
                        story7[i].userEventType.manufacturer + "</td></tr>");
                }
            }
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
                var failures = [];

                if( story9.length < 250 ) {
                    $.each(story9, function (index, value) {
                        totalDuration.push(parseInt(value[1]));
                        numFailures.push(parseInt(value[2]));
                        failures.push(value[0].toString());
                    });
                }else {
                    for( var i = 0; i < 250; i++ ){
                        var value = story9[i];
                        totalDuration.push(parseInt(value[1]));
                        numFailures.push(parseInt(value[2]));
                        failures.push(value[0].toString());
                    }
                }

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

                if( story9.length < 250 ) {
                    $.each(story9, function (index, value) {
                        $("#results").append("<tr><td>" +
                            value[0] + "</td><td>" +
                            value[1] + "</td><td>" +
                            value[2] + "</td></tr>");
                    });
                }else {
                    for( var j = 0; j < 50; j++ ) {
                        var v = story9[j];
                        $("#results").append("<tr><td>" +
                            v[0] + "</td><td>" +
                            v[1] + "</td><td>" +
                            v[2] + "</td></tr>");
                    }
                }

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

                if( story10.length < 250 ){
                    $.each(story10, function (index, value) {
                        eventcause.push(value[0].eventCauseID.eventID + "/" + value[0].eventCauseID.causeCode);
                        counts.push(parseInt(value[1]));
                    });
                }else {
                    for( var i = 0; i < 250; i++ ) {
                        var value = story10[i];
                        eventcause.push(value[0].eventCauseID.eventID + "/" + value[0].eventCauseID.causeCode);
                        counts.push(parseInt(value[1]));
                    }
                }


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


                    if( story10.length < 250 ){
                        $.each(story10, function (index, value) {
                            var eventCause = value[0];
                            $("#results").append("<tr><td>" +
                                eventCause.eventCauseID.eventID + "</td><td>" +
                                eventCause.eventCauseID.causeCode + "</td><td>" +
                                eventCause.description + "</td><td>" +
                                value[1] + "</td></tr>");
                        });
                    }else {
                        for( var j = 0; j < 50; j++ ) {
                            var v = story10[j];
                            var eventCause = value[0];
                            $("#results").append("<tr><td>" +
                                eventCause.eventCauseID.eventID + "</td><td>" +
                                eventCause.eventCauseID.causeCode + "</td><td>" +
                                eventCause.description + "</td><td>" +
                                v[1] + "</td></tr>");
                        }
                    }
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

                if( story11.length < 250 ){
                    $.each(story11, function (index, value) {
                        mccCombos.push( value[0].country
                            + "/" + value[0].market + "/" + parseInt(value[1]) );
                        totals.push(parseInt(value[2]));
                    });
                }else {
                    for( var i = 0; i < 50; i++ ){
                        var value = story11[i];
                        mccCombos.push( value[0].country
                            + "/" + value[0].market + "/" + parseInt(value[1]) );
                        totals.push(parseInt(value[2]));
                    }
                }

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

                if( story11.length < 250 ) {
                    $.each(story11, function (index, value) {
                        $("#results").append("<tr><td>" +
                            (index + 1) + "</td><td>" +
                            value[0].operatorCode.marketCode + "</td><td>" +
                            value[0].operatorCode.operatorCode + "</td><td>" +
                            value[1] + "</td><td>" +
                            value[2] + "</td></tr>"
                        );
                    });
                }else {
                    for( var j = 0; j < 50; j++ ){
                        var v = story11[j];
                        $("#results").append("<tr><td>" +
                            (index + 1) + "</td><td>" +
                            v[0].operatorCode.marketCode + "</td><td>" +
                            v[0].operatorCode.operatorCode + "</td><td>" +
                            v[1] + "</td><td>" +
                            v[2] + "</td></tr>"
                        );
                    }
                }
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

                if( story12.length < 250 ){
                    $.each(story12, function (index, value) {
                        imsis.push(parseInt(value[0]));
                        totals.push(parseInt(value[1]));
                    });
                }else {
                    for( var i = 0; i < 250; i++ ){
                        var value = story12[i];
                        imsis.push(parseInt(value[0]));
                        totals.push(parseInt(value[1]));
                    }
                }

                var data = [{
                    values: totals,
                    labels: imsis,
                    type: 'pie'
                }];
                var layout = {
                    height: 400,
                    width: 500
                };
                Plotly.newPlot('query_output', data, layout);

            }else {

                $("#results").append(
                    "<th onclick = 'sortTable(0)'>" +
                    "IMSI" + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' + "</th>" +
                    "<th onclick = 'sortTable(1)'>" +
                    "TOTAL" + "</th>");

                document.getElementById("searched").innerHTML = story12.length + " results found!";

                if( story12.length < 250 ){
                    $.each(story12, function (index, value) {
                        $("#results").append("<tr><td>" +
                            value[0] + "</td><td>" +
                            value[1] + "</td></tr>");
                    });
                }else {
                    for( var j = 0; j < 50; j++ ){
                        var v = story12[j];
                        $("#results").append("<tr><td>" +
                            v[0] + "</td><td>" +
                            v[1] + "</td></tr>");
                    }
                }
            }
        }
    });
}

function userStory13( charts ){
    $("#results").html("");
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

                if( story13.length < 250 ){
                    $.each(story13, function (index, value) {
                        combos.push(value[0].country +
                            "/" + value[0].operator +
                            "/" + parseInt(value[1]));
                        totals.push(parseInt(value[2]));
                        percentages.push(parseInt(value[3]));
                    });
                }else {
                    for( var i = 0; i < 250; i++ ){
                        var value = story13[i];
                        combos.push(value[0].country +
                            "/" + value[0].operator +
                            "/" + parseInt(value[1]));
                        totals.push(parseInt(value[2]));
                        percentages.push(parseInt(value[3]));
                    }
                }

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

                if( story13.length < 250 ){
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
                }else {
                    for( var j = 0; j < 50; j++ ){
                        var v = story13[j];
                        $("#results").append("<tr><td>" +
                            (index + 1) + "</td><td>" +
                            v[0].operatorCode.marketCode + "</td><td>" +
                            v[0].operatorCode.operatorCode + "</td><td>" +
                            v[1] + "</td><td>" +
                            v[2] + "</td><td>" +
                            v[3] + "</td></tr>"
                        );
                    }
                }
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

            if (story14.length < 250) {
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
            } else {
                for (var i = 0; i < 20; i++) {
                    var value = story14[i];
                    $("#results").append("<tr><td>" +
                        getDate(value.dateTime) + "</td><td>" +
                        value.imsi + "</td><td>" +
                        value.eventCause.description + "</td><td>" +
                        value.marketOperator.country + "</td><td>" +
                        value.marketOperator.operator + "</td><td>" +
                        value.failureClass.description + "</td><td>" +
                        value.userEventType.manufacturer + "</td></tr>");
                }
            }
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
                "<th>" + "UE Type" + "</th>" +
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