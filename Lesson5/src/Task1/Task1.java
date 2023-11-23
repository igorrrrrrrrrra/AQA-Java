package Task1;

public class Task1 {
    public static void task1() {
        Cat[] cats = new Cat[]{new Cat("Барсик"), new Cat("Мурка"), new Cat("Пушок")};
        Dog[] dogs = new Dog[]{new Dog("Ральф"), new Dog("Шарик"), new Dog("Тоби")};

        System.out.println("Всего котов: " + Cat.getCatCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего животных: " + Animal.getAnimalCount());

        cats[0].run(100);
        dogs[1].run(300);
        cats[2].run(500);

        dogs[0].swim(100);
        dogs[1].swim(8);
        cats[2].swim(3);

        Bowl bowl = new Bowl(14);

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        for (Cat cat : cats) {
            System.out.println(cat.isSatiety() ? cat.getName() + " сыт." : cat.getName() + " голоден.");
        }

        bowl.info();
    }
}