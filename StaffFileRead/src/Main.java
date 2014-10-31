import java.util.List;


public class Main {

	public static void main(String[] args) {
		String pathname = "D:\\MusalaSoft\\Java SE 6 Programmer certificate\\Java Software Development Training Materials\\Attachments\\StaffFileRead.txt";
		List<Employee> employees = EmployeeHandler.loadEmployeesFromFile(pathname);
		
		int averageAge = EmployeeHandler.getAverageEmployeeAge(employees);
		System.out.println("Average emplyee age is " + averageAge + ".");
		String mostCommon3Letters = EmployeeHandler.getFirstMostCommonLettersInNames(employees, 3);
		System.out.println("Most common first 3 letters are \"" + mostCommon3Letters + "\".");
		double averageLengthOfService = EmployeeHandler.getAverageLenghtOfService(employees);
		System.out.println("Average length of service is " + averageLengthOfService  + " years.");
		double maximumLenghtOfService = EmployeeHandler.getMaximumLengthOfService(employees);
		System.out.println("The maximum length of service in the company is " + maximumLenghtOfService + " years.");
	}

}
