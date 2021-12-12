
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//Attributes of a Order object
	long orderID;
	Customer customerName;
	Driver driverName;
	String specialInstructions;
	Restaurant orderRestaurant;

	//Constructor to make a Order object
	public Order (long orderID, Customer customerName, Driver driverName, Restaurant orderRestaurant) {
		this.orderID = orderID;
		this.customerName = customerName; 
		this.driverName = driverName;
		this.orderRestaurant = orderRestaurant;
	}
	
   public String toString() {
	      String output = "Order#: " + orderID + " || Customer: " + customerName + " || Driver: " + driverName;
	      return output;
	   }
   
   
	//Getters and setters
   public Long getOrderID() {
	   return (long) orderID;
   }
   public Restaurant getRestaurant() {
	   return orderRestaurant;
   }
   public Customer getCustomerName() {
	   return customerName;
   }
   public String getCustomerNameString() {
	   return customerName.customerName;
   }
   public Driver getDriver() {
	   return driverName;
   }
   public String getSpecial() {
	   return specialInstructions;
   }
   public void setSpecial(String specialInstructions) {
	   this.specialInstructions = specialInstructions;
   }
   
   //Method to read file where past data is stored
   @SuppressWarnings({ "unchecked", "rawtypes" })
public static ArrayList<Order> LoadOrders() {
		ArrayList<Order> lst = new ArrayList<Order>();
		try {
            FileInputStream fis = new FileInputStream("data\\orders.txt");
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

