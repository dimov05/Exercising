package academy.algorithms.problems;

//Consider the following operation on an arbitrary positive integer:
//
//        If n is even -> n / 2
//        If n is odd -> n * 3 + 1
//        Create a function to repeatedly evaluate these operations, until reaching 1. Return the number of steps it took.
//
//        See the following example, using 10 as the input, with 6 steps:
//
//        10 is even - 10 / 2 = 5
//        5 is odd - 5 * 3 + 1 = 16
//        16 is even - 16 / 2 = 8
//        8 is even - 8 / 2 = 4
//        4 is even - 4 / 2 = 2
//        2 is even - 2 / 2 = 1 -> Reached 1, so return 6
//        Examples
//        collatzConjecture(2) ➞ 1
//
//        collatzConjecture(3) ➞ 7
//
//        collatzConjecture(10) ➞ 6
public class TheCollatzConjecture {
    public static void main(String[] args) {
        int number = 1644321;
        System.out.println(collatzConjecture(number));
    }

    private static int collatzConjecture(int number) {
        int counter = 0;
        while (number != 1) {
            if (number % 2 == 0) {
                number /= 2;
            } else {
                number = number * 3 + 1;
            }
            counter++;
        }
        return counter;
    }
}
