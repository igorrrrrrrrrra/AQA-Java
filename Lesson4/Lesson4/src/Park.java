import java.util.ArrayList;
import java.util.List;

public class Park {
    public class Attraction{
        private String name;
        private String workTime;
        private double cost;

        public Attraction(String name, String workTime, double cost) {
            this.name = name;
            this.workTime = workTime;
            this.cost = cost;
        }

        public void printAttractionInfo() {
            System.out.println("\nНазвание аттракциона: " + name + ";" +
                    "\nВремя работы: " + workTime + ";" +
                    "\nСтоимость: " + cost + ".");
        }
    }

    private ArrayList<Attraction> attractions;

    public Park(){
        this.attractions = new ArrayList<Attraction>();
    }

    public void addAttraction(String name, String workTime, double cost) {
        Attraction attraction = new Attraction(name, workTime, cost);
        attractions.add(attraction);
    }

    public void displayAttractions() {
        System.out.println("Информация об аттракционах в парке: ");
        for (Attraction attraction : attractions) {
            attraction.printAttractionInfo();
        }
    }
}
