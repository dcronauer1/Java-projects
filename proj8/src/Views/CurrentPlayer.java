package Views;


import Controllers.TicTacToeController;
import Models.Token;

/**
 * class to handle the current player gui. uses a token to represent this. shows who's turn it is
 */
public class CurrentPlayer {
    private Token currentPlayer;

    /**
     * constructor for the current player object
     */
    public CurrentPlayer(){
        currentPlayer = new Token(TicTacToeController.currentPlayer);
        currentPlayer.setSize(40,40);
        currentPlayer.setLocation(0,280);
    }

    /**
     * Method from Token that calls the method in Token to change the state
     * @param state state of the current player
     */
    public void setState(int state){
        currentPlayer.setState(state);
    }
}
