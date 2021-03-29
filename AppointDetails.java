package training21;
import java.sql.*;
public class AppointDetails {
		
	public static void main(String args[]){  
	
		print();
	}	
		
	static void print() {
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicmanagement","root","tiger");  				  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from patientRecord");  
			while(rs.next())  
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));  
			con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}
}
