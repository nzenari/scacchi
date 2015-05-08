package controller;

import pieces.Coordinates;
import pieces.Pieces;

/**
 * L'interfaccia Controller contiene le dichiarazioni dei metodi
 * utilizzati per gestire l'interazione tra l'utente e le strutture
 * della scacchiera.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */
public interface Controller {
	/**
	 * Gestisce i cambiamenti di stato dovuti alla generazione di un nuovo gioco.
	 */
	void newGame();
	
	/**
	 * Gestisce i cambiamenti di stato dovuti all'interazione dell'utente con le caselle della scacchiera.
	 * @param c Le coordinate del bottone premuto.
	 */
	void onClick(Coordinates c);

	/**
	 * Gestisce i cambiamenti di stato dovuti alla promozione di un pedone.
	 * @param piece Il pezzo da sostituire al pedone.
	 */
	void promotion(Pieces piece);

}
