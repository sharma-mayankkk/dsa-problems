package STRIVERaTOz.GreedyAlgorithm.Easy;

//Each lemonade at a booth sells for $5. Consumers are lining up to place individual orders, following the billing order. Every consumer will purchase a single lemonade and may pay with a $5, $10, or $20 bill. Each customer must receive the appropriate change so that the net transaction is $5. Initially, there is no change available.
//
//Determine if it is possible to provide the correct change to every customer. Return true if the correct change can be given to every customer, and false otherwise.
//
//Given an integer array bills, where bills[i] is the bill the ith customer pays, return true if the correct change can be given to every customer, and false otherwise.
public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        int i = 0;
        while (i < bills.length) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five == 0) {
                    return false;
                }
                ten++;
                five--;
            } else if (bills[i]==20){
                if(ten!=0 && five!=0){
                    ten--;
                    five--;
                }else if (five>=3){
                    five-=3;
                }else{
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{15,5,5,10,20}));
    }
}
