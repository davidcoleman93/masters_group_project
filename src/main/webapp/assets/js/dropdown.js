//Populates autocomplete for textfield, with all unique UE Types in database.
//Options must be strings to appear in suggestion.
//$( function() {
function dropdown(uniqueCol){
    var autoUrl;
    if(uniqueCol === "failure_class") {
        autoUrl = 'api/data/all_unique_failure_class';
        console.log("HERE");
    }

    var availableTags = [];
    $.ajax({
        type: 'GET',
        url: autoUrl,
        contentType: 'application/json',
        dataType: 'json',
        success: function (aList) {
            $.each(aList, function (index, value) {
                if( uniqueCol === "failure_class" ){
                    availableTags.push( value.description );
                }else {
                    availableTags.push(value.toString()); //Converts value to String, and adds to availableTags.
                }
                $('#query_dropdown').append(
                    $('<option></option>').val(value.description).html(text)
                );
            });
            if(uniqueCol === "failure_class") {
                $( "#query_dropdown" ).dropdown({
                    source: availableTags
                });
            }
        }
    });
}