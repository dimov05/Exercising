package academy.leetCode;

//You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item. You are also given a rule represented by two strings, ruleKey and ruleValue.
//
//        The ith item is said to match the rule if one of the following is true:
//
//        ruleKey == "type" and ruleValue == typei.
//        ruleKey == "color" and ruleValue == colori.
//        ruleKey == "name" and ruleValue == namei.
//        Return the number of items that match the given rule.
// BEATS 100% memory complexity

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountItemsMatchingRule1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        Map<String,Integer> types = new HashMap<>();
        Map<String,Integer> colors = new HashMap<>();
        Map<String,Integer> names = new HashMap<>();
        for(List<String> item : items){
            String currType = item.get(0);
            String currColor = item.get(1);
            String currName = item.get(2);
            if(types.containsKey(currType)){
                types.put(currType, types.get(currType) + 1);
            } else {
                types.put(currType, 1);
            }
            if(colors.containsKey(currColor)){
                colors.put(currColor, colors.get(currColor) + 1);
            } else {
                colors.put(currColor, 1);
            }
            if(names.containsKey(currName)){
                names.put(currName, names.get(currName) + 1);
            } else {
                names.put(currName, 1);
            }
        }
        switch(ruleKey){
            case "color":
                if(colors.containsKey(ruleValue)){
                    count = colors.get(ruleValue);}
                break;
            case "type":
                if(types.containsKey(ruleValue)){
                    count = types.get(ruleValue);}
                break;
            case "name":
                if(names.containsKey(ruleValue)){
                    count = names.get(ruleValue);}
                break;
        }
        return count;
    }
}
