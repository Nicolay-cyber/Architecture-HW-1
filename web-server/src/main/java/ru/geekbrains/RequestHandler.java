package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

import java.io.IOException;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestHandler implements Runnable {

    private final SocketService socketService;

    private final FileService fileService;

    public RequestHandler(SocketService socketService, FileService fileService) {
        this.socketService = socketService;
        this.fileService = fileService;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();

        HttpRequest httpRequest = new RequestParser().parse(rawRequest);
        HttpResponse httpResponse;
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "text/html; charset=utf-8");

        if (fileService.isDirectory(httpRequest.getPath())) {
            httpResponse = new HttpResponse(400, headers, "<h1>Это директория!</h1>");
        } else if (!fileService.exists(httpRequest.getPath())) {
            httpResponse = new HttpResponse(404, headers, "<h1>Файл не найден!</h1>");
        } else {
            httpResponse = new HttpResponse(200, headers, fileService.readFile(httpRequest.getPath()));
        }

        socketService.writeResponse(new ResponseSerializer().serialize(httpResponse));
        try {
            socketService.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        System.out.println("Client disconnected!");
    }
}
