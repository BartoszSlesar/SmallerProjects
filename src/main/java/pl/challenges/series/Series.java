package pl.challenges.series;


public class Series {

    //    this method will return sum of n values passed as argument
    public static long nSum(int n) {
        long result = 0;
        if (n > 0) {
            result = ((long) n * (n + 1)) / 2;
        }
        return result;
    }

    //    this method will factorial
    public static long factorials(int n) {
        if (n < 0 || n > 20) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return n * factorials(n - 1);
    }
    //    this method will n fibonacci number
    public static long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Please only provide positive numbers");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
