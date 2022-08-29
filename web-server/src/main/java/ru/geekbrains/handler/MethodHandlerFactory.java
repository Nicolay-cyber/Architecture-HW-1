package ru.geekbrains.handler;

import org.reflections.Reflections;
import ru.geekbrains.ResponseSerializer;
import ru.geekbrains.config.ServerConfig;
import ru.geekbrains.service.FileService;
import ru.geekbrains.service.SocketService;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public final class MethodHandlerFactory {

    public static MethodHandler create(SocketService socketService, ResponseSerializer responseSerializer, ServerConfig config, FileService fileService) {
        PutMethodHandler putHandler = new PutMethodHandler(null, socketService, responseSerializer, config);
        PostMethodHandler postHandler = new PostMethodHandler(putHandler, socketService, responseSerializer, config);
        return new GetMethodHandler(postHandler, socketService, responseSerializer, config, fileService);
    }

    public static MethodHandler createAnnotated() {
        Reflections reflections = new Reflections("ru.geekbrains.handler");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Handler.class);

        Set<Class<?>> sortedMethods = classes.stream()
                .sorted(Comparator.comparing(m -> m.getAnnotation(Handler.class).order()))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        sortedMethods.forEach(System.out::println);
        return null;
    }
}
