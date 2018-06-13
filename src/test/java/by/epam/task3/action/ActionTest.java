package by.epam.task3.action;

import by.epam.task3.composite.TextComponent;
import by.epam.task3.exception.IllegalFileInputException;
import by.epam.task3.parser.TextHandler;
import by.epam.task3.reader.TextFileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionTest {
    private static final String FILE_PATH = "data/text.txt";
    private TextComponent text;
    private TextAction textAction;

    @BeforeClass
    public void init() throws IllegalFileInputException{
        text = new TextHandler().parse(new TextFileReader().readFile(FILE_PATH));
        textAction = new TextAction();
    }

    @Test
    public void sortParagraphsBySentenceNumber(){
        TextComponent sortedText = textAction.sortParagraphsBySentenceNumber(text);
        String expected = "Bye.\n" +
                "It is a 0 established fact that a reader will be of a page when looking at its layout.\n" +
                "It has survived - not only (five) centuries, but also the leap into 52 electronic typesetting, remaining 0 essentially 9 unchanged. It was popularised in the -8 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using 78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English.";
        Assert.assertEquals(sortedText.toString(), expected);
    }

    @Test
    public void sortSentencesByLexemeLength(){
        TextComponent sortedText = textAction.sortSentencesByLexemeLength(text);
        String expected = "Bye. It is a 0 established fact that a reader will be of a page when looking at its layout. It has survived - not only (five) centuries, but also the leap into 52 electronic typesetting, remaining 0 essentially 9 unchanged. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using 78 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here', making it look like readable English. It was popularised in the -8 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        Assert.assertEquals(sortedText.toString(), expected);
    }

    @Test
    public void sortLexemesBySymbolOccurrence(){
        TextComponent sortedText = textAction.sortLexemesBySymbolOccurrence('e', text);
        String expected = "release centuries, electronic essentially established established here', here), Letraset letters, more-or-less PageMaker readable readable reader reader recently sheets typesetting, (Content (five) be be Bye. content content desktop distracted leap like like Lorem Lorem more opposed page page passages, popularised remaining software survived the the the the The unchanged. versions when when - -8 0 0 52 78 9 a a a a a a a Aldus also and as at at but by containing distribution English. fact fact has has in including into Ipsum Ipsum Ipsum. is is is It It It it it It its its layout. layout. long look looking looking making normal not of of of of of of only point publishing that that that to using using was will will with with";
        Assert.assertEquals(sortedText.toString(), expected);
    }
}
