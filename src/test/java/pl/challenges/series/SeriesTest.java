package pl.challenges.series;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class SeriesTest {

    @Test
    public void nSumShouldReturnSumOfNNumbers() {
        //given
        int n = 10;
        //when
        int result = Series.nSum(10);
        //then
        assertThat(result, equalTo(55));
    }

    @Test
    public void nSumTimeDurationTestOnLargeNumbers() {
        //given
        //when
        //then
        assertTimeout(Duration.ofMillis(5), () -> Series.nSum(1000000));
    }
}
