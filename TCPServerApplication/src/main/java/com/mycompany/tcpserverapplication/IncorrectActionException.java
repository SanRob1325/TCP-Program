/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcpserverapplication;

/**
 *
 * @author seanr
 */
public class IncorrectActionException extends Exception {
    protected String msg;
    
    public IncorrectActionException (){
       this.msg ="Incorrect action and event from keyboard"; 
    }
    public IncorrectActionException (String error){
        super(error);
    }
    
    public String getMessage(){
        return this.msg;
    }
}
