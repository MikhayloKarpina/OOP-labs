package org.example;

import java.util.Arrays;

public class StringCalculator {
    int add(String numbers){
        if(numbers.length() == 0) return 0;
        String[] strings;
        if(numbers.charAt(0) == '/' && numbers.charAt(1) == '/') {
            String[] delimiters = numbers.split("\\[|\\]|//");

            StringBuilder pattern = new StringBuilder();
            for(int i = 0; i < delimiters.length - 1; i++){
                if(delimiters[i].length() == 0) continue;
                pattern.append(delimiters[i]).append("|");
            }
            if(pattern.length() == 0) throw new IllegalArgumentException("Error pattern");
            pattern.deleteCharAt(pattern.length() - 1);

            int i = 0;
            for(String c: numbers.split("")){
                if(c.equals("\n")) break;
                i++;
            }
            strings = numbers.substring(i+1).split(String.valueOf(pattern));

        }
        else strings = numbers.split(",|\n");
        if(Arrays.stream(strings).map(Integer::parseInt).mapToInt(i -> i).min().getAsInt() < 0) throw new IllegalArgumentException("Negative numbers in string!");
        return Arrays.stream(strings).map(Integer::parseInt).filter(i -> i <= 1000).mapToInt(i -> i).sum();
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        System.out.println(stringCalculator.add("1\n2,4"));
        System.out.println(stringCalculator.add("//[,-][\\.-][\\.][,]\n1,-2.3.-4,10001"));
        System.out.println(stringCalculator.add("//[,-][\\.-][\\.]\n1,-2.3.--4"));
    }
}