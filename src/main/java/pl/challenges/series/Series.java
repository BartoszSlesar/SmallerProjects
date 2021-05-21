package pl.challenges.series;

import net.bytebuddy.implementation.bytecode.Throw;

public class Series {

    //    this method will return sum of n values passed as argument
    public static long nSum(long n) {
        long result = 0;
        if (n > 0) {
            result = n * (n + 1) / 2;
        }
        return result;
    }

    public static long factorials(long n) {
        if (n < 0 || n > 20) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return n * factorials(n - 1);
    }

    public static long fibonacci(long n) {
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
