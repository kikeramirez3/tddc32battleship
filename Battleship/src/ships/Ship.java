package ships;

public class Ship {
	private int length;
	private String name;
	private int health;
	private boolean vertical;
	private boolean isPlaced;

	public Ship(int l, String n)
	{
		length = l;
		name = n;
		health = length;
		vertical = false;
	}

	public String getName()
	{
		return name;
	}

	public int getLength()
	{
		return length;
	}

	public void setVertical()
	{
		vertical = true;
	}

	public void setHorizontal()
	{
		vertical = false;
	}

	public boolean isVertical()
	{
		return vertical;
	}

	public void hit()
	{
		health--;
		System.out.println(health);
		if (health == 0){
			System.out.println("nu s�nktes " + name);
		}
	}

	public boolean isSunk()
	{
		return (health == 0);
	}

	public void rotate()
	{
		if (vertical)
			vertical = false;
		else
			vertical = true;
	}
	
	public boolean isPlaced() {
		return isPlaced;
	}

	public void setPlaced() {
		isPlaced = true;
	}
}
