<%--
  Created by IntelliJ IDEA.
  User: VINH-PC
  Date: 18/03/2025
  Time: 11:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h1>Thêm sản phẩm mới</h1>

<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if>

<form method="post" action="/products">
    <input type="hidden" name="action" value="create">

    <label for="name">Tên sản phẩm:</label>
    <input type="text" id="name" name="name" required>
    <br>

    <label for="price">Giá:</label>
    <input type="number" id="price" name="price" required>
    <br>

    <label for="description">Mô tả:</label>
    <textarea id="description" name="description"></textarea>
    <br>

    <label for="manufacturer">Nhà sản xuất:</label>
    <input type="text" id="manufacturer" name="manufacturer" required>
    <br>

    <input type="submit" value="Thêm sản phẩm">
</form>

<br>
<a href="/products">Quay lại danh sách sản phẩm</a>

</body>
</html>
