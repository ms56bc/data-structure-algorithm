package org.stack;

import java.util.Objects;
import java.util.Stack;

public class Match {
    static Stack<String> stk = new Stack<>();

    static String decodedString(String s) {
        // code here
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                StringBuilder digit = new StringBuilder();
                while (i >= 0 && Character.isDigit(s.charAt(i))) {
                    digit.append(s.charAt(i));
                    i--;
                }
                i++;
                process(Integer.parseInt(digit.reverse().toString()));
            } else {
                stk.push(String.valueOf(s.charAt(i)));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stk.isEmpty()) {
            result.append(stk.pop());
        }
        return result.toString();
    }

    static void process(int n) {
        StringBuilder curr = new StringBuilder();
        while (!stk.isEmpty() && !Objects.equals(stk.peek(), "]")) {
            String c = stk.pop();
            if (Objects.equals(c, "[")) continue;
            curr.append(c);
        }
        stk.pop();
        String d = times(curr.toString(), n);
        stk.push(d);
    }

    static String times(String s, int n) {
        System.out.println("the string is:" + s);
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(s);
            n--;
        }
        //System.out.println("the string is:" + sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodedString("1[b]1[b]1[b]1[b]"));
    }
}
        //abbbabbbabbb
//abbbab abbbab abbbab