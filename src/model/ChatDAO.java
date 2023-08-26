/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author HP
 */
public class ChatDAO {

    List<Chat> ls = new ArrayList<>();

    public int add(Grade g) {
//        ls.add(d);
//        return 1;

        Connection conn = null;
        PreparedStatement sttm = null;

        try {
            String sSQL = "insert into Chat (MaSV, AnhVan, TinHoc, GDTC, Sinh, Tin, CongNghe, NguVan, DiaLy, LichSu, CongDan) \n"
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

    public List<Chat> getAllChat() {
        //return ls;
        List<Chat> ls = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement sttm = null;
        Connection conn = null;

        try {
            String sSQL = "SELECT * from Chat";
         conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            rs = sttm.executeQuery();
            while (rs.next()) {
                Chat g = new Chat();
               // g.setSv(new SinhVien(rs.getString(1), rs.getString(2)));
               

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

}
