package ru.gb;

public enum Response {
    NOT_FOUND("""
            HTTP/1.1 404 NOT_FOUND
            Content-Type: text/html; charset=utf-8
               
            """,
            "<h1>Файл не найден!</h1>"),
    OK("""
            HTTP/1.1 200 OK
            Content-Type: text/html; charset=utf-8
                        
            """,
            ""),
    IT_IS_DIRECTORY("""
            HTTP/1.1 400 BAD_REQUEST
            Content-Type: text/html; charset=utf-8
          
            """,
            "<h1>Это директория!</h1>"),
    ;
    private final String head;
    private final String body;

    public String get() {
        return head + body;
    }

    Response(String head, String body) {
        this.head = head;
        this.body = body;
    }
}
