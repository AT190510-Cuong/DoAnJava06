/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author HP
 */
public class SinhVien {
    private String maSV;
    private String TenSV;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String diaChi;
    private String hinhAnh;

    public SinhVien() {
    }

    public SinhVien(String maSV, String TenSV) {
        this.maSV = maSV;
        this.TenSV = TenSV;
    }
    
    

    public SinhVien(String maSV, String TenSV, Date ngaySinh, boolean gioiTinh, String diaChi, String hinhAnh) {
        this.maSV = maSV;
        this.TenSV = TenSV;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.hinhAnh = hinhAnh;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String TenSV) {
        this.TenSV = TenSV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "maSV=" + maSV + ", TenSV=" + TenSV + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", hinhAnh=" + hinhAnh + '}';
    }
    
    
    
    
}
