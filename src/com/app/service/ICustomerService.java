package com.app.service;

import java.util.List;

import com.app.model.Customer;



public interface ICustomerService {
	public int saveCustomer(Customer cust);
	public List<Customer> getAllCustomers();
	public void deleteCustomerById(int custId);
	public Customer getCustomerById(int custId);
	public void updateCustomer(Customer cust);
	public Customer getcustomerByEmail(String email);
}
