package com.ice.bondedge.bondticks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicksTest {

    public static final String ROOT_PATH = "/Users/rz08/dev/bondticks/src/test/resources/";

    @Test
    public void testFiles() {
        Ticks ticks = new Ticks();

        int count = ticks.printClosingPrice(ROOT_PATH + "ticks-0.txt");
        assertEquals(0, count);

        count = ticks.printClosingPrice(ROOT_PATH + "ticks-1.txt");
        assertEquals(1, count);

        count = ticks.printClosingPrice(ROOT_PATH + "ticks-2.txt");
        assertEquals(5, count);

        count = ticks.printClosingPrice(ROOT_PATH + "ticks-3.txt");
        assertEquals(2, count);
    }

}
