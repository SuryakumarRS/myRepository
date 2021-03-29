package training21;

import java.sql.*;
import java.util.*;

public class JdbcMain {

	public static void main(String[] args) throws SQLException {
		
		ArrayList<String> specialList = new ArrayList<String>();
		ArrayList<DoctorSlots> doctorList = new ArrayList<DoctorSlots>();
		String[] print = {"DoctorName  "," 9:00-9:30 ","9:30-10:00 ","10:00-10:30 ","10:30-11:00 ","11:00-11:30 ","11:30-12:00 ","12:00-12:30 ","12:30-1:00 ","1:00-1:30 ","1:30-2:00 "};
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the patient Name :");
		String patient = sc.next();
		
		System.out.println("The Speciality we provide : ");
		System.out.println("");
		SlotBook sb = new SlotBook();
		specialList =SlotBook.returnSpeciality();
		
		for(int i=0;i<specialList.size();i++)
			System.out.println(specialList.get(i));
		
		System.out.println("\nEnter the Speciality you need : ");
		String spec = sc.next();
		doctorList = SlotBook.returnDoctor(spec);
		for(int i=0;i<print.length;i++)
			System.out.print(print[i]);
		System.out.println("");
		for(int i=0;i<doctorList.size();i++)
			System.out.println(doctorList.get(i).doctorName+"\t"+doctorList.get(i).slot1+"          "+doctorList.get(i).slot2+"          "+doctorList.get(i).slot3+"          "+doctorList.get(i).slot4+"          "+doctorList.get(i).slot5+"          "+doctorList.get(i).slot6+"          "+doctorList.get(i).slot7+"          "+doctorList.get(i).slot8+"          "+doctorList.get(i).slot9+"         "+doctorList.get(i).slot10);

		System.out.println("\nEnter the Doctor you need : ");
		String doc = sc.next();
		System.out.println("\nEnter the Slot you need : ");
		String slot=sc.next();
		try {
			sb.bookSlot(doc,slot);
		} catch (ClassNotFoundException e) { System.out.println(e);}		
		sc.close();
		sb.createData(patient, spec, doc, slot);
		
		System.out.println("We are here to Serve you");
		System.out.println("Take your Seats and wait");
	}

}
