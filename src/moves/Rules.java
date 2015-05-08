package moves;

import java.util.ArrayList;
import pieces.Colour;
import pieces.Coordinates;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Pieces;
import model.ChessboardMatrix;
/**
 * Classe che implementa le regole degli scacchi attraverso metodi
 * che controllano i movimenti dei pezzi e lo stato del gioco.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */

public class Rules {
	private ChessboardMatrix chessboard;
	private static Colour winner;
	
	/**
	 * Il costruttore della classe.
	 * @param chessboard La scacchiera.
	 */
	public Rules(ChessboardMatrix chessboard) {
		this.chessboard = chessboard;
	}
	
	/**
	 * Ritorna una nuova scacchiera con la mossa se quest'ultima è valida.
	 * @param from Coordinata di partenza.
	 * @param to Coordinata di arrivo.
	 * @return Ritorna una nuova scacchiera con la mossa se quest'ultima è valida.
	 */
	public ChessboardMatrix nextMove(Coordinates from, Coordinates to) {
		if ( checkMove(from, to) ) {
			chessboard.setTurn();
			return chessboard.move(from, to);
		}
		
		return chessboard;
	}
	
	/**
	 * Ritorna true se il re è in scacco.
	 * <p>Controlla tutte le pedine dell'avversario per vedere se c'è scacco.
	 * @return Ritorna true se il re è in scacco.
	 */
	public boolean kingOnCheck() {
		return KingOnCheckAux(chessboard.getEnemyPieces(), chessboard.getTurnKing()) || KingOnCheckAux(chessboard.getTurnPieces(),chessboard.getEnemyKing());
	}
	
	private boolean KingOnCheckAux(ArrayList<Coordinates> coordinatesPieces, Coordinates king) {
		for ( Coordinates c : coordinatesPieces )
			//Se la mossa è possibile ha vinto il giocatore di colore delle coordinatePiseces
			if ( checkMove(c, king) ){
				winner = chessboard.at(c).getColour();
				return true;
			}
		
		//Se nessuna pedina può mangiare il RE
		return false;
	}
		
	/**
	 * Ritorna l'insieme delle coordinate delle pedine che impediscono lo scacco matto.
	 * @param c Una coordinata
	 * @return Ritorna l'ArrayList delle coordinate delle pedine che impediscono lo scacco matto.
	 */
	public ArrayList<Coordinates> getSafetyPositions(Coordinates c){
		if (chessboard.at(c) instanceof King)
			return getKingSafetyPositions();		
		
		return getHeroesPositions();
	}
	
		
	/**
	 * Ritorna l'insieme delle posizioni valide per il re in scacco.
	 * @return Ritorna l'ArrayList delle posizioni valide per il re in scacco.
	 */
	public ArrayList<Coordinates> getKingSafetyPositions (){		
		ArrayList<Coordinates> result = new ArrayList<>();
		Coordinates king = chessboard.getTurnKing();
		
		for ( Coordinates c : chessboard.at(king).validPositions(king) ){	
					
			if ( checkMove(king, c) ) {
				
				Rules temp = new Rules(chessboard.move(king, c));

				if (!temp.kingOnCheck()){
					result.add(c);
				}
				
			}
			
		}
		
		return result;
	}
	
	/**
	 * Ritorna l'insieme delle posizioni in cui i pezzi si possono spostare per uscire dallo 
	 * stato di scacco.
	 * <p>
	 * @return Ritorna l'ArrayList delle posizioni in cui i pezzi si possono spostare per uscire dallo stato di scacco.
	 */
	/*
	 * Funzione che ritorna le posizioni in cui un pezzo si puo' spostare per
	 * ostacolare l'avversario.
	 * Funzionamento:
	 * 1) ottiene le posizioni di tutte le pedine del giocatore
	 * 2) ottiene le pedine dell'avversario che hanno messo in scacco il re
	 * 3) per ogni "minaccia" calcola il path fino alla posizione del re
	 * 4) per ogni pezzo del giocatore, se non e' re, controlla se puo' ostacolare
	 *    la minaccia: se puo' lo aggiunge all'arraylist da restituire.
	 */
	public ArrayList<Coordinates> getHeroesPositions (){
		ArrayList<Coordinates> path = new ArrayList<>();
		ArrayList<Coordinates> coordinatePieces = chessboard.getTurnPieces();
		ArrayList<Coordinates> threats = getThreats();

		for ( Coordinates c : threats ){
			path.add(c); //aggiungo la posizione dell'avversario
			if ( !(chessboard.at(c) instanceof Knight) )
				path.addAll(chessboard.at(c).getPath(c, chessboard.getTurnKing())); //tutte le posizione in cui può andare
		}
		
		ArrayList<Coordinates> result = new ArrayList<>();
			for ( Coordinates c : coordinatePieces )
				for ( Coordinates to : path)
					if ( !(chessboard.at(c) instanceof King) &&  checkMove(c, to) )
						result.add(to);
		return result;
	}
	
	/*
	 * Funzione privata che ritorna le posizioni delle pedine dell'avversario che
	 * mettono in scacco il giocatore
	 */
	private ArrayList<Coordinates> getThreats() {
		ArrayList<Coordinates> result = new ArrayList<>();
		ArrayList<Coordinates> adversary = chessboard.getEnemyPieces();
		Coordinates king = null;
		king = chessboard.getTurnKing();
				
		for (Coordinates c : adversary ){
			if ( checkMove(c, king) ){
				result.add(c);
			}
		}
		
		return result;
	}
	
