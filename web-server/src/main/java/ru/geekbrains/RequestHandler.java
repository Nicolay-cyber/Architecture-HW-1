package ru.geekbrains;

import ru.geekbrains.domain.requests.*;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.handler.MethodHandler;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

import java.io.IOException;
import java.util.Deque;

public class RequestHandler implements Runnable {

    private final SocketService socketService;
    private final RequestParser requestParser;
    private final MethodHandler methodHandler;

    public RequestHandler(SocketService socketService,
                          RequestParser requestParser,
                          MethodHandler methodHandler
                          ) {
        this.socketService = socketService;
        this.requestParser = requestParser;
        this.methodHandler = methodHandler;
    }

    @Override
    public void run() {
        Deque<String> rawRequest = socketService.readRequest();
        HttpRequest req = requestParser.parse(rawRequest);
        switch (req.getMethod()) {
            case "GET" -> req = new GetRequest(req);
            case "POST" -> req = new PostRequest(req);
            case "PUT" -> req = new PutRequest(req);
        }

        System.out.println(req.getSomethingSpecialBaseOnMethodName());

        methodHandler.handle(req);

        try {
            socketService.close();
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
        System.out.println("Client disconnected!");
    }
}
