package com.Employee;

//1. Calculate average salary.
//2. Find employee with maximum salary in each department.
//        3. Calculate total salary per department.
//4. Display employee name and salary.
//5. Sort by salary in descending order

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    List<Employee> employees;
    public EmployeeService() {
        employees = EmployeeRepository.getEmployees();
    }

    public double calculateAvgSalary() {
        return employees.stream()
                .mapToDouble(e->e.getSalary())
                .average()
                .orElse(0.0);
    }

    public void getMaxSalaryOfDepartments(){
        employees.stream().filter(e -> e.getDepartment() != null)
                .collect(Collectors.groupingBy(
                        e -> e.getDepartment().getDepartmentName()
                )).forEach((deptName, list) -> {

                    Employee maxEmp = list.stream()
                            .max((e1, e2) ->Double.compare(e1.getSalary(), e2.getSalary()))
                            .get();

                    System.out.println(deptName + " -> "
                            + maxEmp.getFirstName() + " "
                            + maxEmp.getLastName()
                            + " : " + maxEmp.getSalary());
                });
    }

    public void displayEmployeeNameAndSalary(){
        employees.stream()
            .forEach(e ->
                System.out.println(e.getFirstName() + " "
                                + e.getLastName()
                                + " : " + e.getSalary())
            );
    }

    public void totalSalaryPerDepartment() {

        employees.stream()
            .filter(e -> e.getDepartment() != null)
            .collect(Collectors.groupingBy(
                    e -> e.getDepartment().getDepartmentName()
            ))
            .forEach((deptName, list) -> {

                double total = list.stream()
                        .mapToDouble(e -> e.getSalary())
                        .sum();

                System.out.println(deptName + " : " + total);
            });
    }

    public void sortBySalaryDescending() {
        employees.stream()
            .sorted((e1, e2) ->
                    Double.compare(e2.getSalary(), e1.getSalary()))
            .forEach(e ->
                    System.out.println(e.getFirstName() + " " + e.getLastName() + " : " + e.getSalary()));
    }


}
