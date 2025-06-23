<%--
  Created by IntelliJ IDEA.
  User: VINH-PC
  Date: 13/03/2025
  Time: 11:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sánh</title>
</head>
<body>
<table border="1">
    <tr>
        <th>STT</th>
    <th>Tên</th>
    <th>Ngày Sinh</th>
    <th>Địa chỉ</th>
     <th>Ảnh</th>
    </tr>
<c:forEach items="clients" var="client" varStatus="status">
    <tr>
        <td>${}</td>
        <td>${status.getId()}</td>
      <td>${status.getTen()}</td>
      <td>${status.getDay()}</td>
      <td> <img src="${status.getNhan()}" width="200" height="auto" alt=""></td>
    </tr>
</c:forEach>
  </table>
</body>
</html>
