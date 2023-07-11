package academy.edabit;

//Transcribe the given DNA strand into corresponding mRNA - a type of RNA, that will be formed from DNA after transcription. DNA has the bases A, T, G and C, while RNA converts to U, A, C and G respectively.
//
//        Examples
//        dnaToRna("ATTAGCGCGATATACGCGTAC") ➞ "UAAUCGCGCUAUAUGCGCAUG"
//
//        dnaToRna("CGATATA") ➞ "GCUAUAU"
//
//        dnaToRna("GTCATACGACGTA") ➞ "CAGUAUGCUGCAU"

public class TranscribeTomRNA {
    public static String dnaToRna(String strand) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strand.length();i++){
            char ch = strand.charAt(i);
            if (ch == 'A'){
                sb.append("U");
            } else if (ch == 'T'){
                sb.append("A");
            } else if (ch == 'G'){
                sb.append("C");
            } else if (ch == 'C'){
                sb.append("G");
            }
        }
        return sb.toString();
    }
}
