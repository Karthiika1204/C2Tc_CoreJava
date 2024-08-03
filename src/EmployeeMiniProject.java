import java.util.Scanner;
import java.sql.*;
public class EmployeeMiniProject {

	public static void main(String[] args) throws Exception {
		Scanner read=new Scanner(System.in);
		boolean exit = false;
		while(!exit)
		{
			System.out.println("Employee Management System");
            System.out.println("1. Insert Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Show Employee Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = read.nextInt();
            read.nextLine();
            switch (option) {
            case 1:
            	 int insertResult = EmployeeOperations.insert();
                 if (insertResult > 0) {
                     System.out.println("Employee inserted successfully.");
                 } else {
                     System.out.println("Error inserting employee.");
                 }
                 break;
            case 2:
            	int deleteResult = EmployeeOperations.delete();
                if (deleteResult > 0) {
                    System.out.println("Employee deleted successfully.");
                } else {
                    System.out.println("Error deleting employee.");
                }
                break;
            case 3:
            	
            	int updateResult = EmployeeOperations.update();
                if (updateResult > 0) {
                    System.out.println("Employee updated successfully.");
                } else {
                    System.out.println("Error updating employee.");
                }
                break;

            case 4:
            	EmployeeOperations.showTable();
                break;

            case 5: 
            	exit = true;
                System.out.println("Exit");
                break;

            default:
            	System.out.println("Invalid option. Please try again.");
                break;
                
                
                 
		}
	}
      read.close();
}
	
}