package academy.algorithms.problems;

public class TheKnightsProblem {
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
        int knightsMoves = 1;
        long startTime = System.currentTimeMillis();
        if (moveKnights(chessBoard, knightsMoves, 0, 0)) {
            long endTime = System.currentTimeMillis();
            System.out.println("Successfully placed knights");
            System.out.println("It took: " + (endTime - startTime) + "ms");
            printChessBoard(chessBoard);
        } else {
            System.out.println("Mission failed");
        }
    }

    private static boolean moveKnights(int[][] chessBoard, int knightsMoves, int row, int col) {
        if (knightsMoves > 64) {
            return true;
        }
        if (knightsMoves == 63 || knightsMoves == 64) {
            System.out.println(knightsMoves);
        }
        if (isPlaceableAtThisPosition(chessBoard, row, col)) {
            chessBoard[row][col] = knightsMoves;
            knightsMoves++;
            if (moveKnights(chessBoard, knightsMoves, row + 2, col + 1) // down right
                    || moveKnights(chessBoard, knightsMoves, row + 1, col + 2) // right down
                    || moveKnights(chessBoard, knightsMoves, row - 1, col + 2) // right up
                    || moveKnights(chessBoard, knightsMoves, row - 2, col + 1) // up right
                    || moveKnights(chessBoard, knightsMoves, row - 2, col - 1) // up left
                    || moveKnights(chessBoard, knightsMoves, row - 1, col - 2) // left up
                    || moveKnights(chessBoard, knightsMoves, row + 1, col - 2) // left down
                    || moveKnights(chessBoard, knightsMoves, row + 2, col - 1)) // down left
            {
                return true;
            }
            chessBoard[row][col] = 0;
        }
        return false;
    }

    private static boolean isPlaceableAtThisPosition(int[][] chessBoard, int row, int col) {
        return row >= 0 && row < GRID_SIZE
                && col >= 0 && col < GRID_SIZE
                && chessBoard[row][col] == 0;
    }

    private static void printChessBoard(int[][] chessBoard) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                System.out.print(chessBoard[row][col] + " ");
            }
            System.out.println();
        }
    }
//    private static boolean isPlaceableRightUp(int[][] chessBoard, int row, int col) {
//        int placementRow = row - 1;
//        int placementCol = col + 2;
//        return placementRow >= 0 && placementRow < GRID_SIZE
//                && placementCol >= 0 && placementCol < GRID_SIZE
//                && chessBoard[placementRow][placementCol] == 0;
//    }
//
//    private static boolean isPlaceableRightDown(int[][] chessBoard, int row, int col) {
//        int placementRow = row + 1;
//        int placementCol = col + 2;
//        return placementRow >= 0 && placementRow < GRID_SIZE
//                && placementCol >= 0 && placementCol < GRID_SIZE
//                && chessBoard[placementRow][placementCol] == 0;
//    }
//
//    private static boolean isPlaceableDownRight(int[][] chessBoard, int row, int col) {
//        int placementRow = row + 2;
//        int placementCol = col + 1;
//        return placementRow >= 0 && placementRow < GRID_SIZE
//                && placementCol >= 0 && placementCol < GRID_SIZE
//                && chessBoard[placementRow][placementCol] == 0;
//    }
//
//    private static boolean isPlaceableDownLeft(int[][] chessBoard, int row, int col) {
//        int placementRow = row + 2;
//        int placementCol = col - 1;
//        return placementRow >= 0 && placementRow < GRID_SIZE
//                && placementCol >= 0 && placementCol < GRID_SIZE
//                && chessBoard[placementRow][placementCol] == 0;
//    }
//
//    private static boolean isPlaceableLeftDown(int[][] chessBoard, int row, int col) {
//        int placementRow = row + 1;
//        int placementCol = col - 2;
//        return placementRow >= 0 && placementRow < GRID_SIZE
//                && placementCol >= 0 && placementCol < GRID_SIZE
//                && chessBoard[placementRow][placementCol] == 0;
//    }
//
//    private static boolean isPlaceableLeftUp(int[][] chessBoard, int row, int col) {
//        int placementRow = row - 1;
//        int placementCol = col - 2;
//        return placementRow >= 0 && placementRow < GRID_SIZE
//                && placementCol >= 0 && placementCol < GRID_SIZE
//                && chessBoard[placementRow][placementCol] == 0;
//    }
//
//    private static boolean isPlaceableTopRight(int[][] chessBoard, int row, int col) {
//        int placementRow = row - 2;
//        int placementCol = col + 1;
//        return placementRow >= 0 && placementRow < GRID_SIZE
//                && placementCol >= 0 && placementCol < GRID_SIZE
//                && chessBoard[placementRow][placementCol] == 0;
//    }
//
//    private static boolean isPlaceableTopLeft(int[][] chessBoard, int row, int col) {
//        int placementRow = row - 2;
//        int placementCol = col - 1;
//        return placementRow >= 0 && placementRow < GRID_SIZE
//                && placementCol >= 0 && placementCol < GRID_SIZE
//                && chessBoard[placementRow][placementCol] == 0;
//    }
//
}
