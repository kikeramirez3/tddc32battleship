package battleship;

import ships.*;

;

public class Board {

	private int boardSizeX;
	private int boardSizeY;
	private Ship[][] board;
	private Ship bomb;

	public Board(int x, int y)
	{
		boardSizeX = x;
		boardSizeY = y;
		board = new Ship[x][y];
		bomb = new Ship(1, "bomb");
	}

	/**
	 * Kollar s� att skeppet f�r plats p� spelbr�dan och att inget annat skepp
	 * ligger i v�gen
	 * 
	 * @param ship
	 * @param xStart
	 *            b�rjan p� skeppet
	 * @param yStart
	 *            b�rjan p� skeppet
	 * @param vertical
	 *            <code>true</code> om skeppet ligger vertikalt ifr�n
	 *            utg�ngspunkten
	 * @return <code>true</code> om inget hinder f�religger
	 */
	public boolean isSpace(Ship ship, int xStart, int yStart)
	{
		boolean free;
		boolean vertical = ship.isVertical();
		int length = ship.getLength();
		if (vertical)
			free = yStart + length < boardSizeY;
		else
			free = xStart + length < boardSizeX;

		int i = 0;
		while (free && i < length)
		{
			if (vertical)
				free = isFree(xStart, yStart + i++);
			else
				free = isFree(xStart + i++, yStart);
		}
		return free;
	}

	/**
	 * Metod f�r att placera skepp p� spelplanen N�r metoden f�r koordinaterna
	 * har annan metod kollat s� att plats finns
	 * 
	 * @param ship
	 *            skepp att placera ut
	 * @param xStart
	 *            x-koordinat f�r startpunkt
	 * @param yStart
	 *            y-koordinat f�r startpunkt
	 * @param vertical
	 *            <code>true</code> om skeppet placeras vertikalt
	 */
	public void placeShip(Ship ship, int xStart, int yStart)
	{
		if (isSpace(ship, xStart, yStart))
		{
			int length = ship.getLength();
			for (int i = 0; i < length; i++)
			{
				if (ship.isVertical())
					board[xStart][yStart + i] = ship;
				else
					board[xStart + i][yStart] = ship;
			}
		}
	}

	/**
	 * Anv�nds f�r att markera en ruta som bombad
	 * 
	 * @param x
	 * @param y
	 */
	public void placeBomb(int x, int y)
	{
		board[x][y] = bomb;
	}

	/**
	 * Returnerar br�dan i form av en str�ng
	 */
	public String toString()
	{
		String boardString = "";
		String row;

		for (int y = 0; y < board.length; y++)
		{
			row = "|";
			for (int x = 0; x < board.length; x++)
			{
				if (!(board[x][y] == null))
					row = row + board[x][y].getName().charAt(0) + "|";
				else
					row = row + "_|";
			}
			boardString = boardString + row + "\n";
		}
		return boardString;
	}

	/**
	 * Kollar om en koordinat �r ledig
	 * 
	 * @param x
	 *            mellan 0 och x-1
	 * @param y
	 *            mellan 0 och y-1
	 * @return <code>true</code> om platsen �r ledig
	 */
	public boolean isFree(int x, int y)
	{
		return board[x][y] == null;
	}

	/**
	 * Kollar om koordinaten �r bombad
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isBombed(int x, int y)
	{
		return board[x][y] == bomb;
	}

	public Ship getShip(int x, int y)
	{
		return board[x][y];
	}
}
