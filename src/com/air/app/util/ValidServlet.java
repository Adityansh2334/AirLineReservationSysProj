package com.air.app.util;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String seatNo=req.getParameter("seatNo");
			Integer sn=Integer.parseInt(seatNo);
			String trip=req.getParameter("trip");
			String depdt=req.getParameter("depar");
			String retdt=req.getParameter("return");
			String from=req.getParameter("from");
			String to=req.getParameter("to");
			String preference=req.getParameter("prefer");
			String plane=req.getParameter("planename");
			System.out.println(PlaneServlet.getListEconomy().size());
			System.out.println(PlaneServlet.getListFirstClass().size());
			if(PlaneServlet.getListEconomy().contains(sn) || PlaneServlet.getListFirstClass().contains(sn)){
				req.setAttribute("seatNo", seatNo);
				req.setAttribute("trip", trip);
				req.setAttribute("depdt", depdt);
				req.setAttribute("retdt", retdt);
				req.setAttribute("preference", preference);
				req.setAttribute("plane", plane);
				req.setAttribute("from", from);
				req.setAttribute("to", to);
				RequestDispatcher rd=req.getRequestDispatcher("AirlIneData.jsp");
				rd.forward(req, resp);
			}
			else {
				req.setAttribute("Trip", trip);
				req.setAttribute("Departure", depdt);
				req.setAttribute("Return", retdt);
				req.setAttribute("from", from);
				req.setAttribute("to", to);
				req.setAttribute("Valid", true);
				RequestDispatcher rd=req.getRequestDispatcher("ShowInfoAirline.jsp");
				rd.forward(req, resp);
			}
			
		}
}
