var registerUser = function (roleType, username, email, password) {
    this.username = username, this.email = email, this.password = password;
    this.roleType = roleType;
}
$(document).ready(function () {
    var userName = $("#username"),
        userRole = $("#user-role"),
        emailid = $("#email-id"),
        password = $('#password'),
        confirmPassword = $('#confirm-password'),
        roleSign = $("#rolesign"),
        userSign = $("#usersign"),
        emailSign = $("#emailsign"),
        pWordSign1 = $("#pwordsign1"),
        pWordSign2 = $("#pwordsign2"),
        info = $(".logininfo"),
        regInfo = $(".register"),
        flagUsername = 0,
        flagEmail = 0,
        flagConfirmPassword = 0,
        flagRole = 0,
        flaguserlogin = 0,
        roleObject = "";
    /* Reset all fields in the reg form */
    function resetRegForm() {
        userName.val(""), emailid.val(""), password.val(""), userRole.removeAttr("value"), userSign.html(""), confirmPassword.val(""), roleSign.removeClass("danger"), roleSign.removeClass("success"), roleSign.addClass("warning"), roleSign.html(""), flagRole = 0, userSign.removeClass("danger"), userSign.removeClass("success"), userSign.html(""), userSign.addClass("warning"), flagUsername = 0, emailSign.removeClass("danger"), emailSign.removeClass("success"), emailSign.html(""), emailSign.addClass("warning"), flagEmail = 0, pWordSign1.removeClass("success"), pWordSign1.removeClass("danger"), pWordSign1.addClass("warning"), pWordSign1.text(""), pWordSign2.removeClass("danger"), pWordSign2.removeClass("success"), pWordSign2.html(""), pWordSign2.addClass("warning"), regInfo.removeClass("m-progress"), flagConfirmPassword = 0;
    }
    /*cookies Start*/
    function setCookies() {}

    function getCookies() {}
    /*Cookies end*/
    /* Logins */
    $("#checkbox1").change(function () {
        if ($("#checkbox1").is(":checked") == true) {} else {}
    });
    $("#user-login").on("change paste keyup  blur input", function () {
        $("#user-login").val($("#user-login").val().toLowerCase()), $("#user-login").val($("#user-login").val().replace(/\s+/g, ''))
        if ($("#user-login").val().length >= 5) {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/users/".concat($("#user-login").val()),
                success: function (data) {
                    console.log(data);
                    if (data == true) {
                        $("#logininfo").html("Sorry this  <i>Username </i> doesn't exist!");
                        $("#ulsign").removeClass("success"), $("#ulsign").removeClass("warning"), $("#ulsign").html("&#10005;"), // tick removed to x
                            $("#ulsign").addClass("danger"), flaguserlogin = 0 // turn off flag
                    } else if (data == false) {
                        $("#ulsign").removeClass("danger"), $("#ulsign").removeClass("warning"), $("#ulsign").addClass("success"), $("#ulsign").html("&#10003;"), // tick
                            info.removeClass("m-progress"), info.html(""), flaguserlogin = 1 // turn on flag
                    }
                },
                error: function (data) {
                    console.log("failed");
                },
            })
        }
    });
    $("#password-login").on("change paste keyup blur input", function () {
        if ($("#password-login").val().length == 0) {
            $("#pwlsign").removeClass("warning"), $("#pwlsign").addClass("danger"), $("#pwlsign").removeClass("success"), $("#pwlsign").html("&#10005;") // tick removed to x
        } else {
            $("#pwlsign").removeClass("warning"), $("#pwlsign").removeClass("danger"), $("#pwlsign").addClass("success"), info.removeClass("m-progress"), info.html(""), // remove error msg
                $("#pwlsign").html("&#10003;") // tick
        }
    });
    /*Login submit Button Start*/
    $("#login-submit").click(function () {
        if (flaguserlogin == 0) {
            info.html("Sorry <i>username</i> is invalid");
        } else if (($("#password-login").val().trim()).length == 0) {
            info.html("Please enter your <i> password </i> ");
        } else {
            if ($("#checkbox1").is(":checked") == true) {
                //set cookies here
            }
            info.addClass("m-progress");
            var url = "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/login/";
            url = url.concat($("#user-login").val() + "/");
            $.ajax({
                type: "GET",
                url: url.concat($("#password-login").val()),
                success: function (data) {
                    if (data == false) {
                        window.location.replace("http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/home.html");
                    } else {
                        info.removeClass("m-progress"), $("#pwlsign").addClass("danger"), $("#pwlsign").removeClass("success"), $("#pwlsign").removeClass("warning"), $("#pwlsign").html("&#10005;")
                        info.html("Sorry  <i> password </i> is incorrect. ");
                    }
                },
                error: function () {
                    info.removeClass("m-progress"), info.html("Sorry  <i> password </i> is incorrect. ");
                }
            })
        }
    });
    /*Login submit Button Ends*/
    /** Registrations* */
    // minimum 8 characters
    var bad = /(?=.{8,}).*/;
    // Alpha Numeric plus minimum 8
    var good = /^(?=\S*?[a-z])(?=\S*?[0-9])\S{8,}$/;
    // Must contain at least one upper case letter, one lower case letter and
    // (one number OR one special char).
    var better = /^(?=\S*?[A-Z])(?=\S*?[a-z])((?=\S*?[0-9])|(?=\S*?[^\w\*]))\S{8,}$/;
    // Must contain at least one upper case letter, one lower case letter and
    // (one number AND one special char).
    var best = /^(?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9])(?=\S*?[^\w\*])\S{8,}$/;
    password.on("change paste keyup blur input", function () {
        var password = $(this);
        var pass = password.val();
        var passLabel = $('[for="password"]');
        var strength = 'Weak';
        var pclass = 'danger';
        if (password.val().length == 0) {
            pWordSign1.removeClass("warning");
            pWordSign1.addClass("danger");
            pWordSign1.removeClass("success");
            pWordSign1.text("");
        } else {
            if (best.test(pass) == true) {
                pWordSign1.removeClass("warning");
                pWordSign1.removeClass("danger");
                pWordSign1.addClass("success");
                strength = 'Very Strong';
                pclass = 'success';
            } else if (better.test(pass) == true) {
                pWordSign1.removeClass("warning");
                pWordSign1.removeClass("danger");
                pWordSign1.addClass("success");
                strength = 'Strong';
                pclass = 'warning';
            } else if (good.test(pass) == true) {
                pWordSign1.removeClass("warning");
                pWordSign1.removeClass("danger");
                pWordSign1.addClass("success");
                strength = 'Almost Strong';
                pclass = 'warning';
            } else if (bad.test(pass) == true) {
                pWordSign1.removeClass("danger");
                pWordSign1.removeClass("warning");
                pWordSign1.addClass("danger");
                strength = 'Weak';
            } else {
                strength = 'Very Weak';
                pWordSign1.removeClass("danger");
                pWordSign1.removeClass("warning");
                pWordSign1.addClass("danger");
            }
            pWordSign1.text(strength);
        }
        /* Handle Confirm button if nothing was typed at first */
        confirmPassword.val(""); // reset confirm password
        pWordSign2.html("&#10068;"); // xx
        pWordSign2.removeClass("success");
        pWordSign2.removeClass("danger");
        pWordSign2.addClass("warning");
        flagConfirmPassword = 0; // set flag to zero
    });
    /* check both patterns */
    confirmPassword.on("change paste keyup blur input", function () {
        if ((password.val() === confirmPassword.val()) && (password.val().length > 0)) {
            pWordSign2.removeClass("warning");
            pWordSign2.removeClass("danger");
            pWordSign2.addClass("success");
            regInfo.html(""); // reset warning info
            pWordSign2.html("&#10003;"); // tick
            flagConfirmPassword = 1; // flag on
        } else {
            pWordSign2.removeClass("success");
            pWordSign2.removeClass("warning");
            pWordSign2.addClass("danger");
            pWordSign2.html("&#10005;"); // ??
            flagConfirmPassword = 0; // flag off
        }
    });

    function getRoleType(id) {
        var object;
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/roletype/".concat(id),
            success: function (data) {
                console.log(data);
                roleObject = data; // save object
                roleSign.removeClass("warning");
                roleSign.removeClass("danger");
                roleSign.addClass("success");
                roleSign.html("&#10003;"); // tick
                regInfo.html(""); // CLEAR WARNING
                flagRole = 1; // turn on flag
            },
            error: function (data) {
                console.log("failed");
                regInfo.html("Sorry this  <i>role </i> don't exist!");
            },
        })
    }
    // Adminstrator button
    $("#admin").click(function () {
        userRole.attr({
            value: function () {
                return $("#admin").text();
            },
            disabled: "disabled"
        });
        getRoleType(0);
    });
    // Customer service button
    $("#customer-service").click(function () {
        userRole.attr({
            value: function () {
                return $("#customer-service").text();
            },
            disabled: "disabled"
        });
        getRoleType(1);
    });
    // Support Engineer button
    $("#support-engineer").click(function () {
        userRole.attr({
            value: function () {
                return $("#support-engineer").text();
            },
            disabled: "disabled"
        });
        getRoleType(2);
    });
    // Network Engineer button
    $("#network-engineer").click(function () {
        userRole.attr({
            value: function () {
                return $("#network-engineer").text();
            },
            disabled: "disabled"
        });
        getRoleType(3);
    });
    /* User name validation */
    userName.on("change paste keyup blur input", function () {
        userName.val(userName.val().toLowerCase()), userName.val(userName.val().replace(/\s+/g, ''))
        if (userName.val().length >= 5) {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/users/".concat(userName.val()),
                success: function (data) {
                    console.log(data);
                    if (data == false) {
                        regInfo.html("Sorry this  <i>Username </i> already exist!");
                        userSign.removeClass("success");
                        userSign.removeClass("warning");
                        userSign.addClass("danger");
                        flagUsername = 0; // turn off flag
                        userSign.html("X"); // reset tick
                    } else if (data == true) {
                        userSign.removeClass("warning");
                        userSign.removeClass("danger");
                        userSign.addClass("success");
                        userSign.html("&#10003;"); // tick
                        regInfo.html(""); // reset warning info
                        flagUsername = 1; // turn on flag
                    }
                },
                error: function (data) {
                    console.log("failed");
                },
            })
        }
    });
    emailid.on("change paste keyup blur input", function () {

        if ((!validateEmail(emailid.val()) && emailid.val().trim() != "".trim())) {
            emailSign.removeClass("success");
            emailSign.removeClass("warning");
            emailSign.addClass("danger");
            emailSign.html(""); // reset tick
            flagEmail = 0; // turn off flag
        } else if ((emailid.val().trim() != "".trim()) && validateEmail(emailid.val()) == true) {
            emailSign.removeClass("warning");
            emailSign.removeClass("danger");
            emailSign.addClass("success");
            regInfo.html(""); // reset warning info
            emailSign.html("&#10003;"); // tick
            flagEmail = 1; // turn on flag
            emailid.val(emailid.val().toLowerCase()); // convert to lower case
        }
    });
    /* Email validator */
    function validateEmail($email) {
        var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
        return emailReg.test($email);
    }
    $("#register-submit").click(function () {
        if (flagRole == 0) {
            regInfo.removeClass(" m-progress");
            regInfo.html("Please Assign user a role!");
        } else if ((flagUsername == 0) || (userName.val().trim() == "".trim())) {
            regInfo.removeClass(" m-progress");
            regInfo.html("Sorry  <i>username</i> is invalid!");
        } else if ((flagEmail == 0) || (emailid.val().trim() == "".trim())) {
            regInfo.removeClass(" m-progress");
            regInfo.html("Sorry <i>E-mail </i> is invalid!");
        } else if ((flagConfirmPassword == 0) || (confirmPassword.val().trim() == "".trim())) {
            regInfo.removeClass(" m-progress");
            regInfo.html("Sorry  <i>Passoword </i> is invalid!");
        } else {
            regInfo.html(""); // REMOVE
            regInfo.addClass("m-progress"); // remove this when it's done
            var newUser = new registerUser(roleObject, userName.val(), emailid.val(), password.val());
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/adduser",
                success: function () {
                    $(".panel-body").slideUp(1000).delay(1000).fadeIn(4000);
                    regInfo.html("User Successfully Registered"); //success message
                    resetRegForm(); // reset form
                    console.log(roleObject);
                },
                error: function () {
                    regInfo.removeClass("m-progress"), // remove loader
                        $(".panel-body").fadeToggle().fadeIn(600), regInfo.html("Sorry an  <i>error </i> occured!");
                    console.log(roleObject);
                },
                data: JSON.stringify(newUser),
                contentType: "application/json"
            })
        }
    });
});
