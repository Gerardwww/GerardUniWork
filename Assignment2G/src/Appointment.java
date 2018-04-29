/*
 * class Appointment
 * 
 * A representation of a Appointment for a patient attending the 
 * Child Health Clinic.
 * 
 * You will need to implement the various elements of this class as desccribed
 * in Stage 1 of the Assignment 1 Specification.
 * 
 */
public class Appointment
{

   // write your code for the requirements described in Stage 1 here
   // ...
   //1a		
	private String appointmentID;
	private String clinicName;
	private String appointmentTime;
	private String appointmentStatus;
	private String roomNumber;
	private String patientName;
	private String consultationNotes;
	private boolean bulkBilling;
	private int consultationFee;
	
	//1b
	public Appointment(String appointmentID, String appointmentTime,
            String patientName, boolean bulkBilling)
	{
		this.appointmentID = appointmentID;
		this.appointmentTime = appointmentTime;
		this.patientName = patientName;
		this.bulkBilling = bulkBilling;
		
		this.appointmentStatus = "SCH";
		this.clinicName = ClinicDetails.getClinicName(appointmentID);
	}
	
	//1c
	public String getAppointmentID()
	{
		return this.appointmentID;
	}
	
	public String getClinicName()
	{
		return this.clinicName;
	}
	
	public String getAppointmentTime()
	{
		return this.appointmentTime;
	}
	
	public String getAppointmentStatus()
	{
		return this.appointmentStatus;
	}
	
	public String getPatientName()
	{
		return this.patientName;
	}
	
	//1d
	public boolean checkIn()
	{
		//sets the status from scheduled to checked in
		if(this.appointmentStatus=="SCH"){
			this.appointmentStatus="CHK";
			return true;
		}
		else {
			return false;
		}
	}
	
	//1e
	public boolean callPatient(String roomNumber)
	{
		//check to see if patient has already been called after checkin
		if(this.appointmentStatus!="CHK"){
			return false;
		}
		else{
			this.roomNumber=roomNumber;
			this.appointmentStatus="CLD";
			return true;
		}
	}
	
	//1f
	
	public int recordConsultation(String notes)
	{
		//checks if appointment status and returns either a 0 or -1 or the consultation fee
		if(this.appointmentStatus!="CLD"){
			return -1;
		}
		else{
			this.consultationNotes = notes;
			if(this.bulkBilling==true){
				this.appointmentStatus = "BBL";
				return 0;
			}
			else{
				this.consultationFee = ClinicDetails.getClinicFee(this.appointmentID);
				this.appointmentStatus = "PPE";
				return this.consultationFee;
			}
		}
	}
	
	//1g
	public void printDetails()
	{
		//prints out appointment details in full.
		System.out.println("****************************");
		System.out.print("Appointment ID: " + this.appointmentID);
		System.out.print(", ");
		System.out.println("Clinic Name: " + this.clinicName);
		System.out.print("Appointment Time: " + this.appointmentTime);
		System.out.print(", ");
		System.out.println("Status: " + this.appointmentStatus);

		System.out.print("Room: " + this.roomNumber);
		System.out.print(", ");
		System.out.print("Patient: " + this.patientName);
		System.out.print(", ");
		System.out.println("Bulk Billing: " + this.bulkBilling);
		System.out.println("Consultation Notes: ");
		System.out.println(this.consultationNotes);
		System.out.println("");
		System.out.println("Fee: " + this.consultationFee);
		System.out.println("****************************");
	}
	
}