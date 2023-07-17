package academy.algorithms.problems;

//A "magic square" is a square divided into smaller squares each containing a number, such that the numbers in each vertical, horizontal, and diagonal row add up to the same value.
//        3x3 Magic Square
//        Write a function that takes a 2D array, checks if it's a magic square and returns either true or false depending on the result.
//
//        Examples
//        isMagicSquare([
//        [8, 1, 6],
//        [3, 5, 7],
//        [4, 9, 2]
//        ]) ➞ true
//
//        isMagicSquare([
//        [16,  3,  2, 13],
//        [ 5, 10, 11,  8],
//        [ 9,  6,  7, 12],
//        [ 4, 15, 14,  1]
//        ]) ➞ true
//
//        isMagicSquare([
//        [1, 2, 3],
//        [4, 5, 6],
//        [7, 8, 9]
//        ]) ➞ false
//        Notes
//        Check diagonals as well.
//        Test input will always be square.
//        Check the Resources tab for additional info on magic squares.
public class IsMagicSquare {
    public static void main(String[] args) {
        int[][] square = new int[][]{
                {16, 3, 2, 13},
                {5, 10, 11, 8},
                {9, 6, 7, 12},
                {4, 15, 14, 1}};
        System.out.println(isTheSquareMagic(square));


    }

    private static boolean isTheSquareMagic(int[][] square) {
        int sum = calculateSum(square);
        return rowsAreMagic(square, sum) && columnsAreMagic(square, sum) && diagonalsAreMagic(square, sum);

    }

    private static boolean diagonalsAreMagic(int[][] square, int sum) {
        return firstDiagonalIsMagic(square, sum) && secondDiagonalIsMagic(square, sum);
    }

    private static boolean secondDiagonalIsMagic(int[][] square, int sum) {
        int sumOfDiagonal = 0;
        for (int i = square.length - 1, j = 0; i >= 0; i--, j++) {
            sumOfDiagonal += square[i][j];
        }
        return sumOfDiagonal == sum;
    }

    private static boolean firstDiagonalIsMagic(int[][] square, int sum) {
        int sumOfDiagonal = 0;
        for (int i = 0, j = 0; i < square.length; i++, j++) {
            sumOfDiagonal += square[i][j];
        }
        return sumOfDiagonal == sum;
    }

    private static boolean columnsAreMagic(int[][] square, int sum) {
        for (int col = 0; col < square.length; col++) {
            int currentColSum = 0;
            for (int row = 0; row < square.length; row++) {
                currentColSum += square[row][col];
            }
            if (currentColSum != sum) {
                return false;
            }
        }
        return true;
    }

    private static boolean rowsAreMagic(int[][] square, int sum) {
        for (int row = 0; row < square.length; row++) {
            int currentRowSum = 0;
            for (int col = 0; col < square[row].length; col++) {
                currentRowSum += square[row][col];
            }
            if (currentRowSum != sum) {
                return false;
            }
        }
        return true;
    }

    private static int calculateSum(int[][] square) {
        int sum = 0;
        for (int column = 0; column < square.length; column++) {
            sum += square[0][column];
        }
        return sum;
    }
}
