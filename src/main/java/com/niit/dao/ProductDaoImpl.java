package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Product;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;

		}

	@Transactional
		public void saveOrUpdate(Product product) {
			sessionFactory.getCurrentSession().saveOrUpdate(product);

		}

	@Transactional
		public void delete(String id) {
		Product proToDelete = new Product();
			proToDelete.setId(id);
			sessionFactory.getCurrentSession().delete(proToDelete);

		}

	@Transactional
		public Product get(String id) {

			// sessionFactory.getCurrentSession().get(Product.class,id);
			String hql = "from Product where Id=" + "'" + id + "'";
			Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
			List<Product> listProduct = (List<Product>) query.getResultList();
			if (listProduct  != null && !listProduct .isEmpty()) {
				return listProduct .get(0);
			}
			return null;
		}

	@Transactional
		public List<Product> list() {
			@SuppressWarnings("unchecked")
			List<Product> listProduct  = (List<Product>) sessionFactory.getCurrentSession()
			.createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listProduct;
		}
}
