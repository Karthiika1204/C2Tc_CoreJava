import java.sql.*;
import java.util.Scanner;
public class EmployeeOperations {
	static Scanner read=new Scanner(System.in);
    public static int insert() throws Exception
    {
    	Connection con=DbConnection.dbconnect();
		String name,location,designation;
		int id;
		double salary;
		System.out.println("INSERTING");
		System.out.println("Enter employee id");
		id=read.nextInt();
		System.out.println("Enter employee Name:");
		name=read.nextLine();
		read.nextLine();
		System.out.println("Enter employee designation");
		 designation=read.nextLine();
		 System.out.println("Enter Employee salary");
		salary=read.nextDouble();
		read.nextLine();
		System.out.println("Enter employee location");
		location=read.nextLine();
		String query="insert into employe values(?,?,?,?,?)";
		PreparedStatement pt=con.prepareStatement(query);
		pt.setInt(1,id);
		pt.setString(2,name);
		pt.setString(3,designation );
		pt.setDouble(4, salary);
		pt.setString(5, location);
		int r1=pt.executeUpdate();
		pt.close();
		con.close();
		return r1;
	  }
    public static int update() throws Exception {
        Connection con = DbConnection.dbconnect();
        System.out.println("updation");
        System.out.println("Enter employee id:");
        int upt = read.nextInt();
        read.nextLine(); // Consume newline
        System.out.println("Enter the field you want to update:\n1.employee name\n2.designation\n3.salary\n4.location");
        int fil = read.nextInt();
        read.nextLine(); // Consume newline
        System.out.println("Enter the new value you want to change in the selected field:");
        String newValue = read.nextLine();

        String query = null;
        PreparedStatement pt = null;

        switch (fil) {
            case 1:
                query = "UPDATE employe SET em_name = ? WHERE id = ?";
                pt = con.prepareStatement(query);
                pt.setString(1, newValue);
                pt.setInt(2, upt);
                break;
            case 2:
                query = "UPDATE employe SET designation = ? WHERE id = ?";
                pt = con.prepareStatement(query);
                pt.setString(1, newValue);
                pt.setInt(2, upt);
                break;
            case 3:
                query = "UPDATE employe SET salary = ? WHERE id = ?";
                pt = con.prepareStatement(query);
                pt.setDouble(1, Double.parseDouble(newValue));
                pt.setInt(2, upt);
                break;
            case 4:
                query = "UPDATE employe SET location = ? WHERE id = ?";
                pt = con.prepareStatement(query);
                pt.setString(1, newValue);
                pt.setInt(2, upt);
                break;
            default:
                System.out.println("Invalid option");
                return 0;
        }

        int r2 = pt.executeUpdate();
        pt.close();
        con.close();
        return r2;
    }

    
    
    public static int delete() throws Exception
	
    {
    	Connection con=DbConnection.dbconnect();
    	int del,r;
    	System.out.println("Deletion");
		System.out.println("Enter employee id:");
		del=read.nextInt();
		String query="delete from employe where id=?";
		PreparedStatement pt=con.prepareStatement(query);
		pt.setInt(1,del);
	    r =pt.executeUpdate();
	    pt.close();
        con.close();
		return r;
		
    }
        public static void showTable() throws Exception
    {
 	   Connection con =DbConnection.dbconnect();
 	   String query = "select * from employe";
 	   PreparedStatement pt = con.prepareStatement(query);
 	   ResultSet r=pt.executeQuery();
 	   System.out.println("Employee details");
 	   while(r.next()) {
 		   int id=r.getInt("id");
 		   String name=r.getString("em_name");
 		  String designation=r.getString("designation");
 		  double salary=r.getFloat("salary");
 		  String location=r.getString("location");
 		 System.out.println("Employee ID: " + id + "\t" +"Name: " + name + "\t" +"Designation: " + designation + "\t" +"Salary: " + salary + "\t" + "Location: " + location);
 	   }
 		 r.close();
         pt.close();
         con.close();
                 
                 
 	   }
 	   
 	   
}
       
  

