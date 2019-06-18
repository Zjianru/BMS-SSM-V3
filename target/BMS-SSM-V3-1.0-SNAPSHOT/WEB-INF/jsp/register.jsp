<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>读者注册</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.2.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: rgb(240, 242, 245);
        }
    </style>
</head>
<body>
<c:if test="${!empty error}">
    <div class="alert alert-danger alert-dismissable">
        <button type="button" class="close" data-dismiss="alert"
                aria-hidden="true">
            &times;
        </button>
            ${error}
    </div>
</c:if>

<div class="col-xs-6 col-md-offset-3" style="position: relative;top: 10%">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">读者注册</h3>
        </div>
        <div class="panel-body">
            <form action="reader_register_do.action" method="post" id="readeredit">
                <div class="input-group">
                    <span class="input-group-addon">读者证号</span>
                    <input type="text" class="form-control" name="readerId" id="readerId">
                </div>

                <div class="input-group">
                    <span class="input-group-addon">姓名</span>
                    <input type="text" class="form-control" name="name" id="name">
                </div>

                <div class="input-group">
                    <span class="input-group-addon">性别</span>
                    <input type="text" class="form-control" name="sex" id="sex">
                </div>

                <div class="input-group">
                    <span class="input-group-addon">出生日期</span>
                    <input type="text" class="form-control" name="birth" id="birth">
                </div>

                <div class="input-group">
                    <span class="input-group-addon">地址</span>
                    <input type="text" class="form-control" name="address" id="address">
                </div>

                <div class="input-group">
                    <span class="input-group-addon">电话</span>
                    <input type="text" class="form-control" name="telcode" id="telcode">
                </div>

                <div class="input-group">
                    <span class="input-group-addon">密码</span>
                    <input type="password" class="form-control" name="passwd" id="passwd">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">确认密码</span>
                    <input type="password" class="form-control" name="repasswd" id="repasswd">
                </div>
                <input type="submit" value="注册" class="btn btn-success btn-sm" class="text-left">

            </form>
        </div>
    </div>

</div>
<script>
    function mySubmit(flag) {
        return flag;
    }

    $("#readeredit").submit(function () {

        if ($("#readerId").val() == '' || $("#name").val() == '' || $("#passwd").val() == '' || $("#repasswd").val() == '') {
            alert("请填入完整读者信息！");
            return mySubmit(false);
        }

        if ($("#passwd").val() != $("#repasswd").val()) {
            alert("两次输入的密码不同！");
            return mySubmit(false);
        }

        if (isNaN($("#readerId").val())) {
            alert("读者证号必须为数字！");
            return mySubmit(false);
        }
    })
</script>
</body>
</html>
