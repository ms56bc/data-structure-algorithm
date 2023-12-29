package org.recursion;

public class MatchingBrackets {
    char LEFT = '(';
    char RIGHT = ')';
    public static void main(String[] args) {
        MatchingBrackets mb = new MatchingBrackets();
        //mb.permuteAll("(())");
        mb.matchingBrackets(1, 1, null);
    }

    private void permuteAll(String input){
            _permuteAll(input, null, 0, 0);

    }

    private void matchingBrackets(int left, int right, String output){
        if (left == 0 && right == 0) {
            System.out.println(output);
            return;
        }
        if(left >=0) matchingBrackets(left -1, right, output == null ? String.valueOf(LEFT): output + LEFT);
        if(left <= right - 1)matchingBrackets(left, right -1, output == null ? String.valueOf(RIGHT): output + RIGHT);
    }

    private void _permuteAll(String input, String output, int cLeft, int cRight) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int nCleft = cLeft;
            int nCRight = cRight;
            if (c == '(') nCleft++;
            else nCRight++;
            if (nCleft >= nCRight) {
                String o = output == null ? String.valueOf(c) : output + c;
                _permuteAll(input.substring(0, i) + input.substring(i + 1), o, nCleft, nCRight);
            }
        }
    }
}
