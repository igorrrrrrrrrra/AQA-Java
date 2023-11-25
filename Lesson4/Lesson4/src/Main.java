public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Иванов Иван", "AQA Java Engineer", "ivivan@tut.by",
                "+375(33) 222-22-22", 30000, 30);
        employees[1] = new Employee("Петров Петор", "HR Manager", "petrovvvv@gmail.com",
                "+375(33) 111-11-11", 35000, 40);
        employees[2] = new Employee("Игорев Игорь", "System Analyst", "igoreeev@gmail.com",
                "+375(33) 333-33-33", 40000, 42);
        employees[3] = new Employee("Александров Александр", "Java Developer", "alex@mail.ru",
                "+375(33) 678-21-23", 45000, 25);
        employees[4] = new Employee("Леонидов Леонид", "Designer", "leon@gmail.com",
                "+375(33) 231-12-23", 38000, 32);

        for (Employee employee : employees) {
            if (employee.getAge() >= 40) {
                employee.printEmployeeInfo(employee);
            }
        }

        System.out.println("----------------------------------------------------");

        Park park = new Park();

        park.addAttraction("Американские горки", "10:00 AM - 8:00 PM", 15.0);
        park.addAttraction("Колесо обозрения", "11:00 AM - 7:00 PM", 10.0);
        park.addAttraction("Тир", "9:00 AM - 6:00 PM", 8.0);

        park.displayAttractions();
    }
}