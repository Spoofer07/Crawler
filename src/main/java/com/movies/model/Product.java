package com.movies.model;

import java.util.Date;

public class Product {

	private String name;
	private String link;
	private String price;
	private Date currentDate;
	private String priceOld;
	private String Discount;

	public Product() {
	}


	public Product(String name, String link, String price, Date currentDate, String priceOld, String discount) {
		super();
		this.name = name;
		this.link = link;
		this.price = price;
		this.currentDate = currentDate;
		this.priceOld = priceOld;
		Discount = discount;
	}


	public String getPriceOld() {
		return priceOld;
	}


	public String getDiscount() {
		return Discount;
	}


	public void setPriceOld(String priceOld) {
		this.priceOld = priceOld;
	}


	public void setDiscount(String discount) {
		Discount = discount;
	}


	public String getName() {
		return name;
	}

	public String getLink() {
		return link;
	}

	public String getPrice() {
		return price;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	@Override
	public String toString() {
		return "Product [\nname=" + name + ", \nlink=" + link + ", \nprice=" + price + ", \ncurrentDate=" + currentDate
				+ ", \npriceOld=" + priceOld + ", \nDiscount=" + Discount + "\n]";
	}

}
