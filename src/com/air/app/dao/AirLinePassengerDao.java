package com.air.app.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.air.app.dto.AirLinePassengerDto;

public class AirLinePassengerDao {
		private static AirLinePassengerDao airLinePassengerDao=null;
		private Configuration configuration=null;
		private SessionFactory factory=null;
		
		private AirLinePassengerDao() {
			configuration=new Configuration();
			configuration.configure();
			configuration.addAnnotatedClass(AirLinePassengerDto.class);
			factory= configuration.buildSessionFactory();
		}
		public static AirLinePassengerDao getInstance() {
			if(airLinePassengerDao ==null) {
				airLinePassengerDao=new AirLinePassengerDao();
				return airLinePassengerDao;
			}
			return airLinePassengerDao;
		}
		public void saveAirlinePassangerDetails(AirLinePassengerDto airLinePassengerDto) {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(airLinePassengerDto);
			transaction.commit();
			session.close();
		}
		public AirLinePassengerDto getAirlinePassangerDetailsByTicket(String generatedTicket) {
			Session session = factory.openSession();
			String hql="from "+AirLinePassengerDto.class.getName()+" where generatedTicketNo=:gnt";
			Query query = session.createQuery(hql);
			query.setParameter("gnt", generatedTicket);
			return (AirLinePassengerDto) query.uniqueResult();
		}
		public void deleteAirlinePassengerByTicket(String generatedTicket) {
			AirLinePassengerDto aDto=getAirlinePassangerDetailsByTicket(generatedTicket);
			if(aDto!=null) {
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(aDto);
			transaction.commit();
			}
			else System.out.println("Nothig Found");
		}
		
}
