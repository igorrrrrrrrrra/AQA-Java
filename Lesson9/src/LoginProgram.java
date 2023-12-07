import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LoginProgram {
    // 5. Нужно написать программу, которая будет принимать от пользователя ввод различных логинов.
    // Как только пользователь введет пустую строку - программа должна прекратить приём данных от пользователя
    // и вывести в консоль логины, начинающиеся на букву f (строчную).
    public static void searchLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логины. Для завершения введите пустую строку.");

        List<String> logins = new ArrayList<>();
        String input;

        while (!(input = scanner.nextLine()).isEmpty()) {
            logins.add(input);
        }

        List<String> loginsStartingWithF = logins.stream()
                .filter(login -> login.startsWith("f"))
                .collect(Collectors.toList());

        System.out.println("Логины, начинающиеся с 'f' (строчной):");
        loginsStartingWithF.forEach(System.out::println);

        scanner.close();
    }

}