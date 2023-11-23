package Task1;

public class Cat extends Animal {
    private static int catCount = 0;
    private static final int MAX_RUN_DISTANCE = 200;
    private static final int MIN_FOOD_TO_BE_SATISFIED = 5;
    private boolean satiety;
    private String name;

    public Cat(String name) {
        catCount++;
        this.name = name;
        this.satiety = false;
    }

    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал(а) " + distance + " м.");
        } else {
            System.out.println(name + " может пробежать максимум " + MAX_RUN_DISTANCE + " м.");
        }
    }

    @Override
    public void swim(int distance){
        System.out.println("Кот не умеет плавать!");
    }

    public void eat(Bowl bowl) {
        int amountToEat = Math.min(bowl.getFood(), MIN_FOOD_TO_BE_SATISFIED);

        if (amountToEat >= MIN_FOOD_TO_BE_SATISFIED) {
            bowl.decreaseFood(amountToEat);
            satiety = true;
            System.out.println(name + " поел(а) из тарелки.");
        } else {
            System.out.println("В тарелке недостаточно еды для кота " + name + ".");
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public static int getCatCount() {
        return catCount;
    }

    public String getName() {
        return name;
    }
}