<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="bootstrap.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <title>Fill-Up</title>
    <style>
        .container{
            position: absolute;
            width: 800px;
            height: 200px;
            z-index: 15;
            top: 30%;
            left: 29%;
            margin: -100px 0 0 -150px; 
        }
        body{
            background-image: url("img/m1.jpg");
            background-size: cover;
            color: rgb(105, 1, 27);
            text-shadow: 2px 2px 4px sandybrown;
        }
    </style>
</head>
<body>
	<%
			String sn=(String)request.getAttribute("seatNo");
			String trip=(String)request.getAttribute("trip");
			String depdt=(String)request.getAttribute("depdt");
			String retdt=(String)request.getAttribute("retdt");
			String prefe=(String)request.getAttribute("preference");
			String plane=(String)request.getAttribute("plane");
			String from=(String)request.getAttribute("from");
			String to=(String)request.getAttribute("to");
			double amnt=0;
			if(prefe!=null){
			if(prefe.equals("Economy Class")) amnt=3000.34;
			if(prefe.equals("First Class")) amnt=7000.34;
			}
			boolean flag=false;
			if(request.getAttribute("Validation")!=null){
				flag=(boolean)request.getAttribute("Validation");
			}
	%>
    <div class="container">
        <h1 align="center">Welcome To AirLine Services</h1>
        <form action="pasngrin" method="post">
        	<input type="hidden" name="from" value="<%= from%>">
            <input type="hidden" name="to" value="<%= to%>">
            <input type="hidden" name="seatrefer" value="<%= prefe%>">
            <input type="hidden" name="triptyp" value="<%=trip %>">
            <input type="hidden" name="planecomp" value="<%=plane %>">
            <input type="hidden" name="seatno"  value="<%=sn %>">
            <input type="hidden" name="datedep"  value="<%=depdt %>">
            <input type="hidden" name="dateret"  value="<%=retdt %>">
            <input type="hidden" name="ticketprice" value="<%= amnt%>">
            <div class="form-row">
              <div class="form-group col-md-4">
                <label for="inputEmail4">Name</label>
                <input type="text" name="name" class="form-control" id="inputEmail4" placeholder="Your Name" required>
              </div>
              <div class="form-group col-md-2">
                <label for="inputEmail4">Age</label>
                <input type="number" name="age" class="form-control" id="inputEmail4" placeholder="Your Age" required>
              </div>
              <div class="form-group col-md-6">
                <label for="inputState">AirLine Company</label>
                <input type="text" class="form-control"    id="inputState" placeholder="<%=plane+" PVT. LTD" %>" disabled>
              </div>
            </div>
            <div class="form-row">
            <div class="form-group col-md-3">
              <label for="seatNo">Seat No</label>
              <input type="text"  class="form-control" id="seatNo" placeholder="<%=sn %>" disabled>
            </div>
            <div class="form-group col-md-4">
                <label for="departure">Departure Date</label>
                <input type="text"  class="form-control" id="departure" placeholder="<%=depdt %>" disabled>
              </div>
              <div class="form-group col-md-4">
                <label for="ArrivalPl">Return Date</label>
                <input type="text"  class="form-control" id="ArrivalPl" placeholder="<%=retdt %>" disabled>
              </div>
            <div class="form-group col-md-5">
                <label for="inputPH">Contact Number</label>
                <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroupPrepend2">+91</span>
                  </div>
                <input type="tel"  name="phone" class="form-control" id="inputPH"aria-describedby="inputGroupPrepend2" maxlength='14'  placeholder="Ex: 8249-0582-01" required>
              </div>
            </div>
            <div class="form-group col-md-3">
                <label for="seatPre">Seat Preference</label>
                <input type="text"   class="form-control" id="seatPre"  placeholder="<%=prefe %>" disabled>
              </div>
              <div class="form-group col-md-3">
                <label for="tripType">Trip Type</label>
                <input type="text"  class="form-control" id="tripType"  placeholder="<%=trip %>" disabled>
              </div>
            </div>
            <div class="form-row">
              <div class="form-group col-md-4">
                <label for="inputCity">Ticket Price</label>
                <input type="number"  class="form-control" id="inputCity"  placeholder="<%= amnt%>"disabled >
              </div>
              <div class="form-group col-md-4">
                <label for="inputDoc">AirLine Pay-ID</label>
                <input type="text" name="payid" class="form-control" id="inputDoc"  placeholder="PAY-ID" required>
              </div>
              <div class="form-group col-md-4">
                <label for="inputZip">Unique Username</label>
                <input type="text" name="username" class="form-control" id="inputZip"  placeholder="Username" required>
              </div>
            </div> 
           <a href="ShowInfoAirline.jsp"><button type="button" class="btn btn-primary">Go Back</button></a> &nbsp; <button type="submit" class="btn btn-success">CONFIRM</button>
          </form>
          	 <% 
              if(flag)out.println("<h5 color='red'>Wrong Input! Please Check Again</h5>"); 
              %>
    </div>
    		
    <script>
        $(document).ready(function () {
    $("#inputPH").keyup(function (e) {
      if($(this).val().length === 14) return;
      if(e.keyCode === 8 || e.keyCode === 37 || e.keyCode === 39) return;
      let newStr = '';
      let groups = $(this).val().split('-');
      for(let i in groups) {
       if (groups[i].length % 4 === 0) {
        newStr += groups[i] + "-"
       } else {
        newStr += groups[i];
       }
      }
      $(this).val(newStr);
    });
})
    </script>
</body>
</html>