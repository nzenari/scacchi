package pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * Implementa il cavallo.
 * <p>Si muove a "L".
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */
public class Knight extends Pieces {
	/**
	 * Matrice che contiene le coppie delle posizioni raggiungibili dal cavallo partendo da una posizione ideale.
	 * Vengono sommate alle coordinate.
	 */
	private static final int[][] pos = { {0,0}, {-1,2}, {1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1} };
	
	/**
	 * Costruttore della classe.
	 * <p>Richiama il costruttore di Pieces.
	 * @param colour Il colore del pezzo.
	 */
	public Knight(Colour colour) {
		super(colour);
	}
	
	/**
	 * Ritorna tutte le caselle su cui può muoversi un pezzo senza fare controlli sugli altri pezzi della scacchiera.
	 * <p>L'ArrayList contiene l'insieme delle coordinate che fanno parte del percorso di un pezzo.
	 * @param c Coordinata in cui si trova il pezzo.
	 * @return L'ArrayList delle coordinate di tutti i percorsi possibili.
	 */
	public ArrayList<Coordinates> validPositions(Coordinates c){
		ArrayList<Coordinates> temp = new ArrayList<>();
		
		int x = c.getX();
		int y = c.getY();
		
		for ( int i=0; i<9; i++ )
			if ( ( (x+pos[i][0])>=0 && (x+pos[i][0])<8 ) && ((y+pos[i][1])>=0 && (y+pos[i][1])<8)  )
				temp.add(new Coordinates(x + pos[i][0], y + pos[i][1]));
		
		temp.remove(c);
		
		return temp;
	}
	
	/**
	 * Ritorna true se il pezzo this equivale al pezzo other.
	 * @param other Un pezzo.
	 * @return true se il pezzo this equivale al pezzo other.
	 */
	@Override
	public boolean equals(Pieces other) {
		return other instanceof Knight && ((Knight)other).getColour().equals(getColour());
	}
	
	/**
	 * Ritorna l'immagine associata al pezzo.
	 * @return Ritorna l'ImageIcon associata al pezzo.
	 */
	@Override
	public ImageIcon getImage() {
		return new ImageIcon(getColour().equals(Colour.WHITE) ? "img/whiteKnight.png" : "img/blackKnight.png");
	}
}
