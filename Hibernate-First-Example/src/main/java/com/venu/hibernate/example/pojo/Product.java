package com.venu.hibernate.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	private int product_Id;
	private String product_Name;
	private double product_Price;

}
