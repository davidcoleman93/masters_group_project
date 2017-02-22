
var CompactDisc = function(title, artist, tracks, price) {
    this.title = title;
    this.artist = artist;
    this.price = price;
    this.tracks = tracks;

}



$(document).ready(function() {

    $("#addCDButton").click(function() {
        var cd = new CompactDisc("Dance of Death", "Iron Maiden", 12, 14.99);

        $.ajax({
            type: "POST",
            url: "rest/discs",
            success: function () {
                alert("CD added");
            },
            data: JSON.stringify(cd),
            contentType: "application/json"

        });
    });

    $.ajax({
        type: "GET",
        url: "rest/discs",

        success: function (cdList) {
            $.each(cdList, function (index, value) {
                $("#cdHolder").append("<li>" + value.title + " " + value.artist + " " + value.price +"</li>");

            });
        }
    });
});


