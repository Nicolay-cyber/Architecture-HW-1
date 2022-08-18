package ru.geekbrains.factories;

import ru.geekbrains.ResponseSerializer;

public final class ResponseSerializerFactory {
    public static ResponseSerializer create() {
        return new ResponseSerializer();
    }
}
