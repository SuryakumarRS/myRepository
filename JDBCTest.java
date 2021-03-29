package training21;

import java.sql.*;

public class JDBCTest{
	
		static Connection con;
		JDBCTest() throws SQLException{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicmanagement","root","tiger");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		static ResultSet returnDoc(String special) {
			ResultSet rs=null;
			try {
				Statement stmt=con.createStatement();
				rs=stmt.executeQuery("select * from DoctorMaster where Speciality='"+special+"';");	
			}catch(Exception e){ System.out.println(e);}
		return rs; 
		}

		static ResultSet returnSpec() {
			ResultSet rs =null;
			try {
				Statement stmt=con.createStatement();
				rs= stmt.executeQuery("select Speciality from DoctorMaster union select Speciality from DoctorMaster;");
				
			}catch(Exception e){ System.out.println(e);}
			return rs; 
		}
		
		public static void writeDB(String doctor,String slot){
			try {
				PreparedStatement stmt=con.prepareStatement("update DoctorMaster set "+slot+"=1 where DoctorName = '"+doctor+"';");
				stmt.executeUpdate();
			}catch(Exception e) {System.out.println(e);}
		}
		
		static void createDB(String patient,String speciality,String doctor,String slot) {
			try {
				PreparedStatement stmt=con.prepareStatement("insert into patientRecord values (?,?,?,?)");
				stmt.setString(1,patient);
				stmt.setString(2,speciality);
				stmt.setString(3,doctor);
				stmt.setString(4,slot);
				stmt.executeUpdate();
			}catch(Exception e) {System.out.println(e);}	
		}

}