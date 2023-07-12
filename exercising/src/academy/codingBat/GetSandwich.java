package academy.codingBat;

public class GetSandwich {
    public String getSandwich(String str) {
        if (!str.matches(".*bread.*bread.*")) {
            return "";
        } else {
            int start = 0;
            int end = 0;
            boolean found = false;
            for (int i = 0; i < str.length() - 4; i++) {
                String sub = str.substring(i, i + 5);
                if (sub.equals("bread") && found) {
                    end = i;
                }
                if (sub.equals("bread") && !found) {
                    start = i + 5;
                    found = true;
                }
            }
            return str.substring(start, end);
        }
    }
}
