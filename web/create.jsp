<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: quocq
  Date: 01/16/2018
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<s:form method="post" action="create" id="form">
    Username: <input type="text" id="username" name="username"/>
    Password: <input type="password" id="password" name="password"/> <br/>
    Fullname: <input type="text" id="fullName" name="fullName"/>
    Photo: <input type="text" id="photo" name="photo"/> <br/>
    Email: <input type="text" id="email" name="email"/> <br/>
    Level: <input type="number" id="level" name="level"/> <br/>
    <br/>



    <input type="submit" value="Create" />

</s:form>
    <a href="read.action">Return to index page</a>
</body>
</html>
