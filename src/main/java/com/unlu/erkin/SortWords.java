package com.unlu.erkin;

import java.util.Arrays;

/**
 * Created by ERKIN on 12/03/15.
 */
public class SortWords {

    //input:  [‘world’, ‘4’, ‘hello’, ‘1’, ‘10’]
    //output: [‘hello’, ‘1’, ‘world’, ‘10’, ‘4’]

// for3v3r

    public static void main(String[] args) {
        String[] array = new String[] {"world", "4", "hello", "1", "10"};

        sortWithTypes(array);

        System.out.println(Arrays.toString(array));
    }

    private static boolean isNumber(String item) {
        try {
            long number = Long.valueOf(item);
            return true;
        }
        catch (NumberFormatException e) {
            //log somehow
            return false;
        }

    }

    //input:  [‘world’, ‘4’, ‘hello’, ‘1’, ‘10’]

    public static void sortWithTypes(String[] array) {

        if (array == null) { throw new IllegalArgumentException("null array"); }

        if (array.length == 0) { return; }

        int[] types = new int[array.length];
        int NUMBER = 1;
        int STRING = 2;

        int numberLen = 0;
        int strLen = 0;

        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                numberLen++;
                types[i] = NUMBER;
            }
            else {
                strLen++;
                types[i] = STRING;
            }
        }

        int[] numbers = new int[numberLen];
        String[] strings = new String[strLen];

        int nIdx = 0;
        int sIdx = 0;
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])){
                numbers[nIdx++] = Integer.valueOf(array[i]);
            }
            else {
                strings[sIdx++] = array[i];
            }
        }

        Arrays.sort(numbers);
        Arrays.sort(strings);

        nIdx = 0;
        sIdx = 0;
        for (int i = 0; i < array.length; i++) {
            if (types[i] == NUMBER) {
                array[i] = String.valueOf(numbers[nIdx++]);
            }
            else {
                array[i] = strings[sIdx++];
            }
        }

    }

    /**
     * input: ['good5,bye', '6hello', 'world']

     Input: [‘,,,,,,,,,,,’]

     goodbye + hello + world

     output: “good5\,bye,hello,world”

     output: “7,goodbye5,hello5,world”

     output: “9,good5,bye5,hello5,world”

     output : “7goodbye66”

     */

}
