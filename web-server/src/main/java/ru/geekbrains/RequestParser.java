package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;

public class RequestParser {

    public HttpRequest parse(Deque<String> rawRequest) {
        String[] firstLine = rawRequest.pollFirst().split(" ");
        HttpRequest httpRequest = HttpRequest.createBuilder()
                .withMethod(firstLine[0])
                .withUrl(firstLine[1])
                .build();

        while (!rawRequest.isEmpty()) {
            String line = rawRequest.pollFirst();
            if (line.isBlank()) {
                break;
            }
            String[] header = line.split(": ");
            httpRequest.getHeaders().put(header[0], header[1]);
        }
        StringBuilder sb = new StringBuilder();
        while (!rawRequest.isEmpty()) {
            sb.append(rawRequest.pollFirst());
        }
        httpRequest.setBody(sb.toString());
        return httpRequest;
    }
}
