public class Main {
    public static void main(String[] args) {
        // Задачи из класса Tasks
        System.out.println("Задача 1: ");
        Tasks.processNumbers();

        System.out.println("\nЗадача 2: ");
        Tasks.collectionManipulatuon();

        System.out.println("\nЗадача 3: ");
        Tasks.sortCollection();

        // Задача из класса StudentsList c вложенным Student
        System.out.println("\nЗадача 4: ");
        StudentsList.task4();

        // Задача из класса LoginProgram
        System.out.println("\nЗадача 5: ");
        LoginProgram.searchLogin();
    }
}