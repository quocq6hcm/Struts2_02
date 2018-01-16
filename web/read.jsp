<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: quocq
  Date: 01/16/2018
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Index Page</title>
</head>
<body>
<caption><h1>List of User</h1></caption>
<a href="create.action"> Create new </a>
<br/>
<br/>

<table id="tblData" name="tblData" border="1" cellspacing="0" cellpadding="5" >
    <thead>
    <tr>
        <td>Username</td>
        <td>Fullname</td>
        <td>Photo</td>
        <td>Email</td>
        <td>Level</td>
        <td></td>
        <script>
            console.log('nope');

        </script>
    </tr>
    </thead>

    <tbody>

    <c:forEach var="user" items="${list}">
    <tr>

        <td>${user.username}</td>
        <td>${user.fullName}</td>
        <td><img src="${user.photo}" /></td>
        <td>${user.email}</td>
        <td>${user.level}</td>

        <s:url action="getUpdate" var="update">
            <s:param name="username">${user.username}</s:param>
        </s:url>

        <s:url action="delete" var="delete">
            <s:param name="username">${user.username}</s:param>
        </s:url>


        <td><a href="${update}"> Update </a> | <a href="${delete}"> Delete </a></td>
    </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>
