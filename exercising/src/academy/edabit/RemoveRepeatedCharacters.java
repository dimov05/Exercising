package academy.edabit;

//Create a function that will remove any repeated character(s) in a word passed to the function. Not just consecutive characters, but characters repeating anywhere in the string.
//
//        Examples
//        unrepeated("teshahset") ➞ "tesha"
//
//        unrepeated("hello") ➞ "helo"
//
//        unrepeated("aaaaa") ➞ "a"
//
//        unrepeated("WWE!!!") ➞ "WE!"
//
//        unrepeated("call 911") ➞ "cal 91"
//        Notes
//        No more than two words will be passed.
//        Notice that a string is iterable.
public class RemoveRepeatedCharacters {
    public static String unrepeated(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i<str.length();i++){
            if(sb.indexOf(str.charAt(i) +"") == -1){
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
