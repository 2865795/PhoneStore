package main.java.ee.ivkhkdev.handlers;

import main.java.ee.ivkhkdev.models.Phone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneHandler implements Handler<Phone> {
    private static final String FILE_NAME = "phones.dat";

    @Override
    public List<Phone> load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Phone> phones = (List<Phone>) ois.readObject();
            Phone.loadNextId(phones);  // Обновляем nextId на основе уже существующих телефонов
            return phones;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке телефонов: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public void save(List<Phone> phones) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(phones);
            System.out.println("Телефоны успешно сохранены.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении телефонов: " + e.getMessage());
        }
    }
}
