package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Supplier;

@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao{
	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;

		}

	@Transactional
		public void saveOrUpdate(Supplier supplier) {
			sessionFactory.getCurrentSession().saveOrUpdate(supplier);

		}

	@Transactional
		public void delete(String id) {
			Supplier supToDelete = new Supplier();
			supToDelete.setId(id);
			sessionFactory.getCurrentSession().delete(supToDelete);

		}

	@Transactional
		public Supplier get(String id) {

			// sessionFactory.getCurrentSession().get(Supplier.class,id);
			String hql = "from Supplier where Id=" + "'" + id + "'";
			Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
			List<Supplier> listSupplier = (List<Supplier>) query.getResultList();
			if (listSupplier != null && !listSupplier.isEmpty()) {
				return listSupplier.get(0);
			}
			return null;
		}

	@Transactional
		public List<Supplier> list() {
			@SuppressWarnings("unchecked")
			List<Supplier> listSupplier = (List<Supplier>) sessionFactory.getCurrentSession()
			.createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listSupplier;
		}
	

}
