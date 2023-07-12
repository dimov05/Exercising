package academy.codingBat;
//Look for patterns like "zip" and "zap" in the string -- length-3, starting with 'z' and ending with 'p'. Return a string where for all such words, the middle letter is gone, so "zipXzap" yields "zpXzp".
//
//
//        zipZap("zipXzap") → "zpXzp"
//        zipZap("zopzop") → "zpzp"
//        zipZap("zzzopzop") → "zzzpzp"

public class ZipZap {
    public String zipZap(String str) {
        StringBuilder sb = new StringBuilder();
        if (str.length() < 3) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'z' && str.charAt(i + 2) == 'p') {
                sb.append("zp");
                i += 2;
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

}
