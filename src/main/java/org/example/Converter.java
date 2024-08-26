package org.example;

/*
  @author   Oleh
  @project   RomanToArabicConverterTesting
  @class  Converter
  @version  1.0.0 
  @since 26.08.2024 - 20.44
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Converter {

    public static int romanToInt(String s) {

        if (s == null) {
            throw new IllegalArgumentException("Input is null");
        }

        if (!isValidRomanNumeral(s)) {
            throw new IllegalArgumentException("Invalid Roman numeral");
        }

        if (s.isEmpty()) {
            return 0;
        }

        int result = 0;

        String[] romanNumerals = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] arabicValues = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

        char[] romanNumbers = s.toCharArray();

        for (int i = 0; i < romanNumerals.length; i++) {
            if (Character.toString(romanNumbers[romanNumbers.length - 1]).equals(romanNumerals[i])) {
                result += arabicValues[i];
            }
        }

        for (int i = romanNumbers.length - 1; i >= 1; i--) {
            int numeralIndex = 0;
            int nextNumeralIndex = 0;

            for (int j = 0; j < romanNumerals.length; j++) {
                if (Character.toString(romanNumbers[i]).equals(romanNumerals[j])) {
                    numeralIndex = j;
                }

                if (Character.toString(romanNumbers[i - 1]).equals(romanNumerals[j])) {
                    nextNumeralIndex = j;
                }
            }

            if (arabicValues[numeralIndex] > arabicValues[nextNumeralIndex]) {
                result -= arabicValues[nextNumeralIndex];
            } else {
                result += arabicValues[nextNumeralIndex];
            }
        }
        return result;
    }

    public static boolean isValidRomanNumeral(String s) {
        String regex = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
