function getUserRole(e) {
    $.ajax({
        type: "GET"
        , url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/users/role/" + $("#user-login").val()
        , success: function (s) {
            var r;
            $.each(s, function (e, s) {
                console.log(s.roleType), r = s.roleType.replace(/\s/g, "")
            }), window.location.replace("http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/index.jsp?user=" + e + "&role=" + r), start()
        }
    })
}

function encrypt(e) {
    function s(e, s) {
        return e << s | e >>> 32 - s
    }

    function r(e, s) {
        var r, a, n, o, l;
        return n = 2147483648 & e, o = 2147483648 & s, r = 1073741824 & e, a = 1073741824 & s, l = (1073741823 & e) + (1073741823 & s), r & a ? 2147483648 ^ l ^ n ^ o : r | a ? 1073741824 & l ? 3221225472 ^ l ^ n ^ o : 1073741824 ^ l ^ n ^ o : l ^ n ^ o
    }

    function a(e, s, r) {
        return e & s | ~e & r
    }

    function n(e, s, r) {
        return e & r | s & ~r
    }

    function o(e, s, r) {
        return e ^ s ^ r
    }

    function l(e, s, r) {
        return s ^ (e | ~r)
    }

    function i(e, n, o, l, i, t, g) {
        return e = r(e, r(r(a(n, o, l), i), g)), r(s(e, t), n)
    }

    function t(e, a, o, l, i, t, g) {
        return e = r(e, r(r(n(a, o, l), i), g)), r(s(e, t), a)
    }

    function g(e, a, n, l, i, t, g) {
        return e = r(e, r(r(o(a, n, l), i), g)), r(s(e, t), a)
    }

    function c(e, a, n, o, i, t, g) {
        return e = r(e, r(r(l(a, n, o), i), g)), r(s(e, t), a)
    }

    function u(e) {
        for (var s, r = e.length, a = r + 8, n = (a - a % 64) / 64, o = 16 * (n + 1), l = Array(o - 1), i = 0, t = 0; r > t;) s = (t - t % 4) / 4, i = t % 4 * 8, l[s] = l[s] | e.charCodeAt(t) << i, t++;
        return s = (t - t % 4) / 4, i = t % 4 * 8, l[s] = l[s] | 128 << i, l[o - 2] = r << 3, l[o - 1] = r >>> 29, l
    }

    function d(e) {
        var s, r, a = ""
            , n = "";
        for (r = 0; 3 >= r; r++) s = e >>> 8 * r & 255, n = "0" + s.toString(16), a += n.substr(n.length - 2, 2);
        return a
    }

    function m(e) {
        e = e.replace(/\r\n/g, "\n");
        for (var s = "", r = 0; r < e.length; r++) {
            var a = e.charCodeAt(r);
            128 > a ? s += String.fromCharCode(a) : a > 127 && 2048 > a ? (s += String.fromCharCode(a >> 6 | 192), s += String.fromCharCode(63 & a | 128)) : (s += String.fromCharCode(a >> 12 | 224), s += String.fromCharCode(a >> 6 & 63 | 128), s += String.fromCharCode(63 & a | 128))
        }
        return s
    }
    var p, v, f, S, C, h, $, w, y, b = Array()
        , W = 7
        , T = 12
        , k = 17
        , x = 22
        , P = 5
        , A = 9
        , O = 14
        , N = 20
        , j = 4
        , L = 11
        , I = 16
        , U = 23
        , E = 6
        , R = 10
        , F = 15
        , H = 21;
    for (e = m(e), b = u(e), h = 1732584193, $ = 4023233417, w = 2562383102, y = 271733878, p = 0; p < b.length; p += 16) v = h, f = $, S = w, C = y, h = i(h, $, w, y, b[p + 0], W, 3614090360), y = i(y, h, $, w, b[p + 1], T, 3905402710), w = i(w, y, h, $, b[p + 2], k, 606105819), $ = i($, w, y, h, b[p + 3], x, 3250441966), h = i(h, $, w, y, b[p + 4], W, 4118548399), y = i(y, h, $, w, b[p + 5], T, 1200080426), w = i(w, y, h, $, b[p + 6], k, 2821735955), $ = i($, w, y, h, b[p + 7], x, 4249261313), h = i(h, $, w, y, b[p + 8], W, 1770035416), y = i(y, h, $, w, b[p + 9], T, 2336552879), w = i(w, y, h, $, b[p + 10], k, 4294925233), $ = i($, w, y, h, b[p + 11], x, 2304563134), h = i(h, $, w, y, b[p + 12], W, 1804603682), y = i(y, h, $, w, b[p + 13], T, 4254626195), w = i(w, y, h, $, b[p + 14], k, 2792965006), $ = i($, w, y, h, b[p + 15], x, 1236535329), h = t(h, $, w, y, b[p + 1], P, 4129170786), y = t(y, h, $, w, b[p + 6], A, 3225465664), w = t(w, y, h, $, b[p + 11], O, 643717713), $ = t($, w, y, h, b[p + 0], N, 3921069994), h = t(h, $, w, y, b[p + 5], P, 3593408605), y = t(y, h, $, w, b[p + 10], A, 38016083), w = t(w, y, h, $, b[p + 15], O, 3634488961), $ = t($, w, y, h, b[p + 4], N, 3889429448), h = t(h, $, w, y, b[p + 9], P, 568446438), y = t(y, h, $, w, b[p + 14], A, 3275163606), w = t(w, y, h, $, b[p + 3], O, 4107603335), $ = t($, w, y, h, b[p + 8], N, 1163531501), h = t(h, $, w, y, b[p + 13], P, 2850285829), y = t(y, h, $, w, b[p + 2], A, 4243563512), w = t(w, y, h, $, b[p + 7], O, 1735328473), $ = t($, w, y, h, b[p + 12], N, 2368359562), h = g(h, $, w, y, b[p + 5], j, 4294588738), y = g(y, h, $, w, b[p + 8], L, 2272392833), w = g(w, y, h, $, b[p + 11], I, 1839030562), $ = g($, w, y, h, b[p + 14], U, 4259657740), h = g(h, $, w, y, b[p + 1], j, 2763975236), y = g(y, h, $, w, b[p + 4], L, 1272893353), w = g(w, y, h, $, b[p + 7], I, 4139469664), $ = g($, w, y, h, b[p + 10], U, 3200236656), h = g(h, $, w, y, b[p + 13], j, 681279174), y = g(y, h, $, w, b[p + 0], L, 3936430074), w = g(w, y, h, $, b[p + 3], I, 3572445317), $ = g($, w, y, h, b[p + 6], U, 76029189), h = g(h, $, w, y, b[p + 9], j, 3654602809), y = g(y, h, $, w, b[p + 12], L, 3873151461), w = g(w, y, h, $, b[p + 15], I, 530742520), $ = g($, w, y, h, b[p + 2], U, 3299628645), h = c(h, $, w, y, b[p + 0], E, 4096336452), y = c(y, h, $, w, b[p + 7], R, 1126891415), w = c(w, y, h, $, b[p + 14], F, 2878612391), $ = c($, w, y, h, b[p + 5], H, 4237533241), h = c(h, $, w, y, b[p + 12], E, 1700485571), y = c(y, h, $, w, b[p + 3], R, 2399980690), w = c(w, y, h, $, b[p + 10], F, 4293915773), $ = c($, w, y, h, b[p + 1], H, 2240044497), h = c(h, $, w, y, b[p + 8], E, 1873313359), y = c(y, h, $, w, b[p + 15], R, 4264355552), w = c(w, y, h, $, b[p + 6], F, 2734768916), $ = c($, w, y, h, b[p + 13], H, 1309151649), h = c(h, $, w, y, b[p + 4], E, 4149444226), y = c(y, h, $, w, b[p + 11], R, 3174756917), w = c(w, y, h, $, b[p + 2], F, 718787259), $ = c($, w, y, h, b[p + 9], H, 3951481745), h = r(h, v), $ = r($, f), w = r(w, S), y = r(y, C);
    var G = d(h) + d($) + d(w) + d(y);
    return G.toLowerCase()
}
var userName = $("#username")
    , userRole = $("#user-role")
    , emailid = $("#email-id")
    , password = $("#password")
    , confirmPassword = $("#confirm-password")
    , roleSign = $("#rolesign")
    , userSign = $("#usersign")
    , emailSign = $("#emailsign")
    , pWordSign1 = $("#pwordsign1")
    , pWordSign2 = $("#pwordsign2")
    , info = $(".logininfo")
    , regInfo = $(".register")
    , flagUsername = 0
    , flagEmail = 0
    , flagConfirmPassword = 0
    , flagRole = 0
    , flaguserlogin = 0
    , roleObject = ""
    , pwStrength = 0
    , registerUser = function (e, s, r, a) {
        this.username = s, this.email = r, this.password = a, this.roleType = e
    };
