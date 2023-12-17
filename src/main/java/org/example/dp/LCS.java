package org.example.dp;

public class LCS {
    public static void main(String[] args) {
        var lcs = new LCS();
        System.out.println(lcs.lcsDfs("abcde", "aceee"));
        System.out.println(lcs.lcsDfs("abc", "abc"));
        System.out.println(lcs.lcsDfs("abc", "def"));
    }

    private String lcsDfs(String a, String b){
        return lcsDfs(a, b, "");
    }

    private String lcsDfs(String a, String b, String curr){
        if(a.isEmpty() || b.isEmpty())  return curr;

        char c1 = a.charAt(0);
        char c2 = b.charAt(0);
        String ans = "";
        if(c1 == c2){
            var s = lcsDfs(a.substring(1), b.substring(1), curr + c1);
            if(!s.isEmpty()) ans = s;
        } else {
            var s1 = lcsDfs(a.substring(1), b, curr);
            var s2 = lcsDfs(a, b.substring(1), curr);
            if(!s1.isEmpty()) ans = s1;
            if(s2.length() > ans.length()) ans = s2;
        }
        return ans;
    }
}
