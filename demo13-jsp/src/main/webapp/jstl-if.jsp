<%--
  Created by IntelliJ IDEA.
  User: Aorez
  Date: 2022/10/5
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%--jstl需要这个标签--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<c:if test="true">--%>
<%--    <h1>true</h1>--%>
<%--</c:if>--%>
<%--<c:if test="false">--%>
<%--    <h1>false</h1>--%>
<%--</c:if>--%>
<c:if test="${status == 1}">
    <h1>启用</h1>
</c:if>
<c:if test="${status == 0}">
    <h1>禁用</h1>
</c:if>

</body>
</html>
