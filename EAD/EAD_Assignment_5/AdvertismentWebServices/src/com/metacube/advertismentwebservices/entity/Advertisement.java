package com.metacube.advertismentwebservices.entity;
import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

public class Advertisement extends BaseEntity {
	@JsonbProperty("name")
	private String title;
	@JsonbProperty("description")
	private String description;
	@JsonbProperty("category_id")
	private int category_id;
	
	@JsonbCreator
	public Advertisement(@JsonbProperty("name") String name, @JsonbProperty("description") String description,
			@JsonbProperty("category_id") int category_id){
		this.title=name;
		this.description=description;
		this.category_id=category_id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return the category_id
	 */
	public int getCategory_id() {
		return category_id;
	}
	
	/**
	 * @param category_id the category_id to set
	 */
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	 @Override
	    public String toString() {
	      return title + " wrote " + description + " albums";
	    }
	
}
