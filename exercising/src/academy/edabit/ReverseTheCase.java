package academy.edabit;

//Given a string, create a function to reverse the case. All lower-cased letters should be upper-cased, and vice versa.
//
//        Examples
//        reverseCase("Happy Birthday") ➞ "hAPPY bIRTHDAY"
//
//        reverseCase("MANY THANKS") ➞ "many thanks"
//
//        reverseCase("sPoNtAnEoUs") ➞ "SpOnTaNeOuS"

public class ReverseTheCase {

    public static String reverseCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (Character.isLowerCase(ch)) {
                str = str.substring(0, i) + Character.toUpperCase(ch) + str.substring(i + 1);
            } else {
                str = str.substring(0, i) + Character.toLowerCase(ch) + str.substring(i + 1);
            }
        }
        return str;
    }
}
