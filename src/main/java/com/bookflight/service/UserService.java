/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookflight.service;

/**
 *
 * @author Adithya
 */

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.apache.log4j.Logger;
import com.bookflight.dto.FlightComponent;
import java.util.Date;

@Path("/flight")
/**
 * Test class: Basic version of the web service
 */
public class UserService {
static Logger logger = Logger.getLogger(UserService.class);
static List<FlightComponent> flightsList = new ArrayList<FlightComponent>(); 

  @POST
  @Path("/add")
  @Produces(MediaType.TEXT_HTML)
  public Response addFlightComponent(@FormParam("flight_id") int flightID, 
                @FormParam("airline_price") int airline_price,
                @FormParam("flight_price") double flight_price) {
    FlightComponent flightComponent = new FlightComponent();
    flightComponent.setAirlineCardPrice(airline_price);
    double total_price = airline_price + flight_price;
    flightComponent.setComputedPrice(total_price);
    flightComponent.setCreatedDateTime(new Date());
    flightComponent.setFlightID(flightID);
    flightComponent.setIsRemoved(0); //0 indicates not removed
    
    
    flightsList.add(flightComponent);
    String msg = "add flight component: " + flightsList.toString();
    logger.info(msg);
    return Response.ok(msg).entity(msg).build();
  }

  @POST
  @Path("/cart")
  @Produces(MediaType.TEXT_HTML)
  public Response viewCart(MultivaluedMap<String, String> formFields) {
    StringBuffer msg = new StringBuffer(" View all Form Fields:<br/><br/>");
    for (String field : formFields.keySet()) {
      msg.append(field);
      msg.append(" : ");
      msg.append(formFields.get(field));
      msg.append("<br/>");
    }
 
    return Response.status(200).entity(msg.toString()).build();
  }
   
  @GET
  @Path("/flightComponents")
  public Response getFlightComponents() {
    String msg = "get Flight Components " + flightsList;
    logger.info(msg);
    return Response.ok(msg).entity(msg).build();
  } 
}

