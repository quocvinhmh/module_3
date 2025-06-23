<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: VINH-PC
  Date: 09/03/2025
  Time: 10:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách sinh viên</h1>
<table>
    <tr>
        <th>STT</th>
        <th>Name</th>
        <th>Age</th>
    </tr>
    <c:forEach items="${studentList}" var="studentList" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${studentList.getName()}</td>
            <td>${studentList.getAge()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
