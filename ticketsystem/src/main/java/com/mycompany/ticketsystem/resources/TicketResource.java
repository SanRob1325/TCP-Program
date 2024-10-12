/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ticketsystem.resources;


import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.mycompany.ticketsystem.services.TicketService;
import com.mycompany.ticketsystem.models.Ticket;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

@Path("/tickets")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TicketResource {

    private TicketService TicketService = new TicketService();
/*
    TicketResource() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/	
     @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Ticket postTicket(Ticket t) throws IndexOutOfBoundsException {
        return TicketService.registerTicket(t);
    }
    
    @GET
    public List<Ticket> getTickets(@PathParam("passengerID") int pId)throws IndexOutOfBoundsException {
        
        System.out.println("getAllTicketsForPassengers"+pId);
	return TicketService.getAllTicketsByPassenger(pId);
    }
	
    @GET
    @Path("/{ticketID}")
    public Ticket getTicket(@PathParam("ticketID") int tId,@PathParam("passengerID") int pId )throws IndexOutOfBoundsException {
    	System.out.println("getTicketsByID..."+tId +" for passenger ID "+pId);
	return TicketService.getTicketByID(pId,tId);
    }
    
}
