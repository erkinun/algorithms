package com.unlu.erkin.hackerrank;

/**
 * Created by ERKIN on 14/05/15.
 */
public class ExcelNumber {

    public static void main(String[] args) {
        ExcelNumber excelNumber = new ExcelNumber();

        System.out.println("excel number of AB: " + excelNumber.titleToNumber("AB"));
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
}
