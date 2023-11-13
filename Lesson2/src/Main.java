import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isEnable = true;
        while (isEnable) {

            System.out.println("Выберите номер метода:\n 1)printThreeWords\n " +
                    "2)checkSunSign\n " +
                    "3)printColor\n " +
                    "4)compareNumbers\n " +
                    "5)Выход\n " +
                    "----------------\n" +
                    "Введите номер метода:");

            int num = scanner.nextInt();

            switch (num) {
                case 1:
                    Tasks.printThreeWords();
                    break;
                case 2:
                    Tasks.checkSunSign();
                    break;
                case 3:
                    Tasks.printColor();
                    break;
                case 4:
                    Tasks.compareNumbers();
                    break;
                case 5:
                    isEnable = false;
                    break;
                default:
                    System.out.println("Неверное значение!");
                    break;
            }
        }
    }
}