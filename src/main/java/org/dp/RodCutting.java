package org.dp;

public class RodCutting {
    public static void main(String[] args) {
        int [] price = {2, 5, 3, 5, 4};
        int maxLength = 5;
        System.out.println(maxPrice(price, 5, 4, 0));
    }
    private static long maxPrice(int [] price, int remLength, int index, int aggPrice){
        if(index < 0 || remLength ==0) return aggPrice;
        int currLength = index +1;
        int currPrice = price[index];
        if(currLength <= remLength){
            return Long.max(maxPrice(price, remLength, index -1, aggPrice), maxPrice(price, remLength - currLength, index, aggPrice + currPrice));
        } else {
            return maxPrice(price, remLength, index -1, aggPrice);
        }
    }
}
