package com.air.app.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.air.app.dto.AirLineDto;

public class AirLineDao {
	private static AirLineDao airLineDao=null;
	private Configuration configuration=null;
	private SessionFactory factory=null;
		private AirLineDao() {
			configuration=new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(AirLineDto.class);
			factory=configuration.buildSessionFactory();
		}
    public static AirLineDao getInstance() {
    	if(airLineDao ==  null) {
    		airLineDao=new AirLineDao();
    		return airLineDao;
    	}
    	return airLineDao;
    }
	public void saveAirlineDetails(AirLineDto airLineDto) {
		Session openSession = factory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		openSession.save(airLineDto);
		beginTransaction.commit();
		openSession.close();
	}
	public List<AirLineDto> getAirlineDetailsByRoute(String airRoute) {
		Session openSession = factory.openSession();
		String hql="from "+AirLineDto.class.getName()+" where airRoute=:an";
		Query<AirLineDto> createQuery = openSession.createQuery(hql);
		createQuery.setParameter("an", airRoute);
		List<AirLineDto> list = createQuery.list();
		return list;
	}
	
//	public void deleteAirlineByName(String airlineName) {
//	
//		if(airLineDto != null) {
//			Session openSession = factory.openSession();
//			Transaction beginTransaction = openSession.beginTransaction();
//			openSession.delete(airLineDto);
//			beginTransaction.commit();
//			System.out.println("deleted");
//			openSession.close();
//		}
//	}
}
