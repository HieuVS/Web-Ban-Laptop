<%-- 
    Document   : OrderDetails
    Created on : May 10, 2021, 12:02:29 AM
    Author     : Hieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<h1>Cảm ơn bạn đã mua hàng</h1>
<h2>Thông tin đơn hàng</h2>
<hr>
        <div>Họ và tên     :${OrderIn4.getTenKh()}</div>
        <div>SDT           :${OrderIn4.getSdt()}</div>
        <div>Địa chỉ       :${OrderIn4.getDiaChi()}</div>
        <div>Ngày nhận hàng:${OrderIn4.getNgayNhanHang()}</div>
        <div>Tình Trạng    :${OrderIn4.getTinhTrang()}</div>
        <div>Tổng Tiền     :${OrderIn4.getTongTien()}</div>
        <div style="width: 100%;height: auto">    
            <table border="1" cellspacing="0">
                <tbody>
                    <c:forEach items="${Order}" var="obj">
                    <tr>
                        <td><input value="${obj.getMaSp()}" name="maSp"></td>
                        <td><input value="${obj.getTenSp()}" name="tenSp"></td>
                        <td><input value="${obj.getGia()}" name="gia"></td>
                        <td><input value="${obj.getSoLuong()}" name="soLuong"></td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
<button><a href="danhSachSanPham">Trở về trang chủ</a></button>
<%@include file="footer.jsp" %>

