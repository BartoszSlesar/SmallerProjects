package pl.challenges.series;

public class Series {

    //    this method will return sum of n values passed as argument
    public static long nSum(long n) {
        long result = 0;
        if (n > 0) {
            result = n * (n + 1) / 2;
        }
        return result;
    }
}
