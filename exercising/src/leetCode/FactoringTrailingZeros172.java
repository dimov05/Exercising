package leetCode;

//Given an integer n, return the number of trailing zeroes in n!.
//
//        Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
//
//
//
//        Example 1:
//
//        Input: n = 3
//        Output: 0
//        Explanation: 3! = 6, no trailing zero.
//        Example 2:
//
//        Input: n = 5
//        Output: 1
//        Explanation: 5! = 120, one trailing zero.

public class FactoringTrailingZeros172 {
    public int trailingZeroes(int n) {
        int counter = 0;
        while(n > 4){
            int res = n/5;
            n /= 5;
            counter += res;
        }
        return counter;
    }
}
