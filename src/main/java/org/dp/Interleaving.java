package org.dp;

public class Interleaving {
    public static void main(String[] args) {
        var i = new Interleaving();
        System.out.println(i.interleaveDfs("a", "bc", "abc"));
        System.out.println(i.interleaveDfs("a", "ac", "aacd"));
    }

    private boolean interleaveDfs(String s1, String s2, String s){
        if(s.isEmpty() && s1.isEmpty() && s2.isEmpty()) return true;
        if(s.isEmpty()) return false;
        var c = s.charAt(0);
        var res = false;
        if(!s1.isEmpty() && s1.charAt(0) == c) res = interleaveDfs(s1.substring(1), s2, s.substring(1));
        if(!s2.isEmpty() && s2.charAt(0) == c) res = res || interleaveDfs(s1, s2.substring(1), s.substring(1));
        return res;
    }
    private boolean interleaveDp(String s1, String s2, String s){
        return false;
    }
}
