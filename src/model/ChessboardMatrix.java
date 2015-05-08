package model;

import java.util.ArrayList;
import pieces.*;
/**
 * Classe che implementa la struttura logica della scacchiera.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */

public class ChessboardMatrix {
	/**
	 * Matrice di pezzi. Contiene la configurazione della scacchiera.
	 */
	private final Pieces[][] matrix;
	/**
	 * ArrayList contenente i pezzi bianchi mangiati.
	 */
	private final ArrayList<Pieces> whiteLostPieces;
	/**
	 * ArrayList contenente i pezzi neri mangiati.
	 */
	private final ArrayList<Pieces> blackLostPieces;
	/**
	 * Coordinate del re bianco.
	 */
	private final Coordinates whiteKing;
	/**
	 * Coordinate del re nero.
	 */
	private final Coordinates blackKing;
	/**
	 * Colore del turno. Indica il turno e viene modificato durante la partita.
	 */
	private static Colour turn;
	
	/**
	 * Costruttore della classe.
	 * Genera una scacchiera inserendo i pezzi nelle posizioni di partenza.
	 */
	public ChessboardMatrix() {
		this.matrix = new Pieces[8][8];
		
		otherPieces(0, Colour.BLACK);
		pawns(1, Colour.BLACK);
		
		pawns(6, Colour.WHITE);
		otherPieces(7, Colour.WHITE);
		
		this.whiteLostPieces = new ArrayList<Pieces>();
		this.blackLostPieces = new ArrayList<Pieces>();
		
		this.blackKing = new Coordinates(0, 4);
		this.whiteKing = new Coordinates(7, 4);
		ChessboardMatrix.turn = Colour.WHITE;
		
	}
	
	/*
	 * Riempie una riga della matrice con pedoni di un colore dato in input.
	 */
	private void pawns(int row, Colour colour) {
		for( int i = 0; i < 8; i++) {
			matrix[row][i] = new Pawn(colour);
		}
	}
	
	/*
	 * Inserisci tutti gli altri pezzi, che non sono pedoni, del colore dato in input.
	 */
	private void otherPieces(int row, Colour colour) {
		int i = 0;
		
		matrix[row][i++] = new Rook(colour);
		matrix[row][i++] = new Knight(colour);
		matrix[row][i++] = new Bishop(colour);
		matrix[row][i++] = new Queen(colour);
		matrix[row][i++] = new King(colour);
		matrix[row][i++] = new Bishop(colour);
		matrix[row][i++] = new Knight(colour);
		matrix[row][i++] = new Rook(colour);
	}
	
	/*
	 * Costruttore privato che crea una scacchiera.
	 */
	private ChessboardMatrix(Pieces[][] matrix, ArrayList<Pieces> whiteLostPieces, ArrayList<Pieces> blackLostPieces, 
			Coordinates whiteKing, Coordinates blackKing) {
		
		this.matrix = new Pieces[8][];
		
		for( int i = 0; i < 8; i++) {
			this.matrix[i] = matrix[i].clone();
		}
		
		this.whiteLostPieces = new ArrayList<Pieces>(whiteLostPieces);
		this.blackLostPieces = new ArrayList<Pieces>(blackLostPieces);
		
		this.whiteKing = new Coordinates(whiteKing);
		this.blackKing = new Coordinates(blackKing);
	}
	
	/**
	 * Restituisce il pezzo che si trova in una certa coordinata sulla scacchiera.
	 * 
	 * @param c Coordinata da cercare sulla scacchiera.
	 * @return Restituisce il pezzo che si trova in una certa coordinata sulla scacchiera. 
	 */
	
	public Pieces at(Coordinates c) {
		return matrix[c.getX()][c.getY()];
	}

	/**
	 * Muove un pezzo sulla scacchiera.
	 * 
	 * @param from Coordinata di partenza.
	 * @param to Coordinata di arrivo.
	 * @return Una scacchiera con un pezzo spostato.
	 */
	
	public ChessboardMatrix move(Coordinates from, Coordinates to) {
		int fromX = from.getX();
		int fromY = from.getY();
		int toX = to.getX();
		int toY = to.getY();
		
		Pieces temp = matrix[fromX][fromY];
		
		ChessboardMatrix result = null;
		
		/*
		 * Se il pezzo da muovere è un re va a creare una nuova istanza modificando le coordinate del re.
		 * Altrimenti crea una nuova istanza senza modificare i campi.
		 */
		if ( temp instanceof King ) {
			if ( temp.getColour().equals(Colour.WHITE) )
				result = new ChessboardMatrix(matrix, whiteLostPieces, blackLostPieces, new Coordinates(to), blackKing);
			else
				result = new ChessboardMatrix(matrix, whiteLostPieces, blackLostPieces, whiteKing, new Coordinates(to));
		}
		else
			result = new ChessboardMatrix(matrix, whiteLostPieces, blackLostPieces, whiteKing, blackKing);
		
		/*
		 * La posizione di partenza sarà vuota.
		 */
		result.matrix[fromX][fromY] = null;
		
		/*
		 * Se vi è un pezzo nella posizione di arrivo lo rimuove dalla scacchiera e lo aggiunge
	 	 * nell'ArrayList rispettivo secondo il colore.
		 */
		if( result.matrix[toX][toY] != null && !(result.matrix[toX][toY] instanceof Pawn)) {
			if( result.matrix[toX][toY].getColour() == Colour.WHITE) {
				result.whiteLostPieces.add(result.matrix[toX][toY]);
			}
			else {
				result.blackLostPieces.add(result.matrix[toX][toY]);
			}
		}
		result.matrix[toX][toY] = temp;
		
		return result;
	}
	
