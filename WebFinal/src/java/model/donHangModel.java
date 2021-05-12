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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hieu
 */
public class donHangModel {
//    public static Connection conn = connectDb.openConnect();
    public static void insertDonHang (donHangDTO dh) {   
        Connection conn= connectDb.openConnect();
        if(conn!= null) {
            try {
                String query = "INSERT INTO DonHang(tenKh,sdt,diaChi,ngayNhanHang,tinhTrang,tongTien) VALUES" + "(N'" +dh.getTenKh()
                        +"',"+dh.getSdt()+",N'"+dh.getDiaChi()+"','"+dh.getNgayNhanHang()+"','"+dh.getTinhTrang()+"',"+dh.getTongTien()+ ")";
                System.out.println(query);
                Statement stm = conn.createStatement();
                stm.executeQuery(query);
                
            } catch (Exception ex) {
                
            } finally {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(donHangModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static int getMaDh() {
        int maDh=0;
        Connection conn= connectDb.openConnect();
        if (conn!= null) {
            try {
                String query = "SELECT TOP 1 maDh FROM DonHang ORDER BY maDh DESC";    //Co cach hay hon ko ?
//                String query = "SELECT SCOPE_IDENTITY() FROM DonHang";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next()) {
                    maDh = Integer.valueOf(rs.getString("maDh"));
                }
                conn.close();
                return maDh;
            } catch (SQLException ex) {
                return maDh;
            }   
        }
      //  System.out.println("Ma DON HANG LA:"+maDh);
        return maDh;
    }
    
    

    public static void insertDonHangChiTiet(ArrayList<donHangChiTietDTO> arr) {
        try {
            Connection conn = connectDb.openConnect();
            //thao tac them du lieu
            System.out.println("size:" + arr.size());
            Statement stm = conn.createStatement();
            if (conn != null) {
                for (int i = 0; i < arr.size(); i++) {

                    String query = "INSERT INTO DonHangChiTiet(maSp,tenSp,gia,soLuong,maDh) VALUES ("+arr.get(i).getMaSp()+",N'"
                                    +arr.get(i).getTenSp()+"',"+arr.get(i).getGia()+","+arr.get(i).getSoLuong()+","+arr.get(i).getMaDh()+")";
                  System.out.println(query);
                    
                    stm.execute(query);

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(donHangModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
       
    public static ArrayList<billDTO> getAllarr(int maDh) {
        ArrayList<billDTO> arr = new ArrayList<>();
        Connection conn = connectDb.openConnect();
        if (conn!=null) {
            try {
                String query = "SELECT * FROM DonHang dh INNER JOIN DonHangChiTiet dhct ON dh.maDh = dhct.maDh AND dhct.maDh ="+maDh;
                Statement stm = conn.createStatement();
                System.out.println(query);
                ResultSet rs = stm.executeQuery(query);
                while(rs.next()) {
                    int maSp = Integer.valueOf(rs.getString("maSp"));
                    String tenSp = rs.getString("tenSp");
                    Float gia = Float.valueOf(rs.getString("gia"));
                    int soLuong = Integer.valueOf(rs.getString("soLuong"));
                    
                    billDTO bill = new billDTO(maSp,tenSp,gia,soLuong,maDh);
                    arr.add(bill);
                    System.out.println(query);
                }
            conn.close();
            return arr;    
            } catch (SQLException ex) {
                return arr;    
            }
        }
        return arr;
    }

    public static billDTO getAll(int maDh) {
        Connection conn = connectDb.openConnect();
        if (conn!=null) {
            try {
                String query = "SELECT * FROM DonHang dh INNER JOIN DonHangChiTiet dhct ON dh.maDh = dhct.maDh AND dhct.maDh ="+maDh;
                Statement stm = conn.createStatement();
                System.out.println(query);
                ResultSet rs = stm.executeQuery(query);
                billDTO bill = new billDTO();
                while(rs.next()) {
                    
                    String tenKh = rs.getString("tenKh");
                    int sdt = Integer.valueOf(rs.getString("sdt"));
                    String diaChi = rs.getString("diaChi"); 
                    String ngayNhanHang = rs.getString("ngayNhanHang");
                    int tinhTrang = Integer.valueOf(rs.getString("tinhTrang"));
                    Float tongTien = Float.valueOf(rs.getString("tongTien"));
                    bill = new billDTO(maDh,tenKh,sdt,diaChi,ngayNhanHang,tinhTrang,tongTien);
                    System.out.println(query);
                }
            conn.close();
            return bill;    
            } catch (SQLException ex) {
                return null;    
            }
        }
        return null;
    }    
}


