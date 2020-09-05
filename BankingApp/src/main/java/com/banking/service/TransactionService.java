package com.banking.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.model.Transaction;
import com.banking.repository.TransactionRepository;


@Service
public class TransactionService {

	@Autowired
    private TransactionRepository transactionRepository;
     
    public List<Transaction> listAll() {
        return transactionRepository.findAll();
    }
     
    public void save(Transaction transaction) {
    	transactionRepository.save(transaction);
    }
     
    public Transaction get(long id) {
        return transactionRepository.findById(id).get();
    }
     
    public void delete(long id) {
        transactionRepository.deleteById(id);
    }
    
    
    
    public boolean amountIsNegativeOrZeroValue(double amount) {
    	
    	if (amount <= 0 ) {
    		return true;
    	}
    	
    	return false;
    }

    
}
