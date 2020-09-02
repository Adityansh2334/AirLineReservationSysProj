package com.air.app.util;

import com.air.app.dao.AuthorizationDao;
import com.air.app.dto.AuthorizationDto;

public class AuthorizationTest {

	public static void main(String[] args) {
//		AuthorizationDto authorizationDto= new AuthorizationDto();
//		authorizationDto.setId(3);
//		authorizationDto.setName("Reetu Parna");
//		authorizationDto.setPayId("HTR67590TY");
//		authorizationDto.setUserName("Parna_reetu");
		AuthorizationDao authorizationDao=AuthorizationDao.getInstance();
//		authorizationDao.savePremiumCustomerData(authorizationDto);
		System.out.println(authorizationDao.getDetailsByCustomerPayId("HTR67590TY"));
	}

}
