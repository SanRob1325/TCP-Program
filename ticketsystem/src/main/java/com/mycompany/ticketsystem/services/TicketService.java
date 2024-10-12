/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ticketsystem.services;

import com.mycompany.ticketsystem.models.Passenger;
import com.mycompany.ticketsystem.models.Ticket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author seanr
 */
public class TicketService {

    public static List<Passenger> plist = new ArrayList<>();
    public static List<Ticket> tlist = new ArrayList<>();
    public static boolean init = true;
    
    public TicketService() {
        try{
        if (init) {
            Ticket tOne = new Ticket(1, "First Class (Passenger Name:John)");
            Ticket tTwo = new Ticket(2, "Economy (Passenger Name:Jane)");
            Ticket tThree = new Ticket(3, "Economy (Passenger Name:Gary)");
            Ticket tFour = new Ticket(4, "Economy (Passenger Name:Ashley)");
            Ticket tFive = new Ticket(5, "Economy (Passenger Name:Matt)");
            Ticket tSix = new Ticket(6, "Economy (Passenger Name:Velma)");
            tlist.add(tOne);
            tlist.add(tTwo);
            tlist.add(tThree);
            tlist.add(tFour);
            tlist.add(tFive);
            tlist.add(tSix);
            Passenger pOne = new Passenger("John", 22, "Male", 1,"1/09/2001" ,tlist);
            Passenger pTwo = new Passenger("Jane", 24, "Female", 2,"6/10/1999", tlist);
            Passenger pThree = new Passenger("Gary", 27, "Male", 3, "8/11/1996",tlist);
            Passenger pFour = new Passenger("Ashley", 32, "Female", 4,"7/4/1991" ,tlist);
            Passenger pFive = new Passenger("Matt", 40, "Male", 5, "15/5/1983",tlist);
            Passenger pSix = new Passenger("Velma", 30, "Female", 6,"20/6/1993", tlist);

            plist.add(pOne);
            plist.add(pTwo);
            plist.add(pThree);
            plist.add(pFour);
            plist.add(pFive);
            plist.add(pSix);
            init = false;
        }
        }catch(ArrayIndexOutOfBoundsException a){
            System.out.println("Error With adding list"+a);
        }
    }
    
    public List<Ticket> getAllTicketsByPassenger(int passengerID){
        try{
        return plist.get(passengerID - 1).getTickets();
        }catch(IndexOutOfBoundsException a){
            System.out.println("Cannot retrieve Tickets"+a);
            return null;
        }
    }

    public Ticket getTicketByID(int passengerID, int ticketID) {
        try{
        return plist.get(passengerID - 1).getTickets().get(ticketID - 1);
        }catch(IndexOutOfBoundsException a){
            System.out.println("Cannot get ticket requested:"+a);
            return null;
        }
    }

    public List<Ticket> getAllTickets(){
        //throws new IndexOutOfBoundsException("");
        try{
        return tlist; 
        }catch(IndexOutOfBoundsException a){
            System.out.println("Error retrieving tickets:"+a);
            return null;
        }
    }
    public Ticket registerTicket(Ticket t)throws IndexOutOfBoundsException{
        try{
        t.setId(tlist.size() + 1);
        tlist.add(t);
        System.out.println("201 - resource created with path: /passengers/passengerId/tickets/" + String.valueOf(t.getId()));
        System.out.println("Updated Passenger:" + t.printTicket());
        return t;
        }catch(IndexOutOfBoundsException a){
            System.out.println("Ticket already exists"+a);
            return null;
        }
    }
}
