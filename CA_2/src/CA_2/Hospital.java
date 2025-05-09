/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CA_2;
import java.util.*;
import java.io.*;

/**
 *
 * @author sorgi
 */
public class Hospital {

    /**
     * This is where the program starts. It loads employee data and shows the menu.
     */ 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   
        // Read employee data from a file
        List<Employee> employees = readEmployeesFromCSV("src/CA_2/Applicants_Form.txt");

        // Keep showing the menu until the user exits
        while (true) {
            System.out.println("\n Please choose an Menu:");
            for (int i = 0; i < MenuOption.values().length; i++) {
                System.out.println((i + 1) + ". " + MenuOption.values()[i]);
            }

            int choice = getValidChoice(scanner, MenuOption.values().length);
            MenuOption selected = MenuOption.values()[choice - 1];

            switch (selected) {
                 // Get all employee names and sort them alphabetically
                case SORT:
                    List<String> allNames = new ArrayList<>();
                    for (Employee emp : employees) {
                        allNames.add(emp.getFullName());
                    }
                    List<String> sortedAll = sorter.mergeSort(allNames);
                    
                    // Show the first 20 sorted names
                    System.out.println("\n First 20 sorted names:");
                    for (int i = 0; i < Math.min(20, sortedAll.size()); i++) {
                        System.out.println(sortedAll.get(i));
                    }
                    break;

                case SEARCH:
                    // Search for a name using binary search and show details if found
                    List<String> searchable = new ArrayList<>();
                    for (Employee emp : employees) {
                        searchable.add(emp.getFullName());
                    }
                    List<String> sortedSearch = sorter.mergeSort(searchable);
                    System.out.print("Enter name to search: ");
                    String target = scanner.nextLine();
                    int index = Searcher.binarySearch(sortedSearch, target);
                    
                    if (index >= 0) {
                        System.out.println("Name found: " + sortedSearch.get(index));
                        // Show the full info of the matched employee
                        for (Employee emp : employees) {
                            if (emp.getFullName().equalsIgnoreCase(sortedSearch.get(index))) {
                                System.out.println(emp);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Name not found.");
                    }
                    break;

                case ADD_EMPLOYEE:
                    // Enter new employee details manually
                    System.out.println("Enter full name: ");
                    String fullName = scanner.nextLine();

                    // Choose manager type
                    System.out.println("Select Manager Type:");
                    ManagerType[] managerTypes = ManagerType.values();
                    for (int i = 0; i < managerTypes.length; i++) {
                        System.out.println((i + 1) + ". " + managerTypes[i]);
                    }
                    int managerChoice = getValidChoice(scanner, managerTypes.length);
                    ManagerType managerType = managerTypes[managerChoice - 1];

                    // Choose department
                    System.out.println("Select Department:");
                    DepartmentName[] departments = DepartmentName.values();
                    for (int i = 0; i < departments.length; i++) {
                        System.out.println((i + 1) + ". " + departments[i]);
                    }
                    int deptChoice = getValidChoice(scanner, departments.length);
                    DepartmentName department = departments[deptChoice - 1];

                    // Choose position level
                    System.out.println("Select Position Level:");
                    PositionLevel[] positions = PositionLevel.values();
                    for (int i = 0; i < positions.length; i++) {
                        System.out.println((i + 1) + ". " + positions[i]);
                    }
                    int posChoice = getValidChoice(scanner, positions.length);
                    String position = positions[posChoice - 1].toString();

                    // Choose job title
                    System.out.println("Select Job Title:");
                    JobTitle[] jobTitles = JobTitle.values();
                    for (int i = 0; i < jobTitles.length; i++) {
                        System.out.println((i + 1) + ". " + jobTitles[i]);
                    }
                    int titleChoice = getValidChoice(scanner, jobTitles.length);
                    String jobTitle = jobTitles[titleChoice - 1].toString();

                    // Make the new employee and add to the list
                    Employee newEmployee = new Employee(fullName, managerType, department, position, jobTitle);
                    employees.add(newEmployee);

                    System.out.println("Successfully added: " + newEmployee);
                    break;

                case GENERATE_RANDOM:
                    // Create random employees
                    System.out.print("How many employees to generate? ");
                    int count = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < count; i++) {
                        String fName = "Emp" + (employees.size() + 1);
                        ManagerType manager = ManagerType.values()[new Random().nextInt(ManagerType.values().length)];
                        DepartmentName dept = DepartmentName.values()[new Random().nextInt(DepartmentName.values().length)];
                        String pos = "senior";
                        String title = "Surgeon";
                        Employee e = new Employee(fName, manager, dept, pos, title);
                        employees.add(e);
                        System.out.println("+ " + e);
                    }
                    break;

                case SHOW_EMPLOYEES:
                    // Show all employees
                    System.out.println("All registered employees:");
                    for (Employee emp : employees) {
                        System.out.println(emp);
                    }
                    break;

                case EXIT:
                    // End the program
                    System.out.println("Exiting program.");
                    return;
            }
        }
    }
    
    /**
     * This reads employee data from a text file.
     * Each line has: name, manager type, department, position, job title
     */
    public static List<Employee> readEmployeesFromCSV(String filename) {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            reader.readLine(); // Skip the first line (headers)
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String fullName = parts[0].trim();
                    ManagerType managerType = ManagerType.valueOf(parts[1].trim().toUpperCase());
                    DepartmentName department = DepartmentName.valueOf(parts[2].trim().toUpperCase());
                    String position = parts[3].trim();
                    String jobTitle = parts[4].trim();

                    employees.add(new Employee(fullName, managerType, department, position, jobTitle));
                }
            }
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return employees;
    }
     /**
     * Ask the user until they give a valid number.
     */
    public static int getValidChoice(Scanner scanner, int maxOption) {
        int choice = -1;
        while (choice < 1 || choice > maxOption) {
            System.out.print("Enter choice (1-" + maxOption + "): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();// Clear the input line
            } else {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
            }
        }
        return choice;
    }
} 
    
    

