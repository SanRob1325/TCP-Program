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

public class PassengerService {

    public static List<Passenger> plist = new ArrayList<>();
    public static List<Ticket> tlist = new ArrayList<>();
    public static boolean init = true;

    public PassengerService() {
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
    }

    public List<Passenger> getAllPassengers(){
        return plist;
    }

    public Passenger getPassenger(int id){
        
        return plist.get(id - 1);
        
    }

    public Passenger createPassenger(Passenger p){
        try{
        p.setId(plist.size() + 1);
        plist.add(p);
        System.out.println("201 - resource created with path: /passengers/" + String.valueOf(p.getId()));
        System.out.println("Updated Passenger:" + p.printPassengers());

        return p;
        }catch(IndexOutOfBoundsException a){
            System.out.println("Error creating Passenger:"+a);
            return null;
        }
    }


}
