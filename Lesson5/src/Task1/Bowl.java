package Task1;

public class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = Math.max(0, food);
    }

    public void addFood(int amount) {
        if (amount >= 0) {
            food += amount;
            System.out.println("Добавлено " + amount + " еды в тарелку.");
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды.");
        }
    }

    public boolean decreaseFood(int amount) {
        if (amount >= 0 && amount <= food) {
            food -= amount;
            return true;
        }
        return false;
    }

    public int getFood() {
        return food;
    }

    public void info() {
        System.out.println("В тарелке осталось " + food + " еды.");
    }
}