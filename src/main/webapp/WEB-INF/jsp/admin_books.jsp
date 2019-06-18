<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>全部图书</title>
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
<nav style="position:fixed;z-index: 999;width: 100%;background-color: #fff" class="navbar navbar-default"
     role="navigation">
    <div class="container-fluid">
        <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
            <a class="navbar-brand" href="admin_main.action">图书管理系统</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-left">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        图书管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="allbooks.action">全部图书</a></li>
                        <li class="divider"></li>
                        <li><a href="book_add.action">增加图书</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        图书类型管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="allBookType.action">全部类型</a></li>
                        <li class="divider"></li>
                        <li><a href="bookType_add.action">增加图书类型</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        读者管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="allreaders.action">全部读者</a></li>
                        <li class="divider"></li>
                        <li><a href="reader_add.action">增加读者</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        借还管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="lendlist.action">借还日志</a></li>
                    </ul>
                </li>
                <li>
                    <a href="admin_repasswd.action">
                        密码修改
                    </a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="logout.action"><span class="glyphicon glyphicon-log-in"></span>&nbsp;&nbsp;退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div style="padding: 70px 550px 10px">
    <form method="post" action="querybook.action" class="form-inline" id="searchform">
        <div class="input-group">
            <input type="text" placeholder="输入图书名" class="form-control" id="search" name="searchWord"
                   class="form-control">
            <span class="input-group-btn">
                            <input type="submit" value="搜索" class="btn btn-default">
            </span>
        </div>
    </form>
    <script>
        function mySubmit(flag) {
            return flag;
        }

        $("#searchform").submit(function () {
            var val = $("#search").val();
            if (val == '') {
                alert("请输入关键字");
                return mySubmit(false);
            }
        })
    </script>
</div>
<div style="position: relative;">
    <c:if test="${!empty succ}">
        <div class="alert alert-success alert-dismissable">
            <button type="button" class="close" data-dismiss="alert"
                    aria-hidden="true">
                &times;
            </button>
                ${succ}
        </div>
    </c:if>
    <c:if test="${!empty error}">
        <div class="alert alert-danger alert-dismissable">
            <button type="button" class="close" data-dismiss="alert"
                    aria-hidden="true">
                &times;
            </button>
                ${error}
        </div>
    </c:if>
</div>
<div class="panel panel-default" style="width: 90%;margin-left: 5%">
    <div class="panel-heading" style="background-color: #fff">
        <h3 class="panel-title">
            全部图书
        </h3>
    </div>
    <div class="panel-body">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>书名</th>
                <th>作者</th>
                <th>出版社</th>
                <th>ISBN</th>
                <th>价格</th>
                <th>借还</th>
                <th>详情</th>
                <th>编辑</th>
                <th>删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td><c:out value="${book.name}"></c:out></td>
                    <td><c:out value="${book.author}"></c:out></td>
                    <td><c:out value="${book.publish}"></c:out></td>
                    <td><c:out value="${book.isbn}"></c:out></td>
                    <td><c:out value="${book.price}"></c:out></td>
                    <c:if test="${book.state==1}">
                        <td><a href="lendbook.action?bookId=${book.bookId}">
                            <button type="button" class="btn btn-primary btn-xs">借阅</button>
                        </a></td>
                    </c:if>
                    <c:if test="${book.state==0}">
                        <td><a href="returnbook.action?bookId=${book.bookId}">
                            <button type="button" class="btn btn-primary btn-xs">归还</button>
                        </a></td>
                    </c:if>
                    <td><a href="bookdetail.action?bookId=<c:out value="${book.bookId}"></c:out>">
                        <button type="button" class="btn btn-success btn-xs">详情</button>
                    </a></td>
                    <td><a href="updatebook.action?bookId=<c:out value="${book.bookId}"></c:out>">
                        <button type="button" class="btn btn-info btn-xs">编辑</button>
                    </a></td>
                    <td><a href="deletebook.action?bookId=<c:out value="${book.bookId}"></c:out>">
                        <button type="button" class="btn btn-danger btn-xs">删除</button>
                    </a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="panel-footer">
        <div class="pagination">
            <div class="form-group form-inline">
                总共 ${ page.pages } 页，
                第 ${ page.pageNum } 页，
                共 ${ page.total } 条数据。
                每页 <select class="form-control" onchange="submitPageSize(this)">
                <option value="5" <c:if test="${ page.pageSize == 5 }">selected</c:if> >5</option>
                <option value="10" <c:if test="${ page.pageSize == 10 }">selected</c:if> >10</option>
            </select> 条
            </div>

            <script type="text/javascript">
                // 提交条数
                function submitPageSize(who){
                    // alert(who.value);
                    // 发送请求
                    location.href="${ pageContext.request.contextPath }/allbooks.action?pageSize="+who.value + "&pageNum=" + ${ page.pageNum};
                }
            </script>
        </div>

        <div class="box-tools pull-right">
            <ul class="pagination pagination-right">
                <li><a href="javascript:sumbitPageNum(1)" aria-label="Previous">首页</a></li>
                <li><a href="javascript:sumbitPageNum(${ page.pageNum - 1 })">上一页</a></li>
                <c:forEach begin="1" end="${ page.pages }" var="i">
                    <li><a href="javascript:sumbitPageNum(${ i })">${ i }</a></li>
                </c:forEach>

                <li><a href="javascript:sumbitPageNum(${ page.pageNum + 1 })">下一页</a></li>
                <li><a href="javascript:sumbitPageNum(${ page.pages })" aria-label="Next">尾页</a></li>
            </ul>
        </div>

        <script type="text/javascript">
            /* 发送请求，传的参数当前页 */
            function sumbitPageNum(pageNum){
                if (pageNum > ${page.pages} ){
                    pageNum = ${ page.pages };
                }
                if (pageNum < 1){
                    pageNum = 1;
                }

                location.href="${ pageContext.request.contextPath }/allbooks.action?pageNum="+pageNum + "&pageSize=" + ${page.pageSize};
            }
        </script>

    </div>

</div>


</body>
</html>
