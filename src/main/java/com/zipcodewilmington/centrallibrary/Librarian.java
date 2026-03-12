package com.zipcodewilmington.centrallibrary;

import com.zipcodewilmington.centrallibrary.Library;
import com.zipcodewilmington.centrallibrary.LibraryItem;
import com.zipcodewilmington.centrallibrary.Person;

public class Librarian extends Person {
    private String employeeId;
    private String department;
    private double salary;

    public Librarian(String name, int age, String email, String phoneNumber, String employeeId, String department, double salary) {
        super(name, age, email, phoneNumber);
        setEmployeeId(employeeId);
        setDepartment(department);
        setSalary(salary);
    }

    public String getEmployeeId() {
        return employeeId;
    }
    public String getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }

public void setEmployeeId(String employeeId) {
        if (employeeId == null || employeeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty.");
        }
        this.employeeId = employeeId;
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be null or empty.");
        }
        this.department = department;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }
        this.salary = salary;
    }


public void addItemToLibrary(Library library, LibraryItem item) {
        library.addItem(item);
        System.out.println(getName() + " added: " + item.getTitle());
    }

    public void removeItemFromLibrary(Library library, LibraryItem item) {
        library.removeItem(item);
        System.out.println(getName() + " removed: " + item.getTitle());
    }
@Override
    public String toString() {
        return "Librarian{" +
                "employeeId='" + employeeId + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", email='" + getEmail() + '\'' +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                '}';
    }

}