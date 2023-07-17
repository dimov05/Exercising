//package academy.algorithms.problems;
//
//import java.util.*;
//
//public class SudokuSolver {
//    public static void main(String[] args) {
//        int counterOfValuesToAdd = 0;
//        int[][] board = {
//                {7, 0, 2, 0, 5, 0, 6, 0, 0},
//                {0, 0, 0, 0, 0, 3, 0, 0, 0},
//                {1, 0, 0, 0, 0, 9, 5, 0, 0},
//                {8, 0, 0, 0, 0, 0, 0, 9, 0},
//                {0, 4, 3, 0, 0, 0, 7, 5, 0},
//                {0, 9, 0, 0, 0, 0, 0, 0, 8},
//                {0, 0, 9, 7, 0, 0, 0, 0, 5},
//                {0, 0, 0, 2, 0, 0, 0, 0, 0},
//                {0, 0, 7, 0, 4, 0, 2, 0, 3}};
//        Map<int[], List<Integer>> possibleValues = new HashMap<>();
//        // Fill map with possible values for every cell.
//        for (int row = 0; row < 9; row++) {
//            for (int col = 0; col < 9; col++) {
//                if (board[row][col] == 0) {
//                    counterOfValuesToAdd++;
//                    for (int value = 1; value <= 9; value++) {
//                        int[] currRowAndCol = new int[]{row, col};
//                        possibleValues.put(currRowAndCol, new ArrayList<>());
//                        if (isPossibleValue(board, row, col, value)) {
//                            possibleValues.get(currRowAndCol).add(value);
//                        }
//                    }
//                }
//            }
//        }
//        // Check if any cell has only one possible value and fill it. After every filled value, remove It from other cell where It was also a possible value.
//        while (counterOfValuesToAdd > 0) {
//            int tempCounter = counterOfValuesToAdd;
//            int row;
//            int col;
//            int valueToEnter;
////            for (Map.Entry<int[], List<Integer>> entry : possibleValues.entrySet()) {
////                if (entry.getValue().size() == 1) {
////                    row = entry.getKey()[0];
////                    col = entry.getKey()[1];
////                    valueToEnter = entry.getValue().get(0);
////                    board[row][col] = valueToEnter;
////                    removePossibleValues(possibleValues, row, col, valueToEnter); // removes the value from other cells - column,row and box
////                    possibleValues.remove(entry.getKey()); // remove this cell
////                    counterOfValuesToAdd--;
////                }
////            }
//            Iterator<Map.Entry<int[], List<Integer>>> iterator = new HashSet<>(possibleValues.entrySet()).iterator();
//            List<int[]> entriesToRemove = new ArrayList<>();
//
//            while (iterator.hasNext()) {
//                Map.Entry<int[], List<Integer>> entry = iterator.next();
//                if (entry.getValue().size() == 1) {
//                    row = entry.getKey()[0];
//                    col = entry.getKey()[1];
//                    valueToEnter = entry.getValue().get(0);
//                    board[row][col] = valueToEnter;
//                    removePossibleValues(possibleValues, row, col, valueToEnter);
//                    entriesToRemove.add(entry.getKey());
//                    counterOfValuesToAdd--;
//                }
//            }
//
//            for (int[] entryToRemove : entriesToRemove) {
//                possibleValues.remove(entryToRemove);
//            }
//
//
//            if (tempCounter == counterOfValuesToAdd) {
//                int minPossibleValues = Integer.MAX_VALUE;
//                int[] minPossibleValuesCell = null;
//
//                for (Map.Entry<int[], List<Integer>> entry : possibleValues.entrySet()) {
//                    if (entry.getValue().size() < minPossibleValues) {
//                        minPossibleValues = entry.getValue().size();
//                        minPossibleValuesCell = entry.getKey();
//                    }
//                }
//
//                if (minPossibleValuesCell != null) {
//                    row = minPossibleValuesCell[0];
//                    col = minPossibleValuesCell[1];
//                    List<Integer> values = possibleValues.get(minPossibleValuesCell);
//                    valueToEnter = values.get(0);
//                    board[row][col] = valueToEnter;
//                    removePossibleValues(possibleValues, row, col, valueToEnter);
//                    possibleValues.remove(minPossibleValuesCell); // remove this cell
//                    counterOfValuesToAdd--;
//                }
//            }
//        }
//        printBoard(board);
//
//
//    }
//
//    private static void printBoard(int[][] board) {
//        for (int row = 0; row < 9; row++) {
//            for (int col = 0; col < 9; col++) {
//                System.out.print(board[row][col] + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    private static void removePossibleValues(Map<int[], List<Integer>> possibleValues, int row, int col, int valueToRemove) {
//        int boxRowStart = row < 3 ? 0 : row / 3 * 3;
//        int boxRowEnd = boxRowStart + 2;
//        int boxColStart = col < 3 ? 0 : col / 3 * 3;
//        int boxColEnd = boxColStart + 2;
//
//        for (int currRow = 0; currRow < 9; currRow++) {
//            removeValueFromList(possibleValues, new int[]{currRow, col}, valueToRemove);
//        }
//
//        for (int currCol = 0; currCol < 9; currCol++) {
//            removeValueFromList(possibleValues, new int[]{row, currCol}, valueToRemove);
//        }
//
//        for (int currRow = boxRowStart; currRow <= boxRowEnd; currRow++) {
//            for (int currCol = boxColStart; currCol <= boxColEnd; currCol++) {
//                removeValueFromList(possibleValues, new int[]{currRow, currCol}, valueToRemove);
//            }
//        }
//    }
//
//    private static void removeValueFromList(Map<int[], List<Integer>> possibleValues, int[] cell, int valueToRemove) {
//        List<Integer> values = possibleValues.get(cell);
//        if (values != null) {
//            values.removeIf(value -> value == valueToRemove);
//            if ((values.isEmpty() || values.size() == 1)) {
//                possibleValues.remove(cell);
//            }
//        }
//    }
//
//    private static void removeValuesFromMap(Map<int[], List<Integer>> possibleValues, int valueToRemove, int currRow, int currCol) {
//        List<int[]> entriesToRemove = new ArrayList<>();
//        for (Map.Entry<int[], List<Integer>> entry : possibleValues.entrySet()) {
//            if (entry.getKey()[0] == currRow && entry.getKey()[1] == currCol) {
//                List<Integer> values = entry.getValue();
//                if (values.contains(valueToRemove)) {
//                    for (int index = 0; index < values.size(); index++) {
//                        if (values.get(index) == valueToRemove) {
//                            values.remove(index);
//                        }
//                    }
//                    if (values.size() == 0) {
//                        entriesToRemove.add(entry.getKey());
//                    }
//                }
//            }
//        }
////        for (int[] entryToRemove : entriesToRemove)
////        for (Map.Entry<int[], List<Integer>> entry : possibleValues.entrySet()) {
////            for (int[] entryToRemove : entriesToRemove) {
////                if (entry.getKey()[0] == entryToRemove[0] && entry.getKey()[1] == entryToRemove[1]) {
////                    possibleValues.remove(entry.getKey());
////                }
////            }
////        }
//        Iterator<Map.Entry<int[], List<Integer>>> iterator = possibleValues.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<int[], List<Integer>> entry = iterator.next();
//            int[] entryKey = entry.getKey();
//            for (int[] entryToRemove : entriesToRemove) {
//                if (entryKey[0] == entryToRemove[0] && entryKey[1] == entryToRemove[1]) {
//                    iterator.remove();
//                    break;
//                }
//            }
//        }
//    }
//
//
////    private static void removeValuesFromMap(Map<int[], List<Integer>> possibleValues, int valueToRemove, int currRow, int currCol) {
////        for (Map.Entry<int[], List<Integer>> entry : possibleValues.entrySet()) {
////            if (entry.getKey()[0] == currRow && entry.getKey()[1] == currCol) {
////                if (entry.getValue().contains(valueToRemove)) {
////                    entry.getValue().remove(valueToRemove);
////                    if (entry.getValue().size() == 0) {
////                        possibleValues.remove(entry.getKey());
////                    }
////                }
////            }
////        }
////    }
//
//    private static boolean isPossibleValue(int[][] board, int row, int col, int value) {
//        int boxRowStart = row < 3
//                ? 0
//                : row / 3 * 3;
//        int boxRowEnd = boxRowStart + 2;
//        int boxColStart = col < 3
//                ? 0
//                : col / 3 * 3;
//        int boxColEnd = boxColStart + 2;
//        // perform checks
//        if (checkRowForValue(board, row, value)) return false;
//        if (checkColForValue(board, col, value)) return false;
//        if (checkBoxForValue(board, value, boxRowStart, boxRowEnd, boxColStart, boxColEnd)) return false;
//        return true;
//    }
//
//    private static boolean checkBoxForValue(int[][] board, int value, int boxRowStart, int boxRowEnd,
//                                            int boxColStart, int boxColEnd) {
//        for (int currRow = boxRowStart; currRow <= boxRowEnd; currRow++) {
//            for (int currCol = boxColStart; currCol <= boxColEnd; currCol++) {
//                if (board[currRow][currCol] == value) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private static boolean checkColForValue(int[][] board, int col, int value) {
//        for (int currRow = 0; currRow < 9; currRow++) {
//            if (board[currRow][col] == value) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private static boolean checkRowForValue(int[][] board, int row, int value) {
//        for (int currCol = 0; currCol < 9; currCol++) {
//            if (board[row][currCol] == value) {
//                return true;
//            }
//        }
//        return false;
//    }
//}
