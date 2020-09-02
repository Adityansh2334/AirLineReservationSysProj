package com.air.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.air.app.dto.AuthorizationDto;

public class AuthorizationDao {
		private static AuthorizationDao authorizationDao=null;
		private Configuration configuration=null;
		private SessionFactory factory=null;
		private AuthorizationDao() {
			configuration=new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(AuthorizationDto.class);
			factory=configuration.buildSessionFactory();
		}
		public static AuthorizationDao getInstance() {
			if(authorizationDao==null) {
				authorizationDao=new AuthorizationDao();
				return authorizationDao;
			}
			return authorizationDao;
		}
		public void savePremiumCustomerData(AuthorizationDto authorizationDto) {
			Session openSession = factory.openSession();
			Transaction beginTransaction = openSession.beginTransaction();
			openSession.save(authorizationDto);
			beginTransaction.commit();
			openSession.close();
		}
		public AuthorizationDto getDetailsByCustomerPayId(String payId) {
			Session openSession = factory.openSession();
			String hql="from "+AuthorizationDto.class.getName()+" where payId=:id";
			Query createQuery = openSession.createQuery(hql);
			createQuery.setParameter("id", payId);
			return (AuthorizationDto) createQuery.uniqueResult();
		}
}
