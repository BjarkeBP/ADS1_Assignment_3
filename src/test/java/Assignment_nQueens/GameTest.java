package Assignment_nQueens;

import org.junit.Assert;
import org.junit.experimental.results.ResultMatchers;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void placesNAmountOfQueensOnBoardWithBacktrackingAlgorithmZero() {
        //set op
        Board board = new Board(0);
        Game game = new Game();


        //test
        assertThrows(IllegalArgumentException.class, () -> {
            game.placesNAmountOfQueensOnBoardWithBacktrackingAlgorithm(board);
        });

    }

    @Test
    void placesNAmountOfQueensOnBoardWithBacktrackingAlgorithmOne() {
        //set op
        Board board = new Board(1);
        Game game = new Game();


        //test
        assertThrows(IllegalArgumentException.class, () -> {
            game.placesNAmountOfQueensOnBoardWithBacktrackingAlgorithm(board);
        });

    }

    @Test
    void placesNAmountOfQueensOnBoardWithBacktrackingAlgorithmMany() {
        //note: This isn't the only solution, So the test might fail even if the result is true.

        //set op
        Board board = new Board(4);
        Game game = new Game();

        //do
        game.placesNAmountOfQueensOnBoardWithBacktrackingAlgorithm(board);

        //test
        boolean temp = false;
        if (board.printBoard().equals(
                "\n" +
                "line 3: [ [Restricted] [  Queen   ] [Restricted] [Restricted] ]\n" +
                "line 2: [ [Restricted] [Restricted] [Restricted] [  Queen   ] ]\n" +
                "line 1: [ [  Queen   ] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 0: [ [Restricted] [Restricted] [  Queen   ] [Restricted] ]\n")
            || board.printBoard().equals(
                    "\n" +
                "line 3: [ [Restricted] [Restricted] [  Queen   ] [Restricted] ]\n" +
                "line 2: [ [  Queen   ] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 1: [ [Restricted] [Restricted] [Restricted] [  Queen   ] ]\n" +
                "line 0: [ [Restricted] [  Queen   ] [Restricted] [Restricted] ]\n")
        ){
            temp=true;
        }


        assertEquals(true, temp);

    }

    @Test
    void placesNAmountOfQueensOnBoardWithBacktrackingAlgorithmMany2() {
        //set op
        Board board = new Board(10);
        Game game = new Game();

        //do
        game.placesNAmountOfQueensOnBoardWithBacktrackingAlgorithm(board);

        //test
        assertEquals(board.printBoard(), "\n" +
                "line 9: [ [Restricted] [Restricted] [Restricted] [Restricted] [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 8: [ [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [  Queen   ] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 7: [ [Restricted] [Restricted] [Restricted] [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 6: [ [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [  Queen   ] ]\n" +
                "line 5: [ [Restricted] [Restricted] [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 4: [ [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 3: [ [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [  Queen   ] [Restricted] ]\n" +
                "line 2: [ [Restricted] [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 1: [ [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [  Queen   ] [Restricted] [Restricted] ]\n" +
                "line 0: [ [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] ]\n");

    }

}