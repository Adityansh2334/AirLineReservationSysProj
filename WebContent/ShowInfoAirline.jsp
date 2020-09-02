<%@page import="java.util.Iterator"%>
<%@page import="com.air.app.util.PlaneServlet" %>
<%@page import="com.air.app.dao.AirLineDao"%>
<%@page import="com.air.app.dto.AirLineDto"%>
<%@page import="java.util.Queue"%>
<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="bootstrap.css">
    <title>AirLines Chart</title>
    <style>
        body{
            background-image: url(img/land_s_end-wallpaper-1280x720.jpg);
            background-size: cover;
            color: snow;
            text-shadow: 2px 2px 4px red;
        }
        ul{
            list-style-type: circle;
            overflow: hidden;
        }
        li{
            display: inline-block;
        }
    </style>
</head>
<body>
	<%
	String depdt=(String)request.getAttribute("Departure");
	String retdt=(String)request.getAttribute("Return");
	String trip=(String)request.getAttribute("Trip");
	String from=(String)request.getAttribute("from");
	String to=(String)request.getAttribute("to");
	boolean flag=false;
	if(request.getAttribute("Valid")!=null){
		flag=(boolean)request.getAttribute("Valid");
	}
	%>
    <header>
        <h2 align="center">Results According to your Choice</h2>
    </header>
    <section>
        <div class="container">
            <h4>AirPlanes & Seats Available:</h4>
            <ul>
                <li>
                    <h5>AirAsia</h5>
                    <textarea name="planetext" style="resize: none;overflow-y: scroll;overflow: scroll;"id="plane" cols="30" rows="10" disabled>
                    <%
                    Iterator<Integer> itr=PlaneServlet.getEconomyIterator();
                    int size=PlaneServlet.getListEconomy().size();
                    out.println("TOTAL ECONOMY SEATS AVAILABE: "+size);
                    out.println("Economy Seats Available:[Price:3000.34/-]");
                    if(!itr.hasNext())out.println("Sorry! No Seats Available Now... "+
                    "Check-Back Later..");
                    while(itr.hasNext())
                    {
                    	out.println("Seat No: "+itr.next()+"-ECO");
                    }
                    Iterator<Integer> itr2=PlaneServlet.getFirstClassIterator();
                    int size2=PlaneServlet.getListFirstClass().size();
                    out.println("TOTAL FIRSTCLASS SEATS AVAILABE: "+size2);
                    if(!itr2.hasNext())out.println("Sorry! No Seats Available Now... "+
                            "Check-Back Later..");
                    out.println("FirstClass Seats Available:[Price:7000.34/-]");
                    while(itr2.hasNext())
                    {
                    	out.println("Seat No: "+itr2.next()+"-FCLASS");
                    }
                    %>
                    </textarea>
                </li>
                <li>
                    <h5>GoIndiGoAir</h5>
                <textarea name="planetext" style="resize: none;overflow-y: scroll;overflow: scroll;" id="plane" cols="30" rows="10" disabled></textarea>
                </li>
                <li>
                    <h5>IndiaAir</h5>
                    <textarea name="planetext" style="resize: none;overflow-y: scroll;overflow: scroll;" id="plane" cols="30" rows="10" disabled></textarea>
                </li>
                <li>
                    <h5>DubaiAir</h5>
                <textarea name="planetext"  style="resize: none;overflow-y: scroll;overflow: scroll;" id="plane" cols="30" rows="10" disabled></textarea>
                </li>
            </ul>
            <form class="form-inline" method="get" action="fly">
            <input type="hidden" name="trip" value="<%= trip%>">
            <input type="hidden" name="depar" value="<%= depdt%>">
            <input type="hidden" name="return" value="<%= retdt%>">
            <input type="hidden" name="from" value="<%= from%>">
            <input type="hidden" name="to" value="<%= to%>">
                <label class="my-1 mr-2" for="inlineFormCustomSelectPref">Choose AirPlane</label>
                <select class="custom-select my-1 mr-sm-2" name="planename" id="inlineFormCustomSelectPref">
                  <option selected>Choose...</option>
                  <option value="AirAsia">AirAsia</option>
                  <option value="GoIndiGoAir">GoIndiGoAir</option>
                  <option value="IndiaAir">IndiaAir</option>
                  <option value="DubaiAir">DubaiAir</option>
                </select>
                <label class="my-1 mr-2" for="inlineFormCustomSelectPref2">Choose Preference</label>
                <select class="custom-select my-1 mr-sm-2" name="prefer" id="inlineFormCustomSelectPref2">
                  <option selected>Choose...</option>
                  <option value="Economy Class">Economy Class</option>
                  <option value="First Class">First Class</option>
                </select>
                <label class="my-1 mr-2" for="inlineFormCustomSelectPref3">Enter Seat Number</label>
                <input type="number"  name="seatNo" class="form-control col-md-1" id="inlineFormCustomSelectPref3">
                &nbsp;
                <button type="submit" class="btn btn-success my-1">Submit</button>&nbsp;<a href="index.jsp"><button type="button" class="btn btn-primary my-1">Go Back</button></a>
              </form>
              <% 
              if(flag)out.println("<h5 color='red'>Wrong Input! Please Check Again</h5>"); 
              %>
        </div>
    </section>
</body>
</html>