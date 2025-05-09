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
    
    public static final String[] FIRST_NAMES = {
        "Бат", "Сараа", "Оюунаа", "Тэмүүлэн", "Мөнх", "Энхжин", "Жавхлан", "Төгөлдөр", "Сувд", "Ганболд"
    };
    public static final String[] LAST_NAMES = {
        "Батбаатар", "Эрдэнэ", "Нямжав", "Отгон", "Сайнбаяр", "Лхагвасүрэн", "Цэцгээ", "Очирбат", "Нандин", "Цогбадрах"
    };
    
    public static void main(String[] args) {
        
        
        List<String> names = FileHandler.readNamesFromFile("src/CA_2/Applicants_Form.txt");
        List<String> sortedNames = sorter.mergeSort(names);
        List<Employee> employees = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.println("\n📋 Меню сонгоно уу:");
            for (int i = 0; i < MenuOption.values().length; i++) {
                System.out.println((i + 1) + ". " + MenuOption.values()[i]);
            } 
            
            int choice = getValidChoice(scanner, MenuOption.values().length);
            MenuOption selected = MenuOption.values()[choice - 1];
            
            switch (selected) {
                case SORT:
                    //List<String> names = employees.stream().map(Employee::getName).toList();
                    //List<String> sorted = sorter.mergeSort(names);
                    System.out.println("sorted нэрс:");
                    for(int i = 0; i < Math.min(20,sortedNames.size());i++){
                    System.out.println(sortedNames.get(i));
                     }
                    
                    break;

                case SEARCH:
                    System.out.print("Хайх нэр: ");
                    String target = scanner.nextLine();
//                    List<String> nameList = employees.stream().map(Employee::getName).toList();
//                    List<String> sortedList = sorter.mergeSort(nameList);
                    int index = Searcher.binarySearch(sortedNames, target);
                    if (index >= 0) {
                        System.out.println("Нэр олдлоо: " + sortedNames.get(index));
                    } else {
                        System.out.println("Хайсан нэр олдсонгүй.");
                    }
                    break;

                case ADD_EMPLOYEE:
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
                    break;

                case GENERATE_RANDOM:
                    System.out.print("Хэдэн ажилтан үүсгэх вэ? ");
                    int count = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < count; i++) {
                        Employee e = generateRandomEmployee();
                        employees.add(e);
                        System.out.println("➕ " + e);
                    }
                    break;
                
                case SHOW_EMPLOYEES:
                    System.out.println("📋 Ажилтны нийт жагсаалт:");
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    break;

                case EXIT:
                    System.out.println("Программыг дуусгалаа.");
                    return;
            
        }
        
        
        
        
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
    
    

