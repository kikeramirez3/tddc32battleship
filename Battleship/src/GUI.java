import javax.swing.*;
import java.awt.*;

public class GUI {

	//Parametrar
	
	//Ram
	//MenyRam
	private JButton startKnapp;
	private JButton avslutaKnapp;
	private JButton nyttSpelKnapp; //(anropar konstruktorn till Spelkontroll)
	private JButton anslutTillSpelKnapp; //(anropar konstruktorn till Spelkontroll)
	private JTextField statusF�lt;
	
	
	//SpelRam
	private JTextField dinTurSkylt;
	
	//ChatRam
	private JButton chattKnapp;
	private JTextField chattf�lt;
	
	//2 Rutn�t (skapas utifr�n objekt av klassen rutn�t)
	
	
		
	//konstruktor
	public GUI(){	}
	
	//Metoder
	public void ritaSkepp(){}
	
	public void ritaBomb(){}

	public void s�ttTr�ff(){}
	
	//Metoder direkt fr�n knappar
	//anropar 1:a konstruktorn i n�tverkshanteraren
	public void nyttSpel() {}
	
	//anropar 2:a konstruktorn i n�tverkshanteraren. Statusf�ltet m�ste visa att det finns ett spel att ansluta till
	public void anslutTillSpel(){}
	
	
	
}
