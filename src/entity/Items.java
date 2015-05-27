package entity;

public class Items {
	//id of intems
	private int id;
	//name of items
	private String name;
	//creating place of items
	private String city;
	//price of items
	private int price;
	//storage of items
	private int number;
	//picture for items description
	private String picture;
	
	//get item's id
	public int getId() {
		return id;
	}
	
	//set item's id
	public void setId(int id) {
		this.id = id;
	}
	
	//get item's name
	public String getName() {
		return name;
	}

	//set item's name
	public void setName(String name) {
		this.name = name;
	}
	
	//get item's city
	public String getCity() {
		return city;
	}
	
	//set item's city
	public void setCity(String city) {
		this.city = city;
	}
	
	//get item's price
	public int getPrice() {
		return price;
	}
	
	//set item's price
	public void setPrice(int price) {
		this.price = price;
	}
	
	//get item's storage
	public int getNumber() {
		return number;
	}

	//set item's storage
	public void setNumber(int number) {
		this.number = number;
	}

	//get item's picture
	public String getPicture() {
		return picture;
	}
	
	//set item's picture
	public void setPicture(String picture) {
		this.picture = picture;
	}

}
