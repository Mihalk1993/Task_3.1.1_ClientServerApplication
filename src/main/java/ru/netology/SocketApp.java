package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketApp {
    public static void main(String[] args) {

        int port = 8080;

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String name = in.readLine();
            out.println(String.format("Hi %s, local port: %s, your port: %s",
                    name,
                    clientSocket.getLocalPort(),
                    clientSocket.getPort()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
