package academy.algorithms.problems;
//In this challenge, a farmer is asking you to tell him how many legs can be counted among all his animals.
// The farmer breeds three species:
//
//        chickens = 2 legs
//        cows = 4 legs
//        pigs = 4 legs
//        The farmer has counted his animals and he gives you a subtotal for each species.
//        You have to implement a function that returns the total number of legs of all the animals.
//animals(5, 2, 8) ➞ 50
//        Notes
//        Don't forget to return the result.
//        The order of animals passed is animals(chickens, cows, pigs).
public class FarmProblem {
    public static void main(String[] args) {
        System.out.println(animals(5,2,8)); // 5 chickens, 2 cows, 8 pigs
    }

    private static int animals(int chickens, int cows, int pigs) {
        return chickens * 2 + cows * 4 + pigs * 4;
    }

}
