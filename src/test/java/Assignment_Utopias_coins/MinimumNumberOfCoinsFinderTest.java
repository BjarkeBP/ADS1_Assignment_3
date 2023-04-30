package Assignment_Utopias_coins;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MinimumNumberOfCoinsFinderTest {

    @Test
    void findMinimumNumberOfCoinsZero() {
        //set up
        ArrayList<Integer> listOfCoins = new ArrayList<>();
        listOfCoins.add(1);
        listOfCoins.add(7);
        listOfCoins.add(10);
        listOfCoins.add(22);

        MinimumNumberOfCoinsFinder finder = new MinimumNumberOfCoinsFinder(listOfCoins);

        //test
        assertEquals(finder.findMinimumNumberOfCoins(0), null);
    }


    @Test
    void findMinimumNumberOfCoinsOne() {
        //set up
        ArrayList<Integer> listOfCoins = new ArrayList<>();
        listOfCoins.add(1);
        listOfCoins.add(7);
        listOfCoins.add(10);
        listOfCoins.add(22);
        MinimumNumberOfCoinsFinder finder = new MinimumNumberOfCoinsFinder(listOfCoins);


        ArrayList<Integer> re = new ArrayList<>();
        re.add(1);

        //test
        assertEquals(finder.findMinimumNumberOfCoins( 1), re);
    }

    @Test
    void findMinimumNumberOfCoinsMany() {
        //set up
        ArrayList<Integer> listOfCoins = new ArrayList<>();
        listOfCoins.add(1);
        listOfCoins.add(7);
        listOfCoins.add(10);
        listOfCoins.add(22);
        MinimumNumberOfCoinsFinder finder = new MinimumNumberOfCoinsFinder(listOfCoins);


        ArrayList<Integer> re = new ArrayList<>();
        re.add(1);
        re.add(1);
        re.add(1);
        re.add(1);
        re.add(1);
        re.add(1);



        //test
        assertEquals(finder.findMinimumNumberOfCoins(6), re);
    }

    @Test
    void findMinimumNumberOfCoinsMany2() {
        //set up
        ArrayList<Integer> listOfCoins = new ArrayList<>();
        listOfCoins.add(1);
        listOfCoins.add(7);
        listOfCoins.add(10);
        listOfCoins.add(22);
        MinimumNumberOfCoinsFinder finder = new MinimumNumberOfCoinsFinder(listOfCoins);


        ArrayList<Integer> re = new ArrayList<>();
        re.add(1);
        re.add(1);
        re.add(10);
        re.add(22);
        re.add(22);
        re.add(22);
        re.add(22);


        //test
        assertEquals(finder.findMinimumNumberOfCoins(100), re);
    }






}