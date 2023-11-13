public class Tasks {
    public static boolean checkSum(int num1, int num2){
        int sum = num1 + num2;
        return sum >= 10 && sum <= 20;
    }

    public static void printString(String str, int count){
        for(int i = 0; i < count; i++) System.out.println(str);
    }

    public static void checkNumber(int number){
        if (number >= 0) System.out.println("Число " + number + " положительное");
        else System.out.println("Число " + number + "  отрицательное");
    }

    public static boolean checkNumberBool(int number){
        return number < 0;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }
    }

    public static int[] makeArray(){
        int[] array = new int[100];
        for(int i = 0; i < 100; i++) array[i] = i;
        return array;
    }

    public static void changeArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }

    public static void fillDiagonals(int[][] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            array[i][i] = 1;
        }

        for (int i = 0; i < length; i++) {
            array[i][length - 1 - i] = 1;
        }
    }

    public static int[] generateArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }

    public static void printTwoDArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
