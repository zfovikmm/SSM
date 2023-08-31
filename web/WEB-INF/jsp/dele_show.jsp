<%--
  Created by IntelliJ IDEA.
  User: 14371
  Date: 2020/12/16
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>后台管理系统</title>
    <link rel="icon" type="image/png"
          href="/static/assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed"
          href="/static/assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <link rel="stylesheet"
          href="/static/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="/static/assets/css/admin.css">
    <link rel="stylesheet" href="/static/assets/css/app.css">
    <link rel="stylesheet" href="/static/assets/css/frame.css">
    <script type="text/javascript" src="/static/js/jquery-3.4.1.js"></script>
    <style>
        .black_overlay{
            display: none;
            position: absolute;
            top: 0%;
            left: 0%;
            width: 100%;
            height: 100%;
            background-color: black;
            z-index:1001;
            -moz-opacity: 0.8;
            opacity:.80;
            filter: alpha(opacity=88);
        }
        .white_content {
            display: none;
            position: absolute;
            top: 9%;
            left: 25%;
            width: 45%;
            height: 75%;
            padding: 20px;
            border: 3px solid black;
            background-color: white;
            z-index:1002;
            overflow: auto;
        }
    </style>
    <style>
        .smart-green {
            /*margin-left: auto;*/
            margin-right: auto;
            max-width: 500px;
            /*background: #F8F8F8;*/
            padding: 30px 30px 20px 30px;
            font: 15px Arial, Helvetica, sans-serif;
            color: #666;
            border-radius: 5px;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
        }

        .smart-green h1 > span {
            display: block;
            font-size: 11px;
            color: #FFF;
        }
        .smart-green label {
            display: block;
            margin: 0px 0px 5px;
        }
        .smart-green label > span {
            float: left;
            margin-top: 10px;
            color: #5E5E5E;
        }
        .smart-green input[type="text"],
        .smart-green textarea, .smart-green select {
            color: #555;
            height: 30px;
            line-height: 15px;
            width: 100%;
            padding: 0px 0px 0px 10px;
            margin-top: 2px;
            border: 1px solid #E5E5E5;
            background: #FBFBFB;
            outline: 0;
            -webkit-box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
            box-shadow: inset 1px 1px 2px rgba(238, 238, 238, 0.2);
            font: normal 14px/14px Arial, Helvetica, sans-serif;
        }
        .smart-green textarea {
            height: 100px;
            padding-top: 10px;
        }
        .smart-green .button {
            background-color: #9DC45F;
            border-radius: 5px;
            -webkit-border-radius: 5px;
            -moz-border-border-radius: 5px;
            border: none;
            padding: 10px 25px 10px 25px;
            color: #FFF;
            text-shadow: 1px 1px 1px #949494;
        }
        .smart-green .button:hover {
            background-color: #80A24A;
        }
        .error-msg{
            color: red;
            margin-top: 10px;
        }

    </style>
    <script type="text/javascript">
        $(function () {
            $("#btn1").click(function () {
                var tISDN = $("#tISDN").val();
                if(tISDN==""){
                    $(".errorMsg").text("新闻编号不可为空");
                    return false;}
                return true;
            })
        })



    </script>
    <script type="text/javascript" >
        function editFile(id){
            //获取id为 id(此id为传递过来的id值)的 tr标签的子节点
            var a=$("#tr"+id).children();
            //a[1]表示第二个单元格
            //$("#tr"+id).children().siblings().eq(1).text()表示选中'id'为id的tr的第二个单元格，将其变为可编辑状态
             a[1].innerHTML="<td ><input type='text' id='input1"+id+"' value='"+$("#tr"+id).children().siblings().eq(1).text()+"'/></td>";
            a[2].innerHTML="<td ><input type='text' id='input2"+id+"' value='"+$("#tr"+id).children().siblings().eq(2).text()+"'/></td>";
            a[3].innerHTML="<td ><input type='text' id='input3"+id+"' value='"+$("#tr"+id).children().siblings().eq(3).text()+"'/></td>";
            a[4].innerHTML="<td ><input type='text' id='input4"+id+"' value='"+$("#tr"+id).children().siblings().eq(4).text()+"'/></td>";
            a[5].innerHTML="<td ><input type='text' id='input5"+id+"' value='"+$("#tr"+id).children().siblings().eq(5).text()+"'/></td>";
            //点击修改后将编辑改为保存和取消
            a[6].innerHTML="" +
                "<td><div class='am-btn-toolbar'> <div class='am-btn-group am-btn-group-xs'>" +
                "<button class='am-btn am-btn-default am-btn-xs am-text-secondary' type='button' onclick='save("+id+")'> " +
                "<span class=\"am-icon-edit\"></span>保存 </button>" +
                "<button class='am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only' type='button' onclick='back()'> " +
                "<span class='am-icon-trash-o'></span>取消 </button> </div> </div></td>";
        }

        //编辑保存操作
        function save(id) {//未定义是可能就是id重复了

            var dename=$("#input1"+id).val();
            var email=$("#input2"+id).val();
            var phone=$("#input3"+id).val();
            var address=$("#input4"+id).val();
            var sex=$("#input5"+id).val();

            if (dename == "") {
                $(".errorMsg").text("姓名不可为空");
                return false;
            }
            if (email == "") {
                $(".errorMsg").text("邮箱不可为空");
                return false;
            }
            if (phone == "") {
                $(".errorMsg").text("电话不可为空");
                return false;
            }
            if (address == "") {
                $(".errorMsg").text("地址不可为空");
                return false;
            }
            if (sex == "") {
                $(".errorMsg").text("性别不可为空");
                return false;
            }
            window.location.href="${pageContext.request.contextPath}/upDele?delegatorId="+id+"&dename="+dename+"&email="+email+"&phone="+phone+"&address="+address+"&sex="+sex;
        }

        function back() {
            window.location.href="${pageContext.request.contextPath}/alldele";
        }
        function del(id) {
            window.location.href="${pageContext.request.contextPath}/delGator?delegatorId="+id;
        }

    </script>
    <script type="text/javascript">

        $( function() {
            var choose = function(id) {
                return document.getElementById(id);
            }
            //自定义部分
            window.confirm = function(message, yesCallBack, noCallBack) {

                var message = message || "确定?";

                choose("dialog-message").innerHTML = message;
                // 显示遮罩和对话框
                choose("dialog-hide").className = "wrap-dialog";
                // 确定按钮

                choose("dialog").onclick = function(e) {
                    if (e.target.className == "dialog-btn") {
                        choose("dialog-hide").className = "wrap-dialog dialog-hide";
                        yesCallBack();
                    } else if (e.target.className == "dialog-btn dialog-ml50") {
                        choose("dialog-hide").className = "wrap-dialog dialog-hide";
                        noCallBack();
                    }
                };
                // 取消按钮
                choose("closeBtn").onclick = function() {
                    choose("dialog-hide").style.display = "none";
                }
            }
        })
        function submitHand(id) {
            function submitBtn() {
                // btn();
                del(id);
            }

            function closeBtn() {
                window.history.go(0);
            }
            confirm("确定要删除吗？", submitBtn, closeBtn);
        }
    </script>
