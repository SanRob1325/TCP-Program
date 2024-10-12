/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tcpserverapplication;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author seanr
 */
public class TCPServer {

    private static ServerSocket serSoc;
    private static final int SERVPORT = 5000;
    private static int clientConnection = 0;
    private static ArrayList<String> classes = new ArrayList<String>();
    private static ArrayList<String> date = new ArrayList<String>();
    private static ArrayList<String> times = new ArrayList<String>();
    private static ArrayList<String> courseCode = new ArrayList<String>();
    private static ArrayList<String> roomNum = new ArrayList<String>();

    public static void main(String[] args) {

        // classes.add("");
        System.out.println("Waiting for connections");
        try {
            serSoc = new ServerSocket(SERVPORT);
        } catch (IOException e) {
            System.out.println("Error" + e);
            System.exit(1);
        }
        do {
            run();
        } while (true);

    }
// referenced code for TCP programming from https://www.geeksforgeeks.org/socket-programming-in-java/

    public static void run() {
        BufferedReader input = null;
        PrintWriter output = null;
        Socket socket = null;
        String message = "";
        String dateTime = "";
        String classTime = "";
        String courseCodeNum = "";
        String roomNumClass = "";
        String response = "";
        int index = 0;

        //int decision =0;
        // boolean successfulAdd = false;
        while (!message.equals("STOP")) {
            try {
                socket = serSoc.accept();
                clientConnection++;
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);

                String messageOne = input.readLine();
                switch (messageOne) {
                    case "add":

                        
                        System.out.println("Successfully connected to client");
                        System.out.println("Message from client:" + clientConnection + " entered " + messageOne);
                        output.println("sucessfully scheduled");
                        dateTime = input.readLine();
                        date.add(dateTime);
                        output.println(dateTime);
                        classTime = input.readLine();
                        times.add(classTime);
                        output.println(classTime);
                        courseCodeNum = input.readLine();
                        courseCode.add(courseCodeNum);
                        output.println(courseCodeNum);
                        roomNumClass = input.readLine();
                        roomNum.add(roomNumClass);
//ouputs from arraylist
                        output.println(roomNumClass);
                        
                        System.out.println("Message from Client " + clientConnection + " add;" + dateTime + ";" + classTime + ";" + courseCodeNum + ";" + roomNumClass);
                        output.println("sucessfully scheduled");

                        break;
                    case "remove":
                        try {
                        int indexOfClass = Integer.parseInt(input.readLine()) - 1;
                        output.println("Server Response:" + "Room " + roomNum.get(indexOfClass) + " is available to schedule a class on " + date.get(indexOfClass) + " at " + times.get(indexOfClass));
                        //code inspiration for index input from https://stackoverflow.com/questions/68549596/remove-from-arraylist-based-on-user-input
                        if (indexOfClass >= 0 && indexOfClass < times.size()) {
                            output.print(indexOfClass);
                            // System.out.println("/");
                            times.remove(indexOfClass);
                            date.remove(indexOfClass);
                            courseCode.remove(indexOfClass);
                            roomNum.remove(indexOfClass);
                            output.println(" successfully removed");
                            output.println("Room " + roomNum.get(indexOfClass) + " is available to schedule a class on " + date.get(indexOfClass) + " at " + times.get(indexOfClass));

                            System.out.println("Room " + roomNum.get(indexOfClass) + " is available to schedule a class on " + date.get(indexOfClass) + " at " + times.get(indexOfClass));
                        } else {
                            output.println("Non existent class booking");
                            throw new IncorrectActionException();
                        }
                    } catch (IOException | IndexOutOfBoundsException | NumberFormatException e) {
                        System.out.println("Error " + e);
                    }
                    output.println(messageOne);
                    System.out.println("Successfully connected to client");
                    if (times.isEmpty()) {
                        System.out.println("No classes to remove");
                        output.println("Incorrect action and event from keyboard");
                        throw new IncorrectActionException();

                    }
                    output.println(messageOne);
                    System.out.println("Message from client" + clientConnection + " :entered " + message);
                    System.out.println("Welcome please remove the class you want");
                    System.out.println("\nAvailable classes");
                    for (int i = 0; i < times.size(); i++) {
                        output.println(i + 1 + ":" + "remove;" + date.size() + ";" + times.size() + ";" + courseCode.size() + ";" + roomNum.size());
                        System.out.println("Client message:" + i + 1 + ":" + "remove;" + date.get(i) + ";" + times.get(i) + ";" + courseCode.get(i) + ";" + roomNum.get(i));

                    }
                    System.out.println("Enter the number of the schedule you would like remove");
                    break;
                    case "STOP":

                        output.println("Server response:TERMINATE");
                        output.println(messageOne);
                        try {
                            System.out.println("Message from client " + clientConnection + " :entered " + messageOne);
                            System.out.println("TERMINATE");

                        } finally {

                            System.out.println("Closed connection");
                            socket.close();
                            input.close();
                            output.close();
                        }
                        break;
                    default:
                        output.println("Incorrect action and event from keyboard ");
                        throw new IncorrectActionException();

                }

                System.out.println("/new session");

            } catch (IOException | IncorrectActionException | NumberFormatException e ) {
                e.printStackTrace();
            }

        }
    }

}
