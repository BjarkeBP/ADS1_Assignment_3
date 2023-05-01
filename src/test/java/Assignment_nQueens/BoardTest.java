package Assignment_nQueens;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    // noted: placeQueen method is not safe, but as long as you're just a bit careful. it should be fine..
    // "safe" = Restrict one from doing things that would break the board, or make it incorrect according the rules of chest


    @Test
    void placeQueenZero10x10() {
        //set up
        Board board = new Board(10);

        //test
        assertEquals(board.printBoard(), "\n" +
                "line 9: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 8: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 7: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 6: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 5: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 4: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 3: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 2: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 1: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 0: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n");
    }


    @Test
    void placeQueenOne10x10() {
        //set up
        Board board = new Board(10);

        //do
        board.placeQueen(5,5);

        //test
        assertEquals(board.printBoard(), "\n" +
                "line 9: [ [   null   ] [Restricted] [   null   ] [   null   ] [   null   ] [Restricted] [   null   ] [   null   ] [   null   ] [Restricted] ]\n" +
                "line 8: [ [   null   ] [   null   ] [Restricted] [   null   ] [   null   ] [Restricted] [   null   ] [   null   ] [Restricted] [   null   ] ]\n" +
                "line 7: [ [   null   ] [   null   ] [   null   ] [Restricted] [   null   ] [Restricted] [   null   ] [Restricted] [   null   ] [   null   ] ]\n" +
                "line 6: [ [   null   ] [   null   ] [   null   ] [   null   ] [Restricted] [Restricted] [Restricted] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 5: [ [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 4: [ [   null   ] [   null   ] [   null   ] [   null   ] [Restricted] [Restricted] [Restricted] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 3: [ [   null   ] [   null   ] [   null   ] [Restricted] [   null   ] [Restricted] [   null   ] [Restricted] [   null   ] [   null   ] ]\n" +
                "line 2: [ [   null   ] [   null   ] [Restricted] [   null   ] [   null   ] [Restricted] [   null   ] [   null   ] [Restricted] [   null   ] ]\n" +
                "line 1: [ [   null   ] [Restricted] [   null   ] [   null   ] [   null   ] [Restricted] [   null   ] [   null   ] [   null   ] [Restricted] ]\n" +
                "line 0: [ [Restricted] [   null   ] [   null   ] [   null   ] [   null   ] [Restricted] [   null   ] [   null   ] [   null   ] [   null   ] ]\n");
    }

    @Test
    void placeQueenMany10x10() {
        //set up
        Board board = new Board(10);

        //do
        board.placeQueen(5,5);
        board.placeQueen(8,4);
        board.placeQueen(0,9);
        board.placeQueen(2,0);

        //test
        assertEquals(board.printBoard(), "\n" +
                "line 9: [ [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 8: [ [Restricted] [Restricted] [Restricted] [   null   ] [Restricted] [Restricted] [   null   ] [   null   ] [Restricted] [   null   ] ]\n" +
                "line 7: [ [Restricted] [   null   ] [Restricted] [Restricted] [   null   ] [Restricted] [   null   ] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 6: [ [Restricted] [   null   ] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [   null   ] [Restricted] [   null   ] ]\n" +
                "line 5: [ [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 4: [ [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [  Queen   ] [Restricted] ]\n" +
                "line 3: [ [Restricted] [   null   ] [Restricted] [Restricted] [   null   ] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 2: [ [Restricted] [   null   ] [Restricted] [   null   ] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [   null   ] ]\n" +
                "line 1: [ [Restricted] [Restricted] [Restricted] [Restricted] [   null   ] [Restricted] [   null   ] [   null   ] [Restricted] [Restricted] ]\n" +
                "line 0: [ [Restricted] [Restricted] [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] ]\n");
    }



    @Test
    void getRelevantPointerColumnPositionsFirstColumn3x3() {
        //set up
        Board board = new Board(3);

        //ass ;)
        ArrayList<ArrayList<Integer>> toTest = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.add(0);
        toTest.add(temp);
        temp = new ArrayList<>();
        temp.add(0);
        temp.add(1);
        toTest.add(temp);
        temp = new ArrayList<>();
        temp.add(0);
        temp.add(2);
        toTest.add(temp);

        assertEquals(board.getRelevantPointerColumnPositions(), toTest);
    }

    @Test
    void getRelevantPointerColumnPositionsSecondColumn3x3() {
        //set up
        Board board = new Board(3);

        //ass ;)
        ArrayList<ArrayList<Integer>> toTest = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.add(0);
        toTest.add(temp);
        temp = new ArrayList<>();
        temp.add(0);
        temp.add(1);
        toTest.add(temp);
        temp = new ArrayList<>();
        temp.add(0);
        temp.add(2);
        toTest.add(temp);

        assertEquals(board.getRelevantPointerColumnPositions(), toTest);

        board.placeQueen(0,0);
        toTest = new ArrayList<>();
        temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        toTest.add(temp);

        assertEquals(board.getRelevantPointerColumnPositions(), toTest);
    }

    @Test
    void printBoardOne10x10() {
        //set up
        Board board = new Board(10);

        assertEquals(board.printBoard(), "\n" +
                "line 9: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 8: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 7: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 6: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 5: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 4: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 3: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 2: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 1: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n" +
                "line 0: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] ]\n");

        board.placeQueen(9,1);

        assertEquals(board.printBoard(), "\n" +
                "line 9: [ [   null   ] [Restricted] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [Restricted] ]\n" +
                "line 8: [ [   null   ] [   null   ] [Restricted] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [Restricted] ]\n" +
                "line 7: [ [   null   ] [   null   ] [   null   ] [Restricted] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [Restricted] ]\n" +
                "line 6: [ [   null   ] [   null   ] [   null   ] [   null   ] [Restricted] [   null   ] [   null   ] [   null   ] [   null   ] [Restricted] ]\n" +
                "line 5: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [Restricted] [   null   ] [   null   ] [   null   ] [Restricted] ]\n" +
                "line 4: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [Restricted] [   null   ] [   null   ] [Restricted] ]\n" +
                "line 3: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [Restricted] [   null   ] [Restricted] ]\n" +
                "line 2: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [Restricted] [Restricted] ]\n" +
                "line 1: [ [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [  Queen   ] ]\n" +
                "line 0: [ [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [   null   ] [Restricted] [Restricted] ]\n");
    }

    @Test
    void BackZero3x3() {
        //set up
        Board board = new Board(3);

        board.back();

        //ass ;)
        ArrayList<ArrayList<Integer>> toTest = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.add(0);
        toTest.add(temp);
        temp = new ArrayList<>();
        temp.add(0);
        temp.add(1);
        toTest.add(temp);
        temp = new ArrayList<>();
        temp.add(0);
        temp.add(2);
        toTest.add(temp);

        assertEquals(board.getRelevantPointerColumnPositions(), toTest);
    }

    @Test
    void BackOne3x3() {
        //set up
        Board board = new Board(3);
        board.placeQueen(0, 0);

        //do
        board.back();

        //ass ;)
        ArrayList<ArrayList<Integer>> toTest = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(0);
        temp.add(0);
        toTest.add(temp);
        temp = new ArrayList<>();
        temp.add(0);
        temp.add(1);
        toTest.add(temp);
        temp = new ArrayList<>();
        temp.add(0);
        temp.add(2);
        toTest.add(temp);

        assertEquals(board.getRelevantPointerColumnPositions(), toTest);
    }

    @Test
    void BackMany6x6() {
        //set up
        Board board = new Board(6);
        board.placeQueen(0, 0);
        board.placeQueen(1, 2);
        board.placeQueen(2, 4);
        board.placeQueen(4, 1);
        board.placeQueen(5, 3);

        assertEquals(board.printBoard(), "\n" +
                "line 5: [ [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 4: [ [Restricted] [Restricted] [  Queen   ] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 3: [ [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [  Queen   ] ]\n" +
                "line 2: [ [Restricted] [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 1: [ [Restricted] [Restricted] [Restricted] [Restricted] [  Queen   ] [Restricted] ]\n" +
                "line 0: [ [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] ]\n");
        //do
        board.back();

        //ass ;)
        assertEquals(board.printBoard(), "\n" +
                "line 5: [ [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 4: [ [Restricted] [Restricted] [  Queen   ] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 3: [ [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [   null   ] ]\n" +
                "line 2: [ [Restricted] [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 1: [ [Restricted] [Restricted] [Restricted] [Restricted] [  Queen   ] [Restricted] ]\n" +
                "line 0: [ [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] ]\n");


        //do
        board.back();

        //ass ;)
        assertEquals(board.printBoard(), "\n" +
                "line 5: [ [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 4: [ [Restricted] [Restricted] [  Queen   ] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 3: [ [Restricted] [Restricted] [Restricted] [Restricted] [   null   ] [   null   ] ]\n" +
                "line 2: [ [Restricted] [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] ]\n" +
                "line 1: [ [Restricted] [Restricted] [Restricted] [   null   ] [   null   ] [Restricted] ]\n" +
                "line 0: [ [  Queen   ] [Restricted] [Restricted] [Restricted] [Restricted] [Restricted] ]\n");




    }



}



