package codeMain;
/*
 *  @ author - Arsheemahedi Shethwala 
 * This is the class with the item variables declared
 */
import java.util.ArrayList;

public class Item {
	
	//declaring variables for the items
	private int id;
	private String item;
	private int quantity;
	private double price;
	
	//creating an ArrayList of the item type
	public ArrayList<Item> items = new ArrayList<Item>();

	//Non Parameterized constructor
	public Item() {
		this(0, "", 0, 0);
	}

	//Parameterized Constructor
	public Item(int id, String item, int quantity, double price) {
		this.id = id;
		this.item = item;
		this.quantity = quantity;
		this.price = price;
	}

	//Public getter and setters for the variables
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", item=" + item + ", quantity=" + quantity + ", price=" + price + "]";
	}

} // end of the class