	/**
	 * Verifica se è possibile effettura lo spostamento della pedina presente nella posizione "from" alla posizione "to".
	 * <p>Inoltre questa verifica che lo spostamento non ci metta in una situazione di scacco/scacco matto a proprio svantaggio
	 * @param from Posizione della pedina da spostare
	 * @param to Posizione nella quale spostare la pedina "from"
	 * @return Ritorna se lo spostamento è possibile o meno
	 */
	
	public boolean checkMove(Coordinates from, Coordinates to) {
		Pieces p = chessboard.at(from);
		
		if( !checkMoveBase(p,from,to) )
			return false;
		
		Rules r = new Rules(chessboard.move(from, to));
		
		if( p instanceof King ){
			return checkMoveKing(r,to); //se era un Re la pedina p il checkmove si ferma qui
		}
		//pedine eccetto il RE
		return checkMoveOthers(p,from,to) && (!r.KingOnCheckAux(chessboard.getEnemyPieces(), chessboard.getTurnKing()));
	}
	
	//controlli base validi per tutti i tipi di pedine
	private boolean checkMoveBase(Pieces piece, Coordinates from, Coordinates to) {
		//seleziono una posizione senza pedina
		if ( piece == null )
			return false;

		//se la posizione tu non è contenuta nelle soluzioni valide della pedina from
		if ( !piece.validPositions(from).contains(to) )
			return false;

		//se la posizione di destinazione contiene una pedina dello stesso colore
		return !( chessboard.at(to) != null && chessboard.at(to).getColour().equals(piece.getColour()));
	}
	
	//sse la pedina è un RE
	private boolean checkMoveKing(Rules r, Coordinates to) {
		/*
		 * Il King NON si può spostare in to se:
		 * -la posizione to non è valida oppure è già occupata da una pedina dello stesso colore(controllato dalla checkMoveBase)
		 * -se lo spostamento nella posizione to va a creare una situazione di scacco(implementato qui sotto)
		 */
		for(Coordinates c : r.chessboard.getEnemyPieces()){
			if(chessboard.at(c) instanceof King) {
				if(chessboard.at(c).validPositions(c).contains(to))
					return false;
			}	
			else
				if(r.checkMove(c,to))
					return false;		
		}
		return true;
		
	}
	
	//checkMove pedine eccetto RE
	private boolean checkMoveOthers(Pieces piece, Coordinates from, Coordinates to) {
				
		/* 
		 *il pedone: 
		 * -può andare dritto sse davanti a se non ha pedine
		 * -può andare obliquo sse in quelle posizioni ha una pedina avversaria da mangiare
		 * 
		 */
		if (piece instanceof Pawn) {
			if (from.getY() == to.getY()) {
				if(chessboard.at(to) == null)
					return true;
				else
					return false;
			}
			else
			{
				if(chessboard.at(to) == null) {
					return false;
				}
				else
					return true;
			}
		}
		
		//il cavallo salta le pedine nel mezzo
		if (piece instanceof Knight)
			return true;
		
		//Oltre non andranno il: cavallo, il re ed il pedone.
		/*
		 *Calcolo le posizioni che intercorrono tra il from ed il to escluse 
		 *ed per ogni posizione verifico se è vuota
		 *-se in almeno una posizione c'è una pedina(non importa il colore), la mossa non è valida
		 *-altrimenti, la strada è spianata quindi posso effettuare lo spostamento 
		 */
		ArrayList<Coordinates> path = piece.getPath(from, to);
		for (Coordinates coordinate : path) {
			if ( chessboard.at(coordinate) != null ){
				return false;
			}
		}

		return true;
	}
	
	// serve per vedere se un pedone è sopravvissuto fino al capolinea
	// Se l'array list dei miei pezzi mangiati e' vuoto, allora non viene visualizzata la finestra
	/**
	 * Verifica se un pedone è arrivato dall'altra parte della scacchiera.
	 * <p>Ritorna true solo se sono stati mangiati dei pezzi perché un pedone può essere promosso se ci sono dei pezzi mangiati 
	 * (eccetto i pedoni) da sostituire con il pedone.
	 * @param to Coordinata della scacchiera.
	 * @return true se il pedone deve essere scambiato (quindi sono stati mangiati pezzi al giocatore), altrimenti false.
	 */
	public boolean pawnTrip(Coordinates to) {
	
		if ( chessboard.at(to) instanceof Pawn && (to.getX() == 7 || to.getX() == 0) ){
			if ( chessboard.at(to).getColour().equals(Colour.BLACK) ? chessboard.getBlackLostPieces().isEmpty() : chessboard.getWhiteLostPieces().isEmpty() ){
				((Pawn)chessboard.at(to)).setPawnSwap();
				return false;
			}
		
			return ((Pawn)chessboard.at(to)).getPawnSwap();
				
		}
		return false;
	}
	
	/**
	 * Ritorna il colore del giocatore vincitore.
	 * @return Ritorna il colore del giocatore vincitore.
	 */
	public Colour getWinner(){
		return winner;
	}
	
}


