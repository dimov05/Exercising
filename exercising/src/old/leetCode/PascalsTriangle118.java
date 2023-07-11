package old.leetCode;

// Given an integer numRows, return the first numRows of Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it.

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        if (numRows > 1) {
            List<Integer> second = new ArrayList<>();
            second.add(1);
            second.add(1);
            res.add(second);
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                int numToAdd = res.get(i - 1).get(j - 1) + res.get(i - 1).get(j);
                row.add(numToAdd);
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
