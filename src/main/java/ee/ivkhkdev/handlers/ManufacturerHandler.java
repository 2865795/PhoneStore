package main.java.ee.ivkhkdev.handlers;

import main.java.ee.ivkhkdev.models.Manufacturer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerHandler implements Handler<Manufacturer> {
    private static final String FILE_NAME = "manufacturers.dat";

    @Override
    public List<Manufacturer> load() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Manufacturer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public void save(List<Manufacturer> manufacturers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(manufacturers);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных о производителях.");
        }
    }
}
