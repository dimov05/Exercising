package academy.algorithms;

public class Fibonacci {
    private static long[] fibCache;

    public static void main(String[] args) {
        int testNumber = 51;
        fibCache = new long[testNumber + 1];
        fibCache[0] = 0;
        fibCache[1] = 1;
        System.out.println(fibonacci(testNumber));
    }

    private static long fibonacci(int num) {
        if(num <= 1){
            return fibCache[num];
        }
        if (fibCache[num] != 0) {
            return fibCache[num];
        }
        long nthFibNum = (fibonacci(num - 1) + fibonacci(num - 2));
        fibCache[num] = nthFibNum;
        return nthFibNum;
    }
}
