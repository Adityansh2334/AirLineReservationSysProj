package com.air.app.util;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.air.app.dao.AirLinePassengerDao;
import com.air.app.dao.AuthorizationDao;
import com.air.app.dto.AirLinePassengerDto;
import com.air.app.dto.AuthorizationDto;

public class PassengerServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		System.out.println(name);
		String age=req.getParameter("age");
		System.out.println(age);
		String planeComp=req.getParameter("planecomp");
		System.out.println(planeComp);
		String seatno=req.getParameter("seatno");
		System.out.println(seatno);
		String dtdep=req.getParameter("datedep");
		String dtret=req.getParameter("dateret");
		String phone=req.getParameter("phone");
		String seatprefer=req.getParameter("seatrefer");
		System.out.println(seatprefer);
		String triptyp=req.getParameter("triptyp");
		String ticketprice=req.getParameter("ticketprice");
		String username=req.getParameter("username");
		String payid=req.getParameter("payid");
		String from=req.getParameter("from");
		System.out.println(from);
		String to=req.getParameter("to");
		AuthorizationDao authorizationDao=AuthorizationDao.getInstance();
		AuthorizationDto id = authorizationDao.getDetailsByCustomerPayId(payid);
		if(id!=null) {
			if(id.getUserName().equals(username)) {
				int i=(int)(Math.random()* (10000-500+1)+500);
				String generatedTicket="AIR"+i+"TK";
				
				Timestamp ts= new Timestamp(new Date().getTime());
				
				req.setAttribute("name", name);
				req.setAttribute("age", age);
				req.setAttribute("planeComp", planeComp+"PVT. LTD");
				if(seatprefer.equals("Economy Class"))req.setAttribute("seatno", seatno+"-ECO");
				if(seatprefer.equals("First Class"))req.setAttribute("seatno", seatno+"-FCLASS");
				req.setAttribute("dtdep", dtdep);
				req.setAttribute("dtret", dtret);
				req.setAttribute("phone", phone);
				req.setAttribute("seatprefer", seatprefer);
				req.setAttribute("triptyp", triptyp);
				req.setAttribute("ticketprice", ticketprice);
				req.setAttribute("from", from);
				req.setAttribute("to", to);
				req.setAttribute("Ticket", generatedTicket);
				req.setAttribute("Time", ts.toString());
				
				
				AirLinePassengerDto airLinePassengerDto=new AirLinePassengerDto();
				if(seatprefer.equals("Economy Class"))airLinePassengerDto.setAssignedSeatNo(seatno+"-ECO");
				if(seatprefer.equals("First Class"))airLinePassengerDto.setAssignedSeatNo(seatno+"-FCLASS");
				airLinePassengerDto.setForAirPlane(planeComp+"PVT. LTD");
				airLinePassengerDto.setFromRoute(from);
				airLinePassengerDto.setToRoute(to);
				airLinePassengerDto.setPaid(true);
				airLinePassengerDto.setPassengerAge(Integer.parseInt(age));
				airLinePassengerDto.setPassengerName(name);
				airLinePassengerDto.setSeatPreference(seatprefer);
				airLinePassengerDto.setTicketPrice(Double.parseDouble(ticketprice));
				airLinePassengerDto.setTripType(triptyp);
				airLinePassengerDto.setGeneratedTicketNo(generatedTicket);
				airLinePassengerDto.setBookTime(ts);
				
				
				AirLinePassengerDao airLinePassengerDao=AirLinePassengerDao.getInstance();
				airLinePassengerDao.saveAirlinePassangerDetails(airLinePassengerDto);
				
				LinkedList<Integer> listEconomy = PlaneServlet.getListEconomy();
				LinkedList<Integer> listFirstClass = PlaneServlet.getListFirstClass();
				Integer sn = Integer.parseInt(seatno);
				if(seatprefer.equals("Economy Class"))System.out.println(listEconomy.remove(sn));
				if(seatprefer.equals("First Class"))System.out.println(listFirstClass.remove(sn));
				
				
				System.out.println(PlaneServlet.getListEconomy().size());
				System.out.println(PlaneServlet.getListFirstClass().size());
				RequestDispatcher rd= req.getRequestDispatcher("Confirmation.jsp");
				rd.forward(req, resp);
			}
		}
		else
		{
			
			req.setAttribute("plane", planeComp+"PVT. LTD");
			if(seatprefer.equals("Economy Class"))req.setAttribute("seatNo", seatno+"-ECO");
			if(seatprefer.equals("First Class"))req.setAttribute("seatNo", seatno+"-FCLASS");
			req.setAttribute("depdt", dtdep);
			req.setAttribute("retdt", dtret);
			req.setAttribute("preference", seatprefer);
			req.setAttribute("trip", triptyp);
			req.setAttribute("ticketprice", ticketprice);
			
			req.setAttribute("Validation", true);
			RequestDispatcher rd=req.getRequestDispatcher("AirlIneData.jsp");
			rd.forward(req, resp);
		}
	}

}
