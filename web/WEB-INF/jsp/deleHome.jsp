<%--
  Created by IntelliJ IDEA.
  User: 19080
  Date: 2023/8/29
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>法律咨询</title>
</head>
<body>
<form  action="${pageContext.request.contextPath}/toAdvice" method="post">
  <input type="search" name="context"  value="">
    <select name="type">
        <option value="婚姻">婚姻</option>
        <option value="民事">民事</option>
    </select>
<%--    <input type="hidden" name="delegator_id" value=${delegator.delegatorId}>--%>
    <input type="hidden" name="status" value="打开">
  <input type="submit" value="咨询">
    委托人id：${delegator.delegatorId}
    委托人姓名：${delegator.dename}
    委托人密码：${delegator.depassword}
    委托人电话：${delegator.phone}
</form>
</body>
</html>
