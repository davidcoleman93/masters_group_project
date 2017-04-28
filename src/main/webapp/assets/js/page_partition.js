/**
 * Created by david on 27/04/2017.
 */
<!-- Script to generate the queries (Page partitioning) -->
$(document).ready(function () {

    /* USER STORY #4 */
    $('#ec-imsi').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();

        /* Displays one text field */
        queryOneTextFieldStructure();

        /* Include if there's a dropdown */
        //queryEmptyDropdownStructure();

        /* Unique display per query */
        querySpecificStructure(
            "IMSI (Cus Rep)",
            "Display, for a given affected IMSI, the Event ID and Cause Code for any / all failures affecting that IMSI",
            "IMSI",
            "imsi_text",
            "Eg. 344930000000011",
            "userStory4()"
        );

        //$('#imsi_text').attr("placeholder", "Test");

        /* define which auto-complete to include */
        autoComplete("imsi");
        $(".ec-pmodel").show("fast");
    });

    /* User Story 5 */
    $('#count-imsi-cust').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();

        /* Displays input field corresponding to query */
        queryInputAndFromAndToDateStructure();

        /* Unique display per query */
        querySpecificStructure(
            "IMSI (Cus Rep)", // heading: User Story 1
            "Count, for a given IMSI, the number of failures they have had during a given time period.", // description: For a given affected IMSI...
            "IMSI", // label_text: Eg. IMSI or Phone Model
            "imsi_text", // input_id: imsi_text
            "Eg. 344930000000011", // placeholder: E.g 344930000000011(imsi)
            "userStory5()" // button_method: userStory1()
        );

        /* define if to include auto-complete */
        autoComplete("imsi");

        $(".ec-pmodel").show("fast");
    });

    /* User Story 6 */
    $('#ec-ccode').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();

        /* Displays input field corresponding to query */
        queryOneTextFieldStructure();

        /* Unique display per query */
        querySpecificStructure(
            "Causes Code (Cus Rep)", // heading: User Story 1
            "For a given IMSI, all the unique Cause Codes associated with its call failures", // description: For a given affected IMSI...
            "IMSI", // label_text: Eg. IMSI or Phone Model
            "imsi_text", // input_id: imsi_text
            "Eg. 344930000000011", // placeholder: E.g 344930000000011
            "userStory6()" // button_method: userStory1()
        );

        /* define if to include auto-complete */
        autoComplete("imsi");
        $(".ec-pmodel").show("fast");
    });

    /* User Story 7 */
    $('#fail-list-sup').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();

        /* Displays input field corresponding to query */
        queryFromAndToDateStructure();

        $("#info_heading").append("Failure List (Sup Engn)");
        $("#info_description").append("List of all IMSIs with call failures during a given time period");

        $('#queryBtn').click(function () {
            userStory7();
        });

        /* define if to include auto-complete */
        //autoComplete("ue_type");

        $(".ec-pmodel").show("fast");
    });

    /* User Story 8 */
    $('#count-phone-sup').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();

        /* Displays input field corresponding to query */
        queryInputAndFromAndToDateStructure();

        /* Unique display per query */
        querySpecificStructure(
            "Phone Module (Sup Engn)", // heading: User Story 1
            "Count, for a given model of phone, the number of call failures it has had during a given time period.", // description: For a given affected IMSI...
            "Phone Model", // label_text: Eg. IMSI or Phone Model
            "phone_model_text", // input_id: imsi_text
            "Eg. VEA3", // placeholder: E.g 344930000000011
            "userStory8()" // button_method: userStory1()
        );

        /* define if to include auto-complete */
        autoComplete("phone_model");

        $(".ec-pmodel").show("fast");
    });

    /*User Story 9 - IMSI COUNT (NET ENGN) START*/
    $("#count-imsi-netengn").click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();

        /* Displays input field corresponding to query */
        queryFromAndToDateStructure();

        $("#info_heading").append("IMSI (Net Engn)");
        $("#info_description").append("Count, for each IMSI, the number of call failures and their total duration during a given time period");

        $('#queryBtn').click(function () {
            userStory9();
        });

        $(".ec-pmodel").show("fast");
    });

    /* User Story 10 - Phone Model */
    $("#ec-pmodel").click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();

        /* Displays one text field */
        queryOneTextFieldStructure();

        /* Unique display per query */
        querySpecificStructure(
            "Phone Model (Net Eng)",
            "Display unique EVENT_ID/CAUSE_CODE combinations for a specific ueType and the number of occurrence.",
            "Phone model:",
            "phone_model_text",
            "E.g. VEA3",
            "userStory10( 'test' )"
        );

        /* define if to include auto-complete */
        autoComplete("phone_model");

        $(".ec-pmodel").show("fast");
    });

    /* User Story 11 */
    $('#mcc-mnc-time-netengn').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();

        /* Displays input field corresponding to query */
        queryFromAndToDateStructure();

        $("#info_heading").append("MCC / MNC TIME (Net Engn)");
        $("#info_description").append("Top 10 Market/Operator/Cell ID combinations that had call failures during a time period");

        $('#queryBtn').click(function () {
            userStory11();
        });

        /* define if to include auto-complete */
        //autoComplete("ue_type");

        $(".ec-pmodel").show("fast");
    });

    /* User Story 12 */
    $('#top-imsi-netengn').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();

        /* Displays input field corresponding to query */
        queryFromAndToDateStructure();

        $("#info_heading").append("Top 10 IMSI (Net Engn)");
        $("#info_description").append("Top 10 IMSIs that had call failures during a time period");

        $('#queryBtn').click(function () {
            userStory12();
        });

        $(".ec-pmodel").show("fast");
    });

    /* User Story 13 query */
    $('#mcc-mnc-graph-netengn').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();

        /* Displays input field corresponding to query */
        queryOneButtonFieldStructure();

        $("#info_heading").append("MCC / MNC GRAPH (Net Engn)");
        $("#info_description").append("Graphical Representation of the Top 10 Market/Operator/Cell ID combinations with call failures showing Node, Number of failures & % of all failures");

        $('#queryBtn').click(function () {
            userStory13();
        });

        $(".ec-pmodel").show("fast");
    });

    /* User Story 14 */
    $('#aff-imsi-sup').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();

        /* Displays input field corresponding to query */
        queryEmptyDropdownStructure();

        $('#query_dropdown').attr({
            id:"failure_class_text"
        });

        $("#info_heading").append("Affected IMSI (Sup Engn)");
        $("#info_description").append("Display, for a given failure Cause Class, the IMSIs that were affected.");

        $('#queryBtn').click(function () {
            userStory14();
        });

        /* define if to include auto-complete */
        populateUserStory14DropdownV2();

        $(".ec-pmodel").show("fast");
    });

    /*
     Chart User story #9
     */
    $("#chart9").click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();

        /* Displays input field corresponding to query */
        queryFromAndToDateStructure();

        $("#info_heading").append("User Story 9");
        $("#info_description").append("Count, for each IMSI, the number of call failures and their total duration during a given time period");

        $('#queryBtn').click(function () {
            userStory9( "charts" );
        });

        $('#query_output').empty();

        $(".ec-pmodel").show("fast");
    });

    /*
     Chart User story #10
     */
    $('#chart10').click(function () {
        $(".wrapper").empty();
        queryStructure();

        /* Displays one text field */
        queryOneTextFieldStructure();

        /* Unique display per query */
        querySpecificStructure(
            "Phone Model (Net Eng)",
            "Display unique EVENT_ID/CAUSE_CODE combinations for a specific ueType and the number of occurrence.",
            "Phone model:",
            "phone_model_text",
            "E.g. VEA3",
            "userStory10( 'charts' )"
        );

        /* define if to include auto-complete */
        autoComplete("phone_model");

        $('#query_output').empty();

        $(".ec-pmodel").show("fast");
    });

    /*
     Chart User story #11
     */
    $('#chart11').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();

        /* Displays input field corresponding to query */
        queryFromAndToDateStructure();

        $("#info_heading").append("MCC / MNC TIME (Net Engn)");
        $("#info_description").append("Top 10 Market/Operator/Cell ID combinations that had call failures during a time period");

        $('#queryBtn').click(function () {
            userStory11( 'charts' );
        });

        $('#query_output').empty();

        $(".ec-pmodel").show("fast");
    });

    /*
     Chart User story #12
     */
    $('#chart12').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();

        /* Displays input field corresponding to query */
        queryFromAndToDateStructure();

        $("#info_heading").append("Top 10 IMSI (Net Engn)");
        $("#info_description").append("Top 10 IMSIs that had call failures during a time period");

        $('#queryBtn').click(function () {
            userStory12( 'charts' );
        });

        $('#query_output').empty();

        $(".ec-pmodel").show("fast");
    });

    /*
     Chart User story #13
     */
    $('#chart13').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();

        /* Displays input field corresponding to query */
        queryOneButtonFieldStructure();

        $("#info_heading").append("MCC / MNC GRAPH (Net Engn)");
        $("#info_description").append("Graphical Representation of the Top 10 Market/Operator/Cell ID combinations with call failures showing Node, Number of failures & % of all failures");

        $('#queryBtn').click(function () {
            userStory13( 'charts' );
        });

        $('#query_output').empty();

        $(".ec-pmodel").show("fast");
    });

    //LOOKUP TABLE - EVENT CAUSES
    $('#eventCauses').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();
        $('#query_input').empty();
        $('#query_info').empty();
        showEventCauseTable();

        $(".ec-pmodel").show("fast");
    });

    //LOOKUP TABLE - FAILURE CLASSES
    $('#failureClasses').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();
        $('#query_input').empty();
        $('#query_info').empty();
        showFailureClassTable();

        $(".ec-pmodel").show("fast");
    });

    //LOOKUP TABLE - FAILURE CLASSES
    $('#ueTypes').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();
        $('#query_input').empty();
        $('#query_info').empty();
        showUserEventTypeTable();

        $(".ec-pmodel").show("fast");
    });

    //LOOKUP TABLE - MARKET OPERATORS
    $('#marketOperators').click(function () {
        /* We must empty the outer container first */
        $(".wrapper").empty();

        /* This defines the structure for all query pages */
        queryStructure();
        $('#query_input').empty();
        $('#query_info').empty();
        showMarketOperatorTable();

        $(".ec-pmodel").show("fast");
    });

});

function populateUserStory14DropdownV2() {
    var dropdown_values = [];
        $.ajax({
        type: 'GET',
               url: 'api/data/all_unique_failure_class',
               contentType: 'application/json',
                dataType: 'json',
                success: function (aList) {
                    $.each(aList, function (index, value) {
                           dropdown_values.push(value);
                            //dropdown_values.push(value.toString()); //Converts value to String, and adds to availableTags.
                            });

                       $.each(dropdown_values, function (index, value) {
                                var option = document.createElement("option");
                               option.setAttribute("value", value[0].toString());
                //option.innerHTML = value[0].toString() + " / " + value[1].toString();
                                   option.innerHTML = value[0].toString() + "/" + value[1].toString();
                                //option.setAttribute("value", value);
                                    //option.innerHTML = value;
                                       $("#failure_class_text").append(option);
                                //$("#failure_class_text").append("<option value =" + value + ">");
                               });
               }
        });
    }