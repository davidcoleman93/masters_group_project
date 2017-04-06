var registerUser = function (s, e, a, r) {
    this.username = e, this.email = a, this.password = r, this.roleType = s
};
$(document).ready(function () {
    function s() {
        r.val(""), n.val(""), o.val(""), l.removeAttr("value"), c.html(""), i.val(""), t.removeClass("danger"), t.removeClass("success"), t.addClass("warning"), t.html(""), w = 0, c.removeClass("danger"), c.removeClass("success"), c.html(""), c.addClass("warning"), C = 0, m.removeClass("danger"), m.removeClass("success"), m.html(""), m.addClass("warning"), p = 0, g.removeClass("success"), g.removeClass("danger"), g.addClass("warning"), g.text(""), d.removeClass("danger"), d.removeClass("success"), d.html(""), d.addClass("warning"), v.removeClass("m-progress"), h = 0
    }

    function e(s) {
        $.ajax({
            type: "GET"
            , url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/roletype/".concat(s)
            , success: function (s) {
                console.log(s), S = s, t.removeClass("warning"), t.removeClass("danger"), t.addClass("success"), t.html("&#10003;"), v.html(""), w = 1
            }
            , error: function () {
                console.log("failed"), v.html("Sorry this  <i>role </i> don't exist!")
            }
        })
    }

    function a(s) {
        var e = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
        return e.test(s)
    }
    var r = $("#username")
        , l = $("#user-role")
        , n = $("#email-id")
        , o = $("#password")
        , i = $("#confirm-password")
        , t = $("#rolesign")
        , c = $("#usersign")
        , m = $("#emailsign")
        , g = $("#pwordsign1")
        , d = $("#pwordsign2")
        , u = $(".logininfo")
        , v = $(".register")
        , C = 0
        , p = 0
        , h = 0
        , w = 0
        , f = 0
        , S = "";
    $("#checkbox1").change(function () {
        1 == $("#checkbox1").is(":checked")
    }), $("#user-login").on("change paste keyup", function () {
        $("#user-login").val($("#user-login").val().toLowerCase()), $("#user-login").val($("#user-login").val().replace(/\s+/g, "")), $("#user-login").val().length >= 5 && $.ajax({
            type: "GET"
            , url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/users/".concat($("#user-login").val())
            , success: function (s) {
                console.log(s), 1 == s ? ($("#logininfo").html("Sorry this  <i>Username </i> doesn't exist!"), $("#ulsign").removeClass("success"), $("#ulsign").removeClass("warning"), $("#ulsign").html("&#10005;"), $("#ulsign").addClass("danger"), f = 0) : 0 == s && ($("#ulsign").removeClass("danger"), $("#ulsign").removeClass("warning"), $("#ulsign").addClass("success"), $("#ulsign").html("&#10003;"), u.removeClass("m-progress"), u.html(""), f = 1)
            }
            , error: function () {
                console.log("failed")
            }
        })
    }), $("#password-login").on("change paste keyup", function () {
        0 == $("#password-login").val().length ? ($("#pwlsign").removeClass("warning"), $("#pwlsign").addClass("danger"), $("#pwlsign").removeClass("success"), $("#pwlsign").html("&#10005;")) : ($("#pwlsign").removeClass("warning"), $("#pwlsign").removeClass("danger"), $("#pwlsign").addClass("success"), u.removeClass("m-progress"), u.html(""), $("#pwlsign").html("&#10003;"))
    }), $("#login-submit").click(function () {
        if (0 == f) u.html("Sorry <i>username</i> is invalid");
        else if (0 == $("#password-login").val().trim().length) u.html("Please enter your <i> password </i> ");
        else {
            1 == $("#checkbox1").is(":checked"), u.addClass("m-progress");
            var s = "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/login/";
            s = s.concat($("#user-login").val() + "/"), $.ajax({
                type: "GET"
                , url: s.concat($("#password-login").val())
                , success: function (s) {
                    0 == s ? window.location.replace("http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/home.html") : (u.removeClass("m-progress"), $("#pwlsign").addClass("danger"), $("#pwlsign").removeClass("success"), $("#pwlsign").removeClass("warning"), $("#pwlsign").html("&#10005;"), u.html("Sorry  <i> password </i> is incorrect. "))
                }
                , error: function () {
                    u.removeClass("m-progress"), u.html("Sorry  <i> password </i> is incorrect. ")
                }
            })
        }
    });
    var y = /(?=.{8,}).*/
        , k = /^(?=\S*?[a-z])(?=\S*?[0-9])\S{8,}$/
        , x = /^(?=\S*?[A-Z])(?=\S*?[a-z])((?=\S*?[0-9])|(?=\S*?[^\w\*]))\S{8,}$/
        , b = /^(?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9])(?=\S*?[^\w\*])\S{8,}$/;
    o.on("change paste keyup", function () {
        var s = $(this)
            , e = s.val()
            , a = ($('[for="password"]'), "Weak")
            , r = "danger";
        0 == s.val().length ? (g.removeClass("warning"), g.addClass("danger"), g.removeClass("success"), g.text("")) : (1 == b.test(e) ? (g.removeClass("warning"), g.removeClass("danger"), g.addClass("success"), a = "Very Strong", r = "success") : 1 == x.test(e) ? (g.removeClass("warning"), g.removeClass("danger"), g.addClass("success"), a = "Strong", r = "warning") : 1 == k.test(e) ? (g.removeClass("warning"), g.removeClass("danger"), g.addClass("success"), a = "Almost Strong", r = "warning") : 1 == y.test(e) ? (g.removeClass("danger"), g.removeClass("warning"), g.addClass("danger"), a = "Weak") : (a = "Very Weak", g.removeClass("danger"), g.removeClass("warning"), g.addClass("danger")), g.text(a)), i.val(""), d.html("&#10068;"), d.removeClass("success"), d.removeClass("danger"), d.addClass("warning"), h = 0
    }), i.on("change paste keyup", function () {
        o.val() === i.val() && o.val().length > 0 ? (d.removeClass("warning"), d.removeClass("danger"), d.addClass("success"), v.html(""), d.html("&#10003;"), h = 1) : (d.removeClass("success"), d.removeClass("warning"), d.addClass("danger"), d.html("&#10005;"), h = 0)
    }), $("#admin").click(function () {
        l.attr({
            value: function () {
                return $("#admin").text()
            }
            , disabled: "disabled"
        }), e(0)
    }), $("#customer-service").click(function () {
        l.attr({
            value: function () {
                return $("#customer-service").text()
            }
            , disabled: "disabled"
        }), e(1)
    }), $("#support-engineer").click(function () {
        l.attr({
            value: function () {
                return $("#support-engineer").text()
            }
            , disabled: "disabled"
        }), e(2)
    }), $("#network-engineer").click(function () {
        l.attr({
            value: function () {
                return $("#network-engineer").text()
            }
            , disabled: "disabled"
        }), e(3)
    }), r.on("change paste keyup", function () {
        r.val(r.val().toLowerCase()), r.val(r.val().replace(/\s+/g, "")), r.val().length >= 5 && $.ajax({
            type: "GET"
            , url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/users/".concat(r.val())
            , success: function (s) {
                console.log(s), 0 == s ? (v.html("Sorry this  <i>Username </i> already exist!"), c.removeClass("success"), c.removeClass("warning"), c.addClass("danger"), C = 0, c.html("X")) : 1 == s && (c.removeClass("warning"), c.removeClass("danger"), c.addClass("success"), c.html("&#10003;"), v.html(""), C = 1)
            }
            , error: function () {
                console.log("failed")
            }
        })
    }), n.on("change paste keyup", function () {
        n.val(n.val().toLowerCase()), a(n.val()) || n.val().trim() == "".trim() ? n.val().trim() != "".trim() && 1 == a(n.val()) && (m.removeClass("warning"), m.removeClass("danger"), m.addClass("success"), v.html(""), m.html("&#10003;"), p = 1) : (m.removeClass("success"), m.removeClass("warning"), m.addClass("danger"), m.html(""), p = 0)
    }), $("#register-submit").click(function () {
        if (0 == w) v.removeClass(" m-progress"), v.html("Please Assign user a role!");
        else if (0 == C || r.val().trim() == "".trim()) v.removeClass(" m-progress"), v.html("Sorry  <i>username</i> is invalid!");
        else if (0 == p || n.val().trim() == "".trim()) v.removeClass(" m-progress"), v.html("Sorry <i>E-mail </i> is invalid!");
        else if (0 == h || i.val().trim() == "".trim()) v.removeClass(" m-progress"), v.html("Sorry  <i>Passoword </i> is invalid!");
        else {
            v.html(""), v.addClass("m-progress");
            var e = new registerUser(S, r.val(), n.val(), o.val());
            $.ajax({
                type: "POST"
                , url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/adduser"
                , success: function () {
                    $(".panel-body").slideUp(1e3).delay(1e3).fadeIn(4e3), v.html("User Successfully Registered"), s(), console.log(S)
                }
                , error: function () {
                    v.removeClass("m-progress"), $(".panel-body").fadeToggle().fadeIn(600), v.html("Sorry an  <i>error </i> occured!"), console.log(S)
                }
                , data: JSON.stringify(e)
                , contentType: "application/json"
            })
        }
    })
});
//# sourceMappingURL=form-script.min.js.map
