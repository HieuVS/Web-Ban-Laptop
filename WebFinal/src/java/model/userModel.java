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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hieu
 */
public class userModel {
    public static void InsertRegister (userDTO user) {
        Connection conn = connectDb.openConnect();
        try {
            String query = "INSERT INTO Register (username,password,tenKh,sdt,ngaySinh,diaChi) VALUES('" +user.getUsername()+"','"+user.getPassword()
                    +"',N'"+user.getHoTen()+"',"+user.getSdt()+",'"+user.getNgaySinh()+"',N'"+user.getDiaChi()+"')";
            Statement stm = conn.createStatement();
            stm.executeQuery(query);
        } catch (Exception ex) {
                
        } finally {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(userModel.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    public static Boolean Login (userDTO user) {
        //mo ket noi
        Connection conn = connectDb.openConnect();
        //thao tac lay du lieu
        if (conn != null) {
            try {
                //viet query
                String query = "select * from Register WHERE username='" +user.getUsername()+"' AND password='"+user.getPassword()+"'";
                Statement stm = conn.createStatement();
                ResultSet result = stm.executeQuery(query);
                if (result.next()) {
                    return true;
                }
                return false;
            } catch (SQLException ex) {
               return null;
            }
        }
        return false;
    }
    public static userDTO getUserByUsername (String username) {
        Connection conn = connectDb.openConnect();
        if(conn!=null) {
            try {
                String query = "select * from Register WHERE username='" +username+"'";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                userDTO user = new userDTO();
                    while (rs.next()) {
                        String hoTen = rs.getString("tenKh");
                        int sdt = Integer.valueOf(rs.getString("sdt"));
                        String ngaySinh = rs.getString("ngaySinh");
                        String diaChi = rs.getString("diaChi");
                        user = new userDTO(hoTen,sdt,ngaySinh,diaChi);
                    }
                    conn.close();
                    return user; 
                }catch (SQLException ex) {
                    return null;
                }   
            }
            return null;
    }
}    
