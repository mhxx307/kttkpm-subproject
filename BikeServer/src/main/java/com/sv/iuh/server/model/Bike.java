package com.sv.iuh.server.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bikes")
public class Bike {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String model;
	private String manufacturer;
	private double cost;
	public Bike() {
		super();
	}
	public Bike(int id, String name, String model, String manufacturer, double cost) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.manufacturer = manufacturer;
		this.cost = cost;
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
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Bike [id=" + id + ", name=" + name + ", model=" + model + ", manufacturer=" + manufacturer + ", cost="
				+ cost + "]";
	}
	
	
	

}
