package by.epam.task3.parser;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.exception.IllegalFileInputException;
import by.epam.task3.reader.TextFileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ParserTest {
    private static final String FILE_PATH = "data/text.txt";
    private static final String expected = "It has survived - not only (five) centuries, but also the leap into 52 electronic typesetting, remaining 0 essentially 9 unchanged. It was popularised in the -8 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
            "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using 78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.\n" +
            "It is a 0 established fact that a reader will be of a page when looking at its layout.\n" +
            "Bye.";
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
        Assert.assertEquals(restoredText, expected);
    }
}
