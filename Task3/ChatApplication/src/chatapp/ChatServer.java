/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chatapp;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {

    private static Set<ClientHandler> clients = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Chat Server Started...");

        try (ServerSocket serverSocket = new ServerSocket(1234)) {

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler client = new ClientHandler(socket);
                clients.add(client);
                client.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void broadcast(String message, ClientHandler sender) {
        for (ClientHandler client : clients) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    broadcast(message, this);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void sendMessage(String message) {
            out.println(message);
        }
    }
}
