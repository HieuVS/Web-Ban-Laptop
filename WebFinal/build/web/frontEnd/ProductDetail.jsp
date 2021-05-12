<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
    <br>
    <h1>Chi Tiet San Pham</h1>
    <hr>
    <div class="prod_in4">
        <table class="tbl_prod" cellspacing="0" >
            <tr>
                <td rowspan="3">    
                    <img src="${prod.getAnh()}">
                </td>
                <td>
                    <h5>${prod.getTenSp()}</h5>
                </td>
            </tr>   
            <tr>
                <td>
                    <h3>${prod.getGia()}</h3>
                </td>
            </tr>
            <tr>
                <td>
                    <h3>${prod.getMoTa()}</h3>
                </td>
            </tr>
        </table>
    </div>            
    <div style="text-align: center;">
        <button class="btn-add"><a style="text-decoration: none;color: black;" href="addProdToCart?maSp=${prod.getMaSp()}">
                Them Vao gio hang</a>
        </button>
    </div>            
<%@include file="footer.jsp" %>