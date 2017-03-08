/**
 * Created by C06590861 on 01/03/2017.
 */
var allRecords;

function getAllRecords() {
   $.each(allRecords, function (index, value) {
       $("#innerText").append("<li>" + value[11] + ":" + value[2] + ":" + value[3] + ":" + value[10] + "</li>");
   });
}

function runFileListener(){
   $.ajax({
       type: 'post',
       url: 'api/file/dir_watcher',
       success: function () {
           console.log("LISTENING");
       }
   });
   runIndexQueries();
}

function runIndexQueries(){
   $.ajax({
       type: 'GET',
       url: 'api/data/fail_events',
       success: function (aList) {
           allRecords = aList;
       }
   });
}