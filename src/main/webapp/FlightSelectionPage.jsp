<%-- 
    Document   : FlightSelectionPage
    Created on : Mar 23, 2017, 9:31:53 PM
    Author     : Adithya
--%>

<%@page import="java.sql.*" %>
<%ResultSet resultset =null;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello! Welcome to Flight Selection Page</h1>
        
       <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
            <p>Flight ID: <input type="text" name="flight_id" /></p>
            <p>Airline Price : <input type="number" name="airline_price" step="any" /></p>
            <p>Flight Price : <input type="number" name="flight_price" step="any" /></p>
           
            <input type="submit" value="Add Flight" />
        </form>
        
    </body>
</html>
