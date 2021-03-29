package training21;


import java.sql.*;
import java.util.ArrayList;

public class SlotBook extends JDBCTest{
	
	
	
	SlotBook() throws SQLException {
		super();
	}


	static ArrayList<String> returnSpeciality() throws SQLException {
		
		ArrayList<String> nameList = new ArrayList<String>();
		ResultSet special=null;
		special = JDBCTest.returnSpec();
		while(special.next()) {
		    nameList.add(special.getString(1));
		}
		return nameList;
	}
	
	static ArrayList<DoctorSlots> returnDoctor(String spec) throws SQLException {
		
		ArrayList<DoctorSlots> nameList = new ArrayList<DoctorSlots>();
		ResultSet doctor=null;
		
		doctor = JDBCTest.returnDoc(spec);
		
		while(doctor.next()) {
			DoctorSlots ds= new DoctorSlots(doctor.getString(2), doctor.getString(4), doctor.getString(5),doctor.getString(6),doctor.getString(7),doctor.getString(8),doctor.getString(9),doctor.getString(10),doctor.getString(11),doctor.getString(12),doctor.getString(13));
			nameList.add(ds);
		}
		return nameList;
	}
	
	void bookSlot(String doc,String slot) throws ClassNotFoundException {
		JDBCTest.writeDB(doc,slot);
	}
	
	void createData(String patient,String speciality,String doctor,String slot) {
		JDBCTest.createDB(patient,speciality,doctor,slot);
	}	
	
}
 class DoctorSlots {
	
	String doctorName,slot1,slot2,slot3,slot4,slot5,slot6,slot7,slot8,slot9,slot10;
	DoctorSlots(String doctorName,String slot1,String slot2,String slot3,String slot4,String slot5,String slot6,String slot7,String slot8,String slot9,String slot10) {
		this.doctorName=doctorName;
		this.slot1=slot1;
		this.slot2=slot2;
		this.slot3=slot3;
		this.slot4=slot4;
		this.slot5=slot5;
		this.slot6=slot6;
		this.slot7=slot7;
		this.slot8=slot8;
		this.slot9=slot9;
		this.slot10=slot10;
	}
}