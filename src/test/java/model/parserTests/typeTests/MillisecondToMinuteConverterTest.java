package model.parserTests.typeTests;

import model.type.MillisecondToMinuteConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MillisecondToMinuteConverterTest {

    @Test
    public void convertToMinTest() {
        MillisecondToMinuteConverter millisecondToMinuteConverter = new MillisecondToMinuteConverter();
        double result = millisecondToMinuteConverter.convertToMin("100000");
        Assertions.assertEquals(1.7, result);
    }
}
