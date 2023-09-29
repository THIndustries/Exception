package Home_work02;


import java.io.*;
import java.util.*;

class InvalidDataFormatException extends Exception {
    public InvalidDataFormatException(String message) {
        super(message);
    }
}

public class UserDataParser {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные (Фамилия Имя Отчество ДатаРождения НомерТелефона Пол):");
            String input = scanner.nextLine();

            String[] data = input.split("\\s+");

            if (data.length != 6) {
                System.out.println("Ошибка: неверное количество данных.");
                return;
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            String gender = data[5];

            // Проверка формата данных
            try {
                validateDataFormat(birthDate, phoneNumber, gender);
            } catch (Home_work02.InvalidDataFormatException e) {
                System.out.println("Ошибка: " + e.getMessage());
                return;
            }

            // Создание файла и запись данных
            try {
                String fileName = lastName + ".txt";
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
                writer.write(lastName + firstName + middleName + birthDate + " " + phoneNumber + gender);
                writer.newLine();
                writer.close();
                System.out.println("Данные успешно записаны в файл: " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void validateDataFormat(String birthDate, String phoneNumber, String gender)
            throws Home_work02.InvalidDataFormatException {
        // Проверка формата даты рождения
        if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new Home_work02.InvalidDataFormatException("Неверный формат даты рождения. Используйте dd.mm.yyyy.");
        }

        // Проверка формата номера телефона
        if (!phoneNumber.matches("\\d+")) {
            throw new Home_work02.InvalidDataFormatException("Неверный формат номера телефона. Используйте целое число без пробелов.");
        }

        // Проверка формата пола
        if (!gender.matches("[fm]")) {
            throw new Home_work02.InvalidDataFormatException("Неверный формат пола. Используйте 'f' или 'm'.");
        }
    }
}
