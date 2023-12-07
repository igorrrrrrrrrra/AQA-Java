import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StudentsList {
    private Collection<Student> students;

    public StudentsList() {
        // Инициализация коллекции студентов при создании экземпляра класса
        this.students = Arrays.asList(
                new Student("Дмитрий", 17, Gender.MAN),
                new Student("Максим", 20, Gender.MAN),
                new Student("Екатерина", 20, Gender.WOMAN),
                new Student("Михаил", 27, Gender.MAN)
        );
    }

    // 4.1. Необходимо узнать средний возраст студентов мужского пола;
    public double getAverageAgeOfMaleStudents() {
        List<Student> maleStudents = students.stream()
                .filter(student -> student.getGender() == Gender.MAN)
                .collect(Collectors.toList());

        if (maleStudents.isEmpty()) {
            return 0.0;
        }

        double sumAge = maleStudents.stream()
                .mapToInt(Student::getAge)
                .sum();

        return sumAge / maleStudents.size();
    }

    // 4.2. Кому из студентов грозит получение повестки в этом году при условии,
    // что призывной возраст установлен в диапазоне от 18 до 27 лет;
    public List<Student> getStudentsEligibleForDraft() {
        return students.stream()
                .filter(student -> student.getGender() == Gender.MAN &&
                        student.getAge() >= 18 && student.getAge() <= 27)
                .collect(Collectors.toList());
    }

    public static void task4() {
        // Создание объекта StudentsList
        StudentsList studentsList = new StudentsList();

        // Вызов методов для решения задач
        double averageAgeOfMaleStudents = studentsList.getAverageAgeOfMaleStudents();
        List<Student> studentsEligibleForDraft = studentsList.getStudentsEligibleForDraft();

        // Вывод результатов
        System.out.println("Средний возраст студентов мужского пола: " + averageAgeOfMaleStudents);
        System.out.println("Студенты, грозящие получить повестку в этом году: " + studentsEligibleForDraft);
    }


    // 4. Создай класс со следующим содержимым
    private static class Student {
        private final String name;
        private final Integer age;
        private final Gender gender;

        public Student(String name, Integer age, Gender gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    gender == student.gender;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }
    }
}
