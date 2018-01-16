<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: quocq
  Date: 01/16/2018
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:form method="post" action="update" id="form">
        Username: <input type="text" id="username" name="username" readonly="readonly" value="${username}"/>
        Password: <input type="password" id="password" name="password" value="${password}"/> <br/>
        Fullname: <input type="text" id="fullName" name="fullName" value="${fullName}"/>
        Photo: <input type="text" id="photo" name="photo" value="${photo}" /> <br/>
        Email: <input type="text" id="email" name="email" value="${email}"/> <br/>
        Level: <input type="number" id="level" name="level" value="${level}"/> <br/>
        <br/>



        <input type="submit" value="Update" />

    </s:form>
    <a href="read.action">Return to index page</a>
</body>
</html>
