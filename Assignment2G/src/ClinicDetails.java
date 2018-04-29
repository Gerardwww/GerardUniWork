import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/*
 * ClinicFeeSchedule class
 * 
 * Existing class for identifying clinics and their corresponding fees based 
 * on appointment ID prefixes.
 * 
 * Available methods:
 * 
 * boolean isValidApptID(String apptID) - returns true if appointment ID is 
 *                                        valid (length >= 4, begins with one
 *                                        of specified clinic codes), otherwise
 *                                        returns false.
 *                                                                                                                     
 *                                        
 * String [] clinicCodeList()           - returns list of all valid clinic 
 *                                        codes
 * 
 * String getClinicName(String apptID)  - returns corresponding clinic name if
 *                                        apptID is valid, otherwise returns 
 *                                        null
 *                                       
 * int getClinicFee(String apptID)      - returns corresponding clinic fee if
 *                                        apptID is valid, otherwise returns 
 *                                        zero (0).
 *                                        
 * NOTE:
 * 
 * YOU DO NOT NEED TO UNDERSTAND HOW THESE METHODS WORK - ALL YOU NEED TO DO IS
 * CALL THEM WHEN REQUIRED TO VALIDATE APPOINTMENT ID'S, OR RETRIEVE CLINIC-
 * RELATED INFORMATION IN YOUR APPOINTMENT MANAGEMENT SYSTEM FEATURES.
 * 
 * USAGE INFORMATION IS INCLUDED IN THE HEADER COMMENT FOR EACH METHOD BELOW.
 * 
 */
public class ClinicDetails
{
   /**
    * boolean isValidAppointmentID(String appointmentID)
    * 
    * @param appointmentID - Appointment ID to be checked
    * @return true         - if appointment ID is valid
    * @return false        - if appointment ID is invalid 
    *                        (length < 4 or not beginning with a valid 
    *                         clinic code)                
    * Usage:
    * 
    *    String appointmentID = ... ;
    *    ...
    *    boolean idValid = ClinicDetails.isValidAppointmentID(appointmentID);
    *    ...
    */
   public static boolean isValidAppointmentID(String appointmentID)
   {
      return appointmentID.length() < 4 ||
             feeMap.keySet().contains(appointmentID.substring(0, 3));
   }


   /**
    * String [] getClinicCodeList()
    * 
    * @return array of String containing valid clinic codes
    * 
    * Usage:
    * 
    *    String [] clinicCodes = ClinicDetails.clinicCodeList();
    *    ...
    */
  
   public String [] clinicCodeList()
   {
      return (String []) clinicMap.keySet().toArray();
   }
   
   /**
    * String getClinicName(String apptID)
    * 
    * @param appointmentID       - Appointment ID to be checked
    * @return clinic name        - if appointment ID is valid
    * @return null               - if appointment ID is invalid
    * 
    * Usage:
    * 
    *    String appointID = ... ;
    *    ...
    *    String clinicName = ClinicDetails.getClinicName(appointmentID);
    *    ...
    */
   public static String getClinicName(String apptID)
   {
      if (!isValidAppointmentID(apptID))
         return null;
      else
         return clinicMap.get(apptID.substring(0, 3));
   }

   /**
    * String getClinicFee(String apptID)
    * 
    * @param apptID      - Appointment ID to be checked
    * @return clinic fee - if appointment ID is valid
    * @return 0          - if appointment ID is invalid
    * 
    * Usage:
    * 
    *    String appointmentID = ... ;
    *    ...
    *    int fee = ClinicDetails.getClinicFee(appointmentID);
    *    ...
    */
   public static int getClinicFee(String apptID)
   {
      if (!isValidAppointmentID(apptID))
         return 0;
      else
         return feeMap.get(apptID.substring(0, 3));
   }

   /*
    * NOTE:
    * 
    * YOU ARE NOT EXPECTED TO UNDERSTAND ANY OF THE CODE BELOW - JUST CALL THE METHODS
    * ABOVE AS NEEDED IN YOUR APPOINTMENT MANAGEMENT SYSTEM CLASS.
    */
   
   @SuppressWarnings("serial")
   private static final Map<String, Integer> feeMap =
            Collections.unmodifiableSortedMap(new TreeMap<String, Integer>()
            {
               {
                  put(AUDITORY_CODE, AUDITORY_FEE);
                  put(IMMUNISATION_CODE, IMMUNISATION_FEE);
                  put(OPTHAMOLOGY_CODE, OPTHAMOLOGY_FEE);
                  put(PEDIATRIC_CODE, PEDIATRIC_FEE);
                  put(PHYSIOTHERAPY_CODE, PHYSIOTHERAPY_FEE);
                  put(SPEECH_CODE, SPEECH_FEE);
               }
            });

   @SuppressWarnings("serial")
   private static final Map<String, String> clinicMap =
            Collections.unmodifiableSortedMap(new TreeMap<String, String>()
            {
               {
                  put(AUDITORY_CODE, "AUDITORY");
                  put(IMMUNISATION_CODE, "IMMUNISATION");
                  put(OPTHAMOLOGY_CODE, "OPTHAMOLOGY");
                  put(PEDIATRIC_CODE, "PEDIATRIC");
                  put(PHYSIOTHERAPY_CODE, "PHYSIOTHERAPY");
                  put(SPEECH_CODE, "SPEECH PATHOLOGY");
               }
            });
   
   private static final int AUDITORY_FEE = 120;
   private static final int IMMUNISATION_FEE = 80;
   private static final int OPTHAMOLOGY_FEE = 120;
   private static final int PEDIATRIC_FEE = 85;
   private static final int PHYSIOTHERAPY_FEE = 65;
   private static final int SPEECH_FEE = 60;

   private static final String AUDITORY_CODE = "AUD";
   private static final String IMMUNISATION_CODE = "IMM";
   private static final String OPTHAMOLOGY_CODE = "OPT";
   private static final String PEDIATRIC_CODE = "PED";
   private static final String PHYSIOTHERAPY_CODE = "PHY";
   private static final String SPEECH_CODE = "SPE";

}
