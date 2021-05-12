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
public class gioHangDTO {
    private int maSp;
    private String tenSp;
    private String anh;
    private float gia;
    private int soLuong;

    public gioHangDTO(int maSp, String tenSp, String anh, float gia, int soLuong) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.anh = anh;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}
