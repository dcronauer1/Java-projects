import Views.Board;
import wheelsFX.users.Frame.Frame;

import java.util.Scanner;
import java.lang.Math;

/**
 * Class to handle game initialization
 */
public class TicTacToe {
    public static int boardSize = 3;
    public static int gridSize = 600/boardSize;
    public static int playTo = 3;
    public static int players = 2;

    /**
     * Method to handle program execution
     * @param args command line arguments
     */
    public static void main(String[] args){
        //boardSize logic, playspace is 600x600
        Scanner in = new Scanner(System.in);
        System.out.println("default or custom? (1 for custom)");
        int temp = in.nextInt();
        if(temp == 1)
            CustomGame(in);
        System.out.println("Starting game");

        //Make and start game
        Board b = new Board(boardSize,gridSize,playTo,players);
        Frame.createFrame();
    }

    /**
     * Method to handle user entered inputs for a custom game
     * @param in passes in the scanner object for console
     */
    private static void CustomGame(Scanner in){
        //players
        System.out.println("Enter how many players there will be (default 2, max 6)");
        players = in.nextInt();
        if (players < 2 || players > 6)
            players = 2;
        //board size and grid size
        System.out.println("Enter a board size (default 3, 3<=x<=200. will round):");
        boardSize = in.nextInt();
        if(boardSize <= 2)
            boardSize = 3;
        else if(boardSize > 200)
            boardSize = 200;
        gridSize = Math.round((float)(600/boardSize));
        boardSize=600/gridSize;
        System.out.println("Board size is: "+boardSize); //tell user what it rounded to
        //pieces in a row
        System.out.println("How many pieces need to be in a row to win? (default 3)");
        playTo = in.nextInt();
        if(playTo >= boardSize || playTo < 2)
            playTo = 3;
        System.out.println("playTo amount is: "+playTo); //tell user what number it is (since it defaults to 3)
    }
}
