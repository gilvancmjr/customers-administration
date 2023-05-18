package com.monteiro.soap.webservices.customersadministration.soap;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.monteiro.soap.webservices.customersadministration.bean.Customer;
import com.monteiro.soap.webservices.customersadministration.service.CustomerDetailService;
import com.monteiro.soap.webservices.customersadministration.soap.exception.CustomerNotFoundException;

import br.com.monteiro.CustomerDetaisl;
import br.com.monteiro.DeleteCustomerRequest;
import br.com.monteiro.DeleteCustomerResponse;
import br.com.monteiro.GetAllCustomerDetailRequest;
import br.com.monteiro.GetAllCustomerDetailResponse;
import br.com.monteiro.GetCustomerDetailRequest;
import br.com.monteiro.GetCustomerDetailResponse;

@Endpoint
public class CustomerDetailEndPoint {
	
	@Autowired
	CustomerDetailService service;

	@PayloadRoot(namespace = "http://monteiro.com.br", localPart = "GetCustomerDetailRequest")
	@ResponsePayload
	public GetCustomerDetailResponse processCustomerDetailRequest(@RequestPayload GetCustomerDetailRequest request) throws Exception {
		Customer customer = service.findById(request.getId().intValue());
		if(customer == null) {
			throw new CustomerNotFoundException("Invalid Customer id "+ request.getId());
		}
		return convertToGetCustomerDetailResponse(customer);
	}
	
	private GetCustomerDetailResponse convertToGetCustomerDetailResponse(Customer customer) {
		GetCustomerDetailResponse resp = new GetCustomerDetailResponse();
		resp.setCustomerDetaisl(convertToCustomerDetail(customer));
		return resp;
	}

	private CustomerDetaisl convertToCustomerDetail(Customer customer) {
		CustomerDetaisl customerDetail = new CustomerDetaisl();
		customerDetail.setId(BigInteger.valueOf(customer.getId()));
		customerDetail.setName(customer.getName());
		customerDetail.setPhone(customer.getPhone());
		customerDetail.setEmail(customer.getEmail());
		return customerDetail;
	}
	
	@PayloadRoot(namespace = "http://monteiro.com.br", localPart = "GetAllCustomerDetailRequest")
	@ResponsePayload
	private GetAllCustomerDetailResponse convertToGetAllCustomerDetailResponse(@RequestPayload GetAllCustomerDetailRequest request) {
		List<Customer> customers = service.findAll();
		return convertToGetAllCustomerDetailResponse(customers);
	}
	
	private GetAllCustomerDetailResponse convertToGetAllCustomerDetailResponse(List<Customer> customers) {
		GetAllCustomerDetailResponse response =  new GetAllCustomerDetailResponse();
		customers.stream().forEach(c -> response.getCustomerDetaisl().add(convertToCustomerDetail(c)));
		return response;
	}
	
	
	@PayloadRoot(namespace="http://monteiro.com.br", localPart="DeleteCustomerRequest")
	@ResponsePayload
	public DeleteCustomerResponse deleteCustomerRequest(@RequestPayload DeleteCustomerRequest req) {
		DeleteCustomerResponse resp = new DeleteCustomerResponse();
		resp.setStatus(convertStatusSoap(service.deleteById(req.getId())));
		return resp;
	}
	
	private br.com.monteiro.Status convertStatusSoap(com.monteiro.soap.webservices.customersadministration.helper.Status statusService) {
		if(statusService == com.monteiro.soap.webservices.customersadministration.helper.Status.FAILURE) {
			return  br.com.monteiro.Status.FAILURE;
		}
		return  br.com.monteiro.Status.SUCCESS;
	}
	

}
