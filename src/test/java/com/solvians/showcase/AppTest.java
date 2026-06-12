package com.solvians.showcase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppTest {
    @Test
    public void expectTwoIntArgs() {
        RuntimeException onlyOneArg = Assertions.assertThrows(
                RuntimeException.class,
                () -> App.main(new String[]{"xxx"})
        );
        assertEquals(
                "Expect at least number of threads and number of quotes. But got: [xxx]",
                onlyOneArg.getMessage()
        );

        NumberFormatException firstArgString = Assertions.assertThrows(
                NumberFormatException.class,
                () -> App.main(new String[]{"xxx", "zzz"})
        );
        assertEquals("For input string: \"xxx\"", firstArgString.getMessage());

        NumberFormatException secondArgString = Assertions.assertThrows(
                NumberFormatException.class,
                () -> App.main(new String[]{"10", "zzz"})
        );
        assertEquals("For input string: \"zzz\"", secondArgString.getMessage());

        assertDoesNotThrow(
                () -> App.main(new String[]{"2", "10"})
        );

        assertDoesNotThrow(
                () -> App.main(new String[]{"2", "10", "50"})
        );

        assertDoesNotThrow(
                () -> App.main(new String[]{"2", "10", "xxx"})
        );
    }
}
