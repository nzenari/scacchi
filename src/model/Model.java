package model;

import pieces.Coordinates;
import pieces.Pieces;
import view.View;

/**
 * L'interfaccia del modello. Gestisce le strutture dati della scacchiera.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */
public interface Model {
	
	
	// Metodi per ottenere lo stato.
	 
	/**
	 * Restituisce il pezzo che si trova in una certa coordinata sulla scacchiera.
	 * 
	 * @param c Coordinata da cercare sulla scacchiera.
	 * @return Restituisce il pezzo che si trova in una certa coordinata sulla scacchiera. 
	 */
	Pieces at(Coordinates c);
	
	/**
	 * Restituisce la scacchiera attuale.
	 * @return Restituisce la scacchiera attuale.
	 */
	ChessboardMatrix getChessboard();
	
	// Metodi per cambiare lo stato.
	
	/**
	 * Cambia la scacchiera attuale nel modello e nella vista.
	 * @param chessboard La scacchiera che verrà memorizzata e mostrata.
	 */
	void setChessboard(ChessboardMatrix chessboard);
	
	/**
	 * Imposta la vista.
	 * @param listener la nuova vista.
	 */
	void setView(View listener);
}
