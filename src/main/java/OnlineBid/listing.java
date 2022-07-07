package OnlineBid;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="listing")

public class listing {
	
	@Id
	@Column(name="item")
	private String item;
	
	@Column(name="sellerID")
	private String sellerID;
	
	@Column(name="curPrice")
	private int curPrice;
	
	@Column(name="resPrice")
	private int resPrice;
	
	@Column(name="numBids")
	private int numBids;
	
	@Column(name="buyerID")
	private String buyerID;
	
	@Column(name="status")
	private String status;

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

	public int getCurPrice() {
		return curPrice;
	}

	public void setCurPrice(int curPrice) {
		this.curPrice = curPrice;
	}

	public int getResPrice() {
		return resPrice;
	}

	public void setResPrice(int resPrice) {
		this.resPrice = resPrice;
	}

	public int getNumBids() {
		return numBids;
	}

	public void setNumBids(int numBids) {
		this.numBids = numBids;
	}

	public String getBuyerID() {
		return buyerID;
	}

	public void setBuyerID(String buyerID) {
		this.buyerID = buyerID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public listing(String item, String sellerID, int curPrice, int resPrice, int numBids, String buyerID,
			String status) {
		super();
		this.item = item;
		this.sellerID = sellerID;
		this.curPrice = curPrice;
		this.resPrice = resPrice;
		this.numBids = numBids;
		this.buyerID = buyerID;
		this.status = status;
	}
	
	

	public listing() 
	{
	
	}
}
