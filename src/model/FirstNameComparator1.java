/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Comparator;

/**
 *
 * @author HP
 */
public class FirstNameComparator1 implements Comparator<SinhVien> {

    public String getLastName(String str) {
        String[] word = str.split(" ");

        String ten = word[0];
        return ten;
    }

    @Override
    public int compare(SinhVien o1, SinhVien o2) {

        String ten1 = getLastName(o1.getTenSV());
        String ten2 = getLastName(o2.getTenSV());
        return ten1.compareTo(ten2);
    }
}
