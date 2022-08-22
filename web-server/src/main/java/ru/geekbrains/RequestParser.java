package ru.geekbrains;

import ru.geekbrains.domain.requests.HttpBaseRequest;

import java.util.Deque;

public class RequestParser {

    public HttpBaseRequest parse(Deque<String> rawRequest) {
        HttpBaseRequest.Builder builder = HttpBaseRequest.createBuilder();
        String[] firstLine = rawRequest.pollFirst().split(" ");
        builder
                .withMethod(firstLine[0])
                .withUrl(firstLine[1]);

        while (!rawRequest.isEmpty()) {
            String line = rawRequest.pollFirst();
            if (line.isBlank()) {
                break;
            }
            String[] header = line.split(": ");
            builder.withHeader(header[0], header[1]);
        }
        StringBuilder sb = new StringBuilder();
        while (!rawRequest.isEmpty()) {
            sb.append(rawRequest.pollFirst());
        }
        builder.withBody(sb.toString());
        return builder.build();
    }
}
