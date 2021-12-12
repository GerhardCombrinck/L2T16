import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Item implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Attributes of a Item object
	String ItemName;
	double itemPrice;
	String restaurantName;
	
	//Constructor to make a Item object
	public Item (String ItemName, double itemPrice, String restaurantName) {
		this.ItemName = ItemName; 
		this.itemPrice = itemPrice; 
		this.restaurantName = restaurantName;
	}
	
	public String toString() {
	      String output =  restaurantName + ", " + ItemName + ", " + itemPrice;
	      return output;
	   }
	
	//Getters and setters
	public String getName() {
		return ItemName;
	}
	public double getPrice() {
		return itemPrice;
	}

	 //Method to read file where past data is stored
	   @SuppressWarnings({ "unchecked", "rawtypes" })
	   public static ArrayList<Item> LoadItems() {
	   		ArrayList<Item> lst = new ArrayList<Item>();
	   		try {
	               FileInputStream fis = new FileInputStream("data\\items.txt");
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
