package OnlineBid;

import java.util.ArrayList;
import java.util.Scanner;

import org.hibernate.internal.build.AllowSysOut;

public class user {
	
	private String i;
	private Data D;
	public String getI() {
		return i;
	}
	public void setI(String i) {
		this.i = i;
	}
	public Data getD() {
		return D;
	}
	public void setD(Data d) {
		D = d;
	}
	public user(String i, Data d) {
		super();
		this.i = i;
		D = d;
	}
	public void listing_items()
	{
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the Discription of the listing");
		String item =input.nextLine();
		int cprice=0;
		System.out.println("Please enter the reserved price of the item you want to sell the item");
		int rprice= input.nextInt();
		int nbids = 0;
		String bid = "";
		String st="In progress";
		
		getD().list_item(item, i, cprice, rprice, nbids, bid, st);
		
	}
	
	public void listed_items() 
	{
		
		System.out.println(" "+i+" you have following list of listed items: ");
		
		ArrayList<Object[]> listed = getD().get_list(i);
		
		for(int i=0; i<listed.size(); i++) 
		{
			System.out.println(i+1 +" Item:"+ listed.get(i)[0] +" having current price:"+listed.get(i)[1] +" Number of bids:"+listed.get(i)[2]+" Status of the bid:"+ listed.get(i)[3] );
		}
		
	}
	
	public void search() 
	{
		System.out.println("We have following listings for bids");
		
		ArrayList<Object[]> search = getD().get_search();
		
		for(int i=0; i<search.size(); i++) 
		{
			System.out.println(i+1 + " "+ search.get(i)[0]);		
		}
		
		System.out.println("Enter the number to bid the item");
		Scanner input = new Scanner(System.in);
		int k = input.nextInt();
		int k1 = k-1;
		
		String item= search.get(k1)[0].toString();
		String seller = search.get(k1)[1].toString();
		if(i.equals(seller)) 
		{
			System.out.println("You can not bid on your own listing");
			
		}
		else 
		{
			System.out.println("Enter the amount to bid the item");
			int new_bid = input.nextInt();
			
			getD().bid(i,item, seller, new_bid);
			
			ArrayList<Integer> num_bid = getD().number_bid(item);
			int nbid= num_bid.get(0);
			if(nbid <= 1) 
			{
				getD().update_list(item, new_bid, seller);
			}
			else
			{
				String new_status="Unsold";
				getD().update2_list(item, new_bid, seller, new_status);
			}
			
			ArrayList<Object[]> status = getD().price(item);
			int cprice= Integer.parseInt(status.get(0)[0].toString());
			int reqprice= Integer.parseInt(status.get(0)[1].toString());
			
			
			if(cprice>reqprice) 
			{
				getD().update_sold(item);
			}
			else
			{
				return;
			}
			
		}
		}
	
	
	public void see_bids() 
	{
		System.out.println("You have following bids");
		
		ArrayList<Object[]> bids = getD().my_bids(i);
		
		for(int i=0; i<bids.size(); i++) 
		{
			
			System.out.println(i+1 + " "+ bids.get(i)[0] +" "+ bids.get(i)[1]);
		}
		
		System.out.println("Enter the number to view the bid in detail:");
		
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int m1 = m-1;
		
		String sitem= bids.get(m)[0].toString();
		
		
		ArrayList<Object[]> bid_detail = getD().my_bid_detail(sitem);
		
		for(int i=0; i<bid_detail.size(); i++) 
		{
			System.out.println(i+1 + " "+ bid_detail.get(i)[0] +" "+ bid_detail.get(i)[1]+" "+ bid_detail.get(i)[2]+" "+ bid_detail.get(i)[3]);
		}
		
		String check_status="";
		check_status= bid_detail.get(0)[3].toString();
		String buyer_id = bid_detail.get(0)[4].toString();
		
		if(check_status.equals("Sold")) 
		{
			if(buyer_id.equals(i)) 
			{
				System.out.println("You are the winner");
			}
			else 
			{
				System.out.println("You are outbid");
			}
			
		}
		else if(check_status.equals("UnSold")) 
		{
			System.out.println("Sorry the item is Unsold");
			
		}
		else 
		{
			System.out.println("You are the highest bidder");
		}
		
		
		
		
	}
	
	
}