</head>

<body data-type="generalComponents">

<div class="wrap-dialog dialog-hide" id="dialog-hide">
    <div class="dialog" id="dialog">
        <a class="closeBtn" id="closeBtn">X</a>
        <div class="dialog-header">
            <span class="dialog-title">提示</span>
        </div>
        <div class="dialog-body">
            <span class="dialog-message" id="dialog-message">确定要删除吗？</span>
        </div>
        <div class="dialog-footer">
            <input type="button" class="dialog-btn" id="dialog-confirm" value="确定">
            <input type="button" class="dialog-btn dialog-ml50" id="dialog-cancel" value="取消">
        </div>
    </div>
</div>
<%@include file="top.jsp"%>

<div class="tpl-page-container tpl-page-header-fixed">
    <!--左边start-->
    <%@include file="sidebar.jsp"%>
    <!--左边end-->
    <div class="tpl-content-wrapper">
        <!--右边内容start-->
        <ol class="am-breadcrumb">
            <li>
                <a href="#" class="am-icon-home">首页</a>
            </li>
            <li class="am-active">
                委托人信息管理
            </li>
        </ol>
        <div class="tpl-portlet-components">
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-1">
                        <div class="am-btn-group am-btn-group-xs">

                        </div>
                    </div>
                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-btn-group am-btn-group-xs">
                            <label>
                                <%--  <span ><font style="font-size: 17px;color: red;">111111111111</font></span> --%>
                                <span class="errorMsg" style="font-size: 16px;color: red"><%=request.getAttribute("newsc")==null?"":request.getAttribute("newsc")%></span>
                            </label>
                        </div>
                    </div>

                    <div class="am-u-sm-12 am-u-md-3">
                        <br>
                        <form action=" ${pageContext.request.contextPath}/selectDele"  id="f2" method="post" >
                            <div class="am-input-group am-input-group-sm">
                                <input type="text" name="dename" placeholder="请输入委托人姓名" id="tISDN" class="am-form-field">
                                <span class="am-input-group-btn">
                                    <button class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
                                            type="submit" id="btn1" ></button> </span>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="am-g">
                    <div class="am-u-sm-12">
                        <table class="am-table am-table-striped am-table-hover table-main">
                            <thead>
                            <tr>
                                <th class="table-title">编号</th>
                                <th class="table-title">姓名</th>
                                <th class="table-title">邮箱</th>
                                <th class="table-title">电话</th>
                                <th class="table-title">地址</th>
                                <th class="table-title">性别</th>
                                <th class="table-set">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${delegators}" var="dele" >
                                <tr id="tr${dele.delegatorId}">
                                    <td>${dele.delegatorId}</td>
                                    <td>${dele.dename}</td>
                                    <td>${dele.email}</td>
                                    <td>${dele.phone}</td>
                                    <td>${dele.address}</td>
                                    <td>${dele.sex}</td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button class="am-btn am-btn-default am-btn-xs am-text-secondary"
                                                        type="button" onclick="editFile(${dele.delegatorId})">
                                                    <span class="am-icon-edit"></span> 编辑
                                                </button>
                                                <button class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"
                                                        type="button" onclick="submitHand(${dele.delegatorId})">
                                                    <span class="am-icon-trash-o"></span> 删除
                                                </button>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>


                            <!--行end-->
                            </tbody>

                        </table>
                    </div>
                    <c:if test="${nodePage>1}"><%--当前页面不是第一页显示上一页--%>
                        <a href="${pageContext.servletContext.contextPath}/list?nodePage=${nodePage-1}">上一页</a>
                    </c:if>
                    <c:forEach begin="1" end="${requestScope.allpage}" var="pagesize">
                        <a href="${pageContext.servletContext.contextPath}/list?nodePage=${pagesize}">${pagesize}</a>
                    </c:forEach>
                    <c:if test="${requestScope.nodePage<requestScope.allpage}"><%--当前页面不是最后一页显示下一页--%>
                        <a href="${pageContext.servletContext.contextPath}/list?nodePage=${nodePage+1}">下一页</a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>

<div id="fade" class="black_overlay"></div>
</body>

</html>
