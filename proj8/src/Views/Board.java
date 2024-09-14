package Views;

import Controllers.TicTacToeController;
import Models.Token;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import wheelsFX.users.Shapes.Rectangle;

import javafx.scene.paint.Color;

/**
 * Class to handle collisions of the game
 */
public class Board {
    private TicTacToeController controller;
    private Rectangle[][] grid;
    private Rectangle resetButton;

    public static int boardSize;
    public static int gridSize;
    public static int playTo;
    public static int players;//public because they're static and its easier

    /**
     * constructor of board
     * @param BoardSize size of the board (amount of tokens in the x or y direction)
     * @param GridSize physical distance each gridspace takes up
     * @param PlayTo amount of tokens that need to be in a row to win
     * @param Players amount of players
     */
    public Board(int BoardSize,int GridSize,int PlayTo, int Players) {
        //get game parameters from main
        boardSize=BoardSize;
        gridSize=GridSize;
        playTo=PlayTo;
        players=Players;
        //set up controller and grid
        this.controller = new TicTacToeController(this);
        this.grid = new Rectangle[boardSize][boardSize];
        createGrid();
        createResetButton();
    }

    /**
     * Method to create the Grid for click detection.
     */
    private void createGrid() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                final int row = i;
                final int col = j;
                Rectangle cell = new Rectangle();
                cell.setSize(gridSize, gridSize);
                cell.setLocation(col * gridSize + 100, row * gridSize);//+100 to center it (assuming playspace is 600x600)
                cell.setColor(Color.TRANSPARENT);
                cell.setOutlineColor(Color.BLACK);

                cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        //cell.setColor(Color.GREEN);
                        controller.handleClick(row, col);
                        System.out.println(row+","+col);//debug code remove this
                    }
                });
                grid[row][col] = cell;
            }
        }
    }

    /**
     * Method to create the reset button
     */
    private void createResetButton(){
        resetButton = new Rectangle();
        resetButton.setSize(60,40);
        resetButton.setLocation(720,280);
        resetButton.setColor(Color.GREY);
        resetButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                resetButton.setColor(Color.GREEN);//user feedback
            }
        });
        resetButton.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                resetButton.setColor(Color.GREY);
                controller.reset();
            }
        });
    }
}

