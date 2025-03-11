<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<title>Responsive Image Gallery</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
   <link rel="stylesheet" href="style.css">

</head>
<body>

<div class="container">
  <h2 class="fw-bold ">Responsive Image Gallery</h2>
  <h4 class="fw-bold">Resize the browser window to see the effect.</h4>
  <div class="d-flex flex-wrap gallery">
    <div class="col-custom p-2">
      <div class="border">
        <a target="_blank" href="image/chua-minh-thanh.jpg">
          <img src="image/chua-minh-thanh.jpg"/>
        </a>
        <div class="desc text-center">Chùa Minh Thành</div>
      </div>
    </div>
    <div class="col-custom p-2">
      <div class="border">
        <a target="_blank" href="image/doi-thong-ha-tam.jpg">
          <img src="image/doi-thong-ha-tam.jpg" alt="Đồi Thông Hà Tam">
        </a>
        <div class="desc text-center">Đồi Thông Hà Tam</div>
      </div>
    </div>
    <div class="col-custom p-2">
      <div class="border">
        <a target="_blank" href="image/rung-thong-dak-doa.jpg">
          <img src="image/rung-thong-dak-doa.jpg" alt="Rừng Thông Đăk Đoa">
        </a>
        <div class="desc text-center">Rừng Thông Đăk Đoa</div>
      </div>
    </div>
    <div class="col-custom p-2">
      <div class="border">
        <a target="_blank" href="image/thac-phu-cuong.jpg">
          <img src="image/thac-phu-cuong.jpg" alt="Thác Phú Cường">
        </a>
        <div class="desc text-center">Thác Phú Cường</div>
      </div>
    </div>ga
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>-->
</body>
</html>