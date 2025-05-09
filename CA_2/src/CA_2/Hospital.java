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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Нийт нэрсийн тоо:" + names.size());
        for (String name : names){
            System.out.println(name);
        }
        System.out.println("*******************************************************");
        System.out.println("sorted нэрс:");
        for(int i = 0; i < sortedNames.size();i++){
            System.out.println(sortedNames.get(i));
        }
        System.out.println("*******************************************************");
        System.out.println("Хайх нэрийг оруулна уу: ");
        String targetName = scanner.nextLine();
        
        int index = Searcher.binarySearch(sortedNames, targetName);
        if(index >= 0){
            System.out.println("Нэр олдлоо:" + sortedNames.get(index));
            // Жишээ болгон рандом Manager/Department оноож харуулна
            ManagerType manager = ManagerType.values()[(int)(Math.random() * ManagerType.values().length)];
             DepartmentName department = DepartmentName.values()[(int)(Math.random() * DepartmentName.values().length)];

            System.out.println("Manager: " + manager);
            System.out.println("Department: " + department);
        } else {
            System.out.println("Хайсан нэр олдсонгүй.");
        }
        
    }
    
}
