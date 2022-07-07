package OnlineBid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bid")

public class bid {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="buyerID")
	private String buyerID;
	
	@Column(name="item")
	private String item;
	
	@Column(name="sellerID")
	private String sellerID;
	
	@Column(name="offerPrice")
	private int offerPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuyerID() {
		return buyerID;
	}

	public void setBuyerID(String buyerID) {
		this.buyerID = buyerID;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getSellerID() {
		return sellerID;
	}

	public void setSellerID(String sellerID) {
		this.sellerID = sellerID;
	}

	public int getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(int offerPrice) {
		this.offerPrice = offerPrice;
	}

	public bid(int id, String buyerID, String item, String sellerID, int offerPrice) {
		super();
		this.id = id;
		this.buyerID = buyerID;
		this.item = item;
		this.sellerID = sellerID;
		this.offerPrice = offerPrice;
	}
	
	public bid() {
		
	}
	
	

}
