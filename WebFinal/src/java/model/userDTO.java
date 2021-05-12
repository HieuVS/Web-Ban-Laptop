/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Hieu
 */
public class userDTO {
    private String username;
    private String password;
    private String hoTen;
    private int sdt;
    private String ngaySinh;
    private String diaChi;

    public userDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public userDTO() {
    }

    public userDTO(String hoTen, int sdt, String ngaySinh, String diaChi) {
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }
    
    
    public userDTO(String username, String password, String hoTen, int sdt, String ngaySinh, String diaChi) {
        this.username = username;
        this.password = password;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
}
