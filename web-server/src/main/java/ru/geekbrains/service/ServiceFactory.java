package ru.geekbrains.service;

import java.net.Socket;

public final class ServiceFactory {
    public static FileService createFileService(String rootDir) {
        return new FileService(rootDir);
    }

    public static SocketService createSocketService(Socket socket) {
        return new SocketService(socket);
    }
}
