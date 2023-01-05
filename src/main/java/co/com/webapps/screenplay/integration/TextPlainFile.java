package co.com.webapps.screenplay.integration;

import co.com.webapps.screenplay.exceptions.NotFoundFileException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextPlainFile {

    protected String path;
    private static final Logger LOGGER = LogManager.getLogger(TextPlainFile.class.getName());

    public TextPlainFile(String path) {
        this.path = path;
    }

    public void writeFile(String text){
        try {
            try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
                byte[] strToBytes = text.getBytes();
                fileOutputStream.write(strToBytes);
            }
        }  catch (IOException e) {
                LOGGER.error(e);
        }
    }

    public String readFile() {
        String file = "";
        try {
            file = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            throw new NotFoundFileException("Archivo no encontrado", e);
        }

        return file;
    }

    public static TextPlainFile getInstance(String path){
        return new TextPlainFile(path);
    }

}
