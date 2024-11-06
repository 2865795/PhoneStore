package main.java.ee.ivkhkdev.helpers;

import main.java.ee.ivkhkdev.input.ConsoleInput;
import main.java.ee.ivkhkdev.input.Input;
import main.java.ee.ivkhkdev.models.Manufacturer;
import main.java.ee.ivkhkdev.handlers.ManufacturerHandler;

import java.util.List;

public class AppHelperManufacturer implements AppHelper {
    private List<Manufacturer> manufacturers;
    private ManufacturerHandler manufacturerHandler;
    private Input input;

    public AppHelperManufacturer() {
        this.input = new ConsoleInput();
        this.manufacturerHandler = new ManufacturerHandler();
        this.manufacturers = manufacturerHandler.load();  // Загрузка списка производителей
    }

    @Override
    public void add() {
        String name = getString("Введите название производителя: ");
        String country = getString("Введите страну производителя: ");

        Manufacturer manufacturer = new Manufacturer(name, country);
        manufacturers.add(manufacturer);
        manufacturerHandler.save(manufacturers);
        System.out.println("Производитель добавлен: " + manufacturer);
    }

    @Override
    public void displayAll() {
        System.out.println("Список производителей:");
        for (int i = 0; i < manufacturers.size(); i++) {
            System.out.println(i + 1 + ". " + manufacturers.get(i));
        }
        System.out.println("==== Конец списка ====");
    }

    public void delete() {
        displayAll();
        int manufacturerId = getInt("Введите ID производителя для удаления: ");
        if (manufacturerId > 0 && manufacturerId <= manufacturers.size()) {
            manufacturers.remove(manufacturerId - 1);
            manufacturerHandler.save(manufacturers);
            System.out.println("Производитель удален.");
        } else {
            System.out.println("Производитель с указанным ID не найден.");
        }
    }

    private String getString(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }

    private int getInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Ошибка ввода. Попробуйте снова: ");
            }
        }
    }

    public Manufacturer getManufacturerByName(String name) {
        return manufacturers.stream().filter(m -> m.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public void saveManufacturers() {
        manufacturerHandler.save(manufacturers);
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturers;
    }
}
