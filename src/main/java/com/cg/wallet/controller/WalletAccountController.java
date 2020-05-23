package com.cg.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.wallet.entity.WalletAccount;
import com.cg.wallet.entity.WalletTransactions;
import com.cg.wallet.exception.WalletAccountException;
import com.cg.wallet.service.WalletAccountService;

@RestController
@CrossOrigin("*")
public class WalletAccountController {
	
	@Autowired
	WalletAccountService walletAccountService;
	
	
	@GetMapping("walletAccount/{id}")
	public ResponseEntity<WalletAccount> findAccountById(@PathVariable("id")int id) throws WalletAccountException
	{
		WalletAccount account=walletAccountService.findAccountById(id);
		ResponseEntity<WalletAccount> wacc=new ResponseEntity<WalletAccount>(account,HttpStatus.OK);
		return wacc;


	}

	@GetMapping("walletAccount")
	public ResponseEntity<List<WalletAccount>> findAllAccounts() throws WalletAccountException
	{
		List<WalletAccount> list = walletAccountService.findAllAccounts();
		ResponseEntity<List<WalletAccount>>  rt = new ResponseEntity<List<WalletAccount>>(list,HttpStatus.OK);
		return rt;
	}
	
	
	@PutMapping("walletAccount/id/{id}/amount/{amount}")
	public ResponseEntity<WalletAccount> withdraw(@PathVariable("id")int id,@PathVariable("amount")double amount) throws WalletAccountException
	{
		WalletAccount account=walletAccountService.withdraw(id, amount);
		ResponseEntity<WalletAccount> re=new ResponseEntity<WalletAccount>(account,HttpStatus.OK);
		return re;
	}
	
	

	@GetMapping("walletTransactions/{id}")
	public ResponseEntity<List<WalletTransactions>> printAllTransactionsById(@PathVariable("id") int id) throws WalletAccountException
	{
		List<WalletTransactions> list=walletAccountService.printAllTransactionsById(id);
		ResponseEntity<List<WalletTransactions>> re=new ResponseEntity<List<WalletTransactions>>(list,HttpStatus.OK);
		return re;
	}
	
	
	@PutMapping("walletAccount/id/{id1}/id/{id2}/amount/{amount}")
	public ResponseEntity<WalletAccount> fundTransfer(@PathVariable("id1")int id1,@PathVariable("id2")int id2,@PathVariable("amount")double amount) throws WalletAccountException
	{
		WalletAccount walletAccount=walletAccountService.fundTransfer(id1,id2,amount);
		ResponseEntity<WalletAccount> re=new ResponseEntity<WalletAccount>(walletAccount,HttpStatus.OK);
		return re;
	}
			
	
	/*@GetMapping("walletAccount/{id}")
	public ResponseEntity<WalletAccount> getWalletAccount(@PathVariable("id") int id) throws WalletAccountException
	{
		WalletAccount account=walletAccountService.getWalletAccount(id);
		ResponseEntity<WalletAccount> wacc=new ResponseEntity<>(account,HttpStatus.OK);
		return wacc;
	}
	
	@GetMapping("walletAccount")
	public ResponseEntity<List<WalletAccount>> findAllTrainees() throws WalletAccountException
	{
		List<WalletAccount> list = walletAccountService.findAllAccounts();
		ResponseEntity<List<WalletAccount>>  rt = new ResponseEntity<List<WalletAccount>>(list,HttpStatus.OK);
		return rt;
			}*/
}
