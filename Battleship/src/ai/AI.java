package ai;

import java.util.*;

import ships.*;

import battleship.*;

public class AI implements Player{

	private Random rand;
	private Game game;
	private int boardSizeX = 10;
	private int boardSizeY = 10;

	private Grid board;

	public AI(Game game)
	{
		rand = new Random();
		this.game = game;
		board = game.getMotst�ndarplan();

		placeBoat(new Ship(5, "Aircraft Carrier"));
		placeBoat(new Ship(4, "Battleship"));
		placeBoat(new Ship(3, "Destroyer"));
		placeBoat(new Ship(2, "Patrol Boat"));
		placeBoat(new Ship(3, "Submarine"));

		// skicka klartecken till spelaren, dvs "a"
	}

	/**
	 * Spelaren bombar datorn
	 * 
	 * @param x
	 *            x-koordinat
	 * @param y
	 *            y-koordinat
	 */
	public void bomb(int x, int y)
	{
		if (!board.hasShip(x, y)) // ej tr�ff
		{
			board.bomba(x, y);
			game.print("Miss!");
		}
		else
		// tr�ff
		{
			board.getShip(x, y).hit();
			if (board.getShip(x, y).isSunk())
			{
				game.print("You sunk my " + board.getShip(x, y).getName());
				// uppdatera
			}
			board.bomba(x, y);
			game.print("Hit!");
		}
	}

	/**
	 * Datorn v�ljer slumpm�ssiga koordinater p� spelbr�dan att bomba. Kollar
	 * f�rst s� att koordinaten inte redan �r bombad
	 */
	public void randBomb()
	{
		int x;
		int y;
		do
		{
			x = rand.nextInt(boardSizeX);
			y = rand.nextInt(boardSizeY);
			System.out.println(x + " : " + y);
		}
		while (board.isBombed(x, y)); // om koordinaten �r bombad
													// g�r ny
		
		game.s�ttBomb(x, y);
	}

	/**
	 * Placerar ett skepp slumpm�ssigt p� spelplanen
	 * 
	 * @param boat
	 */
	public void placeBoat(Ship boat)
	{
		int yStart = 0;
		int yEnd = 0;
		int xStart = 0;
		int xEnd = 0;
		// direction
		int direction = rand.nextInt(2);

		// direction == 0 => horisontellt l�ge
		if (direction == 0)
		{
			yStart = rand.nextInt(boardSizeY); // y c [0,10[
			xStart = rand.nextInt(boardSizeX - boat.getLength());
			xEnd = xStart + boat.getLength();

			// kolla s� att alla koordinater �r lediga

			boolean free = true;
			for (int i = xStart; i < xEnd; i++)
			{
				if (free)
					free = !board.hasShip(i, yStart);
			}
			if (free)
			{
				// l�gg skeppet till spelbr�dan
				System.out.println("kkkkkkkkkkkkkkkkkk");
				boat.setHorizontal();
				try {
					board.setShip(boat, xStart, yStart, xStart+boat.getLength()-1, yStart);
				} catch (BoatException e) {
					e.printStackTrace();
				}
			}
			else
				// g�r om
				placeBoat(boat);
		}
		else
		// vertikal
		{
			System.out.println("vertikal");
			xStart = rand.nextInt(boardSizeX);
			yStart = rand.nextInt(boardSizeY - boat.getLength());
			yEnd = yStart + boat.getLength();

			boolean free = true;
			for (int i = yStart; i < yEnd; i++)
			{
				if (free)
					free = !board.hasShip(xStart, i);
			}

			if (free)
			{
				// l�gg skeppet till spelbr�dan
				boat.setVertical();
				try {
					board.setShip(boat, xStart, yStart, xStart, yStart+boat.getLength()-1);
				} catch (BoatException e) {
					e.printStackTrace();
				}
			}
			else
				// g�r om
				placeBoat(boat);
		}
	}
	
	public void goAhead()
	{
		System.out.println("goahead");
		randBomb();

	}

	public void printBoard()
	{
		System.out.println(board.toString());
	}
}
