package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
  @author   Oleh
  @project   RomanToArabicConverterTesting
  @class  ConverterTest
  @version  1.0.0 
  @since 26.08.2024 - 20.51
*/

class ConverterTest {

    @Test
    public void whenInputIsNull_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Converter.romanToInt(null));
    }

    @Test
    public void whenInputIsCyrillic_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Converter.romanToInt("ІІІ"));
    }

    @Test
    public void whenInputIsCyrillic1_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Converter.romanToInt("Привіт"));
    }

    @Test
    public void whenInputIsInteger_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Converter.romanToInt("123"));
    }

    @Test
    public void whenInputIsSomeLetters_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Converter.romanToInt("hello"));
    }

    @Test
    public void whenInputIsWrongRoman_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> Converter.romanToInt("IIVII"));
    }

    @Test
    public void whenInputIsEmpty_thenReturnZero() {
        assertEquals(0, Converter.romanToInt(""));
    }

    @Test
    public void whenInputIsIV_thenReturn4() {
        assertEquals(4, Converter.romanToInt("IV"));
    }

    @Test
    public void whenInputIsX_thenReturn10() {
        assertEquals(10, Converter.romanToInt("X"));
    }

    @Test
    public void whenInputIsC_thenReturn100() {
        assertEquals(100, Converter.romanToInt("C"));
    }

    @Test
    public void whenInputIsM_thenReturn1000() {
        assertEquals(1000, Converter.romanToInt("M"));
    }

    @Test
    public void whenInputIsValidMCMLXXXVII_thenReturnCorrectValue() {
        assertEquals(1987, Converter.romanToInt("MCMLXXXVII"));
    }
}