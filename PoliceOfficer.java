
/**
 * Class PoliceOfficer info.
 *
 * @author (Cherry Cui)
 * @version (updated on 2020-03-29)
 */
import java.util.ArrayList;
import java.util.Iterator;

public class PoliceOfficer
{
    //Symbolic constants
    public static final int ONE_HOUR_FINE_AMOUNT =20;
    public static final int MINUTES_IN_HOUR = 60;
    
    // instance variables 
    private String officerName;
    private String officerBadgeNumber;
    private ArrayList <ParkingTicket> ticketList;
    private String inputLicense;
    private ParkingTicket parkingTicket;
    
    

    /**
     * Parameterized Constructor for objects of class PoliceOfficer
     * @param name A parameter to set officer name value
     * @param badgeNumber A parameter to set officer badge number
     */
    public PoliceOfficer(String name, String badgeNumber)
    {
        setOfficerName(name);
        setOfficerBadgeNumber(badgeNumber);
        ticketList = new ArrayList <ParkingTicket>();
    }

    /**
     * Accessor getOfficerName
     * @return officerName
     */
    public String getOfficerName(){
    return officerName;
    }
    
    /**
     * Accessor getOfficerBadgeNumber
     * @return officerBadgeNumber
     */
    public String getOfficerBadgeNumber(){
    return officerBadgeNumber;
    }
    
    /**
     * Accessor getTicketList
     * @return ticketList
     */
    public ArrayList<ParkingTicket> getTicketList(){
       return ticketList;
    }
    
    /**
     * Mutator setOfficerName
     * @param name A parameter to set officer name
     */
    public void setOfficerName(String name){
    if(name == null ){
    throw new IllegalArgumentException("officer name must not be null");
    } 
    if(name.isEmpty()){
        throw new IllegalArgumentException("officer name must not be an empty String");
        } 
    officerName = name;
    }
    
    /**
     * Mutator setOfficerBadgeNumber
     * @param badgeNumber A parameter to set officer badge number
     */
    public void setOfficerBadgeNumber(String badgeNumber){
    if(badgeNumber == null ){
    throw new IllegalArgumentException("badge number must not be null");
    } 
    if(badgeNumber.isEmpty()){
        throw new IllegalArgumentException("badge number must not be empty String");
        } 
    officerBadgeNumber = badgeNumber;
    }
    /**
     * A private method to check if the parkedCar time has expired
     * @return    if it's expired
     */
  
    private boolean isParkingTimeExpired(ParkedCar car, ParkingMeter meter)
    {
        
        if(car.getNumberOfMinutesParked() > meter.getNumberOfPurchasedMinutes()){
        return true;
        } 
        return false;
        }
        
    
    
    /**
     * A private method to calculate the fine
     * @return calculateFine
     */
    private double calculateFine(ParkedCar car, ParkingMeter meter)
    { 
       int notPaidMinutes = car.getNumberOfMinutesParked() - meter.getNumberOfPurchasedMinutes();
       int fine = 0;
       
    if(isParkingTimeExpired(car,meter)==true){
        if(notPaidMinutes % MINUTES_IN_HOUR == 0){
         fine = ONE_HOUR_FINE_AMOUNT * notPaidMinutes/MINUTES_IN_HOUR;
        }
        if(notPaidMinutes < MINUTES_IN_HOUR){
        fine = ONE_HOUR_FINE_AMOUNT;
        }
        if(notPaidMinutes%MINUTES_IN_HOUR > 0){
            fine = ONE_HOUR_FINE_AMOUNT * (notPaidMinutes/MINUTES_IN_HOUR) + ONE_HOUR_FINE_AMOUNT;
        }
    
    }
    return fine;
}

/**
 * A method to issue parking ticket
 * New modification of adding each issued ticket to the ticketList
 * Not return anything
 */
public void issueParkingTicket(ParkedCar car, ParkingMeter meter)
{
 
if(isParkingTimeExpired(car,meter)==true){

ParkingTicket parkingTicket = new ParkingTicket(officerName, officerBadgeNumber,car.getLicensePlateNumber(),calculateFine(car,meter));
System.out.println("Ticket Number: "+ parkingTicket.getTicketNumber());
System.out.println("Officer Name: "+ getOfficerName());
System.out.println("Officer Badge number: "+ getOfficerBadgeNumber());
System.out.println("Car License Plate Number: "+ parkingTicket.getCarLicensePlateNumber());
System.out.println("Fine amount: "+ calculateFine(car,meter));
ticketList.add(parkingTicket);
} 
}

/**
 * A method to calculate the sum of fines of all the parkingTickets in the collection
 * return the sum
 */
public double sumAllfines()
{

double sum = 0;
for(ParkingTicket parkingTicket:ticketList){
sum = sum + parkingTicket.getFineAmountInCAD();
}

return sum;
}

/**
 * A method to count the total amount of tickets issued to one license plate number
 * @param inputLicense
 * @return the total count
 */
public int getParkingTicketsCountForACar(String inputLicense)
{

int count = 0;
for(ParkingTicket parkingTicket:ticketList){
  String license = parkingTicket.getCarLicensePlateNumber();
  if(inputLicense.equalsIgnoreCase(license)){
    count++;
    }
}
return count;
}

/**
 * A method getTicketArrayByLicenseNumber
 * @param inputLicense
 * @return an array of all the parking ticket objects issued to the car with the given license number
 */
public ParkingTicket[] getTicketArrayByLicenseNumber(String inputLicense)
{
    int i = getParkingTicketsCountForACar(inputLicense);
ParkingTicket[] ticketArrayByLicenseNumber = new ParkingTicket[i];
    for(int j=0;j<i;j++){
        String license = parkingTicket.getCarLicensePlateNumber();
            if(inputLicense.equalsIgnoreCase(license)){
            ticketArrayByLicenseNumber[j]=parkingTicket;
}
}
return ticketArrayByLicenseNumber;

}

/**
 * A method to calculate the total amount of fines issued to the specific car
 * @param inputLicense
 * @return sumOfFinesByCar
 */
public double getSumOfFinesByCar(String inputLicense)
{

double sumOfFinesByCar=0;
for(ParkingTicket parkingTicket:ticketList){
String license = parkingTicket.getCarLicensePlateNumber();
  if(inputLicense.equalsIgnoreCase(license)){
sumOfFinesByCar=sumOfFinesByCar + parkingTicket.getFineAmountInCAD();
}
}
return sumOfFinesByCar;
}

/**
 * A method to display the details of all the parking ticket objects in the ticketList
 */
public void displayticketsDetails()
{
for(ParkingTicket parkingTicket:ticketList){
    parkingTicket.displayDetails();

}
}

/**
 * A method to delete all the parking tickets that issued to the car with the provided plate number
 * @param inputLicense
 * @return the number of deleted Parking Ticket objects
 */
public int deleteTicketsByCarLicense(String inputLicense)
{
int numOfDeleted = 0;
Iterator <ParkingTicket> it=ticketList.iterator();

while(it.hasNext()){
   String license = it.next().getCarLicensePlateNumber();
  if(inputLicense.equalsIgnoreCase(license)){
     it.remove();
     numOfDeleted++;
}
}
return numOfDeleted;
}
}