package main.java.ee.ivkhkdev;

import main.java.ee.ivkhkdev.helpers.AppHelperPhone;
import main.java.ee.ivkhkdev.helpers.AppHelperManufacturer;
import main.java.ee.ivkhkdev.input.ConsoleInput;
import main.java.ee.ivkhkdev.input.Input;

public class App {
    private AppHelperPhone phoneHelper;
    private AppHelperManufacturer manufacturerHelper;
    private Input input;

    public App() {
        this.phoneHelper = new AppHelperPhone();
        this.manufacturerHelper = new AppHelperManufacturer();
        this.input = new ConsoleInput();
    }

    public void run() {
        while (true) {
            System.out.println("\n Список доступных опций: ");
            System.out.println("1. Добавить телефон");
            System.out.println("2. Пополнить количество телефонов");
            System.out.println("3. Показать список телефонов");
            System.out.println("4. Продать телефон");
            System.out.println("5. Добавить производителя");
            System.out.println("6. Показать список производителей");
            System.out.println("7. Удалить телефон");
            System.out.println("8. Удалить производителя");
            System.out.println("0. Выйти");

            int choice = getInt("Выберите опцию: ");
            System.out.println();

            switch (choice) {
                case 1:
                    phoneHelper.add();
                    break;
                case 2:
                    phoneHelper.replenishStock();
                    break;
                case 3:
                    phoneHelper.displayAll();
                    break;
                case 4:
                    phoneHelper.sellPhone();
                    break;
                case 5:
                    manufacturerHelper.add();
                    break;
                case 6:
                    manufacturerHelper.displayAll();
                    break;
                case 7:
                    phoneHelper.delete();
                    break;
                case 8:
                    manufacturerHelper.delete();
                    break;
                case 0:
                    phoneHelper.savePhones(); // Сохраняем данные перед выходом
                    manufacturerHelper.saveManufacturers(); // Сохраняем данные перед выходом
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
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
}