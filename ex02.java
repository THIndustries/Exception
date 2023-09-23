package Home_work02;

public class ex02 {
    public static void main(String[] args) {
        //Задание 2
        try {
            int d = 0;
            int[] intArray = null;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (NullPointerException e) {
            System.out.println("Что-то не так с инициализацией");
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
