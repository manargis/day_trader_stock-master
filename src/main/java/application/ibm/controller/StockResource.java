package application.ibm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Iterables;

import application.ibm.exception.RecordNotFoundException;
import application.ibm.model.Stock;
import application.ibm.service.StockService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/rest/stock")
@RestController
public class StockResource {
	
	
	private ResponseEntity reponseEntity; 
	
	@Autowired 
	StockService stockService;
	
	
	//getHoldings("select *, quoteid from holdingejb h where h.account_accountid = userId")
	//getQuotes(select * from quoteejb q where q.symbol=?)
	@GetMapping("/getHoldings/{accountId}") 
	public ResponseEntity<Iterable<Stock>> getHoldings(@Valid @PathVariable String accountId, Model model){				
		
		int quanity =0; // for quanity must be greator than 0
		
		Iterable<Stock> it  = stockService.findByAccountIdAndQuanityCheck(accountId, quanity);
		
		
		
		System.out.println("getHoldings Hemant ().." + Iterables.size(it));
		
		if (Iterables.size(it) <1 ) {
			throw new RecordNotFoundException("Record Not Found");
		}
		
		model.addAttribute("stocks", it);
		
		return new ResponseEntity<Iterable<Stock>>(it, HttpStatus.OK);
	} 
	
	@GetMapping("/getHolding/{holdingId}") 
	public ResponseEntity<Stock> getHolding(@Valid @PathVariable Long holdingId){		
		
		int quanity =0; // for quanity must be greator than 0
		
		Stock stock  = stockService.findByHoldingIdAndQuanityCheck(holdingId, quanity);		
		System.out.println("getHolding ().." + stock);
		
		if (stock == null) {
			throw new RecordNotFoundException("Record Not Found "+holdingId +".");
		}		
		return 	new ResponseEntity<Stock>(stock, HttpStatus.OK);	
	} 
	
	
	@PostMapping("/saveStock")
	public ResponseEntity<Stock>  save(@Valid @RequestBody Stock stock) {
		
		System.out.println("save().." +  stock);
		int quanity =0;
		
		stockService.save(stock);
		Stock st = stockService.findByHoldingIdAndQuanityCheck(stock.getHoldingId(), quanity);
		
		return new ResponseEntity<Stock>(st, HttpStatus.OK);
	}
	
	
	
	
	@DeleteMapping("/delete/{id}")
	public void   delete(@PathVariable Long id) {
		stockService.delete(id);		  		 
	}
	
	@DeleteMapping("/deleteAll")
	public void   deleteAll() {
		stockService.deleteAll();		  		 
	}
	
	
	
}
