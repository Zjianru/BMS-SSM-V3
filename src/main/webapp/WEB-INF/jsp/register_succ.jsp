<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
<div>
    <p>恭喜你，注册成功！</p>
    <p><span id="num">3</span>秒后，自动跳转到登录页面</p>
    <script>
        var i = 3;

        function djs() {
            if (i == 0) {
                window.location.href = "http://127.0.0.1";
            }
            document.getElementById("num").innerText = i--;
            setTimeout("djs()", 1000);
        }

        djs();
    </script>
</div>

</body>
</html>
