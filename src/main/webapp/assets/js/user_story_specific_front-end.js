/*
    infoHeading: eg. "User Story 10"
 */

function querySpecifcStructure(heading, description, label_text, input_id, placeholder_text, button_method) //parameters instead?!!!
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
    //$("#query_field").id = "uetype_text";
    //alert("Done");

}

function userStory10StructureV2()
{
    var heading, description, label_text, input_id, placeholder_text, button_method;
    heading = "User Story 10";
    description = "Network Mgt Engineer: Display unique EVENT_ID/CAUSE_CODE combinations for a specific ueType and the number of occurrence.";
    label_text = "UE Type:";
    input_id = "uetype_text";
    placeholder_text = "E.g. 100100";
    button_method = "userStory10()";

    querySpecifcStructure(heading, description, label_text, input_id, placeholder_text, button_method);
}

function userStory10Structure() //parameters instead?!!!
{
    //Query Info
    $("#info_heading").append("User Story 10");
    $("#info_description").append("Network Mgt Engineer: Display unique EVENT_ID/CAUSE_CODE combinations for a specific ueType and the number of occurrence.");

    //Query Input
    var text_field = document.getElementById("query_field");
    text_field.setAttribute("id", "uetype_text");
    text_field.placeholder="E.g. 100100";

    var label = document.getElementById("query_label");
    label.setAttribute("for", "uetype_text");
    label.innerHTML = "UE Type:";

    var queryBtn = document.getElementById("queryBtn");
    queryBtn.setAttribute("onclick", "userStory10()");
    //$("#query_field").id = "uetype_text";
    //alert("Done");

}

function userStory14Structure() //parameters instead?!!!
{
    //Query Info
    $("#info_heading").append("User Story 14");
    $("#info_description").append("Support Engineer: I want to display, for a given failure Cause Class, the IMSIs that were affected.");

    //Query Input
    /**
    var text_field = document.getElementById("query_field");
    text_field.setAttribute("id", "failure_class_text");
    //text_field.placeholder="E.g. 100100";

    var label = document.getElementById("query_label");
    label.setAttribute("for", "failure_class_text");
    label.innerHTML = "Failure Class:";
     **/

    var drop_down = document.getElementById("query_dropdown");
    drop_down.setAttribute("id", "failure_class_text");
    //text_field.placeholder="E.g. 100100";

    var label = document.getElementById("query_label");
    label.setAttribute("for", "failure_class_text");
    label.innerHTML = "Failure Class:";

    //Populate Dropdown
    dropdown_values = [0,1,2,3,4];
    $.each(dropdown_values, function (index, value) {
        var option = document.createElement("option");
        option.setAttribute("value", value);
        option.innerHTML = value;
        $("#failure_class_text").append(option);
        //$("#failure_class_text").append("<option value =" + value + ">");
    });

    var queryBtn = document.getElementById("queryBtn");
    queryBtn.setAttribute("onclick", "userStory14()");
    //$("#query_field").id = "uetype_text";
    //alert("Done");

}

function userStory6Structure() //parameters instead?!!!
{
    //Query Info
    $("#info_heading").append("User Story 6");
    $("#info_description").append("Customer Service: Display unique CAUSE_CODEs for a specific imsi and the number of occurrence.");

    //Query Input
    var text_field = document.getElementById("query_field");
    text_field.setAttribute("id", "imsi_text");
    //text_field.placeholder="E.g. 100100";

    var label = document.getElementById("query_label");
    label.setAttribute("for", "imsi_text");
    label.innerHTML = "IMSI:";

    var queryBtn = document.getElementById("queryBtn");
    queryBtn.setAttribute("onclick", "userStory6()");
    //$("#query_field").id = "uetype_text";
    //alert("Done");

}

function userStory9Structure() //parameters instead?!!!
{
    //Query Info
    $("#info_heading").append("User Story 9");
    $("#info_description").append("Network Management Engineer: Count, for each IMSI, the number of call failures and their total duration during a given time period");

    /**
    //Query Input
    var text_field = document.getElementById("query_field1");
    text_field.setAttribute("id", "from_date");
    //text_field.placeholder="E.g. 100100";

    var text_field = document.getElementById("query_field1");
    text_field.setAttribute("id", "to_date");

    var label = document.getElementById("query_label1");
    label.setAttribute("for", "from_date");
    label.innerHTML = "From:";

    var label = document.getElementById("query_label2");
    label.setAttribute("for", "to_date");
    label.innerHTML = "To:";
     **/

    var queryBtn = document.getElementById("queryBtn");
    queryBtn.setAttribute("onclick", "userStory9()");
    //$("#query_field").id = "uetype_text";
    //alert("Done");

}