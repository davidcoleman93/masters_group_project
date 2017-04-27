/**
 * Created by C06590861 on 01/03/2017.
 */
function runFileListener() {
    $.ajax({
        type: 'post'
        , url: 'api/file/dir_watcher/'
        , success: function () {
            console.log("LISTENING");
        }
    });
}
