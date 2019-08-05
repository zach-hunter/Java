import com.sun.nio.sctp.IllegalReceiveException;

import java.io.*;
import java.util.*;

public class CSVReader {

    private List<List<String>> lines = new ArrayList<>();

    public void addToList(String[] fields) {
        this.lines.add(Arrays.asList(fields));
    }

    public List<List<String>> getLines() {
        return this.lines;
    }


    public void read(String file) throws IOException {
        String fileName = String.format("%s", file);
        try (Scanner in =
            new Scanner(
                    new BufferedReader(
                            new FileReader(fileName)))) {
            if (in.hasNextLine()) {
                //doNothing();
            } else {
                throw new IllegalReceiveException("Invalid format");
            }
            while(in.hasNext()) {
                String line = in.nextLine();
                String[] fields = line.split(",(?=(?:[^\"\"]*\"\"[^\"\"]*\"\")*(?![^\"\"]*\"\"))"); //cobbled  together regex to ignore commas inside quotes and double quotes
                addToList(fields);
            }

        }

    }

    public int numberOfRows() {
        int numRows = 0;
        for (List<String> rows : getLines()) {
            numRows++;
        }
        return numRows;
    }

    public int numberOfFields(int row) {
        return getLines().get(row).size();
    }

    public String field(int row, int column) {
        return getLines().get(row).get(column);
    }
}
