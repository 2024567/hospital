/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CA_2;
import java.util.*;

/**
 *
 * @author sorgi
 */
public class Hospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> names = FileHandler.readNamesFromFile("src/CA_2/Applicants_Form.txt");
        List<String> sortedNames = sorter.mergeSort(names);
        System.out.println("Нийт нэрсийн тоо:" + names.size());
        for (String name : names){
            System.out.println(name);
        }
        System.out.println("*******************************************************");
        System.out.println("sorted нэрс:");
        for(int i = 0; i < sortedNames.size();i++){
            System.out.println(sortedNames.get(i));
        }
    }
    
}
