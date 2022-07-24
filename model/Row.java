package it.java.model;

import java.sql.Date;
import java.sql.SQLData;

public class Row {
	
	private String table;
	private int id;
	private String name;
	private double capacity;
	private Object data;
	
	public Row(){
		super();
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
	public double getCapacity() {
		return capacity;
	}
	public void setCapacity(double d) {
		this.capacity = d;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object object) {
		this.data = object;
	}

	
	
	
}
