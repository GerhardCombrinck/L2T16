import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Driver implements Serializable {

	private static final long serialVersionUID = 1L;
	//Attributes of a Driver object
	String driverName;
	String driverCity;
	Integer driverLoad;	
	
	//Constructor to make a Driver object
	public Driver (String driverName, String driverCity, int driverLoad) {
		this.driverName = driverName; 
		this.driverCity = driverCity; 
		this.driverLoad = driverLoad;
	}
	
	public String toString() {
	      String output = driverName + ", " + driverCity  + ", " + driverLoad;
	      return output;
	   }
	
	//Getters and setters
	  public String getCity() {
		    return driverCity;
		  }
	  public String getName() {
		    return driverName;
		  }
	  public Integer getLoads() {
		    return driverLoad;
		  }
	  public void setLoads(int newLoad) {
		    this.driverLoad = newLoad;
		  }
	  

	   //Method to read file where past data is stored
	   @SuppressWarnings({ "unchecked", "rawtypes" })
	   public static ArrayList<Driver> LoadDrivers() {
	   		ArrayList<Driver> lst = new ArrayList<Driver>();
	   		try {
	               FileInputStream fis = new FileInputStream("data\\drivers.txt");
	               ObjectInputStream ois = new ObjectInputStream(fis);
	               lst = (ArrayList) ois.readObject();
	               ois.close();
	               fis.close();       
	   		} catch (Exception ioe) {
	   			lst = new ArrayList<>();
	   		}
	   		return lst;
	   	}
	

	  //Method to check if the value can be converted to an integer
	public static boolean isInt(String str) {
	  	try {
	      	@SuppressWarnings("unused")
	    	int x = Integer.parseInt(str);
	      	return true; //String is an Integer
		} catch (NumberFormatException e) {
	    	return false; //String is not an Integer
		}
	  	
	}
	

	
	
	
}
