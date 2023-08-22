/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class GradeDAO {

    List<Grade> ls = new ArrayList<>();

    public int add(Grade g) {
//        ls.add(d);
//        return 1;

        Connection conn = null;
        PreparedStatement sttm = null;

        try {
            String sSQL = "insert into Grade(MaSV, AnhVan, TinHoc, GDTC, Sinh, Tin, CongNghe, NguVan, DiaLy, LichSu, CongDan) \n"
                    + "values(?,?, ?, ?,?,?,?,?,?,?,?)";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, g.getSv().getMaSV());
            sttm.setDouble(2, g.getAnhVan());
            sttm.setDouble(3, g.getTinHoc());
            sttm.setDouble(4, g.getGdtc());
            sttm.setDouble(5, g.getSinh());
            sttm.setDouble(6, g.getTin());
            sttm.setDouble(7, g.getCongNghe());
            sttm.setDouble(8, g.getNguVan());
            sttm.setDouble(9, g.getDiaLy());
            sttm.setDouble(10, g.getLichSu());
            sttm.setDouble(11, g.getCongDan());

            if (sttm.executeUpdate() > 0) {
                System.out.println("Insert thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return -1;
    }

    public List<Grade> getAllGrade() {
        //return ls;
        List<Grade> ls = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement sttm = null;
        Connection conn = null;

        try {
            String sSQL = "SELECT dbo.Grade.MaSV, dbo.SinhVien.TenSV, dbo.Grade.AnhVan, dbo.Grade.TinHoc, dbo.Grade.GDTC, dbo.Grade.Sinh, dbo.Grade.Tin, dbo.Grade.CongNghe, dbo.Grade.NguVan, dbo.Grade.DiaLy, dbo.Grade.LichSu, dbo.Grade.CongDan\n"
                    + "FROM   dbo.Grade INNER JOIN\n"
                    + "             dbo.SinhVien ON dbo.Grade.MaSV = dbo.SinhVien.MaSV";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            rs = sttm.executeQuery();
            while (rs.next()) {
                Grade g = new Grade();
                g.setSv(new SinhVien(rs.getString(1), rs.getString(2)));
                g.setAnhVan(rs.getDouble(3));
                g.setTinHoc(rs.getDouble(4));
                g.setGdtc(rs.getDouble(5));
                g.setSinh(rs.getDouble(6));
                g.setTin(rs.getDouble(7));
                g.setCongNghe(rs.getDouble(8));
                g.setNguVan(rs.getDouble(9));
                g.setDiaLy(rs.getDouble(10));
                g.setLichSu(rs.getDouble(11));
                g.setCongDan(rs.getDouble(12));

                ls.add(g);

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
        }
        return ls;
    }

    public Grade getOneGradeByMaSV(String masv) {
//        for (Grade d : ls) {
//            if (d.getSv().getMaSV().equalsIgnoreCase(masv)) {
//                return d;
//            }
//        }
//        return null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement sttm = null;
        // Grade st = new Grade();
        try {
            String sSQL = "SELECT dbo.Grade.MaSV, dbo.SinhVien.TenSV, dbo.Grade.AnhVan, dbo.Grade.TinHoc, dbo.Grade.GDTC,  dbo.Grade.Sinh, dbo.Grade.Tin, dbo.Grade.CongNghe, dbo.Grade.NguVan, dbo.Grade.DiaLy, dbo.Grade.LichSu, dbo.Grade.CongDan\n"
                    + "FROM   dbo.Grade INNER JOIN\n"
                    + "             dbo.SinhVien ON dbo.Grade.MaSV = dbo.SinhVien.MaSV where Grade.MaSv = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, masv);
            rs = sttm.executeQuery();
            while (rs.next()) {
                Grade g = new Grade();
                g.setSv(new SinhVien(rs.getString(1), rs.getString(2)));
                g.setAnhVan(rs.getDouble(3));
                g.setTinHoc(rs.getDouble(4));
                g.setGdtc(rs.getDouble(5));
                g.setSinh(rs.getDouble(6));
                g.setTin(rs.getDouble(7));
                g.setCongNghe(rs.getDouble(8));
                g.setNguVan(rs.getDouble(9));
                g.setDiaLy(rs.getDouble(10));
                g.setLichSu(rs.getDouble(11));
                g.setCongDan(rs.getDouble(12));

                return g;

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        } finally {
            try {
                rs.close();
                sttm.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
        }
        return null;
    }

    public int updateGrade(Grade g) {
//        for (Grade d : ls) {
//            if (d.getSv().getMaSV().equalsIgnoreCase(dNew.getSv().getMaSV())) {
//                d.setAnhVan(dNew.getAnhVan());
//                d.setGdtc(dNew.getGdtc());
//                d.setTinHoc(dNew.getTinHoc());
//                return 1;
//
//            }
//
//        }
//        return -1;
        Connection conn = null;
        PreparedStatement sttm = null;

        try {
            String sSQL = "update Grade set AnhVan=?, TinHoc=?, GDTC=? , Sinh=?, Tin=?, CongNghe=?, NguVan=?, DiaLy=?, LichSu=?, CongDan=? where MaSV=?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(11, g.getSv().getMaSV());
            sttm.setDouble(1, g.getAnhVan());
            sttm.setDouble(2, g.getTinHoc());
            sttm.setDouble(3, g.getGdtc());
            sttm.setDouble(4, g.getSinh());
            sttm.setDouble(5, g.getTin());
            sttm.setDouble(6, g.getCongNghe());
            sttm.setDouble(7, g.getNguVan());
            sttm.setDouble(8, g.getDiaLy());
            sttm.setDouble(9, g.getLichSu());
            sttm.setDouble(10, g.getCongDan());

            if (sttm.executeUpdate() > 0) {
                System.out.println("Update thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return -1;
    }

    public int delGrade(String maSV) {
//        Grade d = getOneGradeByMaSV(masv);
//        if (d != null) {
//            ls.remove(d);
//            return 1;
//        }
//        return -1;

        Connection conn = null;
        PreparedStatement sttm = null;

        try {
            String sSQL = "delete Grade where MaSV=?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSV);

            if (sttm.executeUpdate() > 0) {
                System.out.println("Delete thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return -1;
    }

    public Grade getAtPosition(int pos) {
        return ls.get(pos);
    }
}
