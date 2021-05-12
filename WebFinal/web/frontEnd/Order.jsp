<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
    <h1>Xác nhận mua hàng</h1>
    <form method="post" >  
        Họ và tên     :<input value="${User.getHoTen()}" name="tenKh"><br>
        SDT           :<input value="${User.getSdt()}" name="sdt"><br>
        Địa chỉ       :<input value="${User.getDiaChi()}" name="diaChi"><br>
        Ngày nhận hàng:<input type="date" name="ngayNhanHang"><br>
        Tình Trạng    :<input type="number" name="tinhTrang"><br>
        Tổng Tiền     :<input value="${tongTien}" name="tongTien"><br>
        <div>    
            <table border="1" cellspacing="0">
                <tbody>
                    <c:forEach items="${cart}" var="obj">
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
    <div><input type="submit" value="Thanh Toán"></input></div>     
    </form>       
           
<%@include file="footer.jsp" %>