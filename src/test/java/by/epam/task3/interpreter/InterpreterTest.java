package by.epam.task3.interpreter;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InterpreterTest {

    @DataProvider(name = "dataProvider")
    public Object[][] provideData(){
        InterpreterClient interpreter = new InterpreterClient();

        int expected1 = 3 << 5;
        interpreter.parse("3 5 <<");
        int result1 = interpreter.calculate();

        int expected2 = ~4 << 5;
        interpreter.parse("4 ~ 5 <<");
        int result2 = interpreter.calculate();

        int expected3 = 128 >> 3 << 12;
        interpreter.parse("128 3 >> 12 <<");
        int result3 = interpreter.calculate();

        return new Object[][]{{result1, expected1}, {result2, expected2}, {result3, expected3}};
    }
    @Test(dataProvider = "dataProvider")
    public void interpret(int actual, int expected){
        Assert.assertEquals(actual, expected);
    }
}
