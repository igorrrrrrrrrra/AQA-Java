public class Tasks {
    public static void printThreeWords(){
        System.out.println("Orange\n" +
                "Banana\n" +
                "Apple\n");
    }

    public static void checkSunSign(){
        int a, b, sum;
        a = (int) (Math.random() * 100);
        b = (int) (Math.random() * -100);
        sum = a + b;
        if (sum >= 0) System.out.println("Сумма положительная и равна: " + sum);
        else System.out.println("Сумма отрицательная и равна: " + sum);
    }

    public static void printColor(){
        int value = (int) (Math.random() * 100 + 45);
        if (value <= 0) System.out.println("Красный (число равно: " + value + ")");
        else if (value > 0 && value <= 100) System.out.println("Желтый (число равно: " + value + ")");
        else if (value > 100) System.out.println("Зеленый (число равно: " + value + ")");
    }

    public static void compareNumbers(){
        int a, b;
        a = (int) (Math.random() * 100);
        b = (int) (Math.random() * 100);
        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }
}
