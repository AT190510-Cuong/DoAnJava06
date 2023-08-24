/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HP
 */
public class Grade {

    private int id;
    private SinhVien sv;
    private double anhVan, tinHoc, gdtc;
//    private double toan;
//    private double ly;
//    private double hoa;
    private double sinh;
    private double tin;
    private double congNghe;
    private double nguVan;
    private double diaLy;
    private double lichSu;
    private double congDan;

    public Grade() {
    }

    public Grade(int id, SinhVien sv, double anhVan, double tinHoc, double gdtc, double sinh, double tin, double congNghe, double nguVan, double diaLy, double lichSu, double congDan) {
        this.id = id;
        this.sv = sv;
        this.anhVan = anhVan;
        this.tinHoc = tinHoc;
        this.gdtc = gdtc;
        this.sinh = sinh;
        this.tin = tin;
        this.congNghe = congNghe;
        this.nguVan = nguVan;
        this.diaLy = diaLy;
        this.lichSu = lichSu;
        this.congDan = congDan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SinhVien getSv() {
        return sv;
    }

    public void setSv(SinhVien sv) {
        this.sv = sv;
    }

    public double getAnhVan() {
        return anhVan;
    }

    public void setAnhVan(double anhVan) {
        this.anhVan = anhVan;
    }

    public double getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(double tinHoc) {
        this.tinHoc = tinHoc;
    }

    public double getGdtc() {
        return gdtc;
    }

    public void setGdtc(double gdtc) {
        this.gdtc = gdtc;
    }

    public double getSinh() {
        return sinh;
    }

    public void setSinh(double sinh) {
        this.sinh = sinh;
    }

    public double getTin() {
        return tin;
    }

    public void setTin(double tin) {
        this.tin = tin;
    }

    public double getCongNghe() {
        return congNghe;
    }

    public void setCongNghe(double congNghe) {
        this.congNghe = congNghe;
    }

    public double getNguVan() {
        return nguVan;
    }

    public void setNguVan(double nguVan) {
        this.nguVan = nguVan;
    }

    public double getDiaLy() {
        return diaLy;
    }

    public void setDiaLy(double diaLy) {
        this.diaLy = diaLy;
    }

    public double getLichSu() {
        return lichSu;
    }

    public void setLichSu(double lichSu) {
        this.lichSu = lichSu;
    }

    public double getCongDan() {
        return congDan;
    }

    public void setCongDan(double congDan) {
        this.congDan = congDan;
    }

    public double getTBC() {
        return (getAnhVan() + getGdtc() + getTinHoc() + getSinh() + getTin() + getCongNghe() + getNguVan() + getDiaLy() + getLichSu() + getCongDan()) / 10;
    }

    public String getXepLoai() {
        String xl = "";
        double tbc = getTBC();
        if (tbc >= 8) {
            xl = "GIOI";
        } else if (tbc >= 6.5) {
            xl = "TIEN TIEN";
        } else if (tbc >= 5) {
            xl = "TRUNG BINH";
        } else {
            xl = "YEU";
        }
        return xl;

    }

    public String writeCSV(){
        String str = String.format("%s,%s,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%s\n", getSv().getMaSV(),getSv().getTenSV(),getAnhVan(),getTin(), getGdtc(), getSinh(), getTin(), getCongNghe(), getNguVan(), getDiaLy(), getLichSu(), getCongDan(),getTBC(), getXepLoai());
        return  str;
    }
}
