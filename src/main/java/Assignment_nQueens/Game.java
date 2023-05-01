package Assignment_nQueens;

import java.util.ArrayList;

public class Game {

    public Game() {
    }

    //N is the boards size
    public void placesNAmountOfQueensOnBoardWithBacktrackingAlgorithm (Board board){
        if (board.getSize()<3){
            throw new IllegalArgumentException("board is to small. It is required that: size<3");
        }

        ArrayList<ArrayList<Integer>> coordinates = board.getRelevantPointerColumnPositions();
        for (ArrayList<Integer> positions : coordinates) {
            if (placesNAmountOfQueensOnBoardWithBacktrackingAlgorithmRecursion(board, positions.get(0), positions.get(1)) == true){
                return;
            }
        }

    }
    private boolean placesNAmountOfQueensOnBoardWithBacktrackingAlgorithmRecursion(Board board, int tryToPlaceX,int tryToPlaceY){


        board.placeQueen(tryToPlaceX, tryToPlaceY);

        if ((board.getSize())==board.getPointer()){
            return true;
        }

        ArrayList<ArrayList<Integer>> coordinates = board.getRelevantPointerColumnPositions();
        for (ArrayList<Integer> positions : coordinates) {
            if (placesNAmountOfQueensOnBoardWithBacktrackingAlgorithmRecursion(board, positions.get(0), positions.get(1)) == true){
                return true;
            }
        }
        board.back();
        return false;
    }
}
