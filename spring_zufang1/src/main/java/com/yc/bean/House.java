package com.yc.bean;

import java.io.Serializable;
import java.util.Date;

public class House implements Serializable{
	private static final long serialVersionUID = 5520638282673249640L;
	private  Integer id;         
	private User user;  
	private  HouseType   type; 
	private String  title;  
	private String  description;   
	private Double price;              				
	private Date pubDate;                 				
	private Integer floorage;                 	
	private String contact;     		
	private Street street;
	private Double minPrice;
	private Double maxPrice;
	private Integer minFloorage;
	private Integer maxFloorage;
	private Integer user_id;
	private Integer type_id;
	private Integer street_id;
	
	public House() {
		super();
	}
	
	
	public House(User user, HouseType type, String title, Double price, Street street) {
		super();
		this.user = user;
		this.type = type;
		this.title = title;
		this.price = price;
		this.street = street;
	}


	public House(User user, HouseType type, String title, String description, Double price, Date pubDate,
			Integer floorage, String contact, Street street) {
		super();
		this.user = user;
		this.type = type;
		this.title = title;
		this.description = description;
		this.price = price;
		this.pubDate = pubDate;
		this.floorage = floorage;
		this.contact = contact;
		this.street = street;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public HouseType getHouseType() {
		return type;
	}
	public void setHouseType(HouseType houseType) {
		this.type = houseType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getPubdate() {
		return pubDate;
	}
	public void setPubdate(Date pubdate) {
		this.pubDate = pubdate;
	}
	public Integer getFloorage() {
		return floorage;
	}
	public void setFloorage(Integer floorage) {
		this.floorage = floorage;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Street getStreet() {
		return street;
	}
	public void setStreet(Street street) {
		this.street = street;
	}
	

	

	@Override
	public String toString() {
		return "House [id=" + id + ", user=" + user + ", type=" + type + ", title=" + title + ", description="
				+ description + ", price=" + price + ", pubDate=" + pubDate + ", floorage=" + floorage + ", contact="
				+ contact + ", street=" + street + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice
				+ ", minFloorage=" + minFloorage + ", maxFloorage=" + maxFloorage + ", user_id=" + user_id
				+ ", type_id=" + type_id + ", street_id=" + street_id + "]";
	}


	public HouseType getType() {
		return type;
	}


	public void setType(HouseType type) {
		this.type = type;
	}


	public Date getPubDate() {
		return pubDate;
	}


	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}


	public Double getMinPrice() {
		return minPrice;
	}


	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}


	public Double getMaxPrice() {
		return maxPrice;
	}


	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}


	public Integer getMinFloorage() {
		return minFloorage;
	}


	public void setMinFloorage(Integer minFloorage) {
		this.minFloorage = minFloorage;
	}


	public Integer getMaxFloorage() {
		return maxFloorage;
	}


	public void setMaxFloorage(Integer maxFloorage) {
		this.maxFloorage = maxFloorage;
	}




	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public Integer getType_id() {
		return type_id;
	}


	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}


	public Integer getStreet_id() {
		return street_id;
	}


	public void setStreet_id(Integer street_id) {
		this.street_id = street_id;
	}


	


	
	
	
}
