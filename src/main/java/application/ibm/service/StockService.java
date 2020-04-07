package application.ibm.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import application.ibm.model.Stock;
import application.ibm.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository stockRepository;
	
	public Iterable<Stock> findByAccountIdAndQuanityCheck(String accountId, int quanity){				
		return stockRepository.findByAccountIdAndQuanityCheck(accountId, quanity);		
	}
	
	
	public Stock findByHoldingIdAndQuanityCheck(Long id, int quanity) {		
		return stockRepository.findByHoldingIdAndQuanityCheck(id, quanity);
	}
	
	public Stock  save(Stock stock) {
		return stockRepository.save(stock);		  
	}
	
	public void   delete(Long id) {
		 stockRepository.delete(id);		  		 
	}
	
	public void   deleteAll() {
		 stockRepository.deleteAll();		  		 
	}
}
