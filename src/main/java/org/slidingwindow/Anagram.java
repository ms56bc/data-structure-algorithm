package org.slidingwindow;

import java.util.*;

/***
 * aabaabaa
 * aaba a = 3, b = 1
 *
 */
public class Anagram {
    Map<Character, Integer> anaFreq;
    int distinctCount = 0;

    public static void main(String[] args) {
        String s = "aabaabaa";
        Anagram anagram = new Anagram();
        List<String> l = anagram.findAnagrams(s, "aaba");
        l.forEach(System.out::println);
    }
    public List<String> findAnagrams(String input, String a) {
        anaFreq = new HashMap<>();
        for (char c : a.toCharArray()) {
            anaFreq.put(c, anaFreq.getOrDefault(c, 0) + 1);
        }
        distinctCount = anaFreq.keySet().size();
        List<String> ans = new LinkedList<>();

        for (int i = 0, j = 0; j < input.length(); j++) {
            adjustFreq(input.charAt(j), input.charAt(i));
            if (j - i + 1 == a.length()) {
                if (distinctCount ==0) ans.add(input.substring(i, j + 1));
                i++;
            }
        }
        return ans;
    }
    private void adjustFreq(char in, char out) {
        Integer outFreq = anaFreq.get(out);
        if (outFreq != null && outFreq > 0) {
            outFreq--;
            if(outFreq == 0) distinctCount--;
            anaFreq.put(out, outFreq);
        }
        Integer inFreq = anaFreq.get(in);
        if (inFreq != null) {
            if (inFreq == 0) distinctCount++;
            anaFreq.put(in, inFreq + 1);
        }

    }
}
