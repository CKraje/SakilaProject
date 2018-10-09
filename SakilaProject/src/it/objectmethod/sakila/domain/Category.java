package it.objectmethod.sakila.domain;

public class Category {
	private int categoryId;
	private String name;
	private String lastUpdate;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int id) {
		this.categoryId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
