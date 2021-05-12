/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.donHangChiTietDTO;
import model.donHangDTO;
import model.donHangModel;
import model.gioHangDTO;
import model.userDTO;
import model.userModel;

/**
 *
 * @author Hieu
 */
public class Order extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Order</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Order at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        if(session.getAttribute("cart")==null) {
            response.sendRedirect("danhSachSanPham");
        }
        ArrayList<gioHangDTO> orderDetails = (ArrayList<gioHangDTO>) session.getAttribute("cart");
        int TongTien = 0;
        for (gioHangDTO orderDetail : orderDetails) {
            TongTien += orderDetail.getGia() * orderDetail.getSoLuong();
        }
        request.setAttribute("tongTien", TongTien);        
        if( session.getAttribute("login")!= null ) {
            String username = (String) session.getAttribute("login");
            userDTO userInfo = userModel.getUserByUsername(username);
            request.setAttribute("User", userInfo);
        }
             
        request.setAttribute("cart", orderDetails);
        RequestDispatcher rd = request.getRequestDispatcher("/frontEnd/Order.jsp"); 
        
        rd.include(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        //THEM DU LIEU VAO DON HANG
        String tenKh = request.getParameter("tenKh");
        int sdt = Integer.valueOf(request.getParameter("sdt"));
        String diaChi = request.getParameter("diaChi");
        String ngayNhanHang = request.getParameter("ngayNhanHang");
        int tinhTrang = Integer.valueOf(request.getParameter("tinhTrang"));
        Float tongTien = Float.valueOf(request.getParameter("tongTien"));
        donHangDTO Order = new donHangDTO(tenKh,sdt,diaChi,ngayNhanHang,tinhTrang,tongTien);
        donHangModel.insertDonHang(Order);
        // THEM DU LIEU VAO DON HANG CHI TIET
        int maDh = donHangModel.getMaDh();    
        ArrayList<gioHangDTO> cart = (ArrayList<gioHangDTO>) session.getAttribute("cart");
        ArrayList<donHangChiTietDTO> arr = new ArrayList<donHangChiTietDTO>();
        for(int i = 0; i < cart.size(); i++) {
            donHangChiTietDTO dhct = new donHangChiTietDTO(cart.get(i).getMaSp(), cart.get(i).getTenSp()
                    ,cart.get(i).getGia(), cart.get(i).getSoLuong(), maDh);
            arr.add(dhct);

        }
//        System.out.println("gio Hang :" +arr.size());        
        donHangModel.insertDonHangChiTiet(arr);
        

        
        response.sendRedirect("OrderDetails");    
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
