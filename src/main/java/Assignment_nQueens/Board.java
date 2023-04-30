package Assignment_nQueens;

import java.util.ArrayList;

public class Board {

    private String[][] board;
    private ArrayList<String[][]> history;
    private int pointer;

    private int size;

    public Board(int size) {
        this.size = size;
        board = new String[size][size];
        history = new ArrayList<>();

        history.add(copyBoard());
        pointer = 1;
    }

    private String[][] copyBoard(){
        return board.clone();
    }


    public void placeQueen(int x, int y){
        // Should check if there space
        // TODO: 30-04-2023

        //add -|-
        for (int i = 0; i < size; i++) {
            board[x][i] = "Restricted";
            board[i][y] = "Restricted";
        }

        //add X
        int target1 = x-y;
        int target2 = x+y;

        for (int i = 0; i < size; i++) {
            if (target1>=0 && target1<=10) {
                board[target1][i] = "Restricted";
            }
            if (target2>=0 && target2<=10) {
                board[target2][i] = "Restricted";
            }
            target1++;
            target2++;
        }

        //add Queen
        board[x][y] = "Queen";

        //update History and pointer
        history.add(copyBoard());
        pointer++;
    }

    //back to earlier stages
    private void back(){
        if (pointer>0){
            pointer--;
        }
        board = history.get(pointer).clone();
    }

    public ArrayList<ArrayList<Integer>> getRelevantPointerColumnPositions(){
        ArrayList<ArrayList<Integer>> columnPositions = new ArrayList<>();
        ArrayList<Integer> tempList;

        for (int i = 0; i < size; i++) {
            String temp = board[pointer][i];
            if (!temp.equals("Restricted")){
                tempList = new ArrayList<>();
                tempList.add(pointer);
                tempList.add(i);
                columnPositions.add(tempList);
            }
        }
        return columnPositions;
    }
}
