<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách hợp đồng</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<body>
<h2>Danh sách hợp đồng</h2>
<form action="${pageContext.request.contextPath}/Contract" method="get">
    <input type="hidden" name="action" value="search">
    <input type="search" name="contractID" placeholder="Tìm kiếm theo ID">
    <button type="submit">Tìm kiếm</button>
</form>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Deposit</th>
        <th>Total Money</th>
        <th>Customer ID</th>
        <th>Task</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="contract" items="${contractList}">
        <tr>
            <td>${contract.id}</td>
            <td>${contract.startDate}</td>
            <td>${contract.endDate}</td>
            <td>${contract.deposit}</td>
            <td>${contract.totalMoney}</td>
            <td>${contract.customerId}</td>
            <td><button onclick="del(`${contract.getId()}`)">Delete</button><button>Edit</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="${pageContext.request.contextPath}/Contract" method="get">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="contractID"  value="contractID" id="contractID">
    <span>Bạn có muốn xoá sản phẩm có id </span><span >${contract.getId()}</span>
    <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
        <button type="submit" class="btn btn-danger">Xoá</button>
    </div>
</form>


<form action="/Contract" method="get">

</form>
<script>
        function del(id){
            document.getElementById("contractID").value = id ;
    }
</script>
</body>
</html>
