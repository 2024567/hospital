/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;
import java.util.*;

/**
 *
 * @author sorgi
 */
public class test {
    public static final String[] FIRST_NAMES = {
        "Бат", "Сараа", "Оюунаа", "Тэмүүлэн", "Мөнх", "Энхжин", "Жавхлан", "Төгөлдөр", "Сувд", "Ганболд"
    };
    public static final String[] LAST_NAMES = {
        "Батбаатар", "Эрдэнэ", "Нямжав", "Отгон", "Сайнбаяр", "Лхагвасүрэн", "Цэцгээ", "Очирбат", "Нандин", "Цогбадрах"
    };
    
    public static void main(String[] args) {
        System.out.println("dsadsa");
        
        
        List<String> names = FileHandler.readNamesFromFile("src/CA_2/Applicants_Form.txt");
        List<String> sortedNames = sorter.mergeSort(names);
        List<Employee> employees = new ArrayList<>();
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
        
        //1. Нэр авах
        System.out.println("Ажилтны нэр: ");
        String name = scanner.nextLine();
        
        //2.Менежер төрөл сонгох
        System.out.println("Менежерийн төрлийг сонгоно уу:");
        ManagerType[] managerTypes = ManagerType.values();
        for(int i=0 ; i< managerTypes.length;i++){
            System.out.println((i+1) + ". " + managerTypes[i]);   
        }
        
        int managerChoice = getValidChoice(scanner, managerTypes.length);
        ManagerType managerType = managerTypes[managerChoice - 1];
        
        //3. Хэлтэс сонгох
        System.out.println("Хэлтсийг сонгоно уу:");
        DepartmentName[] departments= DepartmentName.values();
        for(int i=0; i < departments.length;i++){
            System.out.println((i + 1) + ". " + departments[i]);
        }
        
        int deptChoice = getValidChoice(scanner, departments.length);
        DepartmentName department = departments[deptChoice - 1];
        
        //4. employee үүсгээд жагсаалт руу нэмэх
        Employee newEmployee = new Employee(name, managerType, department);
        employees.add(newEmployee);
        
        
        System.out.println("Амжилттай нэмэгдлээ: " + newEmployee);
        
        System.out.println("*******************************************************");
        
        System.out.print("Хэдэн санамсаргүй ажилтан үүсгэх вэ? ");
        int count = scanner.nextInt();
        scanner.nextLine();
        
        for(int i = 0 ; i < count ; i++){
            Employee randomEmp = generateRandomEmployee();
            employees.add(randomEmp);
            System.out.println("+ " + randomEmp);
        }
        
        for(Employee e: employees){
            System.out.println(e);
        }
        
        
    }
    
    public static int getValidChoice(Scanner scanner, int maxOption){
        int choice = -1;
        while (choice<1 || choice > maxOption){
            System.out.println("Сонголтоо оруулна уу (1-" + maxOption + "): ");
            if(scanner.hasNextInt()){
                choice = scanner.nextInt();
                
                scanner.nextLine();// newline залгих
            } else {
                System.out.println("Буруу утга. Дахин оролдоно уу.");
                scanner.nextLine();
            }
        }
        return choice;
    }
    public static Employee generateRandomEmployee(){
        Random rand = new Random();
        
        String first = FIRST_NAMES[rand.nextInt(FIRST_NAMES.length)];
        String last = LAST_NAMES[rand.nextInt(LAST_NAMES.length)];
        String fullName = first + " " + last;
        
        ManagerType manager = ManagerType.values()[rand.nextInt(ManagerType.values().length)];
        DepartmentName department = DepartmentName.values()[rand.nextInt(DepartmentName.values().length)];
        
        return new Employee(fullName, manager, department);
    }
    
}