	/**
	 * Ritorna l'ArrayList contenente i pezzi neri che sono stati mangiati.
	 * 
	 * @return Ritorna l'ArrayList contenente i pezzi neri che sono stati mangiati.
	 */
	public ArrayList<Pieces> getBlackLostPieces() {
		return blackLostPieces;
	}
	
	/**
	 * Ritorna l'ArrayList contenente i pezzi bianchi che sono stati mangiati.
	 * 
	 * @return Ritorna l'ArrayList contenente i pezzi bianchi che sono stati mangiati.
	 */
	public ArrayList<Pieces> getWhiteLostPieces() {
		return whiteLostPieces;
	}
	
	/**
	 * Ritorna le coordinate del re il cui colore corrisponde al turno.
	 * 
	 * @return Ritorna le coordinate del re il cui colore corrisponde al turno.
	 */
	
	public Coordinates getTurnKing() {
		return turn.equals(Colour.WHITE) ? whiteKing : blackKing;		
	}
	
	/**
	 * Ritorna le coordinate del re il cui colore è opposto a quello del turno.
	 * 
	 * @return Ritorna le coordinate del re il cui colore è opposto a quello del turno.
	 */
	
	public Coordinates getEnemyKing() {
		return turn.equals(Colour.WHITE) ? blackKing : whiteKing;		
	}
	
	/**
	 * Ritorna l'ArrayList delle coordinate dei pezzi del colore corrispondente al turno.
	 * 
	 * @return Ritorna l'ArrayList delle coordinate dei pezzi del colore corrispondente al turno.
	 */
	
	public ArrayList<Coordinates> getTurnPieces(){
		return turn.equals( Colour.WHITE) ? getPiecesAux(Colour.WHITE) : getPiecesAux(Colour.BLACK);
	}
	
	/**
	 * Ritorna l'ArrayList delle coordinate dei pezzi del colore opposto al turno.
	 * 
	 * @return Ritorna l'ArrayList delle coordinate dei pezzi del colore opposto al turno.
	 */
	
	public ArrayList<Coordinates> getEnemyPieces(){
		return turn.equals( Colour.WHITE) ? getPiecesAux(Colour.BLACK) : getPiecesAux(Colour.WHITE);
	}
	
	/*
	 * Scorre tutta la scacchiera e ritorna un ArrayList di coordinate corrispondenti al colore dato come parametro
	 */
	private ArrayList<Coordinates> getPiecesAux(Colour colour) {
		ArrayList<Coordinates> result = new ArrayList<>();
		
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				if (matrix[i][j] != null && matrix[i][j].getColour().equals(colour))
					result.add(new Coordinates(i, j));
		
		return result;
	}
	
	/**
	 * Sostituisce un pedone con un pezzo proveniente dall'ArrayList dei pezzi mangiati in base al colore del pedone.
	 * 
	 * @param where Coordinata del pedone da sostituire.
	 * @param piece Pezzo da scambiare con il pedone.
	 * @return Una scacchiera con il pezzo scambiato.
	 */
	
	public ChessboardMatrix swap(Coordinates where, Pieces piece) {
		int fromX = where.getX();
		int fromY = where.getY();
		Pieces[][] temp = new Pieces[8][8];
		
		for( int i = 0; i < 8; i++) {
			temp[i] = matrix[i].clone();
		}
		
		temp[fromX][fromY] = piece;
		
		if ( piece.getColour().equals(Colour.WHITE)) {
			whiteLostPieces.remove(piece);
		}
		else {
			blackLostPieces.remove(piece);
		}
				
		return new ChessboardMatrix(temp, whiteLostPieces, blackLostPieces, whiteKing, blackKing);
	}
	
	/**
	 * Ritorna true se le due scacchiere sono uguali.
	 * 
	 * @param obj L'oggeto da confrontare.
	 * @return Ritorna true se le due scacchiere sono uguali.
	 */
	
	public boolean equals(Object obj) {
		if (obj instanceof ChessboardMatrix) {
			ChessboardMatrix temp = (ChessboardMatrix) obj;
			for (int i = 0; i < 8; i++)
				for (int j = 0; j < 8; j++) {
					if(matrix[i][j] != null ^ temp.at(new Coordinates(i,j)) != null)
						return false;
					if(matrix[i][j] != null && temp.at(new Coordinates(i, j)) != null && !(matrix[i][j].equals(temp.at(new Coordinates(i, j)))))
						return false;
				}
				
			if (!(whiteLostPieces.equals(temp.getWhiteLostPieces())) || !(blackLostPieces.equals(temp.getBlackLostPieces())))
				return false;
			
			return true;
		}
		return false;
	}

	/**
	 * Ritorna il turno.
	 * 
	 * @return Ritorna il turno.
	 */
	
	public Colour getTurn() {
		return turn;
	}

	/**
	 * Modifica il turno.
	 * <p>Se è nero diventa bianco e viceversa.
	 */
	
	public void setTurn() {
		turn = Colour.values()[(turn.ordinal() + 1) % 2];
	}

}
