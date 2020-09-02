<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="bootstrap.css">
    <title>Booked Confirmation</title>
    <style>
        body{
            background-image: url(img/kiran.jpg);
            background-size: cover;
            background-position: right;
            color:black;
            text-shadow: 2px 2px 4px rgb(83, 83, 155);
        }
        img{
            padding-top: 20px;
            -webkit-filter: drop-shadow(5px 5px 5px #222);
             filter: drop-shadow(5px 5px 5px #222);
        }
        p{
            width: 100%;
            border-style: dashed;
            border-color: darkcyan;
        }
        .btn{
            width: 50%;
        }
    </style>
</head>
<body>
		<%
		String nm=(String)request.getAttribute("name");
		String age=(String)request.getAttribute("age");
		String planecom=(String)request.getAttribute("planeComp");
		String seatno=(String)request.getAttribute("seatno");
		String depdate=(String)request.getAttribute("dtdep");
		String retdate=(String)request.getAttribute("dtret");
		String phone=(String)request.getAttribute("phone");
		String seatprefer=(String)request.getAttribute("seatprefer");
		String triptype=(String)request.getAttribute("triptyp");
		String ticketprice=(String)request.getAttribute("ticketprice");
		String from=(String)request.getAttribute("from");
		String to=(String)request.getAttribute("to");
		String ticket=(String)request.getAttribute("Ticket");
		String time=(String)request.getAttribute("Time");
		%>
    <div class="container">
        <div align="center">
        <img src="img/tick.png" alt="Payment Success" width="10%" height="10%">
        <h3>Congrats! Your Booking Confirmed</h3>
        <h3>HAPPY JOURNEY &#128522;</h3>
        </div>
        <h5><u> Booking Details:</u></h5>
        <hr>
        <i><mark>Important* Please save Your Ticket Number</mark></i>
        <br>
        <br>
        <p>Ticket No:&nbsp; <i><mark><%= ticket %></mark></i> </p>
        <p>Name:&nbsp; <%= nm %> </p>
        <p>Age:&nbsp; <%= age %> </p>
        <p>AirLine Company:&nbsp; <%= planecom %></p>
        <p>Seat No: &nbsp; <%= seatno %></p>
        <p>Trip: &nbsp; <%= from+"-"+to %></p>
        <p>Trip Type: &nbsp; <%= triptype %></p>
        <p>Departure Date:&nbsp; <%= depdate %> </p>
        <p>Return Date:&nbsp;  <%= retdate %></p>
        <p>Contact Number: &nbsp; <%= phone %></p>
        <p>Seat Preference: &nbsp; <%= seatprefer %></p>
        <p>Ticket Price: &nbsp; <%= ticketprice %></p>
        <p>Paid:&nbsp; <%= "YES" %></p>
        <p>Booking Time:&nbsp; <%= time %></p>
        <div class="text-center">
        <a href="index.jsp"><button class="btn btn-primary" >HOME</button> </a>
        </div>
    </div>
</body>
</html>