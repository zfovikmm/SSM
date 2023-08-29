<%--
  Created by IntelliJ IDEA.
  User: 19080
  Date: 2023/8/28
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册用户</title>
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>用户注册</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/signUp" method="post">
        名字：<input type="text" name="dename" required><br><br><br>
        密码：<input type="text" name="depassword" required><br><br><br>
        邮箱：<input type="text" name="email" required><br><br><br>
        电话：<input type="text" name="phone" required><br><br><br>
        地址：<input type="text" name="address" required><br><br><br>
        <p>性别:
            <input id="man" type="radio" checked="checked" value="男" name="sex"/>男
            <input type="radio" id="woman" value="女" name="sex">女
        </p>

        <input type="submit" value="注册">
    </form>
</div>
</body>
</html>
