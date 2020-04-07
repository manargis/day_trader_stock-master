package application.ibm.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import application.ibm.validation.CheckDateFormat;

@Entity
@Table(name ="dt_user_stocks")
public class Stock {
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Long holdingId;
	
	@NotEmpty(message = "User id can not be blank.")
	private String accountId;
	
	
	
	//@CheckDateFormat(pattern = "ddMMyyyy")
	private Timestamp  purchaseDate;
	
	@NotEmpty(message = "Symbol can not be blank.")
	private String symbol;
	
	
	@NotEmpty(message = "Company name is mandatory")
	private String companyName;
	
	
	@Min(value  = 1, message = "Quanity quantity must be greator than 0. ")
	@Max(value = 1000, message = "Quanity can not be greator than 1000.")
	@Digits(integer=10, fraction=0 ,message = "Quantity must be in round number.  ")
	private int quantity;
	
	@Min(value  = 0, message = "Price must be greator than 0. ")
	private double price;
	
	public Long getHoldingId() {
		return holdingId;
	}
	public void setHoldingId(Long holdingId) {
		this.holdingId = holdingId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Stock [holdingId=" + holdingId + ", accountId=" + accountId + ", purchaseDate=" + purchaseDate
				+ ", symbol=" + symbol + ", companyName=" + companyName + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
	
	
	
	
}
