/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import database.DatabaseUtils;
import java.text.SimpleDateFormat;

/**
 *
 * @author HP
 */
public class SinhVienDAO {

    SimpleDateFormat format_date = new SimpleDateFormat("yyyy/MM/dd");

    public static List<SinhVien> ls = new ArrayList<>();

//    public SinhVienDAO() {
//        ls.add(new SinhVien("PD01", "A1"));
//        ls.add(new SinhVien("PD02", "A2"));
//        ls.add(new SinhVien("PD03", "A3"));
//        ls.add(new SinhVien("PD04", "A4"));
//        ls.add(new SinhVien("PD05", "A5"));
//        ls.add(new SinhVien("PD06", "A6"));
//        
//        
//    }
    public int add(SinhVien sv) {
//        ls.add(sv);
//        return 1;
        Connection conn = null;
        PreparedStatement sttm = null;

        try {
            String sSQL = "insert into SinhVien(MaSV, TenSV, NgaySinh, GioiTinh,DiaChi, HinhAnh, Lop) \n"
                    + "values(?,?, ?, ?, ?, ?,?)";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, sv.getMaSV());
            sttm.setString(2, sv.getTenSV());
            sttm.setString(3, format_date.format(sv.getNgaySinh()));
            sttm.setBoolean(4, sv.isGioiTinh());
            sttm.setString(5, sv.getDiaChi());
            sttm.setString(6, sv.getHinhAnh());
            sttm.setString(7, sv.getLop());
            if (sttm.executeUpdate() > 0) {
                System.out.println("Insert thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return -1;

    }

    public int updateSinhVienByID(SinhVien sv) {
//        ls.add(sv);
//        return 1;
        Connection conn = null;
        PreparedStatement sttm = null;

        try {
            String sSQL = "update SinhVien set TenSV=?, NgaySinh=?, GioiTinh=?, DiaChi=?, HinhAnh=?, Lop=? where MaSV=?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(7, sv.getMaSV());
            sttm.setString(1, sv.getTenSV());
            sttm.setString(2, format_date.format(sv.getNgaySinh()));
            sttm.setBoolean(3, sv.isGioiTinh());
            sttm.setString(4, sv.getDiaChi());
            sttm.setString(5, sv.getHinhAnh());
            sttm.setString(6, sv.getLop());
            if (sttm.executeUpdate() > 0) {
                System.out.println("Update thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return -1;

    }

    public List<SinhVien> getAllSinhVien() {
//        return ls;
        List<SinhVien> ls = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement sttm = null;
        Connection conn = null;

        try {
            String sSQL = "select * from SinhVien";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            rs = sttm.executeQuery();
            while (rs.next()) {
                SinhVien st = new SinhVien();
                st.setMaSV(rs.getString(1));
                st.setTenSV(rs.getString(2));
                st.setNgaySinh(rs.getDate(3));
                st.setGioiTinh(rs.getBoolean(4));
                st.setDiaChi(rs.getString(5));
                st.setHinhAnh(rs.getString(6));
                st.setLop(rs.getString(7));

                ls.add(st);

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

    public int delSinhVienByID(String maSV) {
//        for (SinhVien sv : ls) {
//            if (sv.getMaSV().equalsIgnoreCase(ma)) {
//                ls.remove(sv);
//                return 1;
//            }
//        }
//        return -1;
        Connection conn = null;
        PreparedStatement sttm = null;

        try {
            String sSQL = "delete SinhVien where MaSV = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, maSV);

            if (sttm.executeUpdate() > 0) {
                System.out.println("Xóa thanh cong");
                return 1;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

        return -1;
    }

    public SinhVien getSinhVienByID(String MaSV) {
//        for (SinhVien sv : ls) {
//            if (sv.getMaSV().equalsIgnoreCase(id)) {
//                return sv;
//            }
//        }
//        return null;
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement sttm = null;
        SinhVien st = new SinhVien();
        try {
            String sSQL = "select * from SinhVien where MaSV= ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, MaSV);
            rs = sttm.executeQuery();
            while (rs.next()) {

                st.setMaSV(rs.getString(1));
                st.setTenSV(rs.getString(2));
                st.setNgaySinh(rs.getDate(3));
                st.setGioiTinh(rs.getBoolean(4));
                st.setDiaChi(rs.getString(5));
                st.setHinhAnh(rs.getString(6));
                st.setLop(rs.getString(7));
                return st;

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

//    public int updateSinhVienByID(SinhVien svNew) {
//        for (SinhVien sv : ls) {
//            if (sv.getMaSV().equalsIgnoreCase(svNew.getMaSV())) {
//
//                sv.setDiaChi(svNew.getDiaChi());
//                sv.setGioiTinh(svNew.isGioiTinh());
//                sv.setHinhAnh(svNew.getHinhAnh());
//                sv.setNgaySinh(svNew.getNgaySinh());
//                sv.setTenSV(svNew.getTenSV());
//                return 1;
//            }
//        }
//        return -1;
//    }
}
