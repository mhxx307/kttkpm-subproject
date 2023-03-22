package com.sv.iuh.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.redis.core.RedisHash;

@Entity
@Table(name="brands")
@RedisHash("Brand")
public class Brand implements Serializable {

	private static final long serialVersionUID = 821675973643331270L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String img;

	public Brand() {
		super();
	}

	public Brand(int id, String name, String img) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
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

	@Override
	public String toString() {
		return "Brand [id=" + id + ", name=" + name + ", img=" + img + "]";
	}

}
