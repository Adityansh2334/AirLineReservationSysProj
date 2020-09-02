package com.air.app.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.air.app.dao.AirLinePassengerDao;
import com.air.app.dto.AirLinePassengerDto;

public class TestAirlinePassenger {

	public static void main(String[] args) {
//		AirLinePassengerDto airLinePassengerDto= new AirLinePassengerDto();
//		airLinePassengerDto.setPassengerName("Adi");
//		airLinePassengerDto.setAssignedSeatNo("FC-23");
//		airLinePassengerDto.setForAirPlane("AirAsia");
//		airLinePassengerDto.setFromRoute("Bengaluru");
//		airLinePassengerDto.setToRoute("Bhubaneswar");
//		airLinePassengerDto.setPassengerAge(23);
//		airLinePassengerDto.setSeatPreference("First-Class");
//		airLinePassengerDto.setTicketPrice(7000.87);
//		airLinePassengerDto.setPaid(true);
//		airLinePassengerDto.setGeneratedTicketNo("TK190OP");
//		Date dt= new Date();
//		Timestamp ts=new Timestamp(dt.getTime());
//		airLinePassengerDto.setBookTime(ts);
		AirLinePassengerDao airLinePassengerDao= AirLinePassengerDao.getInstance();
//		airLinePassengerDao.saveAirlinePassangerDetails(airLinePassengerDto);
		airLinePassengerDao.deleteAirlinePassengerByTicket("AIR6167TK");
	}

}
