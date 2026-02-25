/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

import java.io.*;
import java.net.*;

public class ChatClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 1234);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            BufferedReader console =
                    new BufferedReader(new InputStreamReader(System.in));

            new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println("Message: " + msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            String userMsg;
            while ((userMsg = console.readLine()) != null) {
                out.println(userMsg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

