public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private double salary;
    private int age;

    public Employee(String fullName, String position, String email, String phoneNumber, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public Employee() {
    }

    public void printEmployeeInfo(){
        System.out.println("\nФИО: " + fullName + ";" +
                "\nДолжность: " + position + ";" +
                "\nEmail: " + email + ";" +
                "\nНомер телефона: " + phoneNumber + ";" +
                "\nЗарплата: " + salary + ";" +
                "\nВозраст: " + age + ".");
    }

    public int getAge() {
        return age;
    }
}
