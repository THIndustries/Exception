package Home_work02;

import java.util.Scanner;

public class ex04 {
//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
    public static void main(String[] args) {
        try {
            String result = myFunc();
            System.out.println(result);
        } catch (Exception ex) {
            System.out.println("Пустую строку вводить нельзя.");
        }
    }

    public static String myFunc() throws Exception {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        if (text.isEmpty()) {
            throw new Exception("Вы ввели пустую строку.");
        }
        return text;
    }
}
