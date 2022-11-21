package com.sv.iuh.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cars")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String img;
	private double cost;
	private int rate;
	private String type;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	public Car() {
		super();
	}

	public Car(int id, String name, String img, double cost, int rate, String type) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.cost = cost;
		this.rate = rate;
		this.type = type;
	}

	public Car(int id, String name, String img, double cost, int rate, String type, Brand brand) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.cost = cost;
		this.rate = rate;
		this.type = type;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", img=" + img + ", cost=" + cost + ", rate=" + rate + ", type="
				+ type + "]";
	}

}
