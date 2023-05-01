package Assignment_nQueens;

public class Main {
    public static void main(String[] args) {
        //Here are example that you can try out!
        //Disclaimer: I am aware that the class names isn't the best or the most describing. For example "game"

        //Made class's
        Board board = new Board(10);
        Game game = new Game();

        //Try to place queens on board
        game.placesNAmountOfQueensOnBoardWithBacktrackingAlgorithm(board);

        System.out.println("-----------History: -----------");
        System.out.println(board.printHistory());

        System.out.println("-----------Result: -----------");
        System.out.println(board.printBoard());
    }
}