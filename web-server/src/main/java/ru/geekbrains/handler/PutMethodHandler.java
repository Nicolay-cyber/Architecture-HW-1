package ru.geekbrains.handler;

import ru.geekbrains.ResponseSerializer;
import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.domain.HttpRequest;
import ru.geekbrains.domain.HttpResponse;
import ru.geekbrains.service.SocketService;

@Handler(method = "PUT", order = 2)
class PutMethodHandler extends MethodHandlerImpl {

    public PutMethodHandler(MethodHandlerImpl next, SocketService socketService, ResponseSerializer responseSerializer, ServerConfig config) {
        super("PUT", next, socketService, responseSerializer, config);
    }

    @Override
    protected HttpResponse handleInternal(HttpRequest request) {
        return HttpResponse.createBuilder()
                .withStatusCode(200)
                .withStatusCodeName("Ok")
                .withHeader("Content-Type", "text/html; charset=utf-8")
                .withBody("<h1>PUT method handled</h1>")
                .build();
    }
}
