package controller;

import java.util.ArrayList;
import moves.Mover;
import pieces.Coordinates;
import pieces.Pieces;
import view.View;

/**
 * Classe che implementa l'interfaccia Controller.
 * <p>
 * I metodi di questa classe richiamano metodi del Mover e della View.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 * 
 */
public class ChessboardController implements Controller {
	/**
	 * La vista.
	 */
	private final View view;
	/**
	 * Il mover.
	 */
	private final Mover mover;
	/**
	 * La coordinata dove deve bisogna promuovere il pedone.
	 */
	private static Coordinates where;
	
	/**
	 * Costruttore della classe.
	 * 
	 * @param view La vista
	 */
	public ChessboardController(View view) {
		this.view = view;
		this.mover = new Mover(view.getModel());
		
		view.setController(this);
	}
	
	/**
	 * Resetta la scacchiera per poter giocare una nuova partita
	 */
	@Override
	public void newGame() {
		mover.reset();
		view.noColour();
	}

	/**
	 * Gestisce tutti gli eventi legati al click di un bottone sulla scacchiera.
	 * 
	 * @param c La coordinata del bottone su cui l'utente ha cliccato
	 */
	@Override
	public void onClick(Coordinates c) {
		mover.click(c);
	
		if ( mover.checkPromotion(c) ){
			where = c;
			view.showPromotionDialog();
		}
		
		if ( mover.getRethought() )
			view.noColour();
		
		ArrayList<Coordinates> array = mover.colorValidPositions(c);

		//entra nell'IF sse ci sono posizioni valide
		if(!(array.isEmpty()))
			view.showValidPositions(array);
		
		if ( mover.getFirstClick() == null )
			view.noColour();
		
		if (mover.checkMate())
			view.showEndDialog();
		else if ( mover.check() )
			view.colorKing();
		
		if ( mover.isDraw() )
			view.showDrawDialog();
		
	}

	/**
	 * Gestisce la promozione di un pedone che ha raggiunto l'altra sponda.
	 * 
	 * @param piece Pezzo da sostituire con il pedone
	 */
	@Override
	public void promotion(Pieces piece) {
		mover.pawnPromotion(where, piece);
	}
}
