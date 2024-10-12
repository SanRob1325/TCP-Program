/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ticketsystem.resources;

import com.mycompany.ticketsystem.models.Passenger;
import com.mycompany.ticketsystem.services.PassengerService;
import com.mycompany.ticketsystem.services.TicketService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/passengers")

public class PassengerResource {

    PassengerService passengerService = new PassengerService();
    TicketService ticketService = new TicketService();
    @GET
    @Path("/{passengerId}")
    @Produces(MediaType.APPLICATION_XML)
    public Passenger getPassengerXML(@PathParam("passengerId") int id) throws IndexOutOfBoundsException {
        try {
            return passengerService.getPassenger(id);
        } catch (IndexOutOfBoundsException a) {
            System.out.println("Error occured:" + a);
            return null;
        }
        
    }

    @GET
    @Path("/{passengerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Passenger getPassengerJSON(@PathParam("passengerId") int id) throws IndexOutOfBoundsException {
        try {
            return passengerService.getPassenger(id);
        } catch (IndexOutOfBoundsException a) {
            System.out.println("Passenger ID not found:" + a);
            return null;
        }
        
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Passenger postPassenger(Passenger p) throws IndexOutOfBoundsException {
        try{
        return passengerService.createPassenger(p);
        }catch(IndexOutOfBoundsException a){
            System.out.println("Error adding passenger:"+a);
            return null;
        }
    }
   
    @Path("/{passengerID}/tickets")
    public TicketResource getTicketsResource() throws IndexOutOfBoundsException {
        try {
            System.out.println("Getting tickets");
            return new TicketResource();
        } catch (IndexOutOfBoundsException a) {
            System.out.println("Tickets not found:" + a);
            return null;
        }
        
    }

}
