package ru.geekbrains.domain.requests;

public class PostRequest extends RequestDecorator {

    public PostRequest(HttpRequest httpRequest) {
        super(httpRequest);
    }

    @Override
    public String getSomethingSpecialBaseOnMethodName() {
        return super.getSomethingSpecialBaseOnMethodName() + "Wow! It's POST request";
    }
}
