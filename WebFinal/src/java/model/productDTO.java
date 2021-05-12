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
public class productDTO {
    int maSp;
    String tenSp;
    float gia;
    String moTa;
    String anh;

    public productDTO() {
    }

    public productDTO(String anh, String tenSp) {
        this.tenSp = tenSp;
        this.anh = anh;
    }

    
    public productDTO(int maSp, String tenSp, float gia, String moTa, String anh) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.gia = gia;
        this.moTa = moTa;
        this.anh = anh;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
}
