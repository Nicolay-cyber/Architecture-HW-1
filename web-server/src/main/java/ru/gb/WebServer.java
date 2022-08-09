package ru.gb;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    //первая мысль была сделать через yaml файл и отдельный класс config с созданием бина этого класса,
    // но позже подумал, что привязывать спринг для всего этого будет слишком и решил сделать через enum,
    // чтобы параметры не были захардкодины

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(Config.PORT.getInt())) {
            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(new RequestHandler(socket, Config.SOURCE_PATH.get())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}