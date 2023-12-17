package org.example.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumber {
    static Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        PhoneNumber p = new PhoneNumber();
        p.letterCombinations("233", new StringBuilder());
        result.forEach(System.out::println);
    }

    public void letterCombinations(String digits, StringBuilder curr) {
        if (digits.isEmpty()) {
            result.add(curr.toString());
            return;
        }
        for(Character c : map.get(digits.charAt(0)).toCharArray()){
            curr.append(c);
            letterCombinations(digits.substring(1), curr);
            curr.deleteCharAt(curr.length() -1);
        }
    }
}
