import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileWork fileWork = new FileWork();
        fileWork.setHeader(new String[]{"id", "Кол-во товара", "Общая стоимость"});
        fileWork.setData(new int[][]{{1, 25, 100}, {2, 30, 200}, {3, 22, 150}});

        String filePath = "data.csv";
        FileWork.save(fileWork, filePath);

        FileWork loadedData = FileWork.load(filePath);

        System.out.println(Arrays.toString(loadedData.getHeader()));
        for (int[] row : loadedData.getData()) {
            System.out.println(Arrays.toString(row));
        }
    }
}