package network;

/**
 * Network class
 */
import java.net.*;
import java.io.*;

import battleship.*; // h�r ligger game, player (m�jligtvis mer)

public class NetworkPlayer implements Player{

	private ServerSocket serverSocket = null;
	private Socket socket = null;

	private DataOutputStream out;

	private Game game;
	private Receiver receiver;

	/**
	 * Constructor
	 */
	public NetworkPlayer(Game g)
	{
		game = g;
	}

	/**
	 * Makes a ServerSocket listening to <code>port</code> and after accepting
	 * a connection makes a new Socket.
	 * 
	 * @param port
	 *            int of what port to listen to.
	 */
	public void create(int port)
	{
		try
		{
			serverSocket = new ServerSocket(port);
			socket = serverSocket.accept();
			out = new DataOutputStream(socket.getOutputStream());
			receiver = new Receiver(socket, game);
			receiver.start();
		}
		catch (Exception e)
		{
			System.err.println("unable to create: " + e.getMessage());
		}
	}

	/**
	 * Connects to a server at <code>address</code>, <code>port</code> and
	 * makes a new PrintWriter and a BufferedReader
	 * 
	 * @param address
	 *            String.
	 * @param port
	 *            int.
	 */
	public void connect(String address, int port)
	{
		try
		{
			socket = new Socket(address, port);
			out = new DataOutputStream(socket.getOutputStream());
			receiver = new Receiver(socket, game);
			receiver.start();
		}
		catch (Exception e)
		{
			System.err.println("unable to connect: " + e.getMessage());
		}
	}

	/**
	 * Anv�nds av spelaren f�r att bomba motst�ndaren �ver n�tverk
	 * 
	 * @param x
	 *            x-koordinat
	 * @param y
	 *            y-koordinat
	 */
	public void bomb(int x, int y)
	{
		// send("c:" + x +"," + y);
		// kolla spelbr�dan
	}

	/**
	 * Puts a sting in the output stream, connected to the remote socket
	 * 
	 * @param s
	 *            String to send.
	 */
	public void send(String s)
	{
		try
		{
			out.writeUTF(s);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void close()
	{
		try
		{
			receiver.stop();
			if (!serverSocket.isClosed())
				serverSocket.close();
			socket.close();
			out.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
