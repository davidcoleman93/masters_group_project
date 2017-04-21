//Populates autocomplete for textfield, with all unique UE Types in database.
//Options must be strings to appear in suggestion.
//$( function() {
function autoComplete(uniqueCol){
    //var availableTags = ["21060800", "33000153", "33000253"];
    var autoUrl;
    if(uniqueCol == "ue_type")
    {
        autoUrl = 'http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/all_unique_ue_types';
    }
    else if(uniqueCol == "imsi")
    {
        autoUrl = 'http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/all_unique_imsis';
    }

    var availableTags = [];
    $.ajax({
        type: 'GET',
        url: autoUrl,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            $.each(aList, function (index, value) {
                availableTags.push(value.toString()); //Converts value to String, and adds to availableTags.
            });
            if(uniqueCol == "ue_type")
            {
                $( "#uetype_text" ).autocomplete({
                    source: availableTags
                });
            }
            else if(uniqueCol == "imsi")
            {
                $( "#imsi_text" ).autocomplete({
                    //Limits autocomplete suggestions displayed to 20.
                    //This is done to prevent issues with load time.
                    source: function(request, response) {
                        var results = $.ui.autocomplete.filter(availableTags, request.term);

                        response(results.slice(0, 20));
                    }
                });
            }

        }
    });


}// );