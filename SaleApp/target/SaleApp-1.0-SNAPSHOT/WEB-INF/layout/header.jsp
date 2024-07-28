<%-- 
    Document   : header
    Created on : Jul 25, 2024, 9:38:42 PM
    Author     : MSI VN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">My store</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavbar">
                    <ul class="navbar-nav me-auto">

                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/" />">Trang chủ</a>
                        </li>
       
                        <c:forEach items="${categories}" var="c"> 
                            <li class="nav-item">
                                <a class="nav-link" href="#">${c.name}</a>
                            </li>
                        </c:forEach>
                    </ul>

                    <form action="<c:url value="/" />" class="d-flex">
                        <input class="form-control me-2" name="kw" type="text" placeholder="Nhập tên sản phẩm">
                        <button class="btn btn-primary" type="submit">Tìm</button>
                    </form>

                </div>
            </div>
        </nav>
