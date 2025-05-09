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
    // Employee's full name
    private String fullName;
    // What type of manager they report to
    private ManagerType managerType;
    // Which department they work in
    private DepartmentName department;
    // Their level or position in the company (e.g. Junior, Senior)
    private String position;
    // Their job title (e.g. Nurse, Doctor, Clerk)
    private String jobTitle;
    
    
    /**
    * 
    *This constructor creates a new employee with full details.
    */
    public Employee(String fullName, ManagerType managerType, DepartmentName department, String position, String jobTitle) {
        this.fullName = fullName;
        this.managerType = managerType;
        this.department = department;
        this.position = position;
        this.jobTitle = jobTitle;
    }
    
    // Get the full name of the employee
    public String getFullName() {
        return fullName;
    }

    // Get the manager type
    public ManagerType getManagerType() {
        return managerType;
    }

    // Get the department name
    public DepartmentName getDepartment() {
        return department;
    }

    // Get the position level
    public String getPosition() {
        return position;
    }

    // Get the job title
    public String getJobTitle() {
        return jobTitle;
    }
    
    /**
    *This returns a short summary of the employee’s information.
    */
    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %s", fullName, managerType, department, position, jobTitle);
    }
} 