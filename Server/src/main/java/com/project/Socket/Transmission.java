package com.project.Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Transmission {

    public static void sendToClient(Socket socket, String s){

        try{
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(s);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String receiveFromClient(Socket s){

        try{
            InputStreamReader isr = new InputStreamReader(s.getInputStream());
            BufferedReader in = new BufferedReader(isr);
            return in.readLine();
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}