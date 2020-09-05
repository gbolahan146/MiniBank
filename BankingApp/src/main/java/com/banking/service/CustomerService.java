package com.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.model.Customer;
import com.banking.repository.CustomerRepository;




@Service
public class CustomerService {
	
	@Autowired
    private CustomerRepository customerRepository;
     
    public List<Customer> listAll() {
        return customerRepository.findAll();
    }
     
    public void save(Customer customer) {
    	customerRepository.save(customer);
    }
     
    public Customer get(long id) {
        return customerRepository.findById(id).get();
    }
     
    public void delete(long id) {
        customerRepository.deleteById(id);
    }
    
    public Customer getCustomerByAccountNumber(String accountNumber) {
    	return customerRepository.findByAccountNumber(accountNumber);
    }

    
    public boolean isSufficientBlance(String accountNumber, double amount) {
    	
    	Customer customer = this.getCustomerByAccountNumber(accountNumber);
    	// check value must not be negative
    	if ((customer.getAccountBalance() - amount) <= 0 ) {
    		return false;
    	}
    	
    	return true;
    }
    
    
    public int deductAmountFromSender(String accountNumber, double amount) {
    	Customer customer = this.getCustomerByAccountNumber(accountNumber);
    	if (customer != null) {
    		double x = customer.getAccountBalance()-amount;
    		customer.setAccountBalance(x);
    		return 0;
    	} else {
    		return -1;
    	}
    }
    
    public int addAmountFromRecipient(String accountNumber, double amount) {

    	Customer customer = this.getCustomerByAccountNumber(accountNumber);
    	if (customer != null) {
    		double x = customer.getAccountBalance()+amount;
    		customer.setAccountBalance(x);
    		return 0;
    	} else {
    		return -1;
    	}
    }
    
    
    public void closeAccount(String accountNumber) {
    	Customer customer = this.getCustomerByAccountNumber(accountNumber);
    	if (customer != null) {
    		customer.setAccountStatus("Closed");
    	}
    }
    
    
    
}
