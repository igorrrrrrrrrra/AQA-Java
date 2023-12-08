public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>(); // 1 яблоко весит 1 ( менять можно в конструкторе)
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>(); // 1 апельсин весит 1.5
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println("Вес коробки с яблоками №1: " + appleBox1.getWeight());
        System.out.println("Вес коробки с яблоками №2: " + appleBox2.getWeight());
        System.out.println("Вес коробки с апельсинами №1: " + orangeBox.getWeight());

        System.out.println("Сравнение первой коробки яблок со второй: " + appleBox1.compare(appleBox2));
        System.out.println("Сравнение коробки с яблоками и коробки с апельсинами: " + appleBox1.compare(orangeBox));

        appleBox1.pourTo(appleBox2);
        System.out.println("Вес первой коробки яблок после пересыпания: " + appleBox1.getWeight());
        System.out.println("Вес второй коробки яблок после пересыпания: " + appleBox2.getWeight());
    }
}