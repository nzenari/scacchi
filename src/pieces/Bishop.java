package pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Implementa l'alfiere.
 * <p>Si muove in diagonale.
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */
public class Bishop extends Pieces {
	
	/**
	 * Costruttore della classe.
	 * <p>Richiama il costruttore di Pieces.
	 * @param colour Il colore del pezzo.
	 */
	public Bishop(Colour colour) {
		super(colour);
	}
	
	/**
	 * Ritorna tutte le caselle su cui può muoversi un pezzo senza fare controlli sugli altri pezzi della scacchiera.
	 * <p>L'ArrayList contiene l'insieme delle coordinate che fanno parte del percorso di un pezzo.
	 * @param c Coordinata in cui si trova il pezzo.
	 * @return L'ArrayList delle coordinate di tutti i percorsi possibili.
	 */
	public ArrayList<Coordinates> validPositions(Coordinates c){
		ArrayList<Coordinates> result = new ArrayList<Coordinates>();
		int i, j;
		int x = c.getX();
		int y = c.getY();
		
		//alto destra
		for ( i = x - 1, j = y + 1; (i>=0 && j<8); ){
			result.add(new Coordinates(i--, j++));
		}
		
		//alto sinistra
		for ( i = x - 1, j = y - 1; (i>=0 && j>=0); ){
			result.add(new Coordinates(i--, j--));
		}

		//basso destra
		for ( i = x + 1, j = y + 1; (i<8 && j<8); ){
			result.add(new Coordinates(i++, j++));
		}

		//basso sinistra
		for ( i = x + 1, j = y - 1; (i<8 && j>=0); ){
			result.add(new Coordinates(i++, j--));
		}
		
		return result;
	}
	
	/**
	 * Ritorna true se il pezzo this equivale al pezzo other.
	 * @param other Un pezzo.
	 * @return true se il pezzo this equivale al pezzo other.
	 */
	@Override
	public boolean equals(Pieces other) {
		return other instanceof Bishop && ((Bishop)other).getColour().equals(getColour());
	}
	
	/**
	 * Ritorna l'immagine associata al pezzo.
	 * @return Ritorna l'ImageIcon associata al pezzo.
	 */
	@Override
	public ImageIcon getImage() {
		return new ImageIcon(getColour().equals(Colour.WHITE) ? "img/whiteBishop.png" : "img/blackBishop.png");
	}
}
