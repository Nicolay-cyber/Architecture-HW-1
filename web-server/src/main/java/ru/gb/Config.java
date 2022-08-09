package ru.gb;

public enum Config {
    SOURCE_PATH("D:/IntelliJ IDEA projects/GB HW/Architecture/HW-1/HW-1/www"),
    PORT("8088"),
;
    private final String value;

    public String get() {
        return value;
    }

    public int getInt(){
        return Integer.parseInt(value);
    }
    Config(String value) {
        this.value = value;
    }
}
