//Populates autocomplete for textfield, with all unique UE Types in database.
//Options must be strings to appear in suggestion.
//$( function() {
function autoComplete(uniqueCol){
    var autoUrl;
    if(uniqueCol === "ue_type") {
        autoUrl = 'api/data/all_unique_ue_types';
    } else if(uniqueCol === "imsi") {
        autoUrl = 'api/data/all_unique_imsis';
    } else if( uniqueCol === "phone_model" ){
        autoUrl = 'api/data/all_unique_phone_models';
    }

    var availableTags = [];
    $.ajax({
        type: 'GET',
        url: autoUrl,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            $.each(aList, function (index, value) {
                if( uniqueCol === "phone_model" ){
                    availableTags.push( value );
                }else {
                    availableTags.push(value.toString()); //Converts value to String, and adds to availableTags.
                }
            });
            if(uniqueCol === "ue_type") {
                $( "#uetype_text" ).autocomplete({
                    source: availableTags
                });
            } else if(uniqueCol === "imsi") {
                $( "#imsi_text" ).autocomplete({
                    //Limits auto-complete suggestions displayed to 20.
                    //This is done to prevent issues with load time.
                    source: function(request, response) {
                        var results = $.ui.autocomplete.filter(availableTags, request.term);
                        response(results.slice(0, 20));
                    }
                });
            } else if( uniqueCol === "phone_model" ){
                $( "#phone_model_text" ).autocomplete({
                    source: availableTags
                });
                /*$( "#phone_model_text" ).autocomplete({
                    //Limits auto-complete suggestions displayed to 20.
                    //This is done to prevent issues with load time.
                    source: function(request, response) {

                        var results = $.ui.autocomplete.filter(availableTags, request.term);
                        response(results.slice(0, 20));
                    }
                });*/
            }
        }
    });
}