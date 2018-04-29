import java.util.Scanner;

public class AppointmentManagementSystem {

	// declare AntiqueSales array and object count
	private static Appointment[] appointments = new Appointment[20];
	private static int appointmentCount = 0;

	// shared Scanner which can be used by all helper methods below
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		String selection;
		String userInput;

		do {

			// display menu options
			System.out.println("   ***** Appointment Management System Menu *****");
			System.out.println();
			System.out.println("A. Add New Appointment");
			System.out.println("B. List Appointments");
			System.out.println("C. View Appointment Summary");
			System.out.println("D. Check In Patient");
			System.out.println("E. Call Patient");
			System.out.println("F. Record Consultation");
			System.out.println("X. Exit the program");
			System.out.println();

			// prompt user to enter selection
			System.out.print("Enter selection: ");
			selection = input.nextLine();

			System.out.println();

			// validate selection input length
			if (selection.length() != 1) {
				System.out.println("Error - invalid selection!");
			} else {

				// process user's selection
				switch (selection.toUpperCase()) {
				case "A":
					addNewAppointment();
					
					break;

				case "B":
					displayAllAppointments();
					break;

				case "C":
					viewAppointmentSummary();
					break;

				case "D":
					checkInPatient();
					break;

				case "E":
					callPatient();
					break;

				case "F":
					recordConsultation();
					break;

				case "X":
					System.out.println("Exiting the program...");
					break;

				default:
					System.out.println("Error - invalid selection!");
				}
			}
			System.out.println();

		} while (!selection.equalsIgnoreCase("X"));
		appointmentCount = appointmentCount + 1;
	}

	/*
	 * void addNewAppointment() helper method which implements the functionality for
	 * adding a new Appointment to this AppointmentManagementSystem.
	 * 
	 * (implements Stage 2 Requirement A)
	 */
	private static void addNewAppointment() {
		System.out.println("*** Add New Appointment Feature ***");
		System.out.println("Please enter new appointment ID: ");

		// code for Stage 2 Requirement A) should go in here
		// ...

		String appointmentID, appointmentTime, patientName;
		boolean bulkBilling;

		appointmentID = input.nextLine();
		boolean idValid = ClinicDetails.isValidAppointmentID(appointmentID);

		// check return value
		// System.out.println(idValid);
		//checeks the appointment string is valid
		if (idValid == true) {

			// System.out.println(appointmentCount);
			System.out.println("Please enter Appointment Time");
			appointmentTime = input.nextLine();
			System.out.println("Please enter Patient Name");
			patientName = input.nextLine();
			System.out.println("Is this a bulk billing appointment?");
			bulkBilling = Boolean.valueOf(input.nextLine());

			Appointment appt = new Appointment(appointmentID, appointmentTime, patientName, bulkBilling);
			// System.out.print(appointments[appointmentCount]);
			appointments[appointmentCount] = appt;

			//increment the array to next position
			appointmentCount = appointmentCount + 1;

			//if appointment ID entered is not correct loop and ask for valid appointment ID
		} else if (idValid == false) {
			System.out.println("Please enter a valid Appointment ID");
			addNewAppointment();
		}

	}

	/*
	 * void displayAllAppointments() helper method which implements the
	 * functionality for displaying all Appointment details stored in this
	 * AppointmentManagementSystem.
	 * 
	 * (implements Stage 2 Requirement B)
	 */
	private static void displayAllAppointments() {
		System.out.println("*** Display All Appointments Feature ***");
		System.out.println();

		// code for Stage 2 Requirement B) should go in here
		// ...
		//go through array elements 0..end and call print details from appointment.java to return all details.
		for (int k = 0; k < appointmentCount; k++) {
			

			appointments[k].printDetails();

			
		}

	}

	/*
	 * TIP: You may want to consider implementing a helper method at this point
	 * which handles locating and returning the Application object with the
	 * specified appointment ID from the applications array, as this will avoid
	 * having to repeat your search code for every feature which incorporates a
	 * search below.
	 * 
	 * Note that this is not a strict requirement and repeating search code in each
	 * of the features below that require it is also perfectly acceptable.
	 */

	/*
	 * void viewAppointmentSummary() helper method which implements the
	 * functionality for viewing the information for a specified Appointment in this
	 * AppointmentManagementSystem.
	 * 
	 * (implements Stage 2 Requirement C)
	 */
	private static void viewAppointmentSummary() {
		System.out.println("*** View Appointment Summary Feature ***");
		System.out.println();

		// code for Stage 2 Requirement C) should go in here
		// ...

		String appointmentID;
		// int s = 0;
		//asks for user input to get appointment id to search for
		System.out.println("enter apointment Id to search");
		appointmentID = input.nextLine();
		
		//loops through array until user input matches appointment ID and return the details of the appointment
		//using the print details
		for (int i = 0; i < appointmentCount; i++) {
			if (appointmentID.equals(appointments[i].getAppointmentID())) {
				// System.out.println("true");
				appointments[i].printDetails();
			} else {
				//if hit the end of the array without a match, advised no matching appointment found
				if (i == appointmentCount - 1) {
					System.out.println("Appointment cannot be found");
				}

			}

		}

	}

	/*
	 * void checkInPatient() helper method which implements the functionality for
	 * checking in a patient who has a pending Appointment in this
	 * AppointmentManagementSystem.
	 * 
	 * (implements Stage 2 Requirement D)
	 */
	private static void checkInPatient() {

		System.out.println("*** Check In Patient Feature ***");
		System.out.println();

		// code for Stage 2 Requirement D) should go in here
		// ...

		String appointmentID;
		System.out.println("enter apointment Id to search");
		appointmentID = input.nextLine();
		for (int i = 0; i < appointmentCount; i++) {
			if (appointmentID.equals(appointments[i].getAppointmentID())) {
				
				//check if patient has already checked in
				if (appointments[i].checkIn() == false) {
					System.out.println("patient has already been checked in for this appointment");
					// checkInPatient();
				}
			
			} else {
				//if no matching appointment ID found
				if (i == appointmentCount - 1) {
					System.out.println("Appointment cannot be found");
				}

			}

		}

	}

	/*
	 * void updateTrackingHistory() helper method which implements the functionality
	 * for adding a new tracking entry for a Appointment in this
	 * AppointmentManagementSystem.
	 * 
	 * (implements Stage 2 Requirement E)
	 */
	private static void callPatient() {
		System.out.println("*** Call Patient Feature ***");
		System.out.println();

		// code for Stage 2 Requirement E) should go in here
		// ...

		String appointmentID;
		String roomNum;
		System.out.println("enter apointment Id to search");
		appointmentID = input.nextLine();
		//patient is to be checked, loop though array to find correct appointment
		for (int i = 0; i < appointmentCount; i++) {
			if (appointmentID.equals(appointments[i].getAppointmentID())) {

				//when corrent appointment is found, ask for room number
				System.out.print("enter room number:");
				roomNum = input.nextLine();
				if (appointments[i].callPatient(roomNum) == false) {
					System.out.println("patient cannot be called for this appointment");
				}
				;

			} else if (i == appointmentCount - 1) {
				System.out.println("Appointment cannot be found");
			}

		}

	}

	/*
	 * void completeDelivery() helper method which implements the functionality for
	 * completing the delivery of a Appointment in this AppointmentManagementSystem.
	 * 
	 * (implements Stage 2 Requirement E)
	 */
	private static void recordConsultation() {

		System.out.println("*** Record Consultation Feature ***");
		System.out.println();

		// code for Stage 2 Requirement F) should go in here
		// ...

		String consulNote = "";
		String appointmentID;
		String note;
		System.out.println("enter apointment Id to search");
		appointmentID = input.nextLine();
		for (int i = 0; i < appointmentCount; i++) {
			if (appointmentID.equals(appointments[i].getAppointmentID())) {

				System.out.println("Enter Note:");
				
				//take input from user until double enter is hit.
				
				do {
					note = input.nextLine();
					consulNote = consulNote + " " + note;
				} while (note.length() > 0);

				//if error, eg, patient not had appointment closed CLD, then return -1 as error and advice notes
				//cannot be recorded
				if (appointments[i].recordConsultation(consulNote) == -1) {
					System.out.println("Cannot update the tracking history");

				}
				System.out.println("success");
				System.out.print("Fee Payable is $");
				System.out.print(ClinicDetails.getClinicFee(appointmentID));
			} else {
				if (i == appointmentCount - 1) {
					System.out.println("Appointment cannot be found");
				}

			}

		}

	}

}
