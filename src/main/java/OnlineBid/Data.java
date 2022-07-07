package OnlineBid;

import java.util.ArrayList;

public interface Data {
	
	void list_item(String item, String i, int cprice, int rprice, int nbids, String bid, String st);
	ArrayList<Object[]>get_list(String i);
	ArrayList<Object[]>get_search();
	void bid(String i,String item, String seller,int new_bid);
	void update_list(String item, int new_bid, String seller);
	ArrayList<Integer> number_bid(String item);
	void update2_list(String item, int new_bid, String seller, String new_status);
	ArrayList<Object[]> price(String item);
	void update_sold(String item);
	ArrayList<Object[]> my_bids(String i);
	ArrayList<Object[]> my_bid_detail(String sitem);
}
