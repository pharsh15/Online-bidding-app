package OnlineBid;

import java.util.Scanner;

public class OnlineBid {
	public OnlineBid() 
	{
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Data d = new Hibernate();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your login ID");
		String i = input.nextLine(); 
		
		String selection = "";
		while(!selection.equals("x"))  //while not x, keep displaying the menu
		{
			//display the menu
			System.out.println();
            System.out.println("Please enter your selection:");
            System.out.println("1: List a new item");
            System.out.println("2: See all my listings");
            System.out.println("3: Search and bid");
            System.out.println("4: See my bids");
            System.out.println("x: Leave");
            System.out.println();
			
			//get the selection from the user
			selection = input.nextLine();
			System.out.println();
			
			if(selection.equals("1"))
			{
				user u = new user(i,d);
				//list a new item
				u.listing_items();
			}
			else if(selection.equals("2"))
			{
				//see all listings
				user u = new user(i,d);
				u.listed_items();
				
				 
			}
			else if(selection.equals("3"))
			{
				//search and bid
				user u = new user(i,d);
				u.search();
			}
			else if(selection.equals("4"))
			{
				//see all my 
				user u = new user(i,d);
				u.see_bids();
			}
			
			else if(selection.equals("x"))
			{
				//leave
				System.out.println("Bye bye!");
			}
			 
		}
		
		


	}
	
}
