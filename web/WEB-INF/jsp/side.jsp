<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<c:if test="${empty userId}">
    <!-- 未登录 -->
    <div class="panel panel-default" id="sidebar2" style="width: 100%;margin:5% 2% 1% 0%;">
        <div class="panel-heading" style="background:linear-gradient(#f1f1f1,#c4e3f3);text-align: center">
            <blockquote>
                zm
                <small>一个免费的法律咨询社区</small>
            </blockquote>
        </div>
        <ul class="list-group" style="width: 100%">
            <li class="list-group-item">
                <a  href="/signin" class="btn btn-primary btn-block">登录</a>
                <a  href="/signup" class="btn btn-default btn-block">注册</a>
            </li>
        </ul>
    </div>
</c:if>

<c:if test="${!empty userId}">
    <!-- 已登录 -->
    <div class="panel panel-success" id="sidebar2" style="width: 100%;margin:5% 2% 1% 0%;">
        <div class="panel-heading" style="background:linear-gradient(#f1f1f1,#c4e3f3);text-align: center">
            <a style="color:black;" href="/member/${user.username}">${user.username}</a>
        </div>
        <ul class="list-group" style="width: 100%">
            <a class="list-group-item" href="/new">发布新主题</a>
            <a class="list-group-item" href="/message/${userId}">${unreadMessage} 条未读消息</a>
            <a class="list-group-item" href="">积分:${user.credit}</a>
        </ul>
    </div>
</c:if>

<div class="panel panel-default" id="sidebar1" style="width:100%;margin:10% 2% 10% 0%;">
    <div class="panel-heading" style="background:linear-gradient(#f1f1f1,#c4e3f3);text-align: center">
        热议主题
    </div>
    <ul class="list-group" style="width: 250px">
        <c:forEach items="${hotestTopics}" var="hotestTopic">
            <a class="list-group-item" href="/t/${hotestTopic.id}">${hotestTopic.title}</a>
        </c:forEach>
    </ul>
</div>


