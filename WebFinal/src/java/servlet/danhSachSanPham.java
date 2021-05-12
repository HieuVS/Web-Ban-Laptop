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
import model.productDTO;
import model.productModel;
import model.userDTO;
import model.userModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Hieu
 */
public class danhSachSanPham extends HttpServlet {

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
        int page = 1;
        if (request.getParameter("page")!= null) {
            page = Integer.valueOf(request.getParameter("page"));
        }
        
        ArrayList<productDTO> prod = productModel.getAll(page);
        request.setAttribute("arr",prod);
        int total = productModel.countProduct();
        int pages = (int) Math.ceil(total / 9);
        request.setAttribute("pages",pages);
        
        JSONObject obj = new JSONObject();
        JSONArray list = new JSONArray();
        ArrayList<productDTO> product = productModel.getNameAndPic();
        for(productDTO pro : product) {
            obj.put("pro",pro);
            list.add(obj);
        }
        
    //    String forward = "";
        RequestDispatcher rd = request.getRequestDispatcher("/frontEnd/danhSachSanPham.jsp");
        rd.forward(request, response);
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
                PrintWriter out = response.getWriter();
        String username = request.getParameter("txtUser"); 
        String password = request.getParameter("txtPass");  
        userDTO user = userModel.getUserByUsername(username);
        String hoten = user.getHoTen();
        
        JSONArray list = new JSONArray();
        JSONObject obj = new JSONObject();
        String msg;
        userDTO login = new userDTO(username,password); 
        Boolean checkLogin = userModel.Login(login); 
        if(checkLogin) { 
            HttpSession session = request.getSession(); 
            session.setAttribute("login",username); 
            session.setAttribute("Khach", user);
            response.sendRedirect("danhSachSanPham"); 
            session.setAttribute("userTen", hoten); 
            msg = "1";
            obj.put("msg", msg);
            list.add(obj);
          //  out.println(list.toJSONString());
          //  out.flush();
        }
        else { 
        
         //   request.setAttribute("Message", "Mật khẩu hoặc tài khoản chưa đúng! Vui lòng thử lại.");
         //   response.sendRedirect("login?err=1");
           // response.sendRedirect("danhSachSanPham");
            msg="3";
            obj.put("msg", msg);
            list.add(obj);
            out.println(list.toJSONString());
            out.flush();
        }
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
