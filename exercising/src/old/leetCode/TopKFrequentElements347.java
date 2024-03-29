package old.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> counter.get(b) - counter.get(a));
        for (int num : counter.keySet()) {
            heap.offer(num);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}
