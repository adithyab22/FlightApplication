/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookflight.controller;

import com.bookflight.dto.FlightComponent;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adithya
 */
@WebServlet(name = "FlightSelectionServlet", urlPatterns = {"/FlightSelectionServlet"})
public class FlightSelectionServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FlightComponent flightComponent = new FlightComponent();
        String flight_id = request.getParameter("flight_id").replaceAll("\\s","+");
        double airline_price = Double.parseDouble(request.getParameter("airline_price"));
        double flight_price = Double.parseDouble(request.getParameter("flight_price"));
        flightComponent.setAirlineCardPrice(airline_price);
        flightComponent.setFlightID(Integer.parseInt(flight_id));
        flightComponent.setFlightPrice(flight_price);
        request.setAttribute("flightComponent", flight_id+" " + airline_price+" " + flight_price);
        

    	//direct to the results page
        RequestDispatcher view = request.getRequestDispatcher("FlightSelectionPage.jsp");
        view.forward(request, response);
}

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    

}