$(document).ready(function () {
    function e() {
        userName.val(""), emailid.val(""), password.val(""), userRole.removeAttr("value"), userSign.html(""), confirmPassword.val(""), roleSign.removeClass("danger"), roleSign.removeClass("success"), roleSign.addClass("warning"), roleSign.html(""), flagRole = 0, userSign.removeClass("danger"), userSign.removeClass("success"), userSign.html(""), userSign.addClass("warning"), flagUsername = 0, emailSign.removeClass("danger"), emailSign.removeClass("success"), emailSign.html(""), emailSign.addClass("warning"), flagEmail = 0, pWordSign1.removeClass("success"), pWordSign1.removeClass("danger"), pWordSign1.addClass("warning"), pWordSign1.text(""), pWordSign2.removeClass("danger"), pWordSign2.removeClass("success"), pWordSign2.html(""), pWordSign2.addClass("warning"), regInfo.removeClass("m-progress"), flagConfirmPassword = 0
    }

    function s(e) {
        $.ajax({
            type: "GET"
            , url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/roletype/".concat(e)
            , success: function (e) {
                console.log(e), roleObject = e, roleSign.removeClass("warning"), roleSign.removeClass("danger"), roleSign.addClass("success"), roleSign.html("&#10003;"), regInfo.html(""), flagRole = 1
            }
            , error: function () {
                console.log("failed"), regInfo.html("Sorry this  <i>role </i> don't exist!")
            }
        })
    }

    function r() {
        s(0);
        var e = {
                role_id: 0
                , roleType: "administrator"
            }
            , r = new registerUser(e, "admin", "admin@admin.com", "4c79273eed3d095e55d1224f6524ae92");
        $.ajax({
            type: "POST"
            , url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/adduser"
            , success: function () {
                console.log(r)
            }
            , error: function () {
                console.log(e)
            }
            , data: JSON.stringify(r)
            , contentType: "application/json"
        })
    }

    function a(e) {
        var s = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
        return s.test(e)
    }
    $("#checkbox1").change(function () {
        1 == $("#checkbox1").is(":checked")
    }), $("#user-login").on("change paste keyup  blur input", function () {
        $("#user-login").val($("#user-login").val().toLowerCase()), $("#user-login").val($("#user-login").val().replace(/\s+/g, "")), $("#user-login").val().length >= 5 && $.ajax({
            type: "GET"
            , url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/users/".concat($("#user-login").val())
            , success: function (e) {
                console.log(e), 1 == e ? ($("#logininfo").html("Sorry this  <i>Username </i> doesn't exist!"), $("#ulsign").removeClass("success"), $("#ulsign").removeClass("warning"), $("#ulsign").html("&#10005;"), $("#ulsign").addClass("danger"), flaguserlogin = 0) : 0 == e && ($("#ulsign").removeClass("danger"), $("#ulsign").removeClass("warning"), $("#ulsign").addClass("success"), $("#ulsign").html("&#10003;"), info.removeClass("m-progress"), info.html(""), flaguserlogin = 1)
            }
            , error: function () {
                console.log("failed")
            }
        })
    }), $("#password-login").on("change paste keyup blur input", function () {
        0 == $("#password-login").val().length ? ($("#pwlsign").removeClass("warning"), $("#pwlsign").addClass("danger"), $("#pwlsign").removeClass("success"), $("#pwlsign").html("&#10005;")) : ($("#pwlsign").removeClass("warning"), $("#pwlsign").removeClass("danger"), $("#pwlsign").addClass("success"), info.removeClass("m-progress"), info.html(""), $("#pwlsign").html("&#10003;"))
    }), $("#login-submit").click(function () {
        if (0 == flaguserlogin) info.html("Sorry <i>username</i> is invalid");
        else if (0 == $("#password-login").val().trim().length) info.html("Please enter your <i> password </i> ");
        else {
            info.addClass("m-progress");
            var e = "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/login/";
            e = e.concat($("#user-login").val() + "/"), $.ajax({
                type: "GET"
                , url: e.concat(encrypt($("#password-login").val()))
                , success: function (e) {
                    0 == e ? (console.log("PASS"), getUserRole($("#user-login").val()), 1 == $("#checkbox1").is(":checked")) : (info.removeClass("m-progress"), $("#pwlsign").addClass("danger"), $("#pwlsign").removeClass("success"), $("#pwlsign").removeClass("warning"), $("#pwlsign").html("&#10005;"), info.html("Sorry  <i> password </i> is incorrect. "))
                }
                , error: function () {
                    info.removeClass("m-progress"), info.html("Sorry  <i> password </i> is incorrect. ")
                }
            })
        }
    });
    var n = /(?=.{8,}).*/
        , o = /^(?=\S*?[a-z])(?=\S*?[0-9])\S{8,}$/
        , l = /^(?=\S*?[A-Z])(?=\S*?[a-z])((?=\S*?[0-9])|(?=\S*?[^\w\*]))\S{8,}$/
        , i = /^(?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9])(?=\S*?[^\w\*])\S{8,}$/;
    password.on("change paste keyup blur input", function () {
        var e = $(this)
            , s = e.val()
            , r = ($('[for="password"]'), "Weak")
            , a = "danger";
        0 == e.val().length ? (pWordSign1.removeClass("warning"), pWordSign1.addClass("danger"), pWordSign1.removeClass("success"), pWordSign1.text("")) : (1 == i.test(s) ? (pWordSign1.removeClass("warning"), pWordSign1.removeClass("danger"), pWordSign1.addClass("success"), r = "Very Strong", a = "success", pwStrength = 1) : 1 == l.test(s) ? (pWordSign1.removeClass("warning"), pWordSign1.removeClass("danger"), pWordSign1.addClass("success"), r = "Strong", pwStrength = 1, a = "warning") : 1 == o.test(s) ? (pWordSign1.removeClass("warning"), pWordSign1.removeClass("success"), pWordSign1.addClass("danger"), r = "Almost Strong", a = "warning") : 1 == n.test(s) ? (pWordSign1.removeClass("danger"), pWordSign1.removeClass("warning"), pWordSign1.addClass("danger"), r = "Weak") : (r = "Very Weak", pWordSign1.removeClass("danger"), pWordSign1.removeClass("warning"), pWordSign1.addClass("danger")), pWordSign1.text(r)), confirmPassword.val(""), pWordSign2.html("&#10068;"), pWordSign2.removeClass("success"), pWordSign2.removeClass("danger"), pWordSign2.addClass("warning"), flagConfirmPassword = 0
    }), confirmPassword.on("change paste keyup blur input", function () {
        password.val() === confirmPassword.val() && password.val().length > 0 ? (pWordSign2.removeClass("warning"), pWordSign2.removeClass("danger"), pWordSign2.addClass("success"), regInfo.html(""), pWordSign2.html("&#10003;"), flagConfirmPassword = 1) : (pWordSign2.removeClass("success"), pWordSign2.removeClass("warning"), pWordSign2.addClass("danger"), pWordSign2.html("&#10005;"), flagConfirmPassword = 0)
    }), $("#admin").click(function () {
        userRole.attr({
            value: function () {
                return $("#admin").text()
            }
            , disabled: "disabled"
        }), s(0)
    }), $("#customer-service").click(function () {
        userRole.attr({
            value: function () {
                return $("#customer-service").text()
            }
            , disabled: "disabled"
        }), s(1)
    }), $("#support-engineer").click(function () {
        userRole.attr({
            value: function () {
                return $("#support-engineer").text()
            }
            , disabled: "disabled"
        }), s(2)
    }), $("#network-engineer").click(function () {
        userRole.attr({
            value: function () {
                return $("#network-engineer").text()
            }
            , disabled: "disabled"
        }), s(3)
    }), userName.on("change paste keyup blur input", function () {
        userName.val(userName.val().toLowerCase()), userName.val(userName.val().replace(/\s+/g, "")), userName.val().length >= 5 && $.ajax({
            type: "GET"
            , url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/users/".concat(userName.val())
            , success: function (e) {
                console.log(e), 0 == e ? (regInfo.html("Sorry this  <i>Username </i> already exist!"), userSign.removeClass("success"), userSign.removeClass("warning"), userSign.addClass("danger"), flagUsername = 0, userSign.html("X")) : 1 == e && (userSign.removeClass("warning"), userSign.removeClass("danger"), userSign.addClass("success"), userSign.html("&#10003;"), regInfo.html(""), flagUsername = 1)
            }
            , error: function () {
                console.log("failed")
            }
        })
    }), emailid.on("change paste keyup blur input", function () {
        a(emailid.val()) || emailid.val().trim() == "".trim() ? emailid.val().trim() != "".trim() && 1 == a(emailid.val()) && (emailSign.removeClass("warning"), emailSign.removeClass("danger"), emailSign.addClass("success"), regInfo.html(""), emailSign.html("&#10003;"), flagEmail = 1, emailid.val(emailid.val().toLowerCase())) : (emailSign.removeClass("success"), emailSign.removeClass("warning"), emailSign.addClass("danger"), emailSign.html(""), flagEmail = 0)
    }), $("#register-submit").click(function () {
        if (0 == flagRole) regInfo.removeClass(" m-progress"), regInfo.html("Please Assign user a role!");
        else if (0 == flagUsername || userName.val().trim() == "".trim()) regInfo.removeClass(" m-progress"), regInfo.html("Sorry  <i>username</i> is invalid!");
        else if (0 == flagEmail || emailid.val().trim() == "".trim()) regInfo.removeClass(" m-progress"), regInfo.html("Sorry <i>E-mail </i> is invalid!");
        else if (0 == flagConfirmPassword || confirmPassword.val().trim() == "".trim() || 0 == pwStrength) regInfo.removeClass(" m-progress"), regInfo.html("Sorry  <i>Passoword </i> is invalid!");
        else {
            regInfo.html(""), regInfo.addClass("m-progress");
            var s = new registerUser(roleObject, userName.val(), emailid.val(), encrypt(password.val()));
            $.ajax({
                type: "POST"
                , url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/adduser"
                , success: function () {
                    $(".panel-body").slideUp(1e3).delay(1e3).fadeIn(4e3), regInfo.html("User Successfully Registered"), e(), console.log(roleObject)
                }
                , error: function () {
                    regInfo.removeClass("m-progress"), $(".panel-body").fadeToggle().fadeIn(600), regInfo.html("Sorry an  <i>error </i> occured!"), console.log(roleObject)
                }
                , data: JSON.stringify(s)
                , contentType: "application/json"
            })
        }
    }), $.ajax({
        type: "GET"
        , url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/users/admin"
        , success: function (e) {
            console.log(e), 1 == e && (console.log("WORKS"), r())
        }
        , error: function () {
            console.log("failed")
        }
    })
});
//# sourceMappingURL=form-script.min.js.map
