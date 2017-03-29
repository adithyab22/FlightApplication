# FlightApplication

Application URL: Sample-env.bk24gu5qw7.us-east-1.elasticbeanstalk.com (Work in Progress)<br> 
Application that helps users book flights.

DB details:

 <table style="width:100%">
  <tr>
    <th>Table Name</th>
    <th>Columns</th> 
    <th>Description</th>
  </tr>
  <tr>
    <td>USER_DETAILS</td>
    <td>USER_ID (Integer, Primary key) <br> USER_NAME (Varchar)</td> 
    <td>Table that stores user details</td>
  </tr>
  <tr>
    <td>USER_SESSION</td>
    <td>SESSION_ID (Varchar , Primary key) <br> CART_ID (Foreign Key) <br> CARD_TYPE
 <br> CARD_NUMBER

 </td> 
    <td>Table that maintains user session</td>
  </tr>
  <tr>
    <td>FLIGHT</td>
    <td>FLIGHT_NUMBER (Primary Key) <br> FLIGHT_PRICE <br> AIRLINE_NAME <br>

 </td> 
    <td>Table that stores details about the  flight. </td>
  </tr>
<tr>
    <td>CARD_TYPE</td>
    <td>CARD_TYPE_ID (Primary Key) <br> CARD_TYPE_NAME </td> 
    <td>Table that stores the  id and name of cart type e.g. 1 for VISA, 2 for MASTERCARD etc.</td>
  </tr>
<tr>
    <td>CART</td>
    <td>CART_TRIP_ID <br> CART_ID <br> FLIGHT_COMPONENT_ID </td> 
    <td>Table that stores CART details of users </td>
  </tr>
<tr>
    <td>SALES</td>
    <td>SUCCESS_ID <br>
CARD_TYPE_ID <br>
FLIGHT_ID <br>
FLIGHT_DATE <br>
FLIGHT_FEE <br>
AIRLINE_FEE <br>
TOTAL_FEE <br>
CARD_NUMBER
</td> 
    <td>Sales table that saves Success_id and other details associated with the final boooking information of the user. </td>
  </tr>
</table>



 Use Cases:
<table style="width:100%">
<tr>
<td>
<b> 1. For a particular SUCCESS_ID, we need to be able to retrieve, the total fees that the user paid as part of airline card fees for all flights </b> <br>  
SELECT total_fee FROM sales WHERE success_id = ?;
</td>
</tr>
<tr>
<td>
<b> 2.  For a particular SUCCESS_ID, we need to be able to retrieve, the card type used to complete booking </b> <br> 
SELECT card_type FROM sales WHERE success_id  = ?;
</td>
</tr>
<tr>
<td>
3.
  <b> For a particular SUCCESS_ID, we need to be able to retrieve, the fee range for all flights. This means we need the minimum and maximum of all flights. </b>  <br> 
  SELECT MIN(b.flight_price), MAX(b.flight_price) FROM sales  a  INNER JOIN  cart  b ON  a.cart_id  = b.cart_id  WHERE  a.success_id  = ?;
</td>
</tr>
<tr>
<td>
<b> 4. For Q3, can the range also pass the card type associated with it? </b> <br>
SELECT a.card_type, MINb.price),  MAX(b.price)  FROM sales  a  INNER JOIN cart b ON a.cart_id = b.cart_id  WHERE  a.success_id  =  ? GROUP  BY a.card_type;
</td>
</tr>
<tr>
<td>
<b> 5. We need to be able to find out the total number of bookings that were done with a particular card type. So, say the total bookings done by a VISA credit card </b> <br> 
SELECT COUNT(*) FROM sales WHERE card_type = 'VISA';
</td>
</tr>
<tr>
<td>
<b>6. An analyst,
  wants in real time to see the number of attempts that the user made while
  entering different credit cards. Can there be any logging associated that can
  help the analyst? </b> <br>

  SELECT
  a.* FROM sales a INNER
  JOIN
  cart b ON a.cart_id = b.cart_id WHERE a.success_id  = ?;
</td>
</tr>
</table>
