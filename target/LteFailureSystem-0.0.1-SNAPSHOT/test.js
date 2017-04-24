/**
 * Created by C06590861 on 15/02/2015.
 */

var FailureEvent = function() {
    this.title = title;
    this.year = year;
    this.genre = genre;
}

$(document).ready(function() {

    $("#btn").click(function() {
        $.ajax({
            type: "GET",
            url: "api/movies/filechooser"

        });
        return false;
    });

});

