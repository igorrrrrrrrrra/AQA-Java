import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class FileWork {
    private String[] header;
    private int[][] data;

    public FileWork() {

    }

    public static void save(FileWork data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(String.join(";", data.getHeader()));
            writer.newLine();

            for (int[] row : data.getData()) {
                writer.write(String.join(";", convertToStringArray(row)));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileWork load(String filePath) {
        FileWork fileWork = new FileWork();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String headerLine = reader.readLine();
            fileWork.setHeader(headerLine.split(";"));

            String line;
            int rowCount = (int) reader.lines().count();
            fileWork.setData(new int[rowCount][]);

            try (BufferedReader newReader = new BufferedReader(new FileReader(filePath))) {
                newReader.readLine();

                int i = 0;
                while ((line = newReader.readLine()) != null) {
                    String[] values = line.split(";");
                    int[] row = convertToIntArray(values);
                    fileWork.getData()[i++] = row;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileWork;
    }

    private static int[] convertToIntArray(String[] values) {
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = Integer.parseInt(values[i]);
        }
        return result;
    }

    private static String[] convertToStringArray(int[] values) {
        String[] result = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = String.valueOf(values[i]);
        }
        return result;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

}
