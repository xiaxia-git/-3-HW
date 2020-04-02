
/**
 * Class Driver info
 *
 * @author (Cherry Cui)
 * @version (2020-03-04)
 */
public class Driver
{
    
    /**
     * A main method 
     *
    
     * @return    the sum of x and y
     */
    public static void main (String[] args)
    {
        ParkedCar car = new ParkedCar("cherry","Audi", 2019,"AAABBB",125);
        car.displayDetails();
        
        ParkingMeter meter = new ParkingMeter("BBY", true,1,60);
        meter.displayDetails();
        
        PoliceOfficer officer = new PoliceOfficer("Test Cop", "A12345");
        officer.issueParkingTicket(car,meter);
     
        
    }
}
