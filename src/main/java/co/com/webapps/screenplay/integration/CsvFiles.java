package co.com.webapps.screenplay.integration;

import co.com.webapps.screenplay.exceptions.NotFoundDataException;
import co.com.webapps.screenplay.exceptions.NotFoundFileException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class CsvFiles {

    private static final Logger LOGGER =LogManager.getLogger(CsvFiles.class.getName());
    private String path;
    private static final String SEPARATOR = ";";
    private static final String FILTER = "id";

    private CsvFiles(String path) {
        this.path = path;
    }

    public static CsvFiles inPath(String path) {
        return new CsvFiles(path);
    }

    public List<Map<String, String>> getDataFor(String key) {
        return readFile(path).stream()
                .filter(data -> data.get(FILTER).equalsIgnoreCase(key))
                .collect(Collectors.toList());
    }

    public Map<String, String> getUniqueDataFor(String key) {
        return readFile(path).stream()
                .filter(data -> data.get(FILTER).equalsIgnoreCase(key))
                .findFirst().orElseThrow(() -> new NotFoundDataException(NotFoundDataException.NOT_FOUND_OBJECT_CONSULT));

    }


    public List<Map<String, String>> getData() {
        return readFile(path);
    }

    private List<Map<String, String>> readFile(String path) {
        List<Map<String, String>> listData;
        FileReader file = null;
        try (FileReader fileReader = new FileReader(path)) {
            file = fileReader;
            BufferedReader csvReader = new BufferedReader(file);
            listData = readToListMap(csvReader);
            csvReader.close();
        } catch (IOException e) {
            throw new NotFoundFileException(e);
        } finally {
            closeCsvFile(file);
        }
        return listData;
    }

    private List<Map<String, String>> readToListMap(BufferedReader csvReader) {
        List<Map<String, String>> listData = new LinkedList<>();
        try {
            String[] headers = csvReader.readLine().split(SEPARATOR);
            listData = csvReader.lines().map(header -> header.split(SEPARATOR))
                    .map(data -> IntStream.range(0, data.length)
                            .boxed()
                            .collect(toMap((Integer i) -> headers[i], i -> data[i])))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOGGER.info(e);
        }
        return listData;
    }


    private void closeCsvFile(FileReader file) {
        try {
            if (file != null)
                file.close();
        } catch (IOException e) {
            LOGGER.info(e);
        }
    }
}
