package ru.geekbrains.domain.requests;

public class GetRequest extends RequestDecorator {
    public GetRequest(HttpRequest httpRequest) {
        super(httpRequest);
    }

    @Override
    public String getSomethingSpecialBaseOnMethodName() {
        return super.getSomethingSpecialBaseOnMethodName() + "Wow! It's GET request";
    }
}
