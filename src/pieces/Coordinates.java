package pieces;

/**
 * Implementa le coordinate.
 * <p>Vengono utilizzati due interi per memorizzare la x e la y di una casella sulla scacchiera.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */
public class Coordinates {
	private final int x;
	private final int y;
	
	/**
	 * Costruttore della classe.
	 * <p>Crea un'istanza utilizzando due interi.
	 * @param x Ascissa.
	 * @param y Ordinata.
	 */
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Costruttore della classe.
	 * <p>Crea una copia dell'istanza passata come parametro.
	 * @param a Coordinata
	 */
	public Coordinates(Coordinates a) {
		this.x = a.getX();
		this.y = a.getY();
	}
	
	/**
	 * Ritorna x.
	 * @return Ritorna x.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Ritorna y.
	 * @return Ritorna y.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Ritorna true se this equivale ad other.
	 * @return True se this equivale ad other.
	 */
	public boolean equals(Object other) {
		if (other instanceof Coordinates) {
			Coordinates temp = (Coordinates) other;
			if (temp.getX() == x && temp.getY() == y)
				return true;
		}	
		return false;
	}
}
