package Assignment_Utopias_coins;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumNumberOfCoinsFinder {

    private HashMap<Integer, ArrayList<Integer>> hashMap;
    private ArrayList<Integer> coins;

    public MinimumNumberOfCoinsFinder(ArrayList<Integer> coins) {
        this.hashMap = new HashMap<>();
        this.coins = coins;

        //add all coins to hashMap
        ArrayList<Integer> temp;
        for (int coin : coins) {
            temp = new ArrayList<>();
            temp.add(coin);
            hashMap.put(coin, temp);
        }
    }

    public ArrayList<Integer> findMinimumNumberOfCoins(int amount){
        //Did we shoot over ?
        if (amount<=0){
            return null;
        }

        //Do we recognise this value ? (can be coins from constructor)
        ArrayList<Integer> doesItExist = hashMap.get(amount);
        if (doesItExist!=null) {
            return doesItExist;
        }

        //Try the different coins
        ArrayList<Integer> min = null;

        for (int coin : coins) {
            ArrayList<Integer> newList = findMinimumNumberOfCoins(amount-coin);

            if (newList != null){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(coin);
                temp.addAll(newList);

                if (min == null || min.size()>temp.size()){
                    min = temp;
                }
            }
        }

        //Did any hit ?
        if (min == null){
            return null;
        }
        //return the smallest that hit ! pog
        hashMap.put(amount, min);
        return min;
    }
}
