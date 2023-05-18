package com.monteiro.soap.webservices.customersadministration.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
	
	private int id;
	private String name;
	private String phone;
	private String email;

}
