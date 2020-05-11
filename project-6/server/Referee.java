package Server;

public class Referee {
	/**
	 * This class represents the referee of the program for Tic-Tac-Toe game.
	 * @author SIH , Saman
	 * @version 1.0
	 * @since Feb 13, 2020
	 */



	/**
	 *  two object form class of Player as member variables
	 */
	private Player xPlayer, oPlayer;
	/**
	 *  one object form class of board as a member variable
	 */
	private Board board;


	/**
	 * Constructs a Referee object as a default
	 */
	public Referee() {

	}

	/**
	 * this function is presenting the setting opponent for the game
	 * and after that display the board,
	 * and at the end it starts the game with xPlayer
	 */
	public void runTheGame() {
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		board.display();
		xPlayer.play();

	}


	/**
	 * Sets the value of board to the specified value.
	 */

	public void setBoard(Board board) {
		this.board = board;
	}
	/**
	 * Sets the value of xPlayer to the specified value.
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
	}
	/**
	 * Sets the value of oPlayer to the specified value.
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
	}



}
