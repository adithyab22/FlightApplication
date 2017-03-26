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
        
        <form action="rest/books/add" method="post">
            <label>Select flight</label>
             <select id = "myList">
               <option name="flight1" value = "1">flight1</option>
               <option value = "2">flight2</option>
               <option value = "3">flight3</option>
               <option value = "4">flight4</option>
             </select>
            <p>price : <input type="number" step="any" name="price" /></p>
            <input type="submit" value="Add User" />
        </form>
    </body>
</html>
