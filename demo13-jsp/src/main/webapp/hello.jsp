<%--
  Created by IntelliJ IDEA.
  User: Aorez
  Date: 2022/10/5
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Hello JSP</h1>

<%--查看三种脚本在hello_jsp.java中的不同位置--%>
<%--在_jspService方法中，代码一样--%>
<%
    System.out.println("Hello JSP % ...");
    int n = 3;
%>
<%--在out.write()中--%>
<%--普通的html代码也是这个方式--%>
<%="Hello JSP %="%>
<%=n%>
<%--在成员变量和方法中--%>
<%!
    void f() {}
    String s = "郑";
%>

</body>
</html>
