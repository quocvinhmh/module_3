<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới</h1>
<form action="/HomeControll?action=create" method="post">
    <label>
        <input type="text" name="name" placeholder="Nhập tên">
    </label>
    <label>
        <input type="number" name="price" min ="0" step="0.1" placeholder="Nhập giá">
    </label>
    <label>
        <input type="text" name="description" placeholder="Nhập mô tả">
    </label>
    <label>
        <input type="text" name="manufacturer" placeholder="Nhập nhà sản xuất">
    </label>
    <button type="submit">Lưu</button>
</form>
</body>
</html>