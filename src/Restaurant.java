import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Restaurant implements Serializable{
	
	 private static final long serialVersionUID = 1L;

		//Attributes of a Restaurant object
		String restaurantName;
		String restaurantCity;
		String restaurantContactNo;
		
		//Constructor to make a Restaurant object
		public Restaurant (String restaurantName, String restaurantCity, String restaurantContactNo) {
			this.restaurantName = restaurantName; 
			this.restaurantCity = restaurantCity; 
			this.restaurantContactNo = restaurantContactNo;
		}
		
	   public String toString() {
		      String output = restaurantName + ", " + restaurantCity  + ", " + restaurantContactNo;
	      return output;
	   }
	   
	   //Getters and setters
		public String getCity() {
			return restaurantCity;
		}
		public String getName() {
			return restaurantName;
		}
		
	 //Method to read file where past data is stored
	   @SuppressWarnings({ "unchecked", "rawtypes" })
	   public static ArrayList<Restaurant> LoadRestaurants() {
	   		ArrayList<Restaurant> lst = new ArrayList<Restaurant>();
	   		try {
	               FileInputStream fis = new FileInputStream("data\\restaurants.txt");
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
