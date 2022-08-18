package ru.geekbrains.factories;

import ru.geekbrains.RequestParser;

public final class RequestParserFactory {
    public static RequestParser create() {
        return new RequestParser();
    }
}
