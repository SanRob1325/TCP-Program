/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcpclientapplication;

import java.net.*;
import java.io.*;

/**
 *
 * @author seanr
 */
public class AddClientThread implements Runnable {
//referenced class,this class threading example is inspired from thread examples fro module classes

    Thread thread = new Thread();
    //private static final int SERVPORT = 5000; 
    private static ServerSocket socServ;
    private static int clients = 0;
    String clientName;

    public AddClientThread() {
        clientName = "Client 1";
    }

    public void run() {
        Socket socket = null;
        try {
            socket = socServ.accept();
            clients++;
            thread.start();
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String message = input.readLine();
            System.out.println("Client message " + clients +":"+ "\n" + message);
            output.println("Response message:" + message);
        } catch (IOException e) {
            System.out.println("Error:" + e);
        }
    }

}
