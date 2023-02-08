package com.keyin.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTime {
    public static void main(String[] args) {
        // MAIN OUTPUTS
        // Creating Time Cases
        Time T1 = new Time(21, 10, 15);
        Time T2 = new Time(10, 20, 25);
        Time T3 = new Time(5, 59, 59);
        Time T4 = new Time(10, 0, 0);


        // Displaying Times
        System.out.println("Time 1: " + T1.toString());
        System.out.println("Time 2: " + T2.toString());
        System.out.println("Time 3: " + T3.toString());
        System.out.println("Time 3: " + T4.toString());

        // Next Second
        System.out.println("Time 1 Moving Forward 1 Second: " + T1.nextSecond());
        System.out.println("Time 2 Moving Backward 1 Second: " + T2.prevSecond());

        // Showing what happens when minute and second are at 59 and using nextSecond method
        System.out.println("Time 3 Moving Forward 1 Second: " + T3.nextSecond());

        // Showing what happens when the minute and second are at 00 using the prevSecond method
        System.out.println("Time 4 Moving Backward 1 Second: " + T4.prevSecond());

    }
    // TESTS

    // Test1: Previous Second Test Case
    @Test
    public void testPrevSec() {
        // Time Case
        Time T1 = new Time(21, 10, 15);
        System.out.println("Time Before Test Case(Previous Second): " + T1);
        // Moving Time Back By 1 Second
        T1.prevSecond();
        // Test Case
        Assertions.assertEquals("21:10:14",T1.toString());
        System.out.println("Time After Test Case(Previous Second): " + T1);
    }

    // Test2: Next Second Test Case

    @Test
    public void testNextSec() {
        // Time Case
        Time T1 = new Time(21, 10, 15);
        System.out.println("Time Before Test Case(Next Second): " + T1);
        // Moving Time Back By 1 Second
        T1.nextSecond();
        // Test Case
        Assertions.assertEquals("21:10:16",T1.toString());
        System.out.println("Time After Test Case(Next Second): " + T1);
    }

    // Test3: Testing for time change moving time forward 1 second past 23:59:59
    @Test
    public void testPast23() {
        Time T5 = new Time(23,59,59);
        System.out.println("Time Before Test Case(Past 24 hour): " + T5);
        T5.nextSecond();

        // Test Case: testing if time will reset to 00:00:00 moving forward 1 second
        Assertions.assertEquals("00:00:00", T5.toString());
        System.out.println("Time After Test Case(Past 24 hour): " + T5);
    }

    // Test4: Testing for time change moving time backward 1 second past 00:00:00

    @Test
    public void testBack24() {
        Time T5 = new Time(0,0,0);
        System.out.println("Time Before Test Case(Back 0): " + T5);
        T5.prevSecond();

        // Test Case: testing if time will reset to 00:00:00 moving forward 1 second
        Assertions.assertEquals("23:59:59", T5.toString());
        System.out.println("Time After Test Case(Back 0): " + T5);
    }

    // Test5: Testing to see if the time constructor sets the right time
    @Test
    public void testTime() {
        Time T1 = new Time(12,40,55);
        Assertions.assertEquals(12, T1.getHour());
        Assertions.assertEquals(40, T1.getMinute());
        Assertions.assertEquals(55, T1.getSecond());
    }

    // Test6: Testing toString method

    @Test
    public void testString() {
        Time T1 = new Time(9,40,50);
        Assertions.assertEquals("09:40:50",T1.toString());

        System.out.println("Time Should Be Displayed as 09:40:50: " + T1.toString());
    }
}
