package ru.gb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class RequestHandler implements Runnable {

    private final Socket socket;

    private final String folder;

    public RequestHandler(Socket socket, String folder) {
        this.socket = socket;
        this.folder = folder;
    }

    @Override
    public void run() {
        try (BufferedReader input = read();
             PrintWriter output = new PrintWriter(socket.getOutputStream())
        ) {

            File file = new File(folder, extractFileName(input));

            if (file.isPathEmpty()) {
                new ResponseSender(output).send(Response.NOT_FOUND.get());
                return;
            }

            new ResponseSender(output).sendFile(file);

            System.out.println("Client disconnected!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String extractFileName(BufferedReader input) throws IOException {
        String firstLine = input.readLine();
        String[] parts = firstLine.split(" ");

        System.out.println(firstLine);
        while (input.ready()) {
            System.out.println(input.readLine());
        }

        return parts[1];
    }

    private BufferedReader read() throws IOException {
        return new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream(), StandardCharsets.UTF_8));
    }

}
