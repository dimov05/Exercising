package leetCode;

//Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
//
//        For example:
//
//        A -> 1
//        B -> 2
//        C -> 3
//        ...
//        Z -> 26
//        AA -> 27
//        AB -> 28
//        ...

public class ExcelSheetColumnNumber171 {
    public int titleToNumber(String columnTitle) {
        int output = 0;
        int counter = 0;
        for(int i = columnTitle.length()-1; i >= 0;i--){
            char c = columnTitle.charAt(i);
            int num = c;
            num -= 64;
            output += num * Math.pow(26,counter);
            counter++;
        }
        return output;
    }
}
