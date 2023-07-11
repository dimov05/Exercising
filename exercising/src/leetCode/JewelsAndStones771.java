package leetCode;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones771 {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0;i<jewels.length();i++){
            set.add(jewels.charAt(i));
        }
        for(int i = 0;i<stones.length();i++){
            if(set.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }
}
