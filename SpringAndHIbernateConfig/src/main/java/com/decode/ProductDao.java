package com.decode;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDao 
{
	@Autowired
	SessionFactory sessionfactory;
	
	public void setProducts(ProductBean productbean)
	{
		 Session session=sessionfactory.openSession();
		 Transaction tr=session.beginTransaction();
		 session.save(productbean);
		 tr.commit();
		session.close();
	}
	
	public void deleteProduct(ProductBean code)
	{
		Session session=sessionfactory.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(code);
		tr.commit();
		session.close();
	}
	
	public List showproducts()
	{
		Session session=sessionfactory.openSession();
		Criteria criteria=session.createCriteria(ProductBean.class);
		List data=criteria.list();
		return data;
	}
}


