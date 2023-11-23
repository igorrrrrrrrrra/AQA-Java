package Task1;

public class Dog extends Animal {
    private static int dogCount = 0;
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;
    private String name;

    public Dog(String name) {
        this.name = name;
        dogCount++;
    }

    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал(а) " + distance + " м.");
        } else {
            System.out.println(name + " может пробежать максимум " + MAX_RUN_DISTANCE + " м.");
        }
    }

    public void swim(int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(name + " проплыл(а) " + distance + " м.");
        } else {
            System.out.println(name + " может проплыть максимум " + MAX_SWIM_DISTANCE + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }

    public String getName() {
        return name;
    }
}