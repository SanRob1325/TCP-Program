/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcpclientapplication;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author seanr
 */
public class TCPClientApp {

    private static InetAddress hostName;
    private static final int SERVPORT = 5000;
    AddClientThread ac = new AddClientThread();
    ClassTime cd = new ClassTime();
    private static ArrayList<String> date = new ArrayList<String>();
    private static ArrayList<String> times = new ArrayList<String>();
    private static ArrayList<String> courseCode = new ArrayList<String>();
    private static ArrayList<String> roomNum = new ArrayList<String>();
    //the reason why the client has arraylist is to show a better visual representation of data that they have added upon a server request
    public static void main(String[] args) {
        try {
            hostName = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("Error:" + e);
            System.exit(1);
        }
        run();
    }

    public static void run() {
        Socket socket = null;
        BufferedReader input = null;
        PrintWriter output = null;
        String message = "";
        String dateTime = "";
        String classTime = "";
        String courseCodeNum = "";
        String roomNumClass = "";
        String response = "";
        String responseServer = "";
        String responseServerTwo = "";
        String responseServerThree = "";

        while (!message.equals("STOP")) {
            try {
                socket = new Socket(hostName, SERVPORT);
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);// communications from server and client
                BufferedReader clientResponse = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Welcome to the class network");
                System.out.println("\nEnter (add) to add a new class schedule or (remove) to remove a class schedule");

                message = clientResponse.readLine();

                if (message.equalsIgnoreCase("add")) {
                   

                    output.println(message);

                    System.out.println("Server response:" + message);
                    System.out.println("Welcome please add class you would like to schedule");

                    System.out.println("\nEnter date:");
                    dateTime = clientResponse.readLine();
                    
                    
                    

                    System.out.println("\nEnter Time:");
                    classTime = clientResponse.readLine();
                    
                    System.out.println("\nEnter Course Code:");
                    courseCodeNum = clientResponse.readLine();
                    
                    System.out.println("\nEnter Room Number:");
                    roomNumClass = clientResponse.readLine();
                    
                    output.println(dateTime);
                    output.println(classTime);
                    output.println(courseCodeNum);
                    output.println(roomNumClass);
                    date.add(dateTime);
                    times.add(classTime);
                    courseCode.add(courseCodeNum);
                    roomNum.add(roomNumClass);
                    output.println(classTime);
                    response = " add;" + dateTime + ";" + classTime + ";" + courseCodeNum + ";" + roomNumClass;
                   
                    System.out.println("Server Response" + response);
                    responseServer = input.readLine();
                    System.out.println("Server Response " + responseServer);

                    //System.out.println("successfully scheduled");
                } else if (message.equalsIgnoreCase("remove")) {
                    output.println(message);

                    if (times.isEmpty()) {
                        System.out.println("Server response:" + message);
                        return;
                    }
                    output.println(message);
                    System.out.println("Welcome please remove the class you want");
                    System.out.println("\nAvailable classes");
                    for (int i = 0; i < times.size(); i++) {
                        System.out.println(i + 1 + ":" + "remove;" + date.get(i) + ";" + times.get(i) + ";" + courseCode.get(i) + ";" + roomNum.get(i));

                    }
                    System.out.println("Enter the index of the class you would like to delete (starting from 0):");
                    try {
                        int indexOfClass = Integer.parseInt(clientResponse.readLine()) - 1;
                        //to ensure this action works correctly ensure you add muliple class details befor removing the selected class you want
                        if (indexOfClass >= 0 && indexOfClass < times.size()) {
                            output.print(indexOfClass);
                            times.remove(indexOfClass);
                            courseCode.remove(indexOfClass);
                            roomNum.remove(indexOfClass);
                            date.remove(indexOfClass);
                            response = input.readLine();
                            System.out.println(response);

                        } else {
                            System.out.println("Server response:" + message);

                        }
                    } catch (IOException | IndexOutOfBoundsException |NumberFormatException e) {
                        System.out.println("Error" + e);
                    }

                    //System.out.println("Server Response:" + response);
                } else if (message.equals("STOP")) {
                    output.println(message);

                    try {
                        System.out.println(response);
                        System.out.println("Closed connection");
                        responseServerTwo = input.readLine();
                        System.out.println(responseServerTwo);
                    } finally {

                        socket.close();
                        input.close();
                        output.close();
                    }
                } else {
                    output.println(message);
                    responseServerThree = input.readLine();
                    System.out.println("Server Response: " + responseServerThree);
                }

            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

}
