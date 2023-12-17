package org.example.recursion;

public class PrefixBinary {

    public static void main(String[] args) {
        PrefixBinary pb = new PrefixBinary();
        pb.calculate(0, 0, 4, null, 4);
    }

    private void calculate(int one, int zero, int len, String output, int max){
        if(one > max || zero > max) return;
        if(len == 0){
            System.out.println(output);
            return;
        }
        calculate(one +1, zero, len -1, output == null ? "1": output + "1", max);
        if(zero + 1 <= one)calculate(one, zero +1, len -1, output == null ? "0": output + "0", max);

    }
}
