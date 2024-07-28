
<%-- 
    Document   : index
    Created on : Jul 19, 2024, 9:37:09 AM
    Author     : MSI VN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang chủ</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </head>
    <body>
        <section class="container">
            <h1 class="text-center text-info mt-1">Danh Mục Sản Phẩm</h1>
            <a href="<c:url value="/products" />" class="btn btn-success mb-1">Thêm sản phẩm </a>
            <table class="table .table-striped">
                <tr>
                    <th></th>
                    <th>Id</th>
                    <th>Tên sản phẩm</th>
                    <th>Giá sản phẩm</th>
                    <th></th>
                </tr>
                <c:forEach items="${products}" var="p">
                    <tr>
                        <td><img class="rounded img-fluid" src="${p.image}" width="200" alt="${p.name}"></td>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td>${p.price} VNĐ</td>
                        
                        <td>
                            <button class="btn btn-danger">Xóa</button>
                            
                            <c:url value="/products/${p.id}" var="url"/>                            
                            <a href="${url}" class="btn btn-info">Cập nhật</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </section>


    </body>
</html>
