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

    var x = document.getElementById(input_id);
    console.log(x);
    x.placeholder =  placeholder_text;

    //document.getElementById("#query_field").placeholder = placeholder_text;

    //$('#query_field').attr("placeholder",placeholder_text);

    /*$('#query_field').attr({
        "placeholder":placeholder_text
    });*/

    $('#query_label').attr(
        "for","uetype_text"
    );
    $('#query_label').text(label_text);

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