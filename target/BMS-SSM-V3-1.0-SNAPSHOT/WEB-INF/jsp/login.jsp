<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书管理系统 | 登录</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.2.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <script src="../../static/js/js.cookie.js"></script>
    <style>
        #login {
            margin: 100px auto;
            width: 23%;
            z-index: 999;
        }

        * {
            padding: 0;
            margin: 0;
        }
    </style>

</head>
<body>
<c:if test="${!empty error}">
    <script>
        alert("${error}");
        window.location.href = "login.action";
    </script>
</c:if>
<h2 style="text-align: center;font-family: 'Adobe 楷体 Std R';color: palevioletred">欢迎使用图书管理系统</h2>
<div id="github_iframe">
    <div class="panel panel-default" id="login">
        <div class="panel-heading" style="background-color: #fff">
            <h3 class="panel-title">请登录</h3>
        </div>
        <div class="panel-body">
            <div class="form-group">
                <label for="id">账号</label>
                <input type="text" class="form-control" id="id" placeholder="请输入账号">
            </div>
            <div class="form-group">
                <label for="passwd">密码</label>
                <input type="password" class="form-control" id="passwd" placeholder="请输入密码">
            </div>
            <div class="checkbox text-left">
                <label>
                    <input type="checkbox" id="remember">记住密码
                </label>
                <a style="float: right" href="register.action">读者注册</a>
            </div>

            <p style="text-align: right;color: red;position: absolute" id="info"></p><br/>
            <button id="loginButton" class="btn btn-primary  btn-block">登录
            </button>
        </div>
    </div>
</div>
<script>
    $("#id").keyup(
        function () {
            if (isNaN($("#id").val())) {
                $("#info").text("提示:账号只能为数字");
            }
            else {
                $("#info").text("");
            }
        }
    )

    // 记住登录信息
    function rememberLogin(username, password, checked) {
        Cookies.set('loginStatus', {
            username: username,
            password: password,
            remember: checked
        }, {expires: 30, path: ''})
    }

    // 若选择记住登录信息，则进入页面时设置登录信息
    function setLoginStatus() {
        var loginStatusText = Cookies.get('loginStatus')
        if (loginStatusText) {
            var loginStatus
            try {
                loginStatus = JSON.parse(loginStatusText);
                $('#id').val(loginStatus.username);
                $('#passwd').val(loginStatus.password);
                $("#remember").prop('checked', true);
            } catch (__) {
            }
        }
    }

    // 设置登录信息
    setLoginStatus();
    $("#loginButton").click(function () {
        var id = $("#id").val();
        var passwd = $("#passwd").val();
        var remember = $("#remember").prop('checked');

        if (id == '' && passwd == '') {
            $("#info").text("提示:账号和密码不能为空");
        }
        else if (id == '') {
            $("#info").text("提示:账号不能为空");
        }
        else if (passwd == '') {
            $("#info").text("提示:密码不能为空");
        }
        else if (isNaN(id)) {
            $("#info").text("提示:账号必须为数字");
        }
        else {
            $.ajax({
                type: "POST",
                url: "loginCheck.action",
                data: {
                    id: id,
                    passwd: passwd
                },
                dataType: "json",
                success: function (data) {
                    if (data.stateCode.trim() == "0") {
                        $("#info").text("提示:账号或密码错误！");
                    } else if (data.stateCode.trim() == "1") {
                        $("#info").text("提示:登陆成功，跳转中...");
                        window.location.href = "/admin_main.action";
                    } else if (data.stateCode.trim() == "2") {
                        if (remember) {
                            rememberLogin(id, passwd, remember);
                        } else {
                            Cookies.remove('loginStatus');
                        }
                        $("#info").text("提示:登陆成功，跳转中...");
                        window.location.href = "/reader_main.action";
                    }
                }
            });
        }
    })
</script>
</body>
</html>
