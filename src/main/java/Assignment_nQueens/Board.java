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
        pointer = 0;
    }

    private String[][] copyBoard(){
        String[][] newboard = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                String newVal = this.board[i][j];
                newboard[i][j] = newVal;
            }
        }
        return newboard;
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
            if (target1>=0 && target1<size) {
                board[target1][i] = "Restricted";
            }

            if (target2>=0 && target2<size) {
                board[target2][i] = "Restricted";
            }
            target1++;
            target2--;
        }

        //add Queen
        board[x][y] = "  Queen   ";

        //add History and update pointer
        pointer++;
        history.add(copyBoard());
    }

    //back to earlier stages
    public void back(){
        if (pointer>0){
            history.remove(pointer);
            pointer--;
        }

        board = history.get(pointer).clone();
    }

    public ArrayList<ArrayList<Integer>> getRelevantPointerColumnPositions(){
        ArrayList<ArrayList<Integer>> columnPositions = new ArrayList<>();
        ArrayList<Integer> tempList;

        for (int i = 0; i < size; i++) {
            String temp = board[pointer][i];
            if (temp==null){
                tempList = new ArrayList<>();
                tempList.add(pointer);
                tempList.add(i);
                columnPositions.add(tempList);
            }
        }
        return columnPositions;
    }

    public String printBoard(){
        return printBoard(board);
    }

    public String printHistory(){
        String toReturn = "\n";
        for (int i = 0; i < history.size(); i++) {
            if (history.get(i)!=null){
                toReturn += "Historical index: " + i + "\n";
                toReturn += printBoard(history.get(i));
                toReturn += "\n";
            }
        }
        return toReturn;
    }

    private String printBoard(String[][] board){
        String boardRepresentation = "\n";
        for (int i = size-1; i >= 0; i--) {
            String line = "line " + i + ": [";
            for (int j = 0; j < size; j++) {
                String temp = board[j][i];

                if (temp==null){
                    line += " [   " + temp + "   ]";
                } else {
                    line += " [" + temp + "]";
                }
            }
            line += " ]";
            boardRepresentation += line;
            boardRepresentation += "\n";
        }
        return boardRepresentation;

    }



    public int getPointer() {
        return pointer;
    }

    public int getSize() {
        return size;
    }


}
