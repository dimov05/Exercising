package academy.codingBat;


//We'll say that a String is xy-balanced if for all the 'x' chars in the string, there exists a 'y' char somewhere later in the string. So "xxy" is balanced, but "xyx" is not. One 'y' can balance multiple 'x's. Return true if the given string is xy-balanced.
//
//
//        xyBalance("aaxbby") → true
//        xyBalance("aaxbb") → false
//        xyBalance("yaaxbb") → false

public class xyBalance {
    public boolean xyBalance(String str) {
        int indexOfLastX = -1;
        for(int i = str.length()-1;i>=0;i--){
            if(str.charAt(i) == 'x'){
                indexOfLastX = i;
                break;
            }
        }
        if(indexOfLastX == -1){
            return true;
        }
        String sub = str.substring(indexOfLastX);

        return sub.contains("y");
    }
}
