package com.air.app.util;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.air.app.dao.AirLineDao;
import com.air.app.dto.AirLineDto;

public class PlaneServlet extends HttpServlet{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		static LinkedList<Integer> elist=null;
		static LinkedList<Integer> fclist=null;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String from=req.getParameter("from");
			String to=req.getParameter("to");
			String depdt=req.getParameter("departure");
			String retdt=req.getParameter("return");
			String trip=req.getParameter("trip");
			
			AirLineDao airLineDao= AirLineDao.getInstance();
        	List<AirLineDto> lst=airLineDao.getAirlineDetailsByRoute(from+"-"+to);
        	Object[] array = lst.toArray();
        	System.out.println(from+"-"+to);
        	
        	if(elist==null && fclist==null) 
        	{
        		
        	int i=0;
        	int m=1;
        	int k=31;
        	int ln=array.length;
        	while(ln>0){
        		AirLineDto airLineDto=(AirLineDto) array[i];
        		 switch(airLineDto.getAirName())
        		 {
        		 case "AirAsia":
        			elist= new LinkedList<Integer>();
        			for(int j=0;j<30;j++){
        				elist.add(j, m);
        				m++;
        			}
        			fclist= new LinkedList<Integer>();
        			for(int j=0;j<20;j++){
        				fclist.add(j,k);
        				k++;
        			}
        			break;
        		 case "GoIndigoAir":
        			 elist= new LinkedList<Integer>();
         			for(int j=1;j<=30;j++){
         				elist.add(j, j);
         			}
         			fclist= new LinkedList<Integer>();
         			for(int j=31;j<=50;j++){
         				fclist.add(k,j);
         				k++;
         			}
         			break;
        		}
        		 ln--;
        		 i++;
        	}
        	}
        	req.setAttribute("Departure", depdt);
        	req.setAttribute("Return", retdt);
        	req.setAttribute("Trip", trip);
        	req.setAttribute("from", from);
        	req.setAttribute("to", to);
        	
        	RequestDispatcher rd= req.getRequestDispatcher("ShowInfoAirline.jsp");
        	rd.forward(req, resp);
        	
		}
		public static LinkedList<Integer> getListEconomy(){
			return elist;
		}
		public static LinkedList<Integer> getListFirstClass(){
			return fclist;
		}
		public static Iterator<Integer> getEconomyIterator(){
			return elist.iterator();
		}
		public static Iterator<Integer> getFirstClassIterator(){
			return fclist.iterator();
		}
}
