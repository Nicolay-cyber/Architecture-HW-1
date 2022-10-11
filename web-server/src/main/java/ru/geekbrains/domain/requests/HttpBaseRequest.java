package ru.geekbrains.domain.requests;

import java.util.HashMap;
import java.util.Map;

public class HttpBaseRequest implements HttpRequest{

    private String method;

    private String url;

    private Map<String, String> headers = new HashMap<>();

    private String body;

    private HttpBaseRequest() {
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

    public static Builder createBuilder() {
        return new Builder();
    }

    @Override
    public String getSomethingSpecialBaseOnMethodName() {
       return "What is it a method?!";
    }

    public static class Builder {

        private final HttpBaseRequest request = new HttpBaseRequest();

        public Builder withMethod(String method) {
            this.request.method = method;
            return this;
        }

        public Builder withUrl(String url) {
            this.request.url = url;
            return this;
        }

        public Builder withHeader(String key, String value) {
            this.request.getHeaders().put(key, value);
            return this;
        }

        public Builder withBody(String body) {
            this.request.body = body;
            return this;
        }

        public HttpBaseRequest build() {
            if (this.request.getMethod() == null) {
                throw new IllegalStateException("Method not defined");
            }
            if (this.request.getUrl() == null) {
                throw new IllegalStateException("Url not defined");
            }
            return this.request;
        }
    }
}
