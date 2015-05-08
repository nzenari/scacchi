package model;

import pieces.Coordinates;
import pieces.Pieces;
import view.View;

/**
 * Classe che implementa il modello.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */
public class SquaresModel implements Model {
	private ChessboardMatrix chessboard;
	private View view;
	
	/**
	 * Il costruttore della classe.
	 * @param chessboard La scacchiera.
	 */
	public SquaresModel(ChessboardMatrix chessboard) {
		this.chessboard = chessboard;
	}
	
	/**
	 * Restituisce il pezzo che si trova in una certa coordinata sulla scacchiera.
	 * 
	 * @param c Coordinata da cercare sulla scacchiera.
	 * @return Restituisce il pezzo che si trova in una certa coordinata sulla scacchiera. 
	 */
	@Override
	public Pieces at(Coordinates c) {
		return chessboard.at(c);
	}

	/**
	 * Restituisce la scacchiera attuale.
	 * @return Restituisce la scacchiera attuale.
	 */
	@Override
	public ChessboardMatrix getChessboard() {
		return chessboard;
	}

	/**
	 * Cambia la scacchiera attuale nel modello e nella vista.
	 * @param chessboard La scacchiera che verrà memorizzata e mostrata.
	 */
	@Override
	public void setChessboard(ChessboardMatrix chessboard) {
		/*
		 * Se la scacchiera che viene passata è diversa da quella attuale
		 * la sostituisce e cambia la vista.
		 */
		if (!(this.chessboard.equals(chessboard))) {
			this.chessboard = chessboard;
			if (view != null)
				view.onChessboardChange();
		}
	}
	
	/**
	 * Imposta la vista.
	 * @param view la nuova vista.
	 */
	@Override
	public void setView(View view) {
		this.view = view;
	}
	
}
