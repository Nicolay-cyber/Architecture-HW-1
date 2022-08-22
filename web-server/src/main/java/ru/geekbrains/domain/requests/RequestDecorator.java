package ru.geekbrains.domain.requests;

public class RequestDecorator implements HttpRequest {
    protected HttpRequest httpRequest;

    public RequestDecorator(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    @Override
    public String getSomethingSpecialBaseOnMethodName() {
        return httpRequest.getSomethingSpecialBaseOnMethodName();
    }

    @Override
    public String getMethod() {
        return httpRequest.getMethod();
    }

    @Override
    public String getUrl() {
        return httpRequest.getUrl();
    }
}
