import ships.Ship;


public class Grid {
	
	private Cell[][] spelplan;
	private GridGUI gui;
	private Game spelkontroll;
	
	public Grid(int rows, int cols, Game ga, GridGUI g){
		spelkontroll = ga;
		gui = g;
		
		spelplan = new Cell[rows][cols];

		for(int row = 0; row<rows; row++)
			for(int col = 0; col<cols; col++){
				spelplan[row][col] = new Cell();
			}
		for(int row = 0; row<rows; row++)
			for(int col = 0; col<cols; col++){
				spelplan[row][col].addGUI(gui.getCellGUI(row, col));
			}
	}
	
	
	//Metoder
	//Metoder som bearbetar rutn�t
	public void setShip (Ship ship, int X, int Y, int XX, int YY) throws BoatException{
		
		if (X == XX){
			if (YY < spelplan.length){
				for (int i = Y; i <= YY; i++){
					if (spelplan[X][i].hasShip())
						throw new BoatException("Plats upptagen");
				}
				for(int i = Y; i <= YY; i++){
		//			spelplan[X][i].setShip(ship);
				}
			}
			else
				throw new BoatException("g�tt utanf�r rutn�tet");
		}
		
		if (Y == YY){
			if (XX < spelplan.length){
				for (int i = X; i <= XX; i++){
					if (spelplan[i][Y].hasShip())
						throw new BoatException("Plats upptagen");
				}
				for(int i = X; i <= XX; i++){
					spelplan[i][Y].setShip(ship);
				}
			}
			else
				throw new BoatException("g�tt utanf�r rutn�tet");
		}
		
		
	}
	
	
	//Metoder som bearbetar en cell
	/**
	 * korX st�r f�r rad och korY st�r f�r kolumn. F�rsta raden �r rad 0 och 
	 * kolumnen �r kolumn 0.
	 * @param korX
	 * @param korY
	 */
	public void bomba(int korX, int korY){
		//player.setBomb(korX, korY);
		
		spelplan[korX][korY].setBomb();
	}
	
	
	
	//Metoder som ger information
	public Cell getCell(int korX, int korY){
		return spelplan[korX][korY];
	}
	

	
	
	
//	public Ship getShip(String ID){	
//		return 
//	}
}
