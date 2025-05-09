/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author sorgi
 */
public class Employee {
    private String fullName;
    private ManagerType managerType;
    private DepartmentName department;
    private String position;
    private String jobTitle;

    public Employee(String fullName, ManagerType managerType, DepartmentName department, String position, String jobTitle) {
        this.fullName = fullName;
        this.managerType = managerType;
        this.department = department;
        this.position = position;
        this.jobTitle = jobTitle;
    }

    public String getFullName() {
        return fullName;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public DepartmentName getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s", fullName, managerType, department, position, jobTitle);
    }
} 