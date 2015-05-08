package pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Implementa il pedone.
 * <p>Si muove solo verso l'avversario di una posizione verticale. Mangia in diagonale.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */

public class Pawn extends Pieces {
	/**
	 * Quando è true significa che non è arrivato alla fine della scacchiera.
	 * Se arriva alla fine della scacchiera e non sono stati mangiati pezzi al giocatore 
	 * viene impostato a false e non viene più considerato.
	 */
	private boolean pawnSwap;
	
	/**
	 * Costruttore della classe.
	 * <p>Richiama il costruttore di Pieces.
	 * @param colour Il colore del pezzo.
	 */
	public Pawn(Colour colour) {
		super(colour);
		pawnSwap = true;
	}
	
	/**
	 * Ritorna tutte le caselle su cui può muoversi un pezzo senza fare controlli sugli altri pezzi della scacchiera.
	 * <p>L'ArrayList contiene l'insieme delle coordinate che fanno parte del percorso di un pezzo.
	 * @param c Coordinata in cui si trova il pezzo.
	 * @return L'ArrayList delle coordinate di tutti i percorsi possibili.
	 */
	public ArrayList<Coordinates> validPositions(Coordinates c) {
		ArrayList<Coordinates> result = new ArrayList<>();
		int x = c.getX();
		int y = c.getY();
		
		Colour colour =getColour();
		
		// evitiamo uscita dalla matrice
		if ( colour.equals(Colour.WHITE) && (x == 0) )
			return result;
		if ( colour.equals(Colour.BLACK) && (x == 7) )
			return result;
				
		if ( colour == Colour.WHITE ){
			result.add(new Coordinates(x-1, y));
			if ( y != 0 )
				result.add(new Coordinates(x-1, y-1));
			if ( y != 7 )
				result.add(new Coordinates(x-1, y+1));		
		}
		
		if ( colour == Colour.BLACK ){
			result.add(new Coordinates(x+1, y));
			if ( y != 0 )
				result.add(new Coordinates(x+1, y-1));
			if ( y != 7 )
				result.add(new Coordinates(x+1, y+1));
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
		return other instanceof Pawn && ((Pawn)other).getColour().equals(getColour());
	}
	
	/**
	 * Ritorna l'immagine associata al pezzo.
	 * @return Ritorna l'ImageIcon associata al pezzo.
	 */
	@Override
	public ImageIcon getImage() {
		return new ImageIcon(getColour().equals(Colour.WHITE) ? "img/whitePawn.png" : "img/blackPawn.png");
	}
	
	/**
	 * Ritorna lo stato del pedone.
	 * @return true se il pedone non è arrivato alla fine della scacchiera.
	 */
	public boolean getPawnSwap(){
		return pawnSwap;
	}

	/**
	 * Imposta a false la variabile pawnSwap
	 */
	public void setPawnSwap(){
		pawnSwap = false;
	}
}
