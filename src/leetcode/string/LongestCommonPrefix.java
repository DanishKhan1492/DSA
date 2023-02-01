package leetcode.string;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arr = {"abca","aba","aaab"};
        //String[] arr = {"ab","a"};
        //String[] arr = {"flower","flow","flight"};
        //String[] arr = {"dog","racecar","car"};

        System.out.println(longestCommonPrefix(arr));
        System.out.println(longestCommonPrefixSolutionLeetCode(arr));
    }
    // "flower","flow","flight"
    // flo

    /** BIG O : O (M)  Total Comparisons = N * K (N = number of Strings, K = Number of Characters )
     *  M = Sum of All characters in All Strings
     *
     *  Time Complexity: O(1) : Using Constant Extra Space;
     * */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0].length() == 0 ? "" : strs[0];
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++){
            boolean matched = true;
            for(int j=1; j < strs.length; j++){
                if(i >  (strs[j].length() - 1) || strs[0].charAt(i) != strs[j].charAt(i)){
                    matched = false;
                    break;
                }
            }
            if(matched){
                result.append(strs[0].charAt(i));
            }else {
                break;
            }
        }
        return result.toString();
    }


    /** BIG O : O(S)
     *  n = Number of Strings
     *  k = Sum of characters in All Strings
     * */
    public static String longestCommonPrefixSolutionLeetCode(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

}
