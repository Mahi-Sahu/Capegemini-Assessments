package streamAPIAssessment;

public class EmployeeMain {


    public static void main(String[] args) {

        EmployeeService service = new EmployeeService();

        System.out.println("Average Salary:");
        System.out.println(service.calculateAverageSalary());

        System.out.println("\nMax Salary Employee in Each Department:");
        service.maxSalaryEmployeeByDepartment();

        System.out.println("\nTotal Salary per Department:");
        service.totalSalaryPerDepartment();

        System.out.println("\nEmployee Name and Salary:");
        service.displayEmployeeNameAndSalary();

        System.out.println("\nEmployees Sorted by Salary (Descending):");
        service.sortBySalaryDescending();
    }


}