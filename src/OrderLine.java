import java.io.Serializable;

public class OrderLine implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Attributes of a OrderLine object
	long orderID;
	Item itemName;
	int orderQty;
	
	//Constructor to make a OrderLine object
	public OrderLine (long orderID, Item itemName, int orderQty) {
		this.orderID = orderID;
		this.itemName = itemName; 
		this.orderQty = orderQty; 
	}
	
	   public String toString() {
		      String output = "Order#: " + orderID + ", Line#: " + ", " + itemName+ ", " + orderQty  ;
	      return output;
	   }
	   
	//Getters and setters
    public long getOrderID() {
	    return orderID;
    }
    public int getorderQty() {
	    return orderQty;
    }
    public Item getItem() {
	    return itemName;
    }

	


}
