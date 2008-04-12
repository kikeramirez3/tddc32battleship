import java.util.*;

import B�tar.*;

public class Flotta {
	//private List<Ship> flotta;
	private boolean utplacerad = false;

	private int allShips = 0;
	private int maxAllShips;
	
	private int nrBoats = 0;
	private int nrShips = 0;
	private int nrCruisers = 0;
	private int nrBattleships = 0;
	
	private int maxBoats;
	private int maxShips;
	private int maxCruisers;
	private int maxBattleships;
	
	private List<Ship> boats;
	private List<Ship> ships;
	private List<Ship> cruisers;
	private List<Ship> battleships;
	
	
	//konstruktor
	public Flotta(int bo, int sh, int cr, int ba){
		maxBoats = bo;
		maxShips = sh;
		maxCruisers = cr;
		maxBattleships = ba;
		
		maxAllShips = maxBoats + maxShips + maxCruisers + maxBattleships;
		
		boats = new ArrayList<Ship>(bo);
		ships = new ArrayList<Ship>(sh);
		cruisers = new ArrayList<Ship>(cr);
		battleships = new ArrayList<Ship>(ba);
	}
	
	//Metoder som �ndrar flottan
	public void add(Ship s) throws ToManyShipsException{
		if (s.getLength() == 2){
			if (nrBoats == maxBoats)
				throw new ToManyShipsException("Max antal B�tar uppn�tt");
			boats.add(s);
			nrBoats++;
			allShips++;
		}	
		if (s.getLength() == 3){
			if (nrShips == maxShips)
				throw new ToManyShipsException("Max antal Skepp uppn�tt");
			ships.add(s);
			nrShips++;
			allShips++;
		}
		if (s.getLength() == 4){
			if (nrCruisers == maxCruisers)
				throw new ToManyShipsException("Max antal Kryssare uppn�tt");
			cruisers.add(s);
			nrCruisers++;
			allShips++;
		}
		if (s.getLength() == 5){
			if (nrBattleships == maxBattleships)
				throw new ToManyShipsException("Max antal Slagskepp uppn�tt");
			battleships.add(s);
			nrBattleships++;
			allShips++;
		}	


	
		
		
	}
	
	//Metoder som �ndrar skeppen
	
	
	//Metoder som ger information om flottan
	public Boolean isPlaced(){
		return utplacerad;
	}
	
/*	public void printFleet(){
		System.out.println("Flottan best�r av " + antalSkepp + " skepp, varav ");
		System.out.println(antalBoats + " B�tar");
		System.out.println(antalShips + " Skepp");
		System.out.println(antalCruisers + " Kryssare");
		System.out.println(antalBattleships + " Slagskepp");
		
		if (utplacerad = true)
			System.out.println("Skeppen �r utplacerade");
		else
			System.out.println("Skeppen �r inte utplacerade");
	}*/
}
