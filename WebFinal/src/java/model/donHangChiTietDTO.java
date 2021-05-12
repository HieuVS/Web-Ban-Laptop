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
public class donHangChiTietDTO {
    private int maDHCT;
    private int maSp;
    private String tenSp;
    private float gia;
    private int soLuong;
    private int maDh;

    public donHangChiTietDTO(int maDHCT, int maSp, String tenSp, float gia, int soLuong, int maDh) {
        this.maDHCT = maDHCT;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.gia = gia;
        this.soLuong = soLuong;
        this.maDh = maDh;
    }

    public donHangChiTietDTO(int maSp, String tenSp, float gia, int soLuong, int maDh) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.gia = gia;
        this.soLuong = soLuong;
        this.maDh = maDh;
    }
    
    
    public int getMaDHCT() {
        return maDHCT;
    }

    public void setMaDHCT(int maDHCT) {
        this.maDHCT = maDHCT;
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

    public int getMaDh() {
        return maDh;
    }

    public void setMaDh(int maDh) {
        this.maDh = maDh;
    }
    
}
