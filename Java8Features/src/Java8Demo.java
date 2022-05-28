import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8Demo {

	public static void main(String[] args) {
		// How many male and female employees are there in the organization?
		Map<String, Long> noOfMaleAndFemaleEmployees = EmployeeList.getEmployeeList().stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(noOfMaleAndFemaleEmployees);

		//Find Male and Female count on each department
		Map<String, Map<String, Long>> noOfMaleFemalOnEachDept = EmployeeList.getEmployeeList().stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.groupingBy(Employee::getGender, Collectors.counting())));
		System.out.println("No Of Male and Female employees on each department............");
		noOfMaleFemalOnEachDept.entrySet().forEach(data ->{
			System.out.println(data);
		});
		
		//Print employees count on each department
		Map<String, Long> empList = EmployeeList.getEmployeeList().stream()
				.collect(Collectors.groupingBy(Employee::getDepartment , Collectors.counting()));
		System.out.println("Employees count on each department...................");
		System.out.println(empList);
		
		// Print employees on each department
		Map<String, List<Employee>> employeesOnEachDept = EmployeeList.getEmployeeList().stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
		System.out.println("Employees on each department...................");
		employeesOnEachDept.entrySet().forEach(employees ->{
			System.out.println(employees);
		});
		
		
		//Count Active and Inactive employees on each dept
		Map<String, Long> activeInactiveeEmpOnEachDept = EmployeeList.getEmployeeList().stream()
				.collect(Collectors.groupingBy(Employee::getStatus, Collectors.counting()));
		System.out.println("Employees on each department...................");
		activeInactiveeEmpOnEachDept.entrySet().forEach(employees ->{
			System.out.println(employees);
		});
		
		Map<String, Optional<Employee>> maxSalaryEmpOnEachDept = EmployeeList.getEmployeeList().stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		System.out.println("Employees on each department...................");
		
		maxSalaryEmpOnEachDept.entrySet().forEach(employees ->{
			System.out.println(employees);
		});
	}
}
