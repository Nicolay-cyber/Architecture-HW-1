package ru.geekbrains.domain;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

    private String method;

    private String url;

    private Map<String, String> headers = new HashMap<>();

    private String body;

    private HttpRequest() {
    }

    public String getMethod() {
        return method;
    }


    public String getUrl() {
        return url;
    }


    public Map<String, String> getHeaders() {
        return headers;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final HttpRequest httpRequest;

        public Builder() {
            this.httpRequest = new HttpRequest();
        }

        public Builder withHeaders(Map<String, String> headers) {
            this.httpRequest.headers = headers;
            return this;
        }

        public Builder withUrl(String url) {
            this.httpRequest.url = url;
            return this;
        }

        public Builder withMethod(String method) {
            this.httpRequest.method = method;
            return this;
        }

        public HttpRequest build() {
            return httpRequest;
        }

    }
}
