package Controllers;

import Views.*;
import Models.Token;

/**
 * Class TicTacToeController handles all logic operations of TicTacToe, and handles placing all the tokens appropriately
 */
public class TicTacToeController {
    private Board board;
    private Token[][] tokens;
    private CurrentPlayer currentPlayerObject;
    public static int currentPlayer;
    private static int fullSquares;
    private int boardSize=Board.boardSize;
    private int gridSize=Board.gridSize;
    private int playTo=Board.playTo;
    private int players=Board.players;
    private boolean gameStillGoing=true;

    /**
     * Constructor for the TicTacToeController
     * @param board handles the linkage with the board class
     */
    public TicTacToeController(Board board) {
        this.board = board;
        this.tokens = new Token[boardSize][boardSize];
        currentPlayer = 1; //1 indexed
        initializeTokens();
        fullSquares = 0;
        this.currentPlayerObject = new CurrentPlayer();
    }

    /**
     * Method to initialize the positions of each token
     */
    private void initializeTokens() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                tokens[i][j] = new Token(0);
                tokens[i][j].setLocation(j * gridSize + 100, i * gridSize);//+100 because offset
            }
        }
    }

    /**
     * Method to handle logic for clicking on tokens
     * @param row token's row
     * @param col token's column
     */
    public void handleClick(int row, int col) {
        if (tokens[row][col].getValue() == 0 && gameStillGoing) {
            tokens[row][col].setState(currentPlayer);
            fullSquares++;
            if(checkWin(row, col))
                playerWon(currentPlayer);//check for winners recursively
            else if (fullSquares==tokens.length*tokens[0].length)
                declareDraw();//board is full here, Draw
            else {
                if(currentPlayer==players)
                    currentPlayer=1;//go back to player one
                else
                    currentPlayer++;//change player
            }
            currentPlayerObject.setState(currentPlayer); //show who's turn it is
        }
    }

    /**
     * Method to handle resetting when the reset button is pressed (from Board.java)
     */
    public void reset() {
        for (Token[] row : tokens) {
            for (Token token : row) {
                token.setState(0);
            }
        }
        currentPlayer = 1;
        fullSquares = 0;
        currentPlayerObject.setState(currentPlayer);
        gameStillGoing=true;
        System.out.println("Game Was Reset");
    }

    /**
     * Master Method for logic checking for wins. Over-engineered because it also has to handle if the win condition is < the board size
     * @param row row of the token to be checked
     * @param col column of the token to be checked
     * @return true if player won
     */
    private boolean checkWin(int row, int col) {
        //don't check until its possible to win
        if (Math.ceil(((double)fullSquares/(double)players))<playTo){
            return false;}
        else {
            return checkDirection(row, col, 0, 1)  // Horizontal
                    || checkDirection(row, col, 1, 0)  // Vertical
                    || checkDirection(row, col, 1, 1)  // Diagonal (top-left to bottom-right)
                    || checkDirection(row, col, 1, -1); // Diagonal (top-right to bottom-left)
        }
    }
    /**
     * Master Method for logic checking for wins. Over-engineered because it also has to handle if the win condition is < the board size
     * @param row row of the token to be checked
     * @param col column of the token to be checked
     * @return true if player won
     */
    private boolean checkDirection(int row, int col, int rowDelta, int colDelta) {
        int count = 1; // Start with 1 for the current piece
        int player = tokens[row][col].getValue();

        // Check in positive direction
        count += countConsecutive(row, col, rowDelta, colDelta, player);

        // Check in negative direction
        count += countConsecutive(row, col, -rowDelta, -colDelta, player);

        return count >= playTo;
    }

    /**
     * method to count tokens from the player in each direction individually
     * @param row row of the token to be checked
     * @param col column of the token to be checked
     * @param rowDelta original row
     * @param colDelta original column
     * @param player of original token
     * @return count of tokens checked
     */
    private int countConsecutive(int row, int col, int rowDelta, int colDelta, int player) {
        int count = 0;
        row += rowDelta;
        col += colDelta;

        while (isValidPosition(row, col) && tokens[row][col].getValue() == player) {
            count++;
            row += rowDelta;
            col += colDelta;

            if (count == playTo - 1) return count; // Early exit if we've found enough
        }

        return count;
    }

    /**
     * Method to check if the token is at a valid position
     * @param row row of the token to be checked
     * @param col column of the token to be checked
     * @return True if it is valid
     */
    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < boardSize && col >= 0 && col < boardSize;
    }

    /**
     * Method that is called when a player wins the game
     * @param currentPlayer Player that won
     */
    private void playerWon(int currentPlayer) {
        System.out.println("Player " + currentPlayer + " won!");
        gameStillGoing=false; //stop game, but still let player choose when to reset
        System.out.println("Press the reset button to reset the board.");

    }

    /**
     * Method that is called when the board fills (ie draw)
     */
    private void declareDraw() {
        // Implement draw handling here
        System.out.println("Board is full, Draw. Press the reset button to reset the board.");
        gameStillGoing=false;//redundant here
    }
}