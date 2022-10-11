package ru.geekbrains.domain.requests;

public interface HttpRequest {
    String getSomethingSpecialBaseOnMethodName();
    String getMethod();
    String getUrl();
}
