/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*author seanr
 */
package com.mycompany.ticketsystem.models;

import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Passenger {

    private String passengerName;
    private int age;
    private String gender;
    private String dob;
    private int id;
    private List<Ticket> tickets = new ArrayList<>();

    public Passenger() {
    }

    public Passenger(String passengerName, int age, String gender, int id,String dob, List<Ticket> tickets) {
        this.passengerName = passengerName;
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.dob=dob;
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    
    public List<Ticket> getTickets()throws IndexOutOfBoundsException {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicketForPassenger(Ticket ticket) throws IndexOutOfBoundsException{
        (this.tickets).add(ticket);
    }

    public String printPassengers() {
        String message = this.getId() + " " + this.getPassengerName() + " " + this.getGender();
        return message;
    }

    public String printAllTickets()throws IndexOutOfBoundsException {
        String allTickets = "";
        for (int i = 0; i < tickets.size(); i++) {
            allTickets = allTickets + tickets.get(i).printTicket() + " ";
        }
        return allTickets;
    }

}
