package ru.geekbrains.factories;

import ru.geekbrains.RequestHandler;
import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.factories.RequestParserFactory;
import ru.geekbrains.factories.ResponseSerializerFactory;
import ru.geekbrains.service.ServiceFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public final class ConnectionFactory{

    public static void create(ServerConfig config){
        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            System.out.println("Server started!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(new RequestHandler(
                        ServiceFactory.createSocketService(socket),
                        ServiceFactory.createFileService(config.getWww()),
                        RequestParserFactory.create(),
                        ResponseSerializerFactory.create()
                )).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
