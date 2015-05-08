package moves;

import java.util.ArrayList;
import pieces.Bishop;
import pieces.Coordinates;
import pieces.King;
import pieces.Knight;
import pieces.Pieces;
import model.ChessboardMatrix;
import model.Model;

/**
 * Gestisce l'interazione fra l'interfaccia grafica e la struttura dati.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */
public class Mover {
	/**
	 * Il modello.
	 */
	private Model model;
	/**
	 * Le coordinate della casella della pedina da spostare.
	 */
	private static Coordinates firstClick = null;
	/**
	 * Utilizzata per gestire se l'utente decide di muovere un'altro pezzo.
	 */
	private static boolean rethought = false;
	
	/**
	 * Costruttore della classe.
	 * <p>Ha bisogno del modello per applicarvi i cambiamenti causati dall'interazione
	 * dell'utente con l'interfaccia grafica.
	 * @param model Il modello.
	 */
	public Mover(Model model) {
		this.model = model;
	}
	
	/**
	 * Verifica se vi è scacco matto.
	 * @return Ritorna true se vi è scacco matto.
	 */
	public boolean checkMate() {
		Rules r = new Rules(model.getChessboard());
		return r.kingOnCheck() && r.getKingSafetyPositions().isEmpty() && r.getHeroesPositions().isEmpty();
	}
	
	/**
	 * Verifica se vi è scacco.
	 * @return Ritorna true se vi è scacco.
	 */
	public boolean check() {
		return (new Rules(model.getChessboard())).kingOnCheck();
	}
	
	/**
	 * Prepara la scacchiera per una nuova partita.
	 */
	public void reset() {
		model.setChessboard(new ChessboardMatrix());
	}

	/**
	 * Gestisce l'interazione dell'utente con la scacchiera.
	 * <p>Viene utilizzata la variabile statica firstClick per tenere una traccia "temporale"
	 * dei click dell'utente sulla scacchiera. 
	 * <p>Se il primo click ha come coordinata un pezzo e il secondo una posizione valida allora
	 * il pezzo verà spostato. Altrimenti non succede niente.
	 * @param c La coordinata del bottone premuto dall'utente.
	 */
	public void click(Coordinates c) {
		if ( firstClick == null ) {
			//se l'utente clicca un pezzo ed è del colore del turno si segna le coordinate del pezzo
			if ( model.at(c) != null && model.at(c).getColour().equals(model.getChessboard().getTurn())) {
				firstClick = c;
			}
		}
		else {
			//il giocatore ha cambiato idea sulla pedina da spostare
			if ( model.at(c) != null && model.at(c).getColour().equals(model.getChessboard().getTurn())) {
				firstClick = c;
				rethought = true;
			}
			else {
				//l'utente ha eseguito il secondo click per stabilire la destinazione
				ArrayList<Coordinates> validPositions = new ArrayList<>();
				/*
				 * Se si è in scacco verifica se il giocatore vuole fare una mossa valida e se lo è la effettua
				 * altrimenti effettua la mossa, ovviamente solo se quest'ultima è possibile per il pezzo
				 */
				if ( check() ){
					//aggiunge tutte le posizioni valide per il pezzo
					validPositions.addAll((new Rules(model.getChessboard())).getSafetyPositions(firstClick));
					
					/*
					 * Se la casella scelta dal giocatore fa parte di quelle valide
					 * allora fa la mossa se è possibile per quel pezzo
					 */
					if (validPositions.contains(c))
						model.setChessboard(new Rules(model.getChessboard()).nextMove(firstClick, c));
				}
				else
					model.setChessboard(new Rules(model.getChessboard()).nextMove(firstClick, c));
				
				//ripristina le variabili allo stato iniziale
				firstClick = null;
				rethought = false;
			}
		}
		
	}
	
