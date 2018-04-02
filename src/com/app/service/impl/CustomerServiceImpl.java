package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerDao;
import com.app.model.Customer;
import com.app.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService  {
@Autowired
	private ICustomerDao custDao;
	
	@Override
	public int saveCustomer(Customer cust) {
		
		return custDao.saveCustomer(cust);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return custDao.getAllCustomers();
	}
    public void deleteCustomerById(int custId) {
    		custDao.deleteCustomerById(custId);
    		
    	}

	@Override
	public Customer getCustomerById(int custId) {
	
		return custDao.getCustomerById(custId);
	}

	@Override
	public void updateCustomer(Customer cust) {
		custDao.updateCustomer(cust);
		
	}
	
	@Override
		public Customer getcustomerByEmail(String email) {
			return custDao.getcustomerByEmail(email);
		}
}
