<<<<<<< HEAD
=======
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

>>>>>>> bk_partition_ui
function encrypt(e) {
    function s(e, s) {
        return e << s | e >>> 32 - s
    }

    function r(e, s) {
        var r, a, n, l, o;
        return n = 2147483648 & e, l = 2147483648 & s, r = 1073741824 & e, a = 1073741824 & s, o = (1073741823 & e) + (1073741823 & s), r & a ? 2147483648 ^ o ^ n ^ l : r | a ? 1073741824 & o ? 3221225472 ^ o ^ n ^ l : 1073741824 ^ o ^ n ^ l : o ^ n ^ l
    }

    function a(e, s, r) {
        return e & s | ~e & r
    }

    function n(e, s, r) {
        return e & r | s & ~r
    }

    function l(e, s, r) {
        return e ^ s ^ r
    }

    function o(e, s, r) {
        return s ^ (e | ~r)
    }

    function t(e, n, l, o, t, i, c) {
        return e = r(e, r(r(a(n, l, o), t), c)), r(s(e, i), n)
    }

    function i(e, a, l, o, t, i, c) {
        return e = r(e, r(r(n(a, l, o), t), c)), r(s(e, i), a)
    }

    function c(e, a, n, o, t, i, c) {
        return e = r(e, r(r(l(a, n, o), t), c)), r(s(e, i), a)
    }

    function u(e, a, n, l, t, i, c) {
        return e = r(e, r(r(o(a, n, l), t), c)), r(s(e, i), a)
    }

    function g(e) {
        for (var s, r = e.length, a = r + 8, n = (a - a % 64) / 64, l = 16 * (n + 1), o = Array(l - 1), t = 0, i = 0; r > i;) s = (i - i % 4) / 4, t = i % 4 * 8, o[s] = o[s] | e.charCodeAt(i) << t, i++;
        return s = (i - i % 4) / 4, t = i % 4 * 8, o[s] = o[s] | 128 << t, o[l - 2] = r << 3, o[l - 1] = r >>> 29, o
    }

    function m(e) {
<<<<<<< HEAD
        var s, r, a = "",
            n = "";
=======
        var s, r, a = ""
            , n = "";
>>>>>>> bk_partition_ui
        for (r = 0; 3 >= r; r++) s = e >>> 8 * r & 255, n = "0" + s.toString(16), a += n.substr(n.length - 2, 2);
        return a
    }

    function d(e) {
        e = e.replace(/\r\n/g, "\n");
        for (var s = "", r = 0; r < e.length; r++) {
            var a = e.charCodeAt(r);
            128 > a ? s += String.fromCharCode(a) : a > 127 && 2048 > a ? (s += String.fromCharCode(a >> 6 | 192), s += String.fromCharCode(63 & a | 128)) : (s += String.fromCharCode(a >> 12 | 224), s += String.fromCharCode(a >> 6 & 63 | 128), s += String.fromCharCode(63 & a | 128))
        }
        return s
    }
<<<<<<< HEAD
    var v, C, h, p, f, $, w, S, y, b = Array(),
        k = 7,
        x = 12,
        A = 17,
        T = 22,
        L = 5,
        P = 9,
        O = 14,
        N = 20,
        j = 4,
        F = 11,
        H = 16,
        U = 23,
        E = 6,
        G = 10,
        z = 15,
        W = 21;
    for (e = d(e), b = g(e), $ = 1732584193, w = 4023233417, S = 2562383102, y = 271733878, v = 0; v < b.length; v += 16) C = $, h = w, p = S, f = y, $ = t($, w, S, y, b[v + 0], k, 3614090360), y = t(y, $, w, S, b[v + 1], x, 3905402710), S = t(S, y, $, w, b[v + 2], A, 606105819), w = t(w, S, y, $, b[v + 3], T, 3250441966), $ = t($, w, S, y, b[v + 4], k, 4118548399), y = t(y, $, w, S, b[v + 5], x, 1200080426), S = t(S, y, $, w, b[v + 6], A, 2821735955), w = t(w, S, y, $, b[v + 7], T, 4249261313), $ = t($, w, S, y, b[v + 8], k, 1770035416), y = t(y, $, w, S, b[v + 9], x, 2336552879), S = t(S, y, $, w, b[v + 10], A, 4294925233), w = t(w, S, y, $, b[v + 11], T, 2304563134), $ = t($, w, S, y, b[v + 12], k, 1804603682), y = t(y, $, w, S, b[v + 13], x, 4254626195), S = t(S, y, $, w, b[v + 14], A, 2792965006), w = t(w, S, y, $, b[v + 15], T, 1236535329), $ = i($, w, S, y, b[v + 1], L, 4129170786), y = i(y, $, w, S, b[v + 6], P, 3225465664), S = i(S, y, $, w, b[v + 11], O, 643717713), w = i(w, S, y, $, b[v + 0], N, 3921069994), $ = i($, w, S, y, b[v + 5], L, 3593408605), y = i(y, $, w, S, b[v + 10], P, 38016083), S = i(S, y, $, w, b[v + 15], O, 3634488961), w = i(w, S, y, $, b[v + 4], N, 3889429448), $ = i($, w, S, y, b[v + 9], L, 568446438), y = i(y, $, w, S, b[v + 14], P, 3275163606), S = i(S, y, $, w, b[v + 3], O, 4107603335), w = i(w, S, y, $, b[v + 8], N, 1163531501), $ = i($, w, S, y, b[v + 13], L, 2850285829), y = i(y, $, w, S, b[v + 2], P, 4243563512), S = i(S, y, $, w, b[v + 7], O, 1735328473), w = i(w, S, y, $, b[v + 12], N, 2368359562), $ = c($, w, S, y, b[v + 5], j, 4294588738), y = c(y, $, w, S, b[v + 8], F, 2272392833), S = c(S, y, $, w, b[v + 11], H, 1839030562), w = c(w, S, y, $, b[v + 14], U, 4259657740), $ = c($, w, S, y, b[v + 1], j, 2763975236), y = c(y, $, w, S, b[v + 4], F, 1272893353), S = c(S, y, $, w, b[v + 7], H, 4139469664), w = c(w, S, y, $, b[v + 10], U, 3200236656), $ = c($, w, S, y, b[v + 13], j, 681279174), y = c(y, $, w, S, b[v + 0], F, 3936430074), S = c(S, y, $, w, b[v + 3], H, 3572445317), w = c(w, S, y, $, b[v + 6], U, 76029189), $ = c($, w, S, y, b[v + 9], j, 3654602809), y = c(y, $, w, S, b[v + 12], F, 3873151461), S = c(S, y, $, w, b[v + 15], H, 530742520), w = c(w, S, y, $, b[v + 2], U, 3299628645), $ = u($, w, S, y, b[v + 0], E, 4096336452), y = u(y, $, w, S, b[v + 7], G, 1126891415), S = u(S, y, $, w, b[v + 14], z, 2878612391), w = u(w, S, y, $, b[v + 5], W, 4237533241), $ = u($, w, S, y, b[v + 12], E, 1700485571), y = u(y, $, w, S, b[v + 3], G, 2399980690), S = u(S, y, $, w, b[v + 10], z, 4293915773), w = u(w, S, y, $, b[v + 1], W, 2240044497), $ = u($, w, S, y, b[v + 8], E, 1873313359), y = u(y, $, w, S, b[v + 15], G, 4264355552), S = u(S, y, $, w, b[v + 6], z, 2734768916), w = u(w, S, y, $, b[v + 13], W, 1309151649), $ = u($, w, S, y, b[v + 4], E, 4149444226), y = u(y, $, w, S, b[v + 11], G, 3174756917), S = u(S, y, $, w, b[v + 2], z, 718787259), w = u(w, S, y, $, b[v + 9], W, 3951481745), $ = r($, C), w = r(w, h), S = r(S, p), y = r(y, f);
    var I = m($) + m(w) + m(S) + m(y);
    return I.toLowerCase()
=======
    var v, C, p, h, $, f, w, S, y, b = Array()
        , k = 7
        , x = 12
        , T = 17
        , A = 22
        , P = 5
        , L = 9
        , O = 14
        , j = 20
        , N = 4
        , H = 11
        , F = 16
        , U = 23
        , E = 6
        , G = 10
        , z = 15
        , W = 21;
    for (e = d(e), b = g(e), f = 1732584193, w = 4023233417, S = 2562383102, y = 271733878, v = 0; v < b.length; v += 16) C = f, p = w, h = S, $ = y, f = t(f, w, S, y, b[v + 0], k, 3614090360), y = t(y, f, w, S, b[v + 1], x, 3905402710), S = t(S, y, f, w, b[v + 2], T, 606105819), w = t(w, S, y, f, b[v + 3], A, 3250441966), f = t(f, w, S, y, b[v + 4], k, 4118548399), y = t(y, f, w, S, b[v + 5], x, 1200080426), S = t(S, y, f, w, b[v + 6], T, 2821735955), w = t(w, S, y, f, b[v + 7], A, 4249261313), f = t(f, w, S, y, b[v + 8], k, 1770035416), y = t(y, f, w, S, b[v + 9], x, 2336552879), S = t(S, y, f, w, b[v + 10], T, 4294925233), w = t(w, S, y, f, b[v + 11], A, 2304563134), f = t(f, w, S, y, b[v + 12], k, 1804603682), y = t(y, f, w, S, b[v + 13], x, 4254626195), S = t(S, y, f, w, b[v + 14], T, 2792965006), w = t(w, S, y, f, b[v + 15], A, 1236535329), f = i(f, w, S, y, b[v + 1], P, 4129170786), y = i(y, f, w, S, b[v + 6], L, 3225465664), S = i(S, y, f, w, b[v + 11], O, 643717713), w = i(w, S, y, f, b[v + 0], j, 3921069994), f = i(f, w, S, y, b[v + 5], P, 3593408605), y = i(y, f, w, S, b[v + 10], L, 38016083), S = i(S, y, f, w, b[v + 15], O, 3634488961), w = i(w, S, y, f, b[v + 4], j, 3889429448), f = i(f, w, S, y, b[v + 9], P, 568446438), y = i(y, f, w, S, b[v + 14], L, 3275163606), S = i(S, y, f, w, b[v + 3], O, 4107603335), w = i(w, S, y, f, b[v + 8], j, 1163531501), f = i(f, w, S, y, b[v + 13], P, 2850285829), y = i(y, f, w, S, b[v + 2], L, 4243563512), S = i(S, y, f, w, b[v + 7], O, 1735328473), w = i(w, S, y, f, b[v + 12], j, 2368359562), f = c(f, w, S, y, b[v + 5], N, 4294588738), y = c(y, f, w, S, b[v + 8], H, 2272392833), S = c(S, y, f, w, b[v + 11], F, 1839030562), w = c(w, S, y, f, b[v + 14], U, 4259657740), f = c(f, w, S, y, b[v + 1], N, 2763975236), y = c(y, f, w, S, b[v + 4], H, 1272893353), S = c(S, y, f, w, b[v + 7], F, 4139469664), w = c(w, S, y, f, b[v + 10], U, 3200236656), f = c(f, w, S, y, b[v + 13], N, 681279174), y = c(y, f, w, S, b[v + 0], H, 3936430074), S = c(S, y, f, w, b[v + 3], F, 3572445317), w = c(w, S, y, f, b[v + 6], U, 76029189), f = c(f, w, S, y, b[v + 9], N, 3654602809), y = c(y, f, w, S, b[v + 12], H, 3873151461), S = c(S, y, f, w, b[v + 15], F, 530742520), w = c(w, S, y, f, b[v + 2], U, 3299628645), f = u(f, w, S, y, b[v + 0], E, 4096336452), y = u(y, f, w, S, b[v + 7], G, 1126891415), S = u(S, y, f, w, b[v + 14], z, 2878612391), w = u(w, S, y, f, b[v + 5], W, 4237533241), f = u(f, w, S, y, b[v + 12], E, 1700485571), y = u(y, f, w, S, b[v + 3], G, 2399980690), S = u(S, y, f, w, b[v + 10], z, 4293915773), w = u(w, S, y, f, b[v + 1], W, 2240044497), f = u(f, w, S, y, b[v + 8], E, 1873313359), y = u(y, f, w, S, b[v + 15], G, 4264355552), S = u(S, y, f, w, b[v + 6], z, 2734768916), w = u(w, S, y, f, b[v + 13], W, 1309151649), f = u(f, w, S, y, b[v + 4], E, 4149444226), y = u(y, f, w, S, b[v + 11], G, 3174756917), S = u(S, y, f, w, b[v + 2], z, 718787259), w = u(w, S, y, f, b[v + 9], W, 3951481745), f = r(f, C), w = r(w, p), S = r(S, h), y = r(y, $);
    var R = m(f) + m(w) + m(S) + m(y);
    return R.toLowerCase()
>>>>>>> bk_partition_ui
}
var registerUser = function (e, s, r, a) {
    this.username = s, this.email = r, this.password = a, this.roleType = e
};
$(document).ready(function () {
    function e() {
<<<<<<< HEAD
        a.val(""), l.val(""), o.val(""), n.removeAttr("value"), c.html(""), t.val(""), i.removeClass("danger"), i.removeClass("success"), i.addClass("warning"), i.html(""), f = 0, c.removeClass("danger"), c.removeClass("success"), c.html(""), c.addClass("warning"), C = 0, u.removeClass("danger"), u.removeClass("success"), u.html(""), u.addClass("warning"), h = 0, g.removeClass("success"), g.removeClass("danger"), g.addClass("warning"), g.text(""), m.removeClass("danger"), m.removeClass("success"), m.html(""), m.addClass("warning"), v.removeClass("m-progress"), p = 0
=======
        a.val(""), l.val(""), o.val(""), n.removeAttr("value"), c.html(""), t.val(""), i.removeClass("danger"), i.removeClass("success"), i.addClass("warning"), i.html(""), f = 0, c.removeClass("danger"), c.removeClass("success"), c.html(""), c.addClass("warning"), C = 0, u.removeClass("danger"), u.removeClass("success"), u.html(""), u.addClass("warning"), p = 0, g.removeClass("success"), g.removeClass("danger"), g.addClass("warning"), g.text(""), m.removeClass("danger"), m.removeClass("success"), m.html(""), m.addClass("warning"), v.removeClass("m-progress"), h = 0
>>>>>>> bk_partition_ui
    }

    function s(e) {
        $.ajax({
<<<<<<< HEAD
            type: "GET",
            url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/roletype/".concat(e),
            success: function (e) {
                console.log(e), S = e, i.removeClass("warning"), i.removeClass("danger"), i.addClass("success"), i.html("&#10003;"), v.html(""), f = 1
            },
            error: function () {
=======
            type: "GET"
            , url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/roletype/".concat(e)
            , success: function (e) {
                console.log(e), S = e, i.removeClass("warning"), i.removeClass("danger"), i.addClass("success"), i.html("&#10003;"), v.html(""), f = 1
            }
            , error: function () {
>>>>>>> bk_partition_ui
                console.log("failed"), v.html("Sorry this  <i>role </i> don't exist!")
            }
        })
    }

    function r(e) {
        var s = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
        return s.test(e)
    }
<<<<<<< HEAD
    var a = $("#username"),
        n = $("#user-role"),
        l = $("#email-id"),
        o = $("#password"),
        t = $("#confirm-password"),
        i = $("#rolesign"),
        c = $("#usersign"),
        u = $("#emailsign"),
        g = $("#pwordsign1"),
        m = $("#pwordsign2"),
        d = $(".logininfo"),
        v = $(".register"),
        C = 0,
        h = 0,
        p = 0,
        f = 0,
        w = 0,
        S = "",
        y = 0;
=======
    var a = $("#username")
        , n = $("#user-role")
        , l = $("#email-id")
        , o = $("#password")
        , t = $("#confirm-password")
        , i = $("#rolesign")
        , c = $("#usersign")
        , u = $("#emailsign")
        , g = $("#pwordsign1")
        , m = $("#pwordsign2")
        , d = $(".logininfo")
        , v = $(".register")
        , C = 0
        , p = 0
        , h = 0
        , f = 0
        , w = 0
        , S = ""
        , y = 0;
>>>>>>> bk_partition_ui
    $("#checkbox1").change(function () {
        1 == $("#checkbox1").is(":checked")
    }), $("#user-login").on("change paste keyup  blur input", function () {
        $("#user-login").val($("#user-login").val().toLowerCase()), $("#user-login").val($("#user-login").val().replace(/\s+/g, "")), $("#user-login").val().length >= 5 && $.ajax({
<<<<<<< HEAD
            type: "GET",
            url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/users/".concat($("#user-login").val()),
            success: function (e) {
                console.log(e), 1 == e ? ($("#logininfo").html("Sorry this  <i>Username </i> doesn't exist!"), $("#ulsign").removeClass("success"), $("#ulsign").removeClass("warning"), $("#ulsign").html("&#10005;"), $("#ulsign").addClass("danger"), w = 0) : 0 == e && ($("#ulsign").removeClass("danger"), $("#ulsign").removeClass("warning"), $("#ulsign").addClass("success"), $("#ulsign").html("&#10003;"), d.removeClass("m-progress"), d.html(""), w = 1)
            },
            error: function () {
=======
            type: "GET"
            , url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/users/".concat($("#user-login").val())
            , success: function (e) {
                console.log(e), 1 == e ? ($("#logininfo").html("Sorry this  <i>Username </i> doesn't exist!"), $("#ulsign").removeClass("success"), $("#ulsign").removeClass("warning"), $("#ulsign").html("&#10005;"), $("#ulsign").addClass("danger"), w = 0) : 0 == e && ($("#ulsign").removeClass("danger"), $("#ulsign").removeClass("warning"), $("#ulsign").addClass("success"), $("#ulsign").html("&#10003;"), d.removeClass("m-progress"), d.html(""), w = 1)
            }
            , error: function () {
>>>>>>> bk_partition_ui
                console.log("failed")
            }
        })
    }), $("#password-login").on("change paste keyup blur input", function () {
        0 == $("#password-login").val().length ? ($("#pwlsign").removeClass("warning"), $("#pwlsign").addClass("danger"), $("#pwlsign").removeClass("success"), $("#pwlsign").html("&#10005;")) : ($("#pwlsign").removeClass("warning"), $("#pwlsign").removeClass("danger"), $("#pwlsign").addClass("success"), d.removeClass("m-progress"), d.html(""), $("#pwlsign").html("&#10003;"))
    }), $("#login-submit").click(function () {
        if (0 == w) d.html("Sorry <i>username</i> is invalid");
        else if (0 == $("#password-login").val().trim().length) d.html("Please enter your <i> password </i> ");
        else {
<<<<<<< HEAD
            1 == $("#checkbox1").is(":checked"), d.addClass("m-progress");
            var e = "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/login/";
            e = e.concat($("#user-login").val() + "/"), $.ajax({
                type: "GET",
                url: e.concat(encrypt($("#password-login").val())),
                success: function (e) {
                    0 == e ? window.location.replace("http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/home.jsp") : (d.removeClass("m-progress"), $("#pwlsign").addClass("danger"), $("#pwlsign").removeClass("success"), $("#pwlsign").removeClass("warning"), $("#pwlsign").html("&#10005;"), d.html("Sorry  <i> password </i> is incorrect. "))
                },
                error: function () {
=======
            d.addClass("m-progress");
            var e = "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/login/";
            e = e.concat($("#user-login").val() + "/"), $.ajax({
                type: "GET"
                , url: e.concat(encrypt($("#password-login").val()))
                , success: function (e) {
                    0 == e ? (console.log("PASS"), getUserRole($("#user-login").val()), 1 == $("#checkbox1").is(":checked")) : (d.removeClass("m-progress"), $("#pwlsign").addClass("danger"), $("#pwlsign").removeClass("success"), $("#pwlsign").removeClass("warning"), $("#pwlsign").html("&#10005;"), d.html("Sorry  <i> password </i> is incorrect. "))
                }
                , error: function () {
>>>>>>> bk_partition_ui
                    d.removeClass("m-progress"), d.html("Sorry  <i> password </i> is incorrect. ")
                }
            })
        }
    });
<<<<<<< HEAD
    var b = /(?=.{8,}).*/,
        k = /^(?=\S*?[a-z])(?=\S*?[0-9])\S{8,}$/,
        x = /^(?=\S*?[A-Z])(?=\S*?[a-z])((?=\S*?[0-9])|(?=\S*?[^\w\*]))\S{8,}$/,
        A = /^(?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9])(?=\S*?[^\w\*])\S{8,}$/;
    o.on("change paste keyup blur input", function () {
        var e = $(this),
            s = e.val(),
            r = ($('[for="password"]'), "Weak"),
            a = "danger";
        0 == e.val().length ? (g.removeClass("warning"), g.addClass("danger"), g.removeClass("success"), g.text("")) : (1 == A.test(s) ? (g.removeClass("warning"), g.removeClass("danger"), g.addClass("success"), r = "Very Strong", a = "success", y = 1) : 1 == x.test(s) ? (g.removeClass("warning"), g.removeClass("danger"), g.addClass("success"), r = "Strong", y = 1, a = "warning") : 1 == k.test(s) ? (g.removeClass("warning"), g.removeClass("success"), g.addClass("danger"), r = "Almost Strong", a = "warning") : 1 == b.test(s) ? (g.removeClass("danger"), g.removeClass("warning"), g.addClass("danger"), r = "Weak") : (r = "Very Weak", g.removeClass("danger"), g.removeClass("warning"), g.addClass("danger")), g.text(r)), t.val(""), m.html("&#10068;"), m.removeClass("success"), m.removeClass("danger"), m.addClass("warning"), p = 0
    }), t.on("change paste keyup blur input", function () {
        o.val() === t.val() && o.val().length > 0 ? (m.removeClass("warning"), m.removeClass("danger"), m.addClass("success"), v.html(""), m.html("&#10003;"), p = 1) : (m.removeClass("success"), m.removeClass("warning"), m.addClass("danger"), m.html("&#10005;"), p = 0)
=======
    var b = /(?=.{8,}).*/
        , k = /^(?=\S*?[a-z])(?=\S*?[0-9])\S{8,}$/
        , x = /^(?=\S*?[A-Z])(?=\S*?[a-z])((?=\S*?[0-9])|(?=\S*?[^\w\*]))\S{8,}$/
        , T = /^(?=\S*?[A-Z])(?=\S*?[a-z])(?=\S*?[0-9])(?=\S*?[^\w\*])\S{8,}$/;
    o.on("change paste keyup blur input", function () {
        var e = $(this)
            , s = e.val()
            , r = ($('[for="password"]'), "Weak")
            , a = "danger";
        0 == e.val().length ? (g.removeClass("warning"), g.addClass("danger"), g.removeClass("success"), g.text("")) : (1 == T.test(s) ? (g.removeClass("warning"), g.removeClass("danger"), g.addClass("success"), r = "Very Strong", a = "success", y = 1) : 1 == x.test(s) ? (g.removeClass("warning"), g.removeClass("danger"), g.addClass("success"), r = "Strong", y = 1, a = "warning") : 1 == k.test(s) ? (g.removeClass("warning"), g.removeClass("success"), g.addClass("danger"), r = "Almost Strong", a = "warning") : 1 == b.test(s) ? (g.removeClass("danger"), g.removeClass("warning"), g.addClass("danger"), r = "Weak") : (r = "Very Weak", g.removeClass("danger"), g.removeClass("warning"), g.addClass("danger")), g.text(r)), t.val(""), m.html("&#10068;"), m.removeClass("success"), m.removeClass("danger"), m.addClass("warning"), h = 0
    }), t.on("change paste keyup blur input", function () {
        o.val() === t.val() && o.val().length > 0 ? (m.removeClass("warning"), m.removeClass("danger"), m.addClass("success"), v.html(""), m.html("&#10003;"), h = 1) : (m.removeClass("success"), m.removeClass("warning"), m.addClass("danger"), m.html("&#10005;"), h = 0)
>>>>>>> bk_partition_ui
    }), $("#admin").click(function () {
        n.attr({
            value: function () {
                return $("#admin").text()
<<<<<<< HEAD
            },
            disabled: "disabled"
=======
            }
            , disabled: "disabled"
>>>>>>> bk_partition_ui
        }), s(0)
    }), $("#customer-service").click(function () {
        n.attr({
            value: function () {
                return $("#customer-service").text()
<<<<<<< HEAD
            },
            disabled: "disabled"
=======
            }
            , disabled: "disabled"
>>>>>>> bk_partition_ui
        }), s(1)
    }), $("#support-engineer").click(function () {
        n.attr({
            value: function () {
                return $("#support-engineer").text()
<<<<<<< HEAD
            },
            disabled: "disabled"
=======
            }
            , disabled: "disabled"
>>>>>>> bk_partition_ui
        }), s(2)
    }), $("#network-engineer").click(function () {
        n.attr({
            value: function () {
                return $("#network-engineer").text()
<<<<<<< HEAD
            },
            disabled: "disabled"
        }), s(3)
    }), a.on("change paste keyup blur input", function () {
        a.val(a.val().toLowerCase()), a.val(a.val().replace(/\s+/g, "")), a.val().length >= 5 && $.ajax({
            type: "GET",
            url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/users/".concat(a.val()),
            success: function (e) {
                console.log(e), 0 == e ? (v.html("Sorry this  <i>Username </i> already exist!"), c.removeClass("success"), c.removeClass("warning"), c.addClass("danger"), C = 0, c.html("X")) : 1 == e && (c.removeClass("warning"), c.removeClass("danger"), c.addClass("success"), c.html("&#10003;"), v.html(""), C = 1)
            },
            error: function () {
=======
            }
            , disabled: "disabled"
        }), s(3)
    }), a.on("change paste keyup blur input", function () {
        a.val(a.val().toLowerCase()), a.val(a.val().replace(/\s+/g, "")), a.val().length >= 5 && $.ajax({
            type: "GET"
            , url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/users/".concat(a.val())
            , success: function (e) {
                console.log(e), 0 == e ? (v.html("Sorry this  <i>Username </i> already exist!"), c.removeClass("success"), c.removeClass("warning"), c.addClass("danger"), C = 0, c.html("X")) : 1 == e && (c.removeClass("warning"), c.removeClass("danger"), c.addClass("success"), c.html("&#10003;"), v.html(""), C = 1)
            }
            , error: function () {
>>>>>>> bk_partition_ui
                console.log("failed")
            }
        })
    }), l.on("change paste keyup blur input", function () {
<<<<<<< HEAD
        r(l.val()) || l.val().trim() == "".trim() ? l.val().trim() != "".trim() && 1 == r(l.val()) && (u.removeClass("warning"), u.removeClass("danger"), u.addClass("success"), v.html(""), u.html("&#10003;"), h = 1, l.val(l.val().toLowerCase())) : (u.removeClass("success"), u.removeClass("warning"), u.addClass("danger"), u.html(""), h = 0)
    }), $("#register-submit").click(function () {
        if (0 == f) v.removeClass(" m-progress"), v.html("Please Assign user a role!");
        else if (0 == C || a.val().trim() == "".trim()) v.removeClass(" m-progress"), v.html("Sorry  <i>username</i> is invalid!");
        else if (0 == h || l.val().trim() == "".trim()) v.removeClass(" m-progress"), v.html("Sorry <i>E-mail </i> is invalid!");
        else if (0 == p || t.val().trim() == "".trim() || 0 == y) v.removeClass(" m-progress"), v.html("Sorry  <i>Passoword </i> is invalid!");
=======
        r(l.val()) || l.val().trim() == "".trim() ? l.val().trim() != "".trim() && 1 == r(l.val()) && (u.removeClass("warning"), u.removeClass("danger"), u.addClass("success"), v.html(""), u.html("&#10003;"), p = 1, l.val(l.val().toLowerCase())) : (u.removeClass("success"), u.removeClass("warning"), u.addClass("danger"), u.html(""), p = 0)
    }), $("#register-submit").click(function () {
        if (0 == f) v.removeClass(" m-progress"), v.html("Please Assign user a role!");
        else if (0 == C || a.val().trim() == "".trim()) v.removeClass(" m-progress"), v.html("Sorry  <i>username</i> is invalid!");
        else if (0 == p || l.val().trim() == "".trim()) v.removeClass(" m-progress"), v.html("Sorry <i>E-mail </i> is invalid!");
        else if (0 == h || t.val().trim() == "".trim() || 0 == y) v.removeClass(" m-progress"), v.html("Sorry  <i>Passoword </i> is invalid!");
>>>>>>> bk_partition_ui
        else {
            v.html(""), v.addClass("m-progress");
            var s = new registerUser(S, a.val(), l.val(), encrypt(o.val()));
            $.ajax({
<<<<<<< HEAD
                type: "POST",
                url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/adduser",
                success: function () {
                    $(".panel-body").slideUp(1e3).delay(1e3).fadeIn(4e3), v.html("User Successfully Registered"), e(), console.log(S)
                },
                error: function () {
                    v.removeClass("m-progress"), $(".panel-body").fadeToggle().fadeIn(600), v.html("Sorry an  <i>error </i> occured!"), console.log(S)
                },
                data: JSON.stringify(s),
                contentType: "application/json"
=======
                type: "POST"
                , url: "http://localhost:8080/LteFailureSystem-0.0.1-SNAPSHOT/api/data/adduser"
                , success: function () {
                    $(".panel-body").slideUp(1e3).delay(1e3).fadeIn(4e3), v.html("User Successfully Registered"), e(), console.log(S)
                }
                , error: function () {
                    v.removeClass("m-progress"), $(".panel-body").fadeToggle().fadeIn(600), v.html("Sorry an  <i>error </i> occured!"), console.log(S)
                }
                , data: JSON.stringify(s)
                , contentType: "application/json"
>>>>>>> bk_partition_ui
            })
        }
    })
});
//# sourceMappingURL=form-script.min.js.map
