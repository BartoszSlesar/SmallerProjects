package pl.challenges.series;

import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@DisplayName("Test Cases for Series")
public class SeriesTest {

    @ParameterizedTest
    @MethodSource("provideNumbersAndExpectedResult")
    public void nSumShouldReturnSumOfNNumbers(long n, long expected) {
        //given
        //when
        long result = Series.nSum(n);
        //then
        assertThat(result, equalTo(expected));
    }

    @Test
    @DisplayName("nSum is able to process n=1000000 in less then 5ms")
    public void nSumTimeDurationTestOnLargeNumbers() {
        //given
        //when
        //then
        assertTimeout(Duration.ofMillis(5), () -> Series.nSum(1000000));
    }

    private static Stream<Arguments> provideNumbersAndExpectedResult() {
        return Stream.of(
                Arguments.of(10, 55),
                Arguments.of(30, 465),
                Arguments.of(1000000, 500000500000L),
                Arguments.of(34, 595),
                Arguments.of(5, 15)
        );
    }
}
