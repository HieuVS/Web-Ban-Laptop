<%-- 
    Document   : addProdToCart
    Created on : Apr 28, 2021, 7:47:10 AM
    Author     : Hieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <form action="updateProduct" method="post">
        <table id="cart-add" style="margin-top: 60px;" border="1">
        <tr>
            <th>Mã Sản Phẩm</th>
            <th>Tên Sản Phẩm</th>
            <th>Ảnh</th>
            <th>Giá</th>
            <th>Số Lượng</th>
            <th>Thành tiền</th>
            <th>Cập nhập số lượng</th>
            <th>Xoá</th>
        </tr>
        <d:forEach items="${cart}" var="obj">
        <tr>
            <td>${obj.getMaSp()}</td>
            <td>${obj.getTenSp()}</td>
            <td><img src="${obj.getAnh()}" height="80px"> </td>
            <td>${obj.getGia()}</td>
            <td>${obj.getSoLuong()}</td>
            <td>${(obj.getGia()*obj.getSoLuong()).longValue()}</td>
            <td><input type="number" name="CapNhap" value="${obj.getSoLuong()}"></td>
            <td><a href="DeleteProdInCart?maSp=${obj.getMaSp()}">Xoa</a></td>
        </tr>
        </d:forEach>            
    </table>
<!--        <div>
            <input style="width: 150px;height: 25px;position: absolute;top: 600px;text-align: center" type="submit" value="Cap Nhap San Pham">
        </div>-->
        <div style="display: flex;margin-bottom: 60px;">
            <button style="margin-right: 12px" class="btn-add" type="submit">
                Cap Nhap San Pham
            </button>
            <button class="btn-add"><a style="text-decoration: none;color: #000;" href="Order">Dat Hang</a></button>
        </div>
        
    </form>
    
</div>    
      <hr>
        
<%@include file="footer.jsp" %>
