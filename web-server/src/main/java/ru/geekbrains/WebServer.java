package ru.geekbrains;

import ru.geekbrains.config.*;
import ru.geekbrains.factories.ConnectionFactory;

public class WebServer {

    public static void main(String[] args) {
        ServerConfig config = ServerConfigFactory.create(args);
        ConnectionFactory.create(config);
    }
}
