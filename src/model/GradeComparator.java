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
public class GradeComparator implements Comparator<Grade> {

    @Override
    public int compare(Grade o1, Grade o2) {
        if (o1.getTBC() > o2.getTBC()) {
            return -1;
        } else if (o1.getTBC() == o2.getTBC()) {
            return 0;
        }
        return 1;
    }

}
