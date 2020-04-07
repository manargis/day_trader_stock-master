package application.ibm.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import application.ibm.model.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long>{

	
	@Query("select dus from Stock dus where dus.accountId = (?1) and dus.quantity > (?2)")
	Iterable<Stock> findByAccountIdAndQuanityCheck(String accountId, int quanity);
	
	@Query("select dus from Stock dus where dus.holdingId = (?1) and dus.quantity > (?2)")
	Stock findByHoldingIdAndQuanityCheck(Long holdingId, int quanity);
	
	
	

}
