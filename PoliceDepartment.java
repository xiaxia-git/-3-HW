
/**
 * Class PoliceDepartment here.
 *
 * @author (Cherry Cui)
 * @version (2020-03-19)
 */
import java.util.ArrayList;
import java.util.Iterator;
public class PoliceDepartment
{
    // instance variables 
    private String address;
    private ArrayList<PoliceOfficer> officerList;
    private ParkingTicket parkingTicket;
   

    /**
     * Constructor for objects of class PoliceDepartment
     */
    public PoliceDepartment(String inputAddress)
    {
      setAddress(inputAddress);  
      officerList = new ArrayList <PoliceOfficer>();  
    }
    
    /**Accessor getAddress
     * @return address
     */
    public String getAddress(){
    return address;
    }
    
    /**Accessor getOfficerList
     * return officerList
     */
    public ArrayList<PoliceOfficer> getOfficerList(){
       return officerList;
    }
    
    /**
     * Mutator setAddress
     * @param inputAddress
     */
    public void setAddress(String inputAddress){
        if(inputAddress == null){
        throw new IllegalArgumentException("address cannot be null");
        } 
        if(inputAddress.isEmpty()){
        throw new IllegalArgumentException("address cannot be an empty String");
        }
        address = inputAddress;
        }
    
    
    /**
     * A method to add PoliceOfficer object to the officerList
     * @param  PoliceOfficer objects
     */
    public void addPoliceOfficer(PoliceOfficer officer)
    {
        if(officer!=null){
        officerList.add(officer);
        }   
       
    }  
    
    
    /**
     * A method to search the collection and display a list of the parking tickets issued by the specific officer
     * @param officerName
     */
    public void displayTicketsByOfficer(String officerName)
    {
    if(officerName!=null){
        Iterator <PoliceOfficer> it=officerList.iterator();
        while(it.hasNext()){
            if(officerName.equalsIgnoreCase(it.next().getOfficerName())){   
            it.next().displayticketsDetails();
            }
        
    }
   }
       
 }
 
 /**
  * A method to calculate the total amount of fines issued by all the officers in the collection
  * @return sum
  */
 public double calculateSumOfAllTicketsOfAllOfficers()
 {
  double sum = 0;
  for(PoliceOfficer officer:officerList){
    sum = sum + officer.sumAllfines();
    }  
  return sum;  
 }
 
 /**
  * A method to search in the collection for total count of tickets issued to the plate number
  * @param carLicensePlateNumber
  * @return totalTicketCount
  */
 public int totalParkingTicketCountOfACar(String carLicensePlateNumber)
 {
    
    int totalTicketCount = 0;
    
    for(PoliceOfficer officer:officerList){
       ArrayList <ParkingTicket> ticketListIssuedByOfficer = officer.getTicketList();
       Iterator <ParkingTicket> it=ticketListIssuedByOfficer.iterator();
    
       while(it.hasNext()){
           String license = it.next().getCarLicensePlateNumber();
           if(carLicensePlateNumber.equalsIgnoreCase(license)){
           totalTicketCount++; 
        }
    
    }
}
    return totalTicketCount;

    
 }
 
 
 
}
