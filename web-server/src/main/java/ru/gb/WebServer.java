package ru.gb;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private static String WWW = "D:/IntelliJ IDEA projects/GB HW/Architecture/HW-1/HW-1/www";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8088)) {
            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(new RequestHandler(socket, WWW)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}