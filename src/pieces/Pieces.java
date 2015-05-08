package pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Classe astratta che implementa i pezzi del gioco degli scacchi.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */
public abstract class Pieces {
	/**
	 * Il colore del pezzo.
	 */
	private Colour colour;
	
	/**
	 * Costruttore della classe.
	 * @param colour Il colore del pezzo.
	 */
	public Pieces(Colour colour){
		this.colour = colour;
	}
	
	/**
	 * Ritorna il colore del pezzo.
	 * @return Il colore del pezzo.
	 */
	public Colour getColour() {
		return colour;
	}
	
	/**
	 * Ritorna l'immagine associata al pezzo.
	 * @return Ritorna l'ImageIcon associata al pezzo.
	 */
	public abstract ImageIcon getImage();
	
	/**
	 * Ritorna tutte le caselle su cui può muoversi un pezzo senza fare controlli sugli altri pezzi della scacchiera.
	 * <p>L'ArrayList contiene l'insieme delle coordinate che fanno parte del percorso di un pezzo.
	 * @param c Coordinata in cui si trova il pezzo.
	 * @return L'ArrayList delle coordinate di tutti i percorsi possibili.
	 */
	public abstract ArrayList<Coordinates> validPositions(Coordinates c);
	
	/**
	 * Ritorna le coordinate tra le posizioni from e to escluse.
	 * WARNING: questo metodo non dovrà mai essere chiamato da una pedina di tipo cavallo,
	 * in quando un suo percorso non avrebbe un significato corretto, in quanto questa da regolamento salta le 
	 * pedine nel mezzo.
	 * 
	 * @param from Coordinata di partenza.
	 * @param to Coordinata di arrivo.
	 * @return ArrayList contenente le posizioni tra la poszione from e to esclusi 
	 */
	public ArrayList<Coordinates> getPath(Coordinates from, Coordinates to) {
				
		int fromX = from.getX();
		int fromY = from.getY();
		int toX = to.getX();
		int toY = to.getY();
		
		int verticalOffset = toX - fromX;	
		int orizzontalOffset = toY - fromY;
		
		ArrayList<Coordinates> result = new ArrayList<>();
		
		while(fromX!=toX || fromY!=toY) {
			
			if (verticalOffset == 0) { //se iteriamo sulla stessa riga
				result.add(new Coordinates(fromX, orizzontalOffset > 0 ? ++fromY : --fromY));
			}
			else if (orizzontalOffset == 0) //se stiamo sulla stessa colonna
				result.add(new Coordinates(verticalOffset > 0 ? ++fromX : --fromX, fromY));
			else //se andiamo obliqui
				result.add(new Coordinates(verticalOffset > 0 ? ++fromX : --fromX, orizzontalOffset > 0 ? ++fromY : --fromY));
		
		}
		
		result.remove(result.size()-1); //togliamo dall'ArrayList l'ultima posizione inserita ovvero la posizione to
		
		return result;
	}
	
	/**
	 * Ritorna true se il pezzo this equivale al pezzo other.
	 * @param other Un pezzo.
	 * @return true se il pezzo this equivale al pezzo other.
	 */
	public abstract boolean equals(Pieces other);
}
