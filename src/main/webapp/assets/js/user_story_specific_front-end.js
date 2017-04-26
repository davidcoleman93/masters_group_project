function querySpecificStructure(heading, description, label_text, input_id, placeholder_text, button_method) //parameters instead?!!!
{
    //Query Info
    $("#info_heading").append(heading);
    $("#info_description").append(description);

    //Query Input

    $('#query_field').attr(
        "id",input_id
    );
    /*var text_field = document.getElementById("query_field");
    if( text_field !== null ){
        text_field.setAttribute("id", input_id);
    }*/

    $('#query_field').attr("placeholder",placeholder_text);

    /*$('#query_field').attr({
        "placeholder":placeholder_text
    });*/

    $('#query_label').attr(
        "for","uetype_text"
    );
    $('#query_label').innerHTML = label_text;

    /*if(placeholder_text !== null) {
        text_field.setAttribute("placeholder", placeholder_text);
    }*/
/*
    var label = document.getElementById("query_label");
    if( label_text !== null ){
        label.setAttribute("for", "uetype_text");
        label.innerHTML = label_text;
    }*/

    $('#queryBtn').attr(
        "onclick",button_method
    );

   /* var queryBtn = document.getElementById("queryBtn");
    queryBtn.setAttribute("onclick", button_method);*/
}

function userStory14Structure() //parameters instead?!!!
{
    //Query Info
    $("#info_heading").append("User Story 14");
    $("#info_description").append("display, for a given failure Cause Class, the IMSIs that were affected.");


    var drop_down = document.getElementById("query_dropdown");
    drop_down.setAttribute("id", "failure_class_text");
    //text_field.placeholder="E.g. 100100";

    var label = document.getElementById("query_label");
    label.setAttribute("for", "failure_class_text");
    label.innerHTML = "Failure Class:";

    //Populate Dropdown
    //dropdown_values = [0,1,2,3,4];

    dropdown_values = [];
    $.ajax({
        type: 'GET',
        url: 'api/data/all_unique_failure_class',
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            $.each(aList, function (index, value) {
                //dropdown_values.push(value);
                dropdown_values.push(value.toString()); //Converts value to String, and adds to availableTags.
            });

            $.each(dropdown_values, function (index, value) {
                var option = document.createElement("option");
                // option.setAttribute("value", value[0].toString());
                // option.innerHTML = value[0].toString() + " / " + value[1].toString();
                option.setAttribute("value", value);
                option.innerHTML = value;
                $("#failure_class_text").append(option);
                //$("#failure_class_text").append("<option value =" + value + ">");
            });
        }
    });



    var queryBtn = document.getElementById("queryBtn");
    queryBtn.setAttribute("onclick", "userStory14()");
    //$("#query_field").id = "uetype_text";
    //alert("Done");

}

function populateUserStory14Dropdown()
{
    //Populate Dropdown
    dropdown_values = [0,1,2,3,4];
    $.each(dropdown_values, function (index, value) {
        var option = document.createElement("option");
        option.setAttribute("value", value);
        option.innerHTML = value;
        $("#failure_class_text").append(option);
        //$("#failure_class_text").append("<option value =" + value + ">");
    });
}