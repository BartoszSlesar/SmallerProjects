package pl.challenges.series;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeriesTest {

    @Test
    public void nSumShouldAddNNumbersTogether(){
        //given
        int n = 10;
        //when
        int result = Series.nSum(10);
        //then
        assertEquals(result,55);
    }
}
