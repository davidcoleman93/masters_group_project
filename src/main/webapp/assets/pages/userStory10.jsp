<div id="query_info">
    <h1>User Story 10</h1>

    <p>Network Mgt Engineer: Display unique EVENT_ID/CAUSE_CODE combinations for a specific ueType
        and the number of occurrence.</p>
</div>
<br>
<div id="query_input">
    <tbody>
    <tr>
        <td class="name">
            <form class="form-inline">
                <div class="form-group">
                    <label for="uetype_text">UE Type:</label>
                    <input type="text" name="uetype_text" id="uetype_text" class="form-control" placeholder="E.g. 100100" width="20" maxlength="20" size="20">
                </div>
            </form>
        </td>

        <td class="name">
            <input type="button" id="queryBtn" class="btn btn-primary" value="Submit" onclick="userStory10()">
        </td>
    </tr>
    </tbody>
</div>
<br>
<br>
<div id="query_output" class="col-md-12 mt">
        <div class="content-panel">

            <!--
            <p id = "searched" class="bg-info"></p>
            <p id = "resultCount" class="bg-info"></p>
            -->
            <p id = "searched" class="bg-info"></p>
            <table id="results" class="table table-hover"><!-- table-bordered -->

            </table>
        </div><! --/content-panel -->
</div><!-- /col-md-12 -->
<br>