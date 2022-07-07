package OnlineBid;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class Hibernate implements Data {
	
protected SessionFactory sessionFactory;
	
	public Hibernate() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setup()
	{
		final StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure().build();
		try
		{
			sessionFactory = new MetadataSources(reg).buildMetadata().buildSessionFactory();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			StandardServiceRegistryBuilder.destroy(reg);
		}
	}
	
	public void exit()
	{
		sessionFactory.close();
	}
	
	
	public void list_item(String item, String i, int cprice, int rprice, int nbids, String bid, String st) 
	{
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		listing list = new listing(item,i,cprice,rprice,nbids,bid,st);
		session.save(list);
		session.getTransaction().commit();
		session.close();
		exit();
		
	}
	
	public ArrayList<Object[]> get_list(String i)
	{
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String hql="Select l.item, l.curPrice, l.numBids, l.status from listing l where l.sellerID = :sellerID";
		Query query = session.createQuery(hql);
		query.setParameter("sellerID", i);
		ArrayList<Object[]>new_list =(ArrayList<Object[]>)query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		exit();
		return new_list;
	}
	
	public ArrayList<Object[]> get_search()
	{
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String new_st="In progress";
		String hql="Select l.item, l.sellerID from listing l where l.status = :status";
		Query query = session.createQuery(hql);
		query.setParameter("status", new_st);
		
		ArrayList<Object[]>searched =(ArrayList<Object[]>)query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		exit();
		return searched;
		
	}


	public void bid(String i,String item, String seller,int new_bid)
	{
		// TODO Auto-generated method stub
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		bid b = new bid(0,i, item, seller, new_bid);
		
		session.save(b);
		session.getTransaction().commit();
		session.close();
		exit();
		
		
	}


	public void update_list(String item, int new_bid,String seller)
	{
		
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		listing l = session.get(listing.class,item);
		l.setCurPrice(new_bid);
		l.setNumBids(1);
		l.setBuyerID(seller);
		session.update(l); 
		
		session.getTransaction().commit();
		session.close(); 
		exit();
		}


	public ArrayList<Integer> number_bid(String item) {
		// TODO Auto-generated method stub
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String hql="Select l.numBids from listing l where l.item = :item";
		Query query = session.createQuery(hql);
		query.setParameter("item", item);
		
		ArrayList<Integer> number_bids =(ArrayList<Integer>)query.list();
		
		session.getTransaction().commit();
		session.close();
		exit();
		return number_bids;
		
		
	}


	public void update2_list(String item, int new_bid, String seller, String new_status)
	{
		// TODO Auto-generated method stub
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		listing l = session.get(listing.class,item);
		l.setCurPrice(new_bid);
		l.setNumBids(2);
		l.setBuyerID(seller);
		l.setStatus(new_status);
		session.update(l); 
		
		session.getTransaction().commit();
		session.close(); 
		exit();
	}


	public ArrayList<Object[]> price(String item)
	{
		// TODO Auto-generated method stub
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String new_st="In progress";
		String hql="Select l.curPrice, l.resPrice from listing l where l.item = :item";
		Query query = session.createQuery(hql);
		query.setParameter("item", item);
		
		ArrayList<Object[]>price_match =(ArrayList<Object[]>)query.getResultList();
		session.getTransaction().commit();
		session.close();
		exit();
		return price_match;
		
		
	}


	public void update_sold(String item) 
	{
		// TODO Auto-generated method stub
		
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		listing l = session.get(listing.class,item);
		l.setStatus("Sold");
		session.update(l); 
		
		session.getTransaction().commit();
		session.close(); 
		exit();
		
	}


	public ArrayList<Object[]> my_bids(String i) 
	{
		// TODO Auto-generated method stub
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String new_st="In progress";
		String hql="Select b.item, l.offerPrice from bid b where b.buyerID = :buyerID";
		Query query = session.createQuery(hql);
		query.setParameter("buyerID", i);
		
		ArrayList<Object[]>bids =(ArrayList<Object[]>)query.getResultList();
		session.getTransaction().commit();
		session.close();
		exit();
		return bids;
		
		
		
		
	}


	public ArrayList<Object[]> my_bid_detail(String sitem) 
	{
		// TODO Auto-generated method stub
		setup();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		String hql="Select l.item, l.sellerID, l.resPrice, l.status, l.buyerID from listing l where l.item = :item";
		Query query = session.createQuery(hql);
		query.setParameter("item", sitem);
		
		ArrayList<Object[]>my_detail =(ArrayList<Object[]>)query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		exit();
		return my_detail;
		
		
		
	}
	
	
	
	

		
	}
		
		
	
	
		
		
		
		
	
	
	




