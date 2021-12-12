import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {


	private static final long serialVersionUID = 1L;
	//Attributes of a customer object
	String customerName;
	String customerContactNo;
	String customerCity;
	String customerAddress;
	String customerEmailAddress;
	
	//Constructor to make a customer object
	public Customer (String customerName, String customerContactNo, String customerCity, String customerAddress,String customerEmailAddress) {
		this.customerName = customerName; 
		this.customerContactNo =customerContactNo; 
		this.customerCity = customerCity;
		this.customerAddress = customerAddress;
		this.customerEmailAddress = customerEmailAddress;
	}

	public String toString() {
	    String output = customerName + ", " + customerContactNo  + ", " + customerCity + ", " + customerAddress;
	    return output;
	}
	
	//Getters and setters
	public String getEmail() {
		return customerEmailAddress;
	}
	public String getContactNo() {
		return customerContactNo;
	}
	public String getName() {
		return customerName;
	}
	public String getCity() {
		return customerCity;
	}
	
   //Method to read file where past data is stored
   @SuppressWarnings({ "unchecked", "rawtypes" })
   public static ArrayList<Customer> LoadCustomers() {
   		ArrayList<Customer> lst = new ArrayList<Customer>();
   		try {
               FileInputStream fis = new FileInputStream("data\\customers.txt");
               ObjectInputStream ois = new ObjectInputStream(fis);
               lst = (ArrayList) ois.readObject();
               ois.close();
               fis.close();       
   		} catch (Exception ioe) {
   			lst = new ArrayList<>();
   		}
   		return lst;
   	}
	  
	
}
