<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.min.css">
    <script src="../../static/js/jquery-3.2.1.js"></script>
    <script src="../../static/js/bootstrap.min.js"></script>
    <style>
        body {
            background-color: rgb(240, 242, 245);
        }
    </style>
    <script type="text/javascript">
        $(function(){
            $.ajax({
                type:"GET",
                url:"http://127.0.0.1:8080/toplist.action",
                success:function(obj){
                        $.each(obj,function(index,book){
                            var bookStr = "<tr><td>" + book.name + "</td><td>" + book.author+ "</td><td>" + book.publish + "</td><td>" + book.count + "</td></tr>";
                            $('table').append(bookStr);
                        });
                }
            });
        });
    </script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation" style="background-color:#fff">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="example-navbar-collapse">
            <ul class="nav navbar-nav navbar-left">
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login.action"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;登录</a></li>
            </ul>
        </div>
    </div>

    <div class="panel panel-default" style="width: 90%;margin-left: 5%">
        <div class="panel-heading" style="background-color: #fff">
            <h3 class="panel-title">
                最受欢迎图书排行
            </h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>书名</th>
                    <th>作者</th>
                    <th>出版社</th>
                    <th>借阅次数</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
</nav>
</body>
</html>
