package leetCode;

//        Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
//        The returned integer should be non-negative as well.
//
//        You must not use any built-in exponent function or operator.
//
//        For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

public class SqrtOfX69 {
    public int mySqrt(int x) {
        int low = 1 ;
        int high = x;
        int answear = 0;

        while(low <= high){
            int mid = low + (high - low)/2;

            if(x/mid == mid){
                return mid;
            } else if (x/mid < mid){
                high = mid - 1;
            } else {
                low = mid + 1;
                answear = mid;
            }
        }
        return answear;
    }
}
