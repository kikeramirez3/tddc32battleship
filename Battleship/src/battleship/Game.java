package battleship;

import gui.*;
import Network.NetworkPlayer;
import ai.AI;
import ships.Ship;


/**
 * This is the main class that starts the game.
 * @author David
 *
 */
public class Game {	

	private NetworkPlayer net;
	private AI ai;
	private GUI gui;
	private int boardSizeX;
	private int boardSizeY;
	private Board board;
	
	public Game()
	{	
		boardSizeX = 10;
		boardSizeY = 10;
		gui = new GUI(this, boardSizeX, boardSizeY);		
		board = new Board(boardSizeX,boardSizeY);
	}
	
	public void makeAI()
	{
		ai = new AI();
	}
	
	/**
	 * Metod f�r att skapa ny instans av n�tverksspelare. Ligger inte
	 * i konstruktorn ifall spelaren inte ska anv�nda n�tverket
	 */
	public void makeNetwork()
	{
		net = new NetworkPlayer(this);
	}
	
	/**
	 * s�nd str�ng till n�tverksspelare
	 * @param s str�ng att s�nda
	 */
	public void send(String s)
	{
		net.send(s);
	}
	
	/**
	 * Skriver ut en str�ng till GUI:ts statusf�lt
	 * @param s
	 */
	public void print(String s)
	{
		gui.statusUpdate(s);
	}
	
	/**
	 * G�r spelserver
	 * @param port port motst�ndaren ska ansluta till
	 */
	public void create(int port)
	{
		net.create(port);
	}
	
	/**
	 * Ansluter till motst�ndarens server
	 * @param address ip-adress
	 * @param port port hos motst�ndaren
	 */
	public void connect(String address, int port)
	{
		net.connect(address, port);
		send("connected");
	}
	
	/**
	 * St�nger uppkopplingen
	 */
	public void close()
	{
		net.close();
		print("Other player left, you win!");
	}
	
	/**
	 * koordinaterna ska redan vara kollade innan metoden anv�nds
	 * @param ship
	 */
	public void placeShip(Ship ship,int x,int y,Boolean vertical)
	{
		board.placeShip(ship, x, y, vertical);
	}
	
	public void printBoard()
	{
		System.out.println(board.toString());
	}
	
	public static void main(String[] args)
	{
		@SuppressWarnings("unused")
		Game game = new Game();
	}	
}
