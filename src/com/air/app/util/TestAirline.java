package com.air.app.util;

import com.air.app.dao.AirLineDao;
import com.air.app.dto.AirLineDto;

public class TestAirline {

	public static void main(String[] args) {
		AirLineDto airLineDto=new AirLineDto();
		airLineDto.setAirName("AirAsia");
		airLineDto.setAirCompany("AirAsia PVT. LTD");
		airLineDto.setAirRegistrationNo("AIR202012");
		airLineDto.setAirRoute("Bengaluru-Bhubaneswar");
		airLineDto.setAirStaffsCount(44);
		airLineDto.setAirType("National");
		airLineDto.setEconomyPrice(3000.87);
		airLineDto.setFirstClassPrice(7000.23);
		airLineDto.setTotalSeatStrength(50l);
		airLineDto.setEconomySeats(30);
		airLineDto.setFirstClassSeats(20);
		AirLineDao airLineDao=AirLineDao.getInstance();
		airLineDao.saveAirlineDetails(airLineDto);
//		System.out.println(airLineDao.getAirlineDetailsByName("AirAsia"));
//		airLineDao.deleteAirlineByName("AirAsia");
	}

}
