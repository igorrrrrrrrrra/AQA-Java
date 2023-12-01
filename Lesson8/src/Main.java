import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] wordArray = {"apple", "orange", "banana", "apple", "grape", "banana", "kiwi", "orange", "apple", "pear", "kiwi", "banana"};

        Map<String, Integer> wordCounter = new HashMap<>();
        for (String word : wordArray) {
            wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
        }
        List<String> uniqueWords = new ArrayList<>(wordCounter.keySet());
        System.out.println("Уникальные слова: " + uniqueWords);
        System.out.println("Количество повторений каждого слова: " + wordCounter);

        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add("Иванов", "123-456-78");
        phoneDirectory.add("Лысаков", "987-654-32");
        phoneDirectory.add("Иванов", "555-123-45");

        System.out.println("Номер(а) телефона для фамилии 'Иванов': " + phoneDirectory.get("Иванов"));
        System.out.println("Номер(а) телефона для фамилии 'Лысаков': " + phoneDirectory.get("Лысаков"));
        System.out.println("Номер(а) телефона для фамилии 'Сидоров': " + phoneDirectory.get("Сидоров"));
    }
}
