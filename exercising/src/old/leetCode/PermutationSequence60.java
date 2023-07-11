package old.leetCode;

import java.util.ArrayList;

public class PermutationSequence60 {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> array = new ArrayList<>();
        int fact = 1;
        for(int i  = 1;i<n; i++){
            array.add(i);
            fact *= i;
        }
        k = k - 1;
        StringBuilder s = new StringBuilder();
        array.add(n);
        while(true){
            s.append(array.get(k/fact).toString());
            if(array.size() == 0){
                break;
            }
            k = k % fact;
            fact = fact / array.size();
        }
        return s.toString();
    }
}
