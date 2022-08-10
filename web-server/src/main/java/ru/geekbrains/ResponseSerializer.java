package ru.geekbrains;

import ru.geekbrains.domain.HttpResponse;

public class ResponseSerializer {

    public String serialize(HttpResponse response) {

        //Creation response text with the first line
        StringBuilder responseText = new StringBuilder(String.format("HTTP/1.1 %s %s\n",
                response.getStatusCode(),
                getStatusName(response.getStatusCode())
        ));

        //Adding headers to the response
        response.getHeaders().forEach(
                (headTitle, headBody) -> responseText
                        .append(headTitle)
                        .append(": ")
                        .append(headBody)
                        .append("\n\n")
        );

        //Adding a body to the response
        responseText.append(response.getBody());

        return responseText.toString();
    }

    private String getStatusName(int statusCode) {
        return switch (statusCode) {
            case 404 -> "NOT_FOUND";
            case 200 -> "OK";
            case 400 -> "BAD_REQUEST";
            default -> null;
        };
    }
}
