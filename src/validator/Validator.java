 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author HP
 */
public class Validator {

    public static boolean isEmpty(JTextField txtField, StringBuilder str, String msg) {
        String strField = txtField.getText().trim();
        if (strField.equals("")) {
            str.append(msg).append("\n");
            txtField.setBackground(Color.red);

            return false;
        }
        txtField.setBackground(Color.white);
        return true;
    }

    public static boolean isNumber(JTextField txtField, StringBuilder str, String msg) {
        if (!isEmpty(txtField, str, msg)) {
            return false;
        } else {
            try {
                Integer.parseInt(txtField.getText());
                txtField.setBackground(Color.white);

            } catch (Exception e) {
                System.out.println("ERROR: " + e.toString());
                str.append(msg).append("\n");
                txtField.setBackground(Color.red);

                return false;
            }
        }
        return true;
    }

    public static boolean isNumber(JTextField txtField, StringBuilder str, String msg, int type) {
        if (!isEmpty(txtField, str, msg)) {
            return false;
        } else {
            try {
                switch (type) {
                    case 0:
                        Integer.parseInt(txtField.getText());
                        txtField.setBackground(Color.white);
                        break;
                    case 1:
                        Double.parseDouble(
                                txtField.getText()
                        );
                        txtField.setBackground(Color.white);
                        break;
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.toString());
                str.append(msg).append("\n");
                txtField.setBackground(Color.red);

                return false;
            }
        }
        return true;
    }

    public static boolean isNumberMinMax(JTextField txtField, StringBuilder str, String msg, double min, double max , int type) {
        if (!isNumber(txtField, str, msg, type)) {
            return false;
        } else {
            switch (type) {
                case 0:
                    int numberInt = Integer.parseInt(txtField.getText());
                    if (numberInt < min || numberInt > max) {

                        str.append(msg).append("\n");
                        txtField.setBackground(Color.red);

                        return false;
                    }
                    break;
                case 1:
                    double  numberDouble = Double.parseDouble(txtField.getText());
                    if (numberDouble < min || numberDouble > max) {

                        str.append(msg).append("\n");
                        txtField.setBackground(Color.red);

                        return false;
                    }
                    break;

            }
        }
        txtField.setBackground(Color.white);
        return true;
    }

}
