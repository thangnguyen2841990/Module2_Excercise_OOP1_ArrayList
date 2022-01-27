package com.codegym;

import java.io.Serializable;

public class Hotel implements Serializable {
    private int rentsDay;
    private String type;
    private double price;
    private Person person;

    public Hotel() {
    }

    public Hotel(int rentsDay, String type, double price, Person person) {
        this.rentsDay = rentsDay;
        this.type = type;
        this.price = price;
        this.person = person;
    }

    public int getRentsDay() {
        return rentsDay;
    }

    public void setRentsDay(int rentsDay) {
        this.rentsDay = rentsDay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return person.toString() + ", Số ngày thuê: " + rentsDay +
                ", loại phòng: " + type +
                ", giá: " + price + "(VND/ngày.)";
    }
}
