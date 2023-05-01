package Assignment_Utopias_coins;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Here are example that you can try out!
        //Disclaimer: it's only tested with these coins (Because of the requirements)
        //So I don't promise it will work with different coins.

        //list of coins
        ArrayList<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(7);
        coins.add(10);
        coins.add(22);

        //class
        MinimumNumberOfCoinsFinder min = new MinimumNumberOfCoinsFinder(coins);

        //try amount
        ArrayList<Integer> result = min.findMinimumNumberOfCoins(1000);
        System.out.println("coins used: " + result);

        int count = 0;
        for (int coin: result) {
            count+=coin;
        }

        System.out.println("Total amount: " + count);

    }
}