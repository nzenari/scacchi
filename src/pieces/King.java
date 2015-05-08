package pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Implementa il re.
 * <p>Si muove in tutte le celle che ha a distanza 1.
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */
public class King extends Pieces {
	
	/**
	 * Costruttore della classe.
	 * <p>Richiama il costruttore di Pieces.
	 * @param colour Il colore del pezzo.
	 */
	public King(Colour colour) {
		super(colour);
	}
	
	/**
	 * Ritorna tutte le caselle su cui può muoversi un pezzo senza fare controlli sugli altri pezzi della scacchiera.
	 * <p>L'ArrayList contiene l'insieme delle coordinate che fanno parte del percorso di un pezzo.
	 * @param c Coordinata in cui si trova il pezzo.
	 * @return L'ArrayList delle coordinate di tutti i percorsi possibili.
	 */
	public ArrayList<Coordinates> validPositions(Coordinates c) {
		ArrayList<Coordinates> temp = new ArrayList<Coordinates>();
		
		int x = c.getX();
		int y = c.getY();
		
		for ( int i = x - 1; i <= x + 1; i++ )
			for ( int j = y - 1; j <= y + 1; j++ ){
				if ( i >= 0 && j >= 0 && i < 8 && j < 8)
					temp.add(new Coordinates(i, j));
			}
		
		temp.remove(c);
		
		return temp;
	}

	/**
	 * Ritorna true se il pezzo this equivale al pezzo other.
	 * @param other Un pezzo
	 * @return true se il pezzo this equivale al pezzo other.
	 */
	@Override
	public boolean equals(Pieces other) {
		return other instanceof King && ((King)other).getColour().equals(getColour());
	}
	
	/**
	 * Ritorna l'immagine associata al pezzo.
	 * @return Ritorna l'ImageIcon associata al pezzo.
	 */
	@Override
	public ImageIcon getImage() {
		return new ImageIcon(getColour().equals(Colour.WHITE) ? "img/whiteKing.png" : "img/blackKing.png");
	}
}
