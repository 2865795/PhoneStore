package main.java.ee.ivkhkdev.models;

import java.io.*;
import java.util.List;

public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int nextId = 1;  // Статическая переменная для отслеживания следующего ID
    private int id;
    private Manufacturer manufacturer;
    private String name;
    private int year;
    private String color;
    private double price;
    private int quantity;

    // Конструктор, который автоматически присваивает уникальный ID
    public Phone(Manufacturer manufacturer, String name, int year, String color, double price, int quantity) {
        this.id = nextId++;  // При создании нового телефона ID будет увеличиваться
        this.manufacturer = manufacturer;
        this.name = name;
        this.year = year;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }

    // Метод для отображения информации о телефоне
    @Override
    public String toString() {
        return String.format("ID: %d, Производитель: %s, Страна: %s, Название: %s, Год: %d, Цвет: %s, Цена: %.2f, Количество: %d",
                id, manufacturer.getName(), manufacturer.getCountry(), name, year, color, price, quantity);
    }

    // Геттеры для получения информации
    public int getId() {
        return id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Метод для загрузки следующего ID из файла
    public static void loadNextId(List<Phone> phones) {
        if (phones != null && !phones.isEmpty()) {
            nextId = phones.stream()
                    .mapToInt(Phone::getId)
                    .max()
                    .orElse(0) + 1;  // Устанавливаем следующий ID как максимальный ID + 1
        }
    }
}
