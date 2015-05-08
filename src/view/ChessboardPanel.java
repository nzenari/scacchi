package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import pieces.Colour;
import pieces.Coordinates;
import pieces.Pieces;
import model.Model;
import moves.Rules;
import controller.Controller;

/**
 * Implementa la View.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */
public class ChessboardPanel extends JPanel implements View {
	
	private static final long serialVersionUID = 1L;
	
	private final Model model;
	private Controller controller;
	private final JFrame frame;
	private final JButton[][] squareButtons = new JButton[8][8];
	private final Color[] colors = {Color.gray, Color.white};

	/**
	 * Costruttore della scacchiera.
	 * <p>Crea il pannello contenente una matrice di JButton che rappresentano le caselle della scacchiera.
	 * 
	 * @param model Il modello.
	 * @param frame La finestra.
	 */
	public ChessboardPanel(Model model, JFrame frame) {
		this.frame = frame;
		this.model = model;
		
		createChessboard();
		
		model.setView(this);
	}
	
	private void createChessboard() {
		setLayout(new GridLayout(8, 8));
		int index = 0;
		
		for (int i = 0; i < 8; i++) {
			index++;
			index %= 2;
			for (int j = 0; j < 8; j++)
				add(squareButtons[i][j] = makeButton(new Coordinates(i, j), model.at(new Coordinates(i, j)), colors[(index++) % 2]));
		}
	}

	
	private JButton makeButton(Coordinates c, Pieces at, Color color) {
		JButton button;
		
		if (at == null)
			button = new JButton();
		else	
			button = new JButton(at.getImage());

		button.setBackground(color);
		
		button.addActionListener(event -> controller.onClick(c));
		
		return button;
	}

	/**
	 * Ritorna il modello.
	 * @return Ritorna il modello.
	 */
	@Override
	public Model getModel() {
		return model;
	}

	/**
	 * Imposta il controllore.
	 */
	@Override
	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	/**
	 * Crea l'istanza della finestra di fine partita.
	 */
	@Override
	public void showEndDialog() {	
		new EndDialog(frame, controller, new Rules(model.getChessboard()).getWinner());
	}
	
	/**
	 * Crea l'istanza della finestra di promozione del pedone.
	 */
	@Override
	public void showPromotionDialog() {
		new PromotionDialog(frame, controller, model.getChessboard().getTurn().equals(Colour.BLACK) ? model.getChessboard().getWhiteLostPieces() : model.getChessboard().getBlackLostPieces());
	}
	
	/**
	 * Cambia la scacchiera in base al modello.
	 * <p>Cambia anche l'etichetta del turno.
	 */
	@Override
	public void onChessboardChange() {
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				squareButtons[i][j].setIcon((model.at(new Coordinates(i, j)) == null ? null : model.at(new Coordinates(i, j)).getImage()));
			}
		
		// setta la label del turno
		((ChessboardFrame)frame).setLblTurn();
		
	}
	
	/**
	 * Colora le posizioni valide dove puo' muoversi una pedina di arancione.
	 */
	public void showValidPositions(ArrayList<Coordinates> array) {
		for (Coordinates c : array) 
			squareButtons[c.getX()][c.getY()].setBackground(Color.orange);
	}

	/**
	 * Ripristina il colore delle caselle.
	 * <p>Viene utilizzato quando il giocatore ha un ripensamento.
	 */
	@Override
	public void noColour() {
		int index = 0;
		
		for (int i = 0; i < 8; i++) {
			index++;
			index %= 2;
			for (int j = 0; j < 8; j++)
				squareButtons[i][j].setBackground(colors[(index++) % 2]);
		}		
	}

	/**
	 * Colora il re di rosso quando è in scacco.
	 */
	@Override
	public void colorKing() {
		Coordinates king = model.getChessboard().getTurnKing();
		squareButtons[king.getX()][king.getY()].setBackground(Color.red);
	}

	/**
	 * Crea un'istanza della finestra della patta.
	 */
	@Override
	public void showDrawDialog() {
		new DrawDialog(frame, controller);
	}
}
