package algolab.warmup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("car", "rat"));
        System.out.println(isAnagram("ac", "bb"));
        System.out.println(isAnagram("aacc", "ccac"));
        System.out.println();
        System.out.println(isAnagramOptimized("anagram", "nagaram"));
        System.out.println(isAnagramOptimized("car", "rat"));
        System.out.println(isAnagramOptimized("ac", "bb"));
        System.out.println(isAnagramOptimized("aacc", "ccac"));
        System.out.println();
        System.out.println(isAnagramSolution2("anagram", "nagaram"));
        System.out.println(isAnagramSolution2("car", "rat"));
        System.out.println(isAnagramSolution2("ac", "bb"));
        System.out.println(isAnagramSolution2("aacc", "ccac"));

    }


    /**
     * This Solution iterates on every single character of strings
     * and add the character -> sum of the identical characters to its corresponding Map object
     * (e.g. In ASCII a -> 97 so if a is 2 times in string then in map it will be.  a -> 194)
     *  Then iterate on one Map. Take key and get the value from the 2nd Map object.
     *  Check if both values are equal. If Not return false otherwise return true.
     *
     *  Time Complexity: In Simple Terms  O(n) where n is the number of characters in String. As both strings are exactly equal in length
     *  Calculation: O(n) + O(n) = O(2n) = O(n) : As we ignore constants in BigO
     *
     *  Space Complexity: O(n) + O(n) = O(2n) = O(n)
     *  Whatever is the length of both Strings we will need 2 Map Objects of same length of Strings.
     * */

    public static boolean isAnagram(String s, String t) {

        if(s.length() == 1 && t.length() == 1 && s.equals(t)){
            return true;
        }

        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> sCharByCount = new HashMap<>();
        Map<Character, Integer> tCharByCount = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(sCharByCount.containsKey(s.charAt(i))){
                sCharByCount.put(s.charAt(i), sCharByCount.get(s.charAt(i)) + s.charAt(i));
            }else{
                sCharByCount.put(s.charAt(i), (int) s.charAt(i));
            }

            if(tCharByCount.containsKey(t.charAt(i))){
                tCharByCount.put(t.charAt(i), tCharByCount.get(t.charAt(i)) + t.charAt(i));
            }else{
                tCharByCount.put(t.charAt(i), (int) t.charAt(i));
            }
        }


        boolean anagram = false;
        for(Map.Entry<Character, Integer> entry: tCharByCount.entrySet()){
            Integer value = sCharByCount.get(entry.getKey());
            if(value == null || !value.equals(entry.getValue())){
                anagram = false;
                break;
            }else {
                anagram = true;
            }
        }
        return anagram;
    }


    /**
     * This Solution first converts the Strings to Char Arrays.
     * Then Sort the arrays. And Again the arrays are converted to Strings.
     * Then we check if both are equal. If not return false otherwise return true.
     *
     *  Time Complexity: In Simple Terms O(n log n)
     *  Converting to Char Array = O(n)
     *  Sorting Array = O(n log n) (According to the official documentation.
     *  Arrays,sort using Quicksort for primitives and MergeSort for Objects and for both Time Complexity is O(n log n))
     *
     *  So Big O Of this solution = O(n) + O(n log n) = O(2n log n)  = O(n log n) : As we ignore constants
     *
     *  Space Complexity: O(n) + O(n) = O(2n) = O(n)
     *  Whatever is the length of both Strings we will need 2 Char Arrays of same length of Strings.
     * */
    public static boolean isAnagramSolution2(String s, String t) {

        if(s.length() == 1 && t.length() == 1 && s.equals(t)){
            return true;
        }

        if(s.length() != t.length()){
            return false;
        }
        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        String sortedS = new String(sChars);

        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);
        String sortedT = new String(tChars);

        return sortedT.equals(sortedS);
    }


    /**
     *  This solution first creates an array of int of length 26 (26 alphabets)
     *  Then iterate through the first string. increment the index of the character in th array
     *  e.g. lets take "ac", "bb" and check if both are anagram
     *  first loop: char at index 0 = a  a-a = 0  so index 0 in array will be incremented by 1.
     *  Then char at index 1 = c-a = 2 (99 - 97) so index 2 in array will be incremented by 1.
     *
     *  Now 2nd loop: b - a = 1 (98-97) so index 1 in array will be decremented by 1 which will result in -1.
     *  So we check if the result is -1 it means that the string are not anagram.
     *  As if both are anagrams then only those index will be decremented which were incremented by previous iteration
     *
     *
     *  Time Complexity: O (n) + O(n) = O (2n) =O(n)
     *  Space Complexity: O(1) : As an array of size 26 is created no matter what is the size of the strings.
     *
     * */
    public static boolean isAnagramOptimized(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}
