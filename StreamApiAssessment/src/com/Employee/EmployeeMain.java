package com.Employee;

public class EmployeeMain {
    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        System.out.print("Average Salary: ");
        System.out.println(service.calculateAvgSalary());
        System.out.println();

        System.out.print("Max Salary of Employee in Each Department: ");
        service.getMaxSalaryOfDepartments();
        System.out.println();

        System.out.print("Total Salary per Department: ");
        service.totalSalaryPerDepartment();
        System.out.println();

        System.out.println("Employee Names and Salary: ");
        service.displayEmployeeNameAndSalary();
        System.out.println();

        System.out.println("Employees Sorted by Salary: ");
        service.sortBySalaryDescending();
    }
}
