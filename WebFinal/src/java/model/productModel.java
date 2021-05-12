/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Hieu
 */
public class productModel {
    public static ArrayList<productDTO> getAll(int page) {
        ArrayList<productDTO> arr = new ArrayList<>();
        Connection conn = connectDb.openConnect();
        if(conn!=null) {
            try {
                String query = "SELECT * FROM Products ORDER BY maSp DESC OFFSET "+ (page-1)*9 +" ROWS FETCH NEXT 9 ROWS ONLY";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while (rs.next()) {
                    int ma = Integer.valueOf(rs.getString("maSp"));
                    String tenSp = rs.getString("tenSp");
                    float gia= Float.valueOf(rs.getString("gia"));
                    String moTa = rs.getString("moTa");
                    String anh = rs.getString("anh");
                    productDTO prod = new productDTO(ma,tenSp,gia,moTa,anh);
                    arr.add(prod);
                }
                conn.close();
                return arr; 
            }catch (SQLException ex) {
                return arr;
            }   
        }
        return arr;
    }
    public static ArrayList<productDTO> getNameAndPic () {
        ArrayList<productDTO> arr = new ArrayList<>();
        Connection conn = connectDb.openConnect();
        if (conn!=null) {
            try {
                String query = "SELECT anh,tenSp FROM Products";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next()) {
                    String anh = rs.getString("anh");
                    String tenSp = rs.getString("tenSp");
                    productDTO prod = new productDTO(anh,tenSp);
                    arr.add(prod);
                }
                conn.close();
                return arr;
            } catch (SQLException ex) {
                return arr;
            }
        }
        return arr;
    } 
    
    public static productDTO getProdById(int maSp) {
        Connection conn = connectDb.openConnect();
        if(conn!=null) {
            try {
                String query = "SELECT * FROM Products WHERE maSp= "+maSp;
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                productDTO obj = new productDTO();
                while (rs.next()) {
                    int ma = Integer.valueOf(rs.getString("maSp"));
                    String tenSp = rs.getString("tenSp");
                    float gia= Float.valueOf(rs.getString("gia"));
                    String moTa = rs.getString("moTa");
                    String anh = rs.getString("anh");
                    obj = new productDTO(ma,tenSp,gia,moTa,anh);
                }
                conn.close();
                return obj; 
            }catch (SQLException ex) {
                return null;
            }   
        }
        return null;
    }
    
    public static int countProduct() {
        int total=0;
        Connection conn = connectDb.openConnect();
        if(conn!=null) {
            try {
                String query = "SELECT COUNT(*) as Total FROM Products ";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while (rs.next()) {
                    total = Integer.valueOf(rs.getString("total"));
                }
                conn.close();
                return total; 
            }catch (SQLException ex) {
                return total;
            }   
        }
        return total;
    }
    
    public static ArrayList<gioHangDTO> addProdToCart (int maSp, ArrayList<gioHangDTO>list) {
        productDTO item = getProdById(maSp);
        if (list.size()>0) {
            boolean CheckExist = false;
                for(int i = 0; i < list.size(); i++) {
                    if(list.get(i).getMaSp() == item.getMaSp()) {
                        CheckExist = true;
                        gioHangDTO obj = list.get(i);
                        obj.setSoLuong(obj.getSoLuong()+1);
                        list.set(i, obj);
                    } 
                }    
                if(!CheckExist) {
                        gioHangDTO obj = new gioHangDTO(maSp,item.getTenSp(),item.getAnh(),item.getGia(),1);
                        list.add(obj);
                }
        } else {
            gioHangDTO obj = new gioHangDTO(maSp,item.getTenSp(),item.getAnh(),item.getGia(),1);
            list.add(obj);
        }
        return list;
    }
}
//dung concat de filter moi ky tu nhap vao input