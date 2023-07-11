package leetCode;

//A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
//
//        You are given an array of strings sentences, where each sentences[i] represents a single sentence.
//
//        Return the maximum number of words that appear in a single sentence.


public class MaximumNumberOfWordsFoundInSentences2114 {
    public int mostWordsFound(String[] sentences) {
        int maxCount = 0;
        int spacesCount = 1;
        for(int i = 0; i < sentences.length;i++){
            for(int j = 0;j < sentences[i].length();j++){
                if (sentences[i].charAt(j) == ' '){
                    spacesCount++;
                }
            }
            if(spacesCount > maxCount){
                maxCount = spacesCount;
            }
            spacesCount = 1;
        }
        return maxCount;
    }
}
