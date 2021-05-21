package pl.challenges.series;

import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Cases for Series")
public class SeriesTest {

    @ParameterizedTest
    @MethodSource("provideNumbersAndExpectedResultNSum")
    public void nSumShouldReturnSumOfNNumbers(int n, long expected) {
        //given
        //when
        long result = Series.nSum(n);
        //then
        assertThat(result, equalTo(expected));
    }

    @Test
    @DisplayName("nSum is able to process n=1000000 in less then 5ms")
    public void nSumTimeDurationOnLargeNumbers() {
        //given
        //when
        //then
        assertTimeout(Duration.ofMillis(5), () -> Series.nSum(1000000));
    }

    @ParameterizedTest
    @MethodSource("provideNumbersAndExpectedResultfactorial")
    public void factorialShouldReturnCorrectResult(int n, long expected) {
        //given
        //when
        long result = Series.factorials(n);
        //then
        assertThat(result, equalTo(expected));
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 21, -433, 11223})
    public void factorialShouldReturnZeroForValuesLessThenZeroAndGreaterThen20(int n) {
        //given
        //when
        long result = Series.factorials(n);
        //then
        assertThat(result, equalTo(0L));
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForFibonacciMethod")
    public void fibonacciShouldReturnCorrectValue(int n, long expected) {
        //given
        //when
        long result = Series.fibonacci(n);
        //then
        assertThat(result, equalTo(expected));
    }

    @Test
    public void fibonacciShouldThrowIllegalArgumentExceptionForValuesLessThenZero() {
        //given
        int value = -1;
        //when
        assertThrows(IllegalArgumentException.class, () -> Series.fibonacci(value));
    }


    private static Stream<Arguments> provideNumbersAndExpectedResultfactorial() {
        return Stream.of(
                Arguments.of(5, 120),
                Arguments.of(10, 3628800),
                Arguments.of(15, 1307674368000L),
                Arguments.of(0, 1),
                Arguments.of(20, 2432902008176640000L),
                Arguments.of(11, 39916800)
        );
    }

    private static Stream<Arguments> provideNumbersAndExpectedResultNSum() {
        return Stream.of(
                Arguments.of(10, 55),
                Arguments.of(30, 465),
                Arguments.of(1000000, 500000500000L),
                Arguments.of(34, 595),
                Arguments.of(-412, 0),
                Arguments.of(-223, 0),
                Arguments.of(0, 0),
                Arguments.of(5, 15)
        );
    }

    private static Stream<Arguments> provideArgumentsForFibonacciMethod() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(4, 3),
                Arguments.of(7, 13),
                Arguments.of(8, 21),
                Arguments.of(15, 610)
        );
    }
}
