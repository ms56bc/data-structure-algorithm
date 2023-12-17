package org.blind75;

import java.util.HashMap;
import java.util.HashSet;

public class DecodingWays {
    public static void main(String[] args) {
        var s = new DecodingWays();
        var i = s.waysDp("12");
        System.out.println(i);
        i = s.waysDp("121"); //1, 21or 1,2,1 or,12,1
        System.out.println(i);
        i = s.waysDp("102"); //1, 21or 1,2,1 or,12,1
        System.out.println(i);

    }
    private int waysDp(String s){
        var dp = new HashMap<Integer, Integer>();
        var twoDigit = new HashSet<Character>();
        for(char c: "0123456".toCharArray()) {
            twoDigit.add(c);
        }
        dp.put(s.length(), 1);
        for(int i = s.length() -1; i >=0; i--){
            var c = s.charAt(i);
            if(c == '0') dp.put(i, 0);
            else dp.put(i, dp.getOrDefault(i+1, 0));

            if(i+1 < s.length() && (c == '1' || (c == '2' && twoDigit.contains(s.charAt(i+1))))){
                var v = dp.getOrDefault(i+2, 0) + dp.getOrDefault(i, 0);
                dp.put(i, v);
            }
        }
        return dp.getOrDefault(0,0);
    }
}
