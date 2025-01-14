/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*@author seanr
 */
package com.mycompany.ticketsystem.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ticket {

    private int id;
    private String description;

    public Ticket() {
    }

    public Ticket(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String printTicket() {
        String str = this.getId() + " " + this.getDescription();
        return str;
    }
}
