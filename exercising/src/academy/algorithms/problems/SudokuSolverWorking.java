package academy.algorithms.problems;

public class SudokuSolverWorking {
    private static final int GRID_SIZE = 9;


    public static void main(String[] args) {
        int[][] board = {
                {7, 0, 0, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 0, 0, 0, 0, 7, 0, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}};
        if (solveBoard(board)) {
            System.out.println("The sudoku is solved");
            printBoard(board);
        } else {
            System.out.println("Couldn't solve sudoku board :(");
        }

    }
    private static void printBoard(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean solveBoard(int[][] board) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int value = 1; value <= GRID_SIZE; value++) {
                        if (isValidPlacement(board, value, row, col)) {
                            board[row][col] = value;

                            if (solveBoard(board)) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isNumberInRow(int[][] board, int number, int row) {
        for (int column = 0; column < GRID_SIZE; column++) {
            if (board[row][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(int[][] board, int number, int column) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (board[row][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(int[][] board, int number, int row, int column) {
        int boxRowStart = row < 3 ? 0 : row / 3 * 3;
        int boxRowEnd = boxRowStart + 2;
        int boxColStart = column < 3 ? 0 : column / 3 * 3;
        int boxColEnd = boxColStart + 2;
        for (int currRow = boxRowStart; currRow <= boxRowEnd; currRow++) {
            for (int currCol = boxColStart; currCol <= boxColEnd; currCol++) {
                if (board[currRow][currCol] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] board, int number, int row, int column) {
        return !isNumberInRow(board, number, row)
                && !isNumberInColumn(board, number, column)
                && !isNumberInBox(board, number, row, column);
    }
}
