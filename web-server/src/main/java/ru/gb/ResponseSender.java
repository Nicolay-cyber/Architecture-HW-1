package ru.gb;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class ResponseSender {

    private final PrintWriter output;

    public ResponseSender(PrintWriter output) {
        this.output = output;
    }

    public void sendFile(File file) throws IOException {
        if(Files.isDirectory(file.getPath())){
            output.println(Response.IT_IS_DIRECTORY.get());
            output.flush();
            System.out.println("User wrote directory!");

        }else{
            output.println(Response.OK.get());
            Files.newBufferedReader(file.getPath()).transferTo(output);
            System.out.println("File sent!");
        }
    }
    public void send(String text){
        output.println(text);
        output.flush();
    }
}
