package org.recursion;

public class PermutationWithSpaces {
    public void addSpaces(String input , String output){
        if(input.isEmpty()) {
            System.out.println(output);
            return;
        }
        char c = input.charAt(0);
        addSpaces(input.substring(1), output + c);
        if(!output.isEmpty()) addSpaces(input.substring(1), output + ' '+c);
    }
    public void caseChange(String input , String output){
        if(input.isEmpty()) {
            System.out.println(output);
            return;
        }
        char c = input.charAt(0);

        caseChange(input.substring(1), output == null ? String.valueOf(c) : output + c);
        caseChange(input.substring(1), output == null ? String.valueOf(Character.toUpperCase(c)) : output + Character.toUpperCase(c));
    }

    public static void main(String[] args) {
        PermutationWithSpaces ps = new PermutationWithSpaces();
        //ps.addSpaces("abc", "");
        ps.caseChange("abc", null);
    }
}
