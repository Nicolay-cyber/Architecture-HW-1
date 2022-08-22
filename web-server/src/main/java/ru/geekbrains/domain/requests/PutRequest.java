package ru.geekbrains.domain.requests;

public class PutRequest extends RequestDecorator {

    public PutRequest(HttpRequest httpRequest) {
        super(httpRequest);
    }

    @Override
    public String getSomethingSpecialBaseOnMethodName() {
        return super.getSomethingSpecialBaseOnMethodName() + "Wow! It's PUT request";
    }
}
