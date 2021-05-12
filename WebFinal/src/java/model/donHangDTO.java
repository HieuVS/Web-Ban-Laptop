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
public class donHangDTO {
    private int maDh;
    private String tenKh;
    private int sdt;
    private String diaChi;
    private String ngayNhanHang;
    private int tinhTrang;
    private float tongTien;

    public donHangDTO(int maDh, String tenKh, int sdt, String diaChi, String ngayNhanHang, int tinhTrang, float tongTien) {
        this.maDh = maDh;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngayNhanHang = ngayNhanHang;
        this.tinhTrang = tinhTrang;
        this.tongTien = tongTien;
    }
    public donHangDTO(String tenKh, int sdt, String diaChi, String ngayNhanHang, int tinhTrang, float tongTien) {
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngayNhanHang = ngayNhanHang;
        this.tinhTrang = tinhTrang;
        this.tongTien = tongTien;
    }
    
    public int getMaDh() {
        return maDh;
    }

    public void setMaDh(int maDh) {
        this.maDh = maDh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgayNhanHang() {
        return ngayNhanHang;
    }

    public void setNgayNhanHang(String ngayNhanHang) {
        this.ngayNhanHang = ngayNhanHang;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }
    
    
}
