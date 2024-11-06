package main.java.ee.ivkhkdev.input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String nextLine() {
        return scanner.nextLine(); // Чтение строки
    }

    @Override
    public int nextInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ошибка ввода! Введите целое число: ");
            scanner.next(); // Пропускаем неправильный ввод
        }
        return scanner.nextInt(); // Чтение целого числа
    }

    @Override
    public double nextDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Ошибка ввода! Введите число с плавающей точкой: ");
            scanner.next(); // Пропускаем неправильный ввод
        }
        return scanner.nextDouble(); // Чтение числа с плавающей точкой
    }
}
