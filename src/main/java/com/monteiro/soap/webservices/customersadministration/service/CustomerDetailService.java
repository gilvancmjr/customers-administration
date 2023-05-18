package com.monteiro.soap.webservices.customersadministration.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.monteiro.soap.webservices.customersadministration.bean.Customer;
import com.monteiro.soap.webservices.customersadministration.helper.Status;

@Component
public class CustomerDetailService {

	private static List<Customer> customer = new ArrayList<>();

	static {
		Customer customer1 = new Customer(1, "Bob", "1111111111", "bob@gmail.com");
		customer.add(customer1);
		Customer customer2 = new Customer(2, "Mark", "2222222222", "mark@gmail.com");
		customer.add(customer2);
		Customer customer3 = new Customer(3, "Jose", "3333333333", "jose@gmail.com");
		customer.add(customer3);
		Customer customer4 = new Customer(4, "Klay", "4444444444", "klay@gmail.com");
		customer.add(customer4);
		Customer customer5 = new Customer(5, "John", "5555555555", "john@gmail.com");
		customer.add(customer5);

	}

	public Customer findById(int id) {
		Optional<Customer> customerOptional = customer.stream().filter(c -> c.getId() == id).findAny();
		if (customerOptional.isPresent()) {
			return customerOptional.get();
		}
		return null;
	}
	
	public List<Customer> findAll(){
		return customer;
	}
	public Status deleteById(int id) {
		Optional<Customer> customerOptional = customer.stream().filter(c -> c.getId() == id).findAny();
		if(customerOptional.isPresent()) {
			customer.remove(customerOptional.get());
			return Status.SUCCESS;
		}
		return Status.FAILURE;
	}

}
