package service;

import java.util.List;

public interface FileDataReader {

    List<List<String>> readStrings(String fileName);
}