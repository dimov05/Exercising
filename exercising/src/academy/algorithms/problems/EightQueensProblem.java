package academy.algorithms.problems;

import java.util.Arrays;

public class EightQueensProblem {
    private static final int GRID_SIZE = 8;

    public static void main(String[] args) {
        int[][] chessBoard = {
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}};
        long startTime = System.currentTimeMillis();
        if (placeQueens(chessBoard, 0)) {
            long endTime = System.currentTimeMillis();
            System.out.println("Successfully placed queens");
            System.out.println("It took: " + (endTime - startTime) + "ms");
            printChessBoard(chessBoard);
        } else {
            System.out.println("Mission failed");
        }
    }

    private static boolean placeQueens(int[][] chessBoard, int countOfQueens) {
        if (countOfQueens == 8) {
            return true;
        }
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (isValidPlacement(chessBoard, row, col)) {
                    chessBoard[row][col] = 1;
                    countOfQueens++;

                    if (placeQueens(chessBoard, countOfQueens)) {
                        return true;
                    } else {
                        chessBoard[row][col] = 0;
                        countOfQueens--;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isValidPlacement(int[][] chessBoard, int row, int col) {
        return !isQueenInRow(chessBoard, row)
                && !isQueenInColumn(chessBoard, col)
                && !isQueenInDiagonals(chessBoard, row, col);
    }

    private static void printChessBoard(int[][] chessBoard) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                System.out.print(chessBoard[row][col] + " ");
            }
            System.out.println();
        }
    }


    private static boolean isQueenInRow(int[][] chessBoard, int row) {
        for (int col = 0; col < GRID_SIZE; col++) {
            if (chessBoard[row][col] == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean isQueenInColumn(int[][] chessBoard, int column) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (chessBoard[row][column] == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean isQueenInDiagonals(int[][] chessBoard, int row, int column) {
        return isQueenInFirstDiagonal(chessBoard, row, column) || isQueenInSecondDiagonal(chessBoard, row, column);
    }

    private static boolean isQueenInSecondDiagonal(int[][] chessBoard, int row, int column) {
        while (row > 0 && column < GRID_SIZE - 1) {
            row--;
            column++;
        }
        while (row < GRID_SIZE && column >= 0) {
            if (chessBoard[row][column] == 1) {
                return true;
            }
            row++;
            column--;
        }
        return false;
    }

    private static boolean isQueenInFirstDiagonal(int[][] chessBoard, int row, int column) {
        while (row > 0 && column > 0) {
            row--;
            column--;
        }
        while (row < GRID_SIZE && column < GRID_SIZE) {
            if (chessBoard[row][column] == 1) {
                return true;
            }
            row++;
            column++;
        }
        return false;
    }

}
