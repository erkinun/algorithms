package com.unlu.erkin.hackerrank;

/**
 * Created by ERKIN on 14/05/15.
 */
public class ExcelNumber {

    public static void main(String[] args) {
        ExcelNumber excelNumber = new ExcelNumber();

        System.out.println("excel number of AB: " + excelNumber.titleToNumber("AB"));
        System.out.println("excel string for number 26: " + excelNumber.convertToTitle(26));
    }

    public int titleToNumber(String s) {
        char[] excel = s.toCharArray();

        int pow = 0;
        int sum = 0;
        int val;
        double digit;
        for (int i = excel.length - 1; i >= 0; i--) {
            val = (excel[i] - 'A') + 1;
            digit = Math.pow(26, pow++);
            sum += (val * digit);
        }

        return sum;
    }

    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();

        int remainder;
        while (n > 0) {
            remainder = n % 26;
            builder.append(findChar(remainder));
            n = (n-1) / 26;
        }

        return builder.reverse().toString();
    }

    private char findChar(int remainder) {
        char c = 'A';

        if (remainder == 0) {
            remainder = 26;
        }

        for (int i = 1; i < remainder; i++) {
            c++;
        }

        return c;
    }
}
