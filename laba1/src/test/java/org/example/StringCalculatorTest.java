package org.example;

import org.example.StringCalculator;
import org.junit.*;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    //Test for empty string
    @Test
    public void test1() { assertEquals(0, stringCalculator.add("")); }

    //Test for 1 element in string
    @Test
    public void test2() { assertEquals(1, stringCalculator.add("1")); }

    //Test for 2 elements in string
    @Test
    public void test3() { assertEquals(3, stringCalculator.add("1,2")); }

    //Test for several elements in string wit using "\n" delimeter
    @Test
    public void test4() { assertEquals(11, stringCalculator.add("1\n2,3,5")); }

    //Test for different delimiter
    @Test
    public void test5() { assertEquals(10, stringCalculator.add("//[;]\n1;2;3;4")); }

    //Test for negative numbers
    @Test
    public void test6() {
        try {
            stringCalculator.add("-1,-2,3");
            fail("Expected exception for negative numbers");
        } catch(RuntimeException ex) {
            assertEquals("Negative numbers in string!", ex.getMessage());
        }
    }

    //Test for numbers more than 1000
    @Test
    public void test7() { assertEquals(1999, stringCalculator.add("1000,999,1001")); }

    //Test for delimiter with unknown range
    @Test
    public void test8() { assertEquals(6, stringCalculator.add("//[\\*\\*\\*]\n1***2***3")); }

    //Test for different delimiters which longer than 1
    @Test
    public void test9() { assertEquals(6, stringCalculator.add("//[\\*][%]\n1*2%3")); }
}