package academy.codingBat;

//Given a string, does "xyz" appear in the middle of the string? To define middle, we'll say that the number of chars to the left and right of the "xyz" must differ by at most one. This problem is harder than it looks.
//
//
//        xyzMiddle("AAxyzBB") → true
//        xyzMiddle("AxyzBB") → true
//        xyzMiddle("AxyzBBB") → false

public class xyzMiddle {
    public boolean xyzMiddle(String str) {
        int startIndex = 0;
        int endIndex = str.length() - 1;
        int countBefore = -2; // to skip case of Math.abs(0 - 0) <= 1;
        int countAfter = 0;

        if (!str.contains("xyz")) {
            return false;
        }
        for (int i = str.length() / 2 - 2; i < str.length() / 2 + 1; i++) {
            if (str.startsWith("xyz", i)) {
                startIndex = i;
                endIndex = i + 2;
                countBefore = i;
                countAfter = str.length() - endIndex - 1;
                break;
            }
        }
        return Math.abs(countBefore - countAfter) <= 1;

    }
}

