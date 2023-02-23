package com.project.ams.processor;

public class Coin {
    private String name;
    private Double price;
    private String time;

    public Coin(String name, Double price, String time) {
        this.name = name;
        this.price = price;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", time=" + time +
                '}';
    }
}
