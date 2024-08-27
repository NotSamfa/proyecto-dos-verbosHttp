package com.co.falla.verboHttp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class GroceryItem {

	private String id;
	private String name;
	private int quantity;
	private String category;

	public GroceryItem(String id, String name, int quantity, String category) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.category = category;
	}

	@Override
	public String toString() {
		  return "GroceryItem{" + 
                "id='" + id + '\'' + 
                ", name='" + name + '\'' + 
                ", quantity=" + quantity + 
                ", category='" + category + '\'' + 
                '}'+"\n"; 
	}
}
