import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isEnable = true;
        while (isEnable) {
            System.out.println("1)checkSum\n" +
                    "2)printString\n" +
                    "3)checkNumber\n" +
                    "4)checkNumberBool\n" +
                    "5)isLeapYear\n" +
                    "6)invertArray\n" +
                    "7)makeArray\n" +
                    "8)changeArray\n" +
                    "9)fillDiagonal\n" +
                    "10)generateArray\n" +
                    "11)exit\n" +
                    "Введите номер метода: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("checkSum(5, 6): " + Tasks.checkSum(5, 6));
                    break;

                case 2:
                    System.out.println("printString(\"Hello\", 3):");
                    Tasks.printString("Hello", 3);
                    break;

                case 3:
                    int number = -5;
                    Tasks.checkNumber(number);
                    break;

                case 4:
                    int num = -5;
                    System.out.println("checkNumberBool(" + num + "): " + Tasks.checkNumberBool(num));
                    break;

                case 5:
                    int year = 2024;
                    System.out.println("isLeapYear(" + year + "): " + Tasks.isLeapYear(year));
                    break;

                case 6:
                    int[] arrayToInvert = {1, 0, 1, 0, 1};
                    System.out.print("Before invertArray: ");
                    for (int value : arrayToInvert) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                    Tasks.invertArray(arrayToInvert);
                    System.out.print("After invertArray: ");
                    for (int value : arrayToInvert) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                    break;

                case 7:
                    int[] newArray = Tasks.makeArray();
                    System.out.print("makeArray: ");
                    for (int value : newArray) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                    break;

                case 8:
                    int[] arrayToChange = {1, 2, 3, 4, 5, 6};
                    System.out.print("Before changeArray: ");
                    for (int value : arrayToChange) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                    Tasks.changeArray(arrayToChange);
                    System.out.print("After changeArray: ");
                    for (int value : arrayToChange) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                    break;

                case 9:
                    int[][] diagonalArray = new int[5][5];
                    System.out.println("Before fillDiagonal:");
                    Tasks.printTwoDArray(diagonalArray);
                    Tasks.fillDiagonals(diagonalArray);
                    System.out.println("After fillDiagonal:");
                    Tasks.printTwoDArray(diagonalArray);
                    break;

                case 10:
                    int[] generatedArray = Tasks.generateArray(5, 7);
                    System.out.print("generateArray: ");
                    for (int value : generatedArray) {
                        System.out.print(value + " ");
                    }
                    System.out.println();
                    break;
                case 11:
                    isEnable = false;
                    break;

                default:
                    System.out.println("Неверный выбор.");
                    break;
            }
        }
    }
}