package by.epam.task3.parser;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.exception.IllegalFileInputException;
import by.epam.task3.reader.TextFileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParserTest {
    private static final String FILE_PATH = "data/text.txt";
    private TextFileReader reader;
    private TextHandler handler;

    @BeforeClass
    public void init(){
        reader = new TextFileReader();
        handler = new TextHandler();
    }

    @Test
    public void parse() throws IllegalFileInputException{
        String text = reader.readFile(FILE_PATH);
        TextComponent textComponent = handler.parse(text);
        String restoredText = textComponent.toString();
        Assert.assertEquals(restoredText, text);
    }
}
