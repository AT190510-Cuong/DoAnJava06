/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import model.Grade;

/**
 *
 * @author HP
 */
public class FileCSV {

    private final String current = System.getProperty("user.dir");
    private final String separator = File.separator;
    private final String PATH_CSV_FILE = current + separator + "src" + separator + "file" + separator;

    public void write(List<Grade> list, String nameFile) {
        BufferedWriter bw;
        try {
            //  bw = new BufferedWriter(new FileWriter(PATH_CSV_FILE + nameFile + ".csv"));

            bw = new BufferedWriter(new FileWriter(nameFile + ".csv"));

            String str = "MaSinhVien,HovaTen,Toan,Ly,Hoa,Sinh,Tin,CongNghe,NguVan,DiaLy,LichSu,CongDan,DiemTB,XepLoai\n";
            bw.append(str);
            for (Grade grade : list) {
                bw.append(grade.writeCSV());
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
