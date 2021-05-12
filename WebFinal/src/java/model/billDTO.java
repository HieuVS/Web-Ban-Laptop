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
public class billDTO {
    private int maDHCT;
    private int maSp;
    private String tenSp;
    private float gia;
    private int soLuong;   
    private int maDh;
    private String tenKh;
    private int sdt;
    private String diaChi;
    private String ngayNhanHang;
    private int tinhTrang;
    private float tongTien;

    public billDTO() {
    }

    public billDTO(int maSp, String tenSp, float gia, int soLuong, int maDh) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.gia = gia;
        this.soLuong = soLuong;
        this.maDh = maDh;
    }

    public billDTO(int maDh, String tenKh, int sdt, String diaChi, String ngayNhanHang, int tinhTrang, float tongTien) {
        this.maDh = maDh;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngayNhanHang = ngayNhanHang;
        this.tinhTrang = tinhTrang;
        this.tongTien = tongTien;
    }



    
    public billDTO(int maSp, String tenSp, float gia, int soLuong, int maDh, String tenKh, int sdt, String diaChi, String ngayNhanHang, int tinhTrang, float tongTien) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.gia = gia;
        this.soLuong = soLuong;
        this.maDh = maDh;
        this.tenKh = tenKh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngayNhanHang = ngayNhanHang;
        this.tinhTrang = tinhTrang;
        this.tongTien = tongTien;
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