	/**
	 * Gestisce la colorazione della scacchiera per dare un feedback all'utente.
	 * <p>Colora le posizioni valide in base al pezzo scelto con il firstClick.
	 * @param c La coordinata del bottone.
	 * @return Ritorna l'ArrayList delle coordinate delle caselle da colorare.
	 */
	public ArrayList<Coordinates> colorValidPositions(Coordinates c) {
		ArrayList<Coordinates> validPositions = new ArrayList<Coordinates>();
		
		if (firstClick == null ) 
			return validPositions;
		
		//se si e' in scacco, le posizioni valide sono solo quelle che lo evitano
		if ( check() ){
			validPositions.addAll((new Rules(model.getChessboard())).getSafetyPositions(c));
			ArrayList<Coordinates> toRemove = new ArrayList<>();
			for ( Coordinates to : validPositions )
				if (!(new Rules(model.getChessboard())).checkMove(c, to))
					toRemove.add(to);
			validPositions.removeAll(toRemove);

			return validPositions;
		}
		validPositions = model.at(c).validPositions(c);

		ArrayList<Coordinates> temp = new ArrayList<Coordinates>(validPositions);
		
		for (Coordinates coordinate : validPositions) {
			Rules r = new Rules(model.getChessboard());
			if ( !(r.checkMove(c, coordinate)) || (r.kingOnCheck()))
				temp.remove(coordinate);
			
		}
		
		return temp;
	}
	
	/**
	 * Ritorna se il giocatore ha cliccato un altro pezzo.
	 * @return Ritorna la variabile boolean rethought.
	 */
	public boolean getRethought() {
		return rethought;
	}
	
	/**
	 * Ritorna le coordinate del firstClick.
	 * @return Ritorna le coordinate del firstClick.
	 */
	public Coordinates getFirstClick(){
		return firstClick;
	}
	
	/**
	 * Controlla se la scacchiera nella coordinata c contiene un pedone da promuovere.
	 * @param c Coordinata del bottone cliccato dall'utente.
	 * @return True se in c vi è un pedone che può essere promosso.
	 */
	public boolean checkPromotion(Coordinates c){
		// entra nel IF sse l'utente ha cliccato la seconda volta
		// Poiche' la variabile firstClick viene modificata prima della chiamata a questo
		// metodo, il test e' con NULL
		if ( firstClick == null){
			Rules r = new Rules(model.getChessboard());
			return r.pawnTrip(c);
		}
		return false;
	}
	
	/**
	 * Scambia sul modello il pedone con il pezzo scelto dall'utente.
	 * @param where Coordinate del pedone al capolinea.
	 * @param piece Il pezzo da spostare.
	 */
	public void pawnPromotion(Coordinates where, Pieces piece){
		model.setChessboard(model.getChessboard().swap(where, piece));
	}
	
	/**
	 * Ritorna true se si ha una patta.
	 * @return True si ha una patta, altrimenti false.
	 */
	public boolean isDraw(){
		model.getChessboard().setTurn();
		ChessboardMatrix chessboard = model.getChessboard();
		ArrayList<Coordinates> enemy = chessboard.getEnemyPieces();
		ArrayList<Coordinates> pieces = chessboard.getTurnPieces();
		
		// Avversario ha solo RE
		if ( (enemy.size()==1) && (chessboard.at(enemy.get(0))instanceof King) ){
			// Giocatore ha solo RE
			if ( (pieces.size()==1) && (chessboard.at(pieces.get(0))instanceof King) )
				return true;
			
			// Giocatore ha RE e CAVALLO
			if ( (chessboard.getTurnPieces().size()==2) )
				if ( (chessboard.at(pieces.get(0))instanceof Knight ^ chessboard.at(pieces.get(1))instanceof Knight) )
					return true;
			
			// Giocatore ha RE e ALFIERE
			if ( (pieces.size()==2) )
				if ( (chessboard.at(pieces.get(0))instanceof Bishop ^ chessboard.at(pieces.get(1))instanceof Bishop) )
					return true;				
		}
		
		model.getChessboard().setTurn();
		return false;
	}
}
