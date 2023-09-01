<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta name="Content-Type"  content="text/html;charset=utf-8">
  <meta name="keywords" content="社区，法律，免费">
  <title>zm法律社区</title>
  <link href="/static/css/bootstrap.min.css" rel="stylesheet">
  <script src="/static/js/jquery-3.2.1.js"></script>
  <script src="/static/js/bootstrap.min.js"></script>
  <style>
    li {list-style-type:none;}
    /*html, body {*/
    /*height: 100%;*/
    /*font-size: 14px;*/
    /*color: #525252;*/
    /*font-family: NotoSansHans-Regular,AvenirNext-Regular,arial,Hiragino Sans GB,"Microsoft Yahei","Hiragino Sans GB","WenQuanYi Micro Hei",sans-serif;*/
    /*background: #f0f2f5;*/
    /*}*/
    body{
      /*background:black;*/
    }
    .footer {
      background-color: #fff;
      margin-top: 22px;
      margin-bottom: 22px;
      width: 100%;
      padding-top: 22px;
      color: #8A8A8A;
      display: block;
      height: 200px;
      border: 1px ;
      clear:both
    }

    .container {
      margin-right: 5%;
      margin-left: 5%;
      padding-left: 15px;
      padding-right: 15px;
      width: 40%;
      float: left;
    }
    .info {
      margin-right: 5%;
      width: 10%;
      float: left;
    }
    a{
      color: #8A8A8A;
      cursor: pointer;
    }
  </style>
</head>
<body>
<!-- 引入header文件 -->
<%@ include file="header.jsp"%>
<div style="display: inline-block;width: 70%">
  <div class="panel panel-success" id="main" style="width: 100%;margin:1% 2% 5% 5%;float: left;">
    <ul class="nav nav-tabs" style="background:linear-gradient(#f1f1f1,#c4e3f3);">
      <li><a style="color: black" href="/topic/active">活跃</a></li>
      <li><a style="color: black" href="/topic/essence">精华</a></li>
      <li><a style="color: black" href="/topic/recent">最近</a></li>
    </ul>

    <ul class="list-group" style="width: 100%">
      <c:forEach items="${messages}" var="message">
        <li class="list-group-item">
          <div style="height: 50px">
            <div style="float: left;width: 6%;margin-bottom: 5px">
              <img width="50px" height="50px" src="/static/img/avatar/delegator_avatar.png" class="img-rounded">
            </div>
            <div style="width: 89%;float: left">
              <a style="color: black;font-weight: normal;"><p style="color: #c9302c;display: inline"></p>${message.title}</a><br/>
              <div>
                <a><span class="label label-default" >${message.type}</span></a>&nbsp;&nbsp;&nbsp;
                <a><span ><strong>委托人id：${message.senderId}</strong></span></a>&nbsp;&nbsp;&nbsp;
                <small class="text-muted">正文: ${message.content}</small>  &nbsp;
              </div>
            </div>
            <div style="width: 5%;float: right;text-align: center">
              <span class="badge">${topic.countReplies}</span>
            </div>
          </div>
        </li>
      </c:forEach>
      <%--    <c:forEach var="lawyer" items="${lawyers}">--%>
      <%--        <tr>${lawyer.name}</tr>--%>
      <%--        <tr>${lawyer.age}</tr>--%>
      <%--        <tr>${lawyer.contact}</tr>--%>
      <%--        <tr>${lawyer.address}</tr>--%>
      <%--        <tr>${lawyer.lawFirm}</tr>--%>
      <%--        <tr>${lawyer.education}</tr>--%>
      <%--        <tr>${lawyer.specialization}</tr>--%>
      <%--        <tr>${lawyer.registrationDate}</tr>--%>

      <%--    </c:forEach>--%>
    </ul>
  </div>
  <%--<div class="pageDiv" align="center" style="display:block;">--%>
  <%--    <%@include file="../jsp/page.jsp" %>--%>
  <%--</div>--%>
</div>
<div align="center" style="display:block;float: right;margin-right: 30px">
  <!-- 引入侧边栏文件 -->
  <%@ include file="side.jsp"%>
</div>

<!-- 引入footer文件 -->
<%@ include file="footer.jsp"%>
</body>
</html>
