function sortTable(n) {
    var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
    table = document.getElementById("results");
    switching = true;
    //Set the sorting direction to ascending:
    dir = "asc";
    /*Make a loop that will continue until
     no switching has been done:*/
    while (switching) {
        //start by saying: no switching is done:
        switching = false;
        rows = table.getElementsByTagName("TR");
        /*Loop through all table rows (except the
         first, which contains table headers):*/
        for (i = 0; i < (rows.length - 1); i++) {
            //start by saying there should be no switching:
            shouldSwitch = false;
            /*Get the two elements you want to compare,
             one from current row and one from the next:*/
            x = rows[i].getElementsByTagName("TD")[n];
            y = rows[i + 1].getElementsByTagName("TD")[n];
            /*check if the two rows should switch place,
             based on the direction, asc or desc:*/
            if (dir == "asc") {
                if (parseInt(x.innerHTML.toLowerCase()) > parseInt(y.innerHTML.toLowerCase())) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch= true;
                    break;
                }
            } else if (dir == "desc") {
                if (parseInt(x.innerHTML.toLowerCase()) < parseInt(y.innerHTML.toLowerCase())) {
                    //if so, mark as a switch and break the loop:
                    shouldSwitch= true;
                    break;
                }
            }
        }
        if (shouldSwitch) {
            /*If a switch has been marked, make the switch
             and mark that a switch has been done:*/
            rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
            switching = true;
            //Each time a switch is done, increase this count by 1:
            switchcount ++;
        } else {
            /*If no switching has been done AND the direction is "asc",
             set the direction to "desc" and run the while loop again.*/
            if (switchcount == 0 && dir == "asc") {
                dir = "desc";
                switching = true;
            }
        }
    }
    updateArrow(n);
}

function updateArrow(n)
{
    var table = document.getElementById("results");
    var row_headings = table.getElementsByTagName("TH");
    //alert("n: " + n);
    //alert("Count: " + row_headings.length);

    var clicked = row_headings[n];
    var currentArrow = document.getElementById("sort_arrow");
    console.log(clicked.innerHTML);

    console.log("Parent: " + currentArrow.parentNode.innerHTML);
    if (currentArrow.parentNode == clicked)
    {
        if(currentArrow.className == "glyphicon glyphicon-chevron-down"){
            currentArrow.className = "glyphicon glyphicon-chevron-up";
        }
        else{
            //else if (currentArrow.className == "glyphicon glyphicon-chevron-up"){
            currentArrow.className = "glyphicon glyphicon-chevron-down";
        }
    }
    else{
        currentArrow.parentNode.removeChild(currentArrow);
        //table.remove(currentArrow);
        //document.remove(currentArrow);

        clicked.innerHTML = clicked.innerHTML + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>'
    }
    console.log(clicked.innerHTML);
    //clicked.innerHTML = clicked.innerHTML + '<span id = "sort_arrow" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>'
    //console.log(clicked.innerHTML);
}