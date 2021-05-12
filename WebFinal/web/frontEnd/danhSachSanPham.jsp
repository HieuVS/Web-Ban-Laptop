<%-- 
    Document   : danhSachSanPham
    Created on : Apr 27, 2021, 10:03:34 PM
    Author     : Hieu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
        <hr>
        <h1>Danh Sach San Pham</h1>
        <hr>
        <table id="tbl-prod" cellspacing="0">
            <tbody class="container">
                <c:set var="count" value="0"></c:set>
                <tr >
                    <c:forEach items="${arr}" var="o">
                        <c:set var="count" value="${count+1}"></c:set>
                        <td>
                            <div class="prod product_item">
                                <div class="prod_details ">
                                    <div class="prod_img">
                                        <a href="ProductDetail?maSp=${o.getMaSp()}"><img src="${o.getAnh()}" class="img"></a>
                                        <div class="prod_hover">
                                            <a>${o.getGia()}</a>
                                        </div>
                                    </div>
                                    <div class="prod_info">
                                        <a>${o.getTenSp()}</a>
                                    </div>
                                </div>    
                            </div>
                        </td>
                        <c:if test="${count%3==0&&count<arr.size()}">
                            </tr>
                            <tr>
                        </c:if>
                    </c:forEach>
                    </tr>                   
            </tbody>    
        </table>
                <div class="paging">
                    <div class="paging-option">
                        <div class="btn-select-page m-btn-firstpage">«</div>
                        <div class="btn-select-page m-btn-prev-page">‹</div>
                        <div class="btn">
                            <c:forEach begin="1" end="${pages+1}" var="index">
                                <button class="btn-page"><a href="?page=${index}">${index}</a></button>
                            </c:forEach> 
                        </div>
                        <div class="btn-select-page m-btn-next-page">›</div>
                        <div class="btn-select-page m-btn-last-page">»</div>
                    </div>      
                </div>    

<%@include file="footer.jsp" %>
