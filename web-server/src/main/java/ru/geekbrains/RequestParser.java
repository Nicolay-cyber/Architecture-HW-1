package ru.geekbrains;

import ru.geekbrains.domain.HttpRequest;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    public HttpRequest parse(Deque<String> rawRequest) {
        HttpRequest httpRequest = new HttpRequest();

        //Extraction of method and path
        String[] requestRaw = rawRequest.pollFirst().split(" ");
        httpRequest.setMethod(requestRaw[0]);
        httpRequest.setPath(requestRaw[1]);

        //Extraction of headers
        Map<String, String> headers = new HashMap<>();
        while (true){
            if(!rawRequest.isEmpty() && rawRequest.getFirst().contains(":")){
                requestRaw = rawRequest.pollFirst().split(":",2);
                headers.put(requestRaw[0],requestRaw[1]);
            }
            else break;
        }
        httpRequest.setHeaders(headers);

        //Extraction of body
        httpRequest.setBody(rawRequest.toString());

        return httpRequest;
    }
}
