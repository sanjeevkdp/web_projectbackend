package com.niit.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.UserLogin;

@Repository("userLoginDao")
public class UserLoginDaoImpl implements UserLoginDao {
	@Autowired
	private SessionFactory sessionFactory;

	public UserLoginDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;

		}

	@Transactional
		public void saveOrUpdate(UserLogin userLogin) {
			sessionFactory.getCurrentSession().saveOrUpdate(userLogin);

		}

	@Transactional
		public void delete(String id) {
		UserLogin userToDelete = new UserLogin();
			userToDelete.setId(id);
			sessionFactory.getCurrentSession().delete(userToDelete);

		}

	@Transactional
		public UserLogin get(String id) {

			// sessionFactory.getCurrentSession().get(UserLogin.class,id);
			String hql = "from Product where Id=" + "'" + id + "'";
			Query query =(Query) sessionFactory.getCurrentSession().createQuery(hql);
			List<UserLogin> listuserLogin = (List<UserLogin>) query.getResultList();
			if (listuserLogin  != null && !listuserLogin .isEmpty()) {
				return listuserLogin.get(0);
			}
			return null;
		}

	@Transactional
		public List<UserLogin> list() {
			@SuppressWarnings("unchecked")
			List<UserLogin> listuserLogin= (List<UserLogin>) sessionFactory.getCurrentSession()
			.createCriteria(UserLogin.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return listuserLogin;
		}

}
