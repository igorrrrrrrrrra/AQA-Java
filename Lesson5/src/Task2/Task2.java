package Task2;

public class Task2 {
    public static void task2() {
        Circle circle = new Circle(5, "Крысный", "Черный");
        Rectangle rectangle = new Rectangle(3, 4, "Синий", "Зеленый");
        Triangle triangle = new Triangle(5, 12, 13, "Желтый", "Фиолетовый");

        displayShapeInfo(circle);
        displayShapeInfo(rectangle);
        displayShapeInfo(triangle);
    }

    private static void displayShapeInfo(Form form) {
        if (form instanceof Circle) {
            System.out.println("Фигура: Круг");
        } else if (form instanceof Rectangle) {
            System.out.println("Фигура: Прямоугольник");
        } else if (form instanceof Triangle) {
            System.out.println("Фигура: Треугольник");
        }
        
        System.out.println("Периметр: " + form.calculatePerimeter());
        System.out.println("Площадь: " + form.calculateArea());
        System.out.println("Цвет заливки: " + form.getFillColor());
        System.out.println("Цвет контура: " + form.getBorderColor());
        System.out.println();
    }
}
