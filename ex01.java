package Home_work02;

import java.io.*;

public class ex01 {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            String[] strings = {"asdf", "asdf"};
            String strings1 = strings[2];
            test();
            int a = 1 / 0;
            inputStream = new FileInputStream("sdafgdsaf");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Что-то не так с обращением к индексу массива.");
        }catch (ArithmeticException e){
            System.out.println("Что-то не то поделил");;
        }catch (IOException e){
            e.printStackTrace();
        }catch (StackOverflowError error) {
            System.out.println("sdhjghfsdkl");
        }finally {
            System.out.println("Я все равно выполнился!");
        }
        System.out.println("Я жив!");
    }

    public static void test() throws IOException {
        File file = new File("1");
        file.createNewFile();
        FileReader reader = new FileReader(file);
        reader.read();
        test();
    }
}
