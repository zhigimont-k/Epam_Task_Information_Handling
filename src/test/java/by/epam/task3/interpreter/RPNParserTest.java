package by.epam.task3.interpreter;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RPNParserTest {
    @DataProvider(name = "dataProvider")
    public Object[][] provideData() {
        ReversePolishNotationParser parser = new ReversePolishNotationParser();

        String expected1 = "2 3 >> 1 ~ 5 << &";
        String result1 = parser.parse("2>>3&(~1)<<5");

        String expected2 = "128 4 >> ~ 78 77 & 90 & |";
        String result2 = parser.parse("~(128>>4)|(78&77)&90");

        String expected3 = "88 288 4 >>> <<";
        String result3 = parser.parse("88<<(288>>>4)");

        return new Object[][]{{result1, expected1}, {result2, expected2}, {result3, expected3}};
    }

    @Test(dataProvider = "dataProvider")
    public void parse(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }
}
