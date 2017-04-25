function queryStructure() {
    console.log("CREATING QUERY STRUCTURE");
    var queryInfo = document.createElement("div");
    queryInfo.id = "query_info";

    var queryInput = document.createElement("div");
    queryInput.id = "query_input";

    var queryOutput = document.createElement("div");
    queryOutput.id = "query_output";

    $(".wrapper").append(queryInfo);
    $(".wrapper").append(queryInput);
    $(".wrapper").append(queryOutput);

    queryInfoStructure();
    queryOutputStructure();
}

function noInputQueryStructure() {
    var queryInfo = document.createElement("div");
    queryInfo.id = "query_info";

    var queryOutput = document.createElement("div");
    queryOutput.id = "query_output";

    $(".wrapper").append(queryInfo);
    $(".wrapper").append(queryOutput);

    queryInfoStructure();
    queryOutputStructure();
}

/*
    Heading structure for ALL queries
 */
function queryInfoStructure() {
    var infoHeading = document.createElement("h1");
    infoHeading.id = "info_heading";

    var infoDescription = document.createElement("p");
    infoDescription.id = "info_description";

    $("#query_info").append(infoHeading);
    $("#query_info").append(infoDescription);
}

function queryOneTextFieldStructure() {

    $("#query_input").append(' <tbody> <tr> <td class="name"> <form class="form-inline"> <div class="form-group"> <label id = "query_label" for="query_field"></label> <input type="text" name="query_field" id="query_field" class="form-control" width="20" maxlength="20" size="20"> </div> </form> </td> <td class="name"> <input type="button" id="queryBtn" class="btn btn-primary" value="Submit"> </td> </tr> </tbody>');

}

function queryOneButtonFieldStructure() {

    $("#query_input").append(' <tbody> <tr> <td class="name"> <form class="form-inline"> <div class="form-group"> </div> </form> </td> <td class="name"> <input type="button" id="queryBtn" class="btn btn-primary" value="Submit"> </td> </tr> </tbody>');

}

function queryTwoTextFieldStructure() {

    $("#query_input").append(' <tbody> <tr> <td class="name"> <form class="form-inline"> <div class="form-group"> <label id = "query_label1" for="query_field1"></label> <input type="text" name="query_field1" id="query_field1" class="form-control" width="20" maxlength="20" size="20"> <label id = "query_label2" for="query_field2"></label> <input type="text" name="query_field2" id="query_field2" class="form-control" width="20" maxlength="20" size="20"> </div> </form> </td> <td class="name"> <input type="button" id="queryBtn" class="btn btn-primary" value="Submit"> </td> </tr> </tbody>');

}

function queryFromAndToDateStructure() {

    $("#query_input").append(' <tbody> <tr> <td class="name"> <form class="form-inline"> <div class="form-group"> <label id = "query_label1" for="fromDate"></label> <input type="date" name="query_field1" id="fromDate" class="form-control" width="20" maxlength="20" size="20"> <label id = "query_label2" for="toDate"></label> <input type="date" name="query_field2" id="toDate" class="form-control" width="20" maxlength="20" size="20"> </div> </form> </td> <td class="name"> <input type="button" id="queryBtn" class="btn btn-primary" value="Submit"> </td> </tr> </tbody>');

}

function queryInputAndFromAndToDateStructure() {

    $("#query_input").append(' <tbody> <tr> <td class="name"> <form class="form-inline"> <div class="form-group"> <label id = "query_label" for="query_field"></label> <input type="text" name="query_field" id="query_field" class="form-control" width="20" maxlength="20" size="20"> </div> </form> </td> </tr>  <tr> <td class="name"> <form class="form-inline"> <div class="form-group"> <label id = "query_label1" for="fromDate"></label> <input type="date" name="query_field1" id="fromDate" class="form-control" width="20" maxlength="20" size="20"> <label id = "query_label2" for="toDate"></label> <input type="date" name="query_field2" id="toDate" class="form-control" width="20" maxlength="20" size="20"> </div> </form> </td> <td class="name"> <input type="button" id="queryBtn" class="btn btn-primary" value="Submit"> </td> </tr> </tbody>');

}

/*function queryFromAndToDateTimeStructure() {

    $("#query_input").append(' <tbody> <tr> <td class="name"> <form class="form-inline"> <div class="form-group"> <label id = "query_label1" for="fromDate"></label> <input type="datetime" name="query_field1" id="fromDate" class="form-control" width="20" maxlength="20" size="20"> <label id = "query_label2" for="toDate"></label> <input type="datetime" name="query_field2" id="toDate" class="form-control" width="20" maxlength="20" size="20"> </div> </form> </td> <td class="name"> <input type="button" id="queryBtn" class="btn btn-primary" value="Submit"> </td> </tr> </tbody>');

}*/

function queryEmptyDropdownStructure()
{
    $("#query_input").append(' <tbody> <tr> <td class="name"> ' +
        '<form class="form-inline"> <div class="form-group"> ' +
        '<label id = "query_label" for="query_dropdown"></label> ' +
        '<select id="query_dropdown"></select> </div> </form> </td> ' +
        '<td class="name">' +
        '<input type="button" id="queryBtn" class="btn btn-primary" value="Submit">' +
        '</td> </tr> </tbody>');
}

function queryOutputStructure()
{
    $("#query_output").append('' +
        '<div class="col-md-12 mt"> ' +
        '<div class="content-panel"> ' +
        '<p id = "searched" class="bg-info"></p> ' +
        '<table id="results" class="table table-hover"> ' +
        '</table> ' +
        '</div> ' +
        '</div>'
    );

}