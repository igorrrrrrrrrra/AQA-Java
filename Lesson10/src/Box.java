import java.util.ArrayList;

class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        float weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> otherBox) {
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0001;
    }

    public void pourTo(Box<T> otherBox) {
        if (this != otherBox) {
            otherBox.fruits.addAll(this.fruits);
            this.fruits.clear();
        }
    }
}