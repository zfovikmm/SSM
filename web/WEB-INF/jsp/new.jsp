<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="/static/js/jquery-3.2.1.js"></script>
    <script src="/static/js/bootstrap.min.js"></script>
    <title>创作新主题 › Lhfly </title>
</head>
<body>
<!-- 引入header文件 -->
<%@ include file="header.jsp"%>

    <div style="width: 70%;margin:1% 2% 1% 5%;float: left;">
    <div class="panel panel-default" id="main" style="">
        <div class="panel-heading" style="background-color: white">
            <a href="/">Lhfly</a> › 咨询问题
        </div>

        <div class="panel-body">
            <form action="${pageContext.request.contextPath}/tocate" method="post" id="replyForm">
                <div class="form-group">
                    <label for="title">问题概要</label>
                    <input type="text" class="form-control" id="title" name="title" placeholder="请输入问题概要，如果概要能够表达完整内容，则正文可以为空" required="required">
                </div>
                <div class="form-group">
                    <label for="content">正文</label>
                    <textarea class="form-control" rows="10" id="content" name="content"></textarea>
                </div>

                <div class="form-group">
                    <label>板块</label><br/>
<%--                    <div class="col-sm-10" style="width: 40%">--%>
<%--                        <select class="form-control" name="type">--%>
<%--                            <option value="民事">民事</option>--%>
<%--                            <option value="刑事">刑事</option>--%>
<%--                        </select>--%>
<%--                    </div>--%>
                    <div class="col-sm-10" style="width: 40%">
                        <select class="form-control" id="tab" name="type">
                            <c:forEach items="${casetypes}" var="casetype">
                                <option value="${casetype.type}">${casetype.type}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div><br/>
                <br/>
                <div style="text-align: center">
                    <input type="submit" class="btn btn-success btn-sm" value="咨询问题">
                </div>
            </form>
        </div>

    </div>
</div>

    <div class="panel panel-default" id="sidebar2" style="width: 20%;margin:1% 2% 1% 0%;float: right">
        <div class="panel-heading" style="background-color: white;text-align: center">
            发帖提示
        </div>
        <ul class="list-group" style="width: 100%">
            <li class="list-group-item">
                <h5>问题概要</h5>
                <p>
                    请在概要中描述内容要点。如果一件事情在概要的长度内就已经可以说清楚，那就没有必要写正文了。
                </p>
            </li>

            <li class="list-group-item">
                <h5>正文</h5>
                <p>
                    请清楚地表达所要说明的内容。
                </p>
            </li>
        </ul>
    </div>


    <div class="panel panel-default" id="sidebar1" style="width: 20%;margin:1% 2% 1% 0%;float: right">
    <div class="panel-heading" style="background-color: white;text-align: center">
        社区指导原则
    </div>
    <ul class="list-group" style="width: 100%">
        <li class="list-group-item">
            <h5>尊重原创</h5>
            <p>
                请不要发布任何盗版下载链接，包括软件、音乐、电影等等。Lhfly是创意工作者的社区，我们尊重原创。
            </p>
        </li>

        <li class="list-group-item">
            <h5>友好互助</h5>
            <p>
                保持对陌生人的友善。用知识去帮助别人。
            </p>
        </li>
    </ul>
</div>


<!-- 引入footer文件 -->
<%@ include file="footer.jsp"%>

<script>
    function submitValidate(flag){
        return flag;
    }
    $("#replyForm").submit(function () {
        if($("#title").val()==''){
            alert("请填写概要！");
            return submitValidate(false);
        }else {
            var ifSubmit=confirm("确定咨询该问题吗?");
            if (ifSubmit == true){

            }else {
                return submitValidate(false);
            }
        }
    })
</script>
</body>
</html>
