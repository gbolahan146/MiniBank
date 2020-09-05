package com.banking.controller.admin;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banking.model.Transaction;
import com.banking.service.CustomerService;
import com.banking.service.TransactionService;





@Controller
public class AdminTransactionController {
	
	@Autowired
    private TransactionService transactionService;
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/admin/customer/fund_transfer")
	public String getTransferPage(Model model) {
	    
		Transaction transaction = new Transaction();
		model.addAttribute("transaction", transaction);
	    return "/admin/customer/fund_transfer";
	}
	

	

	@RequestMapping(value="/admin/customer/fund_transfer", method=RequestMethod.POST)
	public String makeTransfer(
			@RequestParam("sender") String sender,
			@RequestParam("recipient") String recipient,
			@RequestParam("amount") String amount,
			Transaction transaction )
	{

		
		// check amount is > 0 first
		Boolean amountIsNegativeOrZeroValue = transactionService.amountIsNegativeOrZeroValue(Float.parseFloat(amount));
		if (amountIsNegativeOrZeroValue == true) {
			return "redirect:/admin/customer/fund_transfer?error=Invalid amount";
		}
		

		// ensure sender_balance - amount >= 0
		Boolean hasSufficientBalance = customerService.isSufficientBlance(sender, Float.parseFloat(amount));
		if (hasSufficientBalance == false) {
			return "redirect:/admin/customer/fund_transfer?error=Insufficient balance";
		}
		
		
		
		
		customerService.deductAmountFromSender(sender, Float.parseFloat(amount));		
		customerService.addAmountFromRecipient(recipient, Float.parseFloat(amount));
		
		transaction.setPaymentMethod("transfer");
		transactionService.save(transaction);
		

		
		return "redirect:/admin/customer/fund_transfer?success";

	}
	
	
	
}
