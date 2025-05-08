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
        System.out.println("Нийт нэрсийн тоо:" + names.size());
        for (String name : names){
            System.out.println(name);
        }
    }
    
}
