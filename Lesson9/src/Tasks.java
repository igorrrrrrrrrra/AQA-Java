import java.util.*;
import java.util.stream.Collectors;

public class Tasks {
    // 1. Для любого набора случайно-сгенерированных чисел нужно определить количество чётных чисел.
    public static void processNumbers() {
        List<Integer> numbers = generateRandomNumbers(10, 1, 100);

        System.out.println("Сгенерированный набор чисел: " + numbers);

        long evenCount = numbers.stream()
                .filter(number -> number % 2 == 0)
                .count();

        System.out.println("Количество четных чисел: " + evenCount);
    }

    // Вспомогательный метода для первого задания
    private static List<Integer> generateRandomNumbers(int count, int min, int max) {
        return new Random().ints(count, min, max + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    // 2. Задана коллекция, состоящая из строк: «Highload», «High», «Load», «Highload».
    // Нужно с ней выполнить следующие манипуляции:
    public static void collectionManipulatuon() {
        List<String> collection = Arrays.asList("Highload", "High", "Load", "Highload");

        // 2.1. Посчитать, сколько раз объект «High» встречается в коллекции
        long countHigh = collection.stream()
                .filter("High"::equals)
                .count();

        System.out.println("Количество вхождений \"High\": " + countHigh);

        // 2.2. Определить, какой элемент в коллекции находится на первом месте
        String firstElement = collection.stream()
                .findFirst()
                .orElse("0");

        System.out.println("Первый элемент коллекции: " + firstElement);

        // 2.3. Вернуть последний элемент
        String lastElement = collection.stream()
                .reduce((first, second) -> second)
                .orElse("0");

        System.out.println("Последний элемент коллекции: " + lastElement);
    }

    // 3. Задана коллекция, содержащая элементы "f10", "f15", "f2", "f4", "f4".
    // Необходимо отсортировать строки по возрастанию и добавить их в массив;
    public static void sortCollection() {
        List<String> collection = Arrays.asList("f10", "f15", "f2", "f4", "f4");

        String[] sortedArray = collection.stream()
                .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1))))
                .toArray(String[]::new);

        System.out.println("Отсортированный массив: " + Arrays.toString(sortedArray));
    }
}
