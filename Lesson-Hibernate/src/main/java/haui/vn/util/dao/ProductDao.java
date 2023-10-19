package haui.vn.util.dao;

import java.util.List;
import haui.vn.model.Product;
import haui.vn.util.HibernateUtil;
import javax.persistence.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
public class ProductDao implements DAOInterface<Product> {

	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public List<Product> selectAll() {
		List<Product> list = new ArrayList<>();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			//Create a session factory 
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				//Create new transaction
				Transaction transaction = session.beginTransaction();
				
				//Enforcement(TThi) query 
				String hql = "select p from Product p";
				Query query = session.createQuery(hql);
				list = query.getResultList();
				transaction.commit();//Finish transaction 
				session.close();//free up resources 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product selectById(Product t) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory!=null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				Integer productId = t.getId();
				//The way 1 
//				Product result = session.get(Product.class, productId);
				
				//The way 2 
				String sql = "from Product p where p.id = :productId";
				Query query = session.createQuery(sql);
				
				query.setParameter("productId" , productId);
				
				Product result2 = (Product)query.getSingleResult();
					
				transaction.commit();
				session.close();
//					return result;
				return result2;	
			}
		}catch(Exception e) {
			return null;
		}
		return null;
	}

	
	public boolean saveOrUpdate(Product p) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			//Created new record if not exists , and updated if existed 
			//The way 1 
			session.saveOrUpdate(p);
			transaction.commit();
			session.close();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public boolean insert(Product p) {
		return saveOrUpdate(p);
	}

	@Override
	public boolean update(Product p) {
		return saveOrUpdate(p);
	}

	@Override
	public boolean delete(Product p) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			if(sessionFactory != null) {
				Session session = sessionFactory.openSession();
				Transaction transaction = session.beginTransaction();
				
				//The way 1
				session.delete(p);
				
				//The way 2 
				//String sql = "delete from Product p where p.id = :productId";
				
				transaction.commit();
				session.close();
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
