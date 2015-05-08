package pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Implementa la torre.
 * <p>Si muove in orizzontale e in verticale.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */

public class Rook extends Pieces {
	
	/**
	 * Costruttore della classe.
	 * <p>Richiama il costruttore di Pieces.
	 * @param colour Il colore del pezzo.
	 */
	public Rook(Colour colour) {
		super(colour);
	}
	
	/**
	 * Ritorna tutte le caselle su cui può muoversi un pezzo senza fare controlli sugli altri pezzi della scacchiera.
	 * <p>L'ArrayList contiene l'insieme delle coordinate che fanno parte del percorso di un pezzo.
	 * @param c Coordinata in cui si trova il pezzo.
	 * @return L'ArrayList delle coordinate di tutti i percorsi possibili.
	 */
	public ArrayList<Coordinates> validPositions(Coordinates c){
		ArrayList<Coordinates> result = new ArrayList<>();
		int i;
		int x = c.getX();
		int y = c.getY();
		
		//riempiamo la riga
		for ( i=0; i<8; i++)
			if (i != y)
				result.add(new Coordinates(x, i));

		//riempiamo la colonna
		for ( i=0; i<8; i++ )
			if (i != x)
				result.add(new Coordinates(i, y));

		return result;
	}
	
	/**
	 * Ritorna true se il pezzo this equivale al pezzo other.
	 * @param other Un pezzo.
	 * @return true se il pezzo this equivale al pezzo other.
	 */
	@Override
	public boolean equals(Pieces other) {
		return other instanceof Rook && ((Rook)other).getColour().equals(getColour());
	}
	
	/**
	 * Ritorna l'immagine associata al pezzo.
	 * @return Ritorna l'ImageIcon associata al pezzo.
	 */
	@Override
	public ImageIcon getImage() {
		return new ImageIcon(getColour().equals(Colour.WHITE) ? "img/whiteRook.png" : "img/blackRook.png");
	}
}
