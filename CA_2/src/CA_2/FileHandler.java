/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

import java.io.*;
import java.util.*;

/**
 *
 * @author sorgi
 */
public class FileHandler {
    public static List<String> readNamesFromFile(String filename) {
        List<String> names = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine()) !=null){
                if (!line.trim().isEmpty()){
                    names.add(line.trim());
                }
            }
            System.out.println("File read successfully!");
        }catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
        return names;
    }
    
}
