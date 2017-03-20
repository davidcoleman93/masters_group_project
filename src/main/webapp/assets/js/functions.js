/**
 * Created by C06590861 on 01/03/2017.
 */


function runFileListener(){
    $.ajax({
        type: 'post',
        url: 'api/file/dir_watcher',
        success: function () {
            console.log("LISTENING");
        }
    });
}


/*var failEventVar = function(id, dateTime, causeCode, eventID, failureClass, tac,
 market, operator, cellID, duration, neVersion, imsi){
 this.id = id;
 this.dateTime = dateTime;
 this.causeCode = causeCode;
 this.eventID = eventID;
 this.failureClass = failureClass;
 this.tac = tac;
 this.market = market;
 this.operator = operator;
 this.cellID = cellID;
 this.duration = duration;
 this.neVersion = neVersion;
 this.imsi = imsi;
 }

 var dataLogVar = function(numImports, numErrors, numQueries, numSuccess){
 this.numImports = numImports;
 this.numErrors = numErrors;
 this.numQueries = numQueries;
 this.numSuccess = numSuccess;
 }*/