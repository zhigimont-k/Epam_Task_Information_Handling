package by.epam.task3.reader;

import by.epam.task3.exception.IllegalFileInputException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextFileReaderTest {
    private static final String FILE_PATH = "data/text.txt";
    private static final String EMPTY_FILE_PATH = "data/empty.txt";
    private static final String WRONG_FILE_PATH = "data/none.txt";
    private static final String EXPECTED = "    It has survived - not only (five) centuries, but also the leap into 13<<2 electronic typesetting, remaining 3>>5 essentially ~6&9|(3&4) unchanged. It was popularised in the ~(121>>4)|(78&77)&90 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\r\n" +
            "    It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using ~71&2&3|78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.\r\n" +
            "    It is a 2>>3&(~1)<<5 established fact that a reader will be of a page when looking at its layout.\r\n" +
            "    Bye.";
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
