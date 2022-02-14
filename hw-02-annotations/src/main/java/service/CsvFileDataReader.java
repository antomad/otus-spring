package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvFileDataReader implements FileDataReader {

    @Override
    public List<List<String>> readStrings(String fileName) {
        List<List<String>> records = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream("/" + fileName)) {
            if (inputStream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] values = line.split(";");
                    records.add(Arrays.asList(values));
                }
            }
        } catch (IOException e) {
            System.out.println("Cannot read the file");
        }
        return records;
    }
}