package com.example.testlabs.lab1;

import com.example.testlabs.service.lab1.DefaultCalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class DefaultCalculatorServiceTest {

    public static DefaultCalculatorService CALCULATOR = new DefaultCalculatorService();

    @ParameterizedTest(name = "{index} => numberOne={0}, numberTwo={1}, expectedResult={2}")
    @CsvSource({"1, 1, 2", "2, 3, 5", "1, -2, -1", "-3, -4, -7"})
     void add(int numberOne, int numberTwo, int expectedResult) {
        int result = CALCULATOR.add(numberOne, numberTwo);
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "{index} => numberOne={0}, numberTwo={1}, expectedResult={2}")
    @CsvSource({"5, 1, 4", "2, 3, -1", "1, -2, 3", "-3, -4, 1"})
    void minus(int numberOne, int numberTwo, int expectedResult) {
        int result = CALCULATOR.minus(numberOne, numberTwo);
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "{index} => numberOne={0}, numberTwo={1}, expectedResult={2}")
    @CsvSource({"5, 1, 5", "2, -3, -6", "1, 0, 0", "-3, -4, 12"})
    void multiply(int numberOne, int numberTwo, int expectedResult) {
        int result = CALCULATOR.multiply(numberOne, numberTwo);
        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "{index} => numberOne={0}, numberTwo={1}, expectedResult={2}")
    @CsvSource({"0, 5, 0", "-10, -3, 3", "12, 4, 3", "-6, -2, 3"})
    void division(int numberOne, int numberTwo, int expectedResult) {
        int result = CALCULATOR.division(numberOne, numberTwo);
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void division_ByZero_ReturnsException() {
        assertThrows(ArithmeticException.class, () -> CALCULATOR.division(1,0));
    }
}
