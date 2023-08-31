/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;
import java.util.List;
import model.Grade;

/**
 *
 * @author HP
 */
public class FileJSON {

    public static void writeJsonFile(List<Grade> list1) throws IOException {
        FileWriter fw = null;

        try {
            fw = new FileWriter("D:\\json-server\\db.json");
            Gson gson = new Gson();

            List<Grade> list = new ArrayList<>();

            for (Grade item : list1) {

                list.add(item);

            }

            GradeWrapper gradeWrapper = new GradeWrapper(list1);

            String data = gson.toJson(gradeWrapper);

            // String data = gson.toJson(list);
            fw.write(data);
        } finally {
            if (fw != null) {
                fw.close();
            }

        }
    }

}
