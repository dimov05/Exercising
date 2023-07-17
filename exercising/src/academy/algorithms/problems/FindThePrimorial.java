package academy.algorithms.problems;
//A Primorial is a product of the first n prime numbers (e.g. 2 x 3 x 5 = 30). 2, 3, 5, 7, 11, 13 are prime numbers. If n was 3, you'd multiply 2 x 3 x 5 = 30 or Primorial = 30.
//
//        Create a function that returns the Primorial of a number.
//
//        Examples
//        primorial(1) ➞ 2
//
//        primorial(2) ➞ 6
//
//        primorial(8) ➞ 9699690

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FindThePrimorial {
    public static void main(String[] args) {
        int number = 8;
        System.out.println(primorial(number));
    }

    private static Integer primorial(int number) {
        int countOfFoundPrimeNumbers = 0;
        List<Integer> primeNumbers = new ArrayList<>();
        int currentNumber = 2;
        while (countOfFoundPrimeNumbers < number) {
            if (isPrime(currentNumber)) {
                primeNumbers.add(currentNumber);
                countOfFoundPrimeNumbers++;
            }
            currentNumber++;
        }
        return primeNumbers.stream().mapToInt(n -> n).reduce(1, Math::multiplyExact);
    }

    private static boolean isPrime(int number) {
        if (number < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

}
