package streamAPIAssessment;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {

    List<Employee> empList = EmployeeRepository.getEmployees();


    public double calculateAverageSalary() {
        return empList.stream()
                .mapToDouble(e -> e.getSalary())
                .average()
                .orElse(0.0);
    }


    public void maxSalaryEmployeeByDepartment() {

        empList.stream().filter(e -> e.getDepartment() != null)
                .collect(Collectors.groupingBy(
                        e -> e.getDepartment().getDepartmentName()
                )).forEach((deptName, list) -> {

                    Employee maxEmp = list.stream().max((e1, e2) ->Double.compare(e1.getSalary(), e2.getSalary()))
                            .get();

                    System.out.println(deptName + " -> "
                            + maxEmp.getFirstName() + " "
                            + maxEmp.getLastName()
                            + " : " + maxEmp.getSalary());
                });
    }


    public void totalSalaryPerDepartment() {

        empList.stream()
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


    public void displayEmployeeNameAndSalary() {
        empList.stream()
                .forEach(e ->
                        System.out.println(
                                e.getFirstName() + " "
                                        + e.getLastName()
                                        + " : " + e.getSalary())
                );
    }


    public void sortBySalaryDescending() {
        empList.stream()
                .sorted((e1, e2) ->
                        Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(e ->
                        System.out.println(
                                e.getFirstName() + " "
                                        + e.getLastName()
                                        + " : " + e.getSalary())
                );
    }
}