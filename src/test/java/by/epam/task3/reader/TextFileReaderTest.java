package by.epam.task3.reader;

import by.epam.task3.exception.IllegalFileInputException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextFileReaderTest {
    private static final String FILE_PATH = "data/test.txt";
    private static final String EMPTY_FILE_PATH = "data/empty.txt";
    private static final String WRONG_FILE_PATH = "data/none.txt";
    private static final String EXPECTED = "This is a text for TextFileReader testing.";
    private TextFileReader reader;


    @BeforeClass
    public void init(){
        reader = new TextFileReader();
    }

    @Test
    public void readFilePositive() throws IllegalFileInputException{
        Assert.assertEquals(reader.readFile(FILE_PATH), EXPECTED);
    }

    @Test(expectedExceptions = IllegalFileInputException.class)
    public void readEmptyFile() throws IllegalFileInputException {
        reader.readFile(EMPTY_FILE_PATH);
    }

    @Test(expectedExceptions = IllegalFileInputException.class)
    public void readFileNotFound() throws IllegalFileInputException{
        reader.readFile(WRONG_FILE_PATH);
    }
}
