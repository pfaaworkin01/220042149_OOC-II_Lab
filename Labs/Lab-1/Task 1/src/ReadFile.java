import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class ReadFile {

    public void readFile(String filePath) {
        String file = filePath;
        String tempLine;
        String splitBy = ",";
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((tempLine = br.readLine()) != null) {
                String[] row = tempLine.split(splitBy);
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

