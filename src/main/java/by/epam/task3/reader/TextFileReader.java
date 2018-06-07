package by.epam.task3.reader;

import by.epam.task3.exception.IllegalFileInputException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class TextFileReader {
    private static Logger logger = LogManager.getLogger();

    public String readFile(String fileName) throws IllegalFileInputException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new IllegalFileInputException("Attempt to read non-existent file.");
        }
        if (file.length() == 0) {
            throw new IllegalFileInputException("Attempt to read empty file.");
        }
        String text;
        try {
            text = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            logger.catching(Level.FATAL, e);
            throw new RuntimeException(e);
        }
        logger.log(Level.INFO, "Text read: " + text);
        return text;
    }
}

