<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Product Discount Calculator" %>
</h1>
<form action="discount" method="post">
    <label for="product_description">Product Description:</label>
    <br>
    <input type="text" id="Product_Description" name="Product_Description" required placeholder="Enter product name">
    <br>
    <label for="List_Price">List Price:</label>
    <br>
    <input type="number" id="List_Price" name="List_Price" required placeholder="Enter price" min="0" max="100" step="0.1">
    <br>
    <label for="Discount_Percent">Discount Percent</label>
    <br>
    <input type="number" id="discount_percent" name="discount_percent" required min="0" max="100" step="0.1" placeholder="Enter discount %">
    <button type="submit">Calculate Discount</button>
</form>
</body>
</html>