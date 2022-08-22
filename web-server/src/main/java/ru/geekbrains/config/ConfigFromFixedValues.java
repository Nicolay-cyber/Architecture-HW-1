package ru.geekbrains.config;

class ConfigFromFixedValues implements ServerConfig {

    @Override
    public String getWww() {
        return "D:/IntelliJ IDEA projects/GB HW/Architecture/HW-1/HW-1/www";
    }

    @Override
    public int getPort() {
        return 8088;
    }
}
