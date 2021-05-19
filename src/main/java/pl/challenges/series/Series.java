package pl.challenges.series;

public class Series {

    //    this method will return sum of n values passed as argument
    public static int nSum(int n) {
        int result = 0;
        for (int i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }
}
