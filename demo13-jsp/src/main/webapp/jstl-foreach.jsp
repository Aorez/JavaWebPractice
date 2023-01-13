<%--
  Created by IntelliJ IDEA.
  User: Aorez
  Date: 2022/10/5
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>
    </tr>

<c:forEach items="${brands}" var="brand" varStatus="varStatus">
    <tr align="center">
<%--        不能写brand.getId()--%>
<%--        <td>${brand.id}</td>--%>
<%--    用遍历状态对象varStatus写序号--%>
<%--    varStatus是类的实例，要用el表达式来取？--%>
        <td>${varStatus.count}</td>
        <td>${brand.brandName}</td>
        <td>${brand.companyName}</td>
        <td>${brand.ordered}</td>
        <td>${brand.description}</td>
        <c:if test="${brand.status == 1}">
            <td>启用</td>
        </c:if>
        <c:if test="${brand.status == 0}">
            <td>禁用</td>
        </c:if>
        <td><a href="#">修改</a> <a href="#">删除</a></td>
    </tr>
</c:forEach>
</table>

<%--分页控制条--%>
<c:forEach begin="1" end="10" step="1" var="i">
    <a href="#">${i}</a>
</c:forEach>

</body>
</html>
