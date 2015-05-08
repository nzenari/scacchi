package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pieces.Colour;
import controller.ChessboardController;
import controller.Controller;
import model.ChessboardMatrix;
import model.SquaresModel;

/**
 * Implementa la finestra principale del gioco.
 * <p>Al suo interno vi è il pannello contenente la scacchiera,
 * un'etichetta che indica il turno, il bottone che avvia una nuova
 * partita e un bottone per uscire dal programma.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */
public class ChessboardFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	private final SquaresModel model = new SquaresModel(new ChessboardMatrix());
	private final Controller controller;
	private JLabel lblTurn = new JLabel();
	
	/**
	 * Il costruttore del frame.
	 * <p>Crea la finestra e vi aggiunge tutti i componenti.
	 * <p>La finestra viene creata al centro dello schermo ed ha una forma quadrata
	 * con lato pari all'altezza dello schermo. L'utente è libero di cambiarne le dimensioni
	 * della finestra ma la scacchiera mantiene le caselle quadrate.
	 */
	public ChessboardFrame() {
		setTitle("Chess");
		
		View view = addChessboard();
		controller = new ChessboardController(view);
		controller.newGame();
		addButtons();
		
		setIconImage(new ImageIcon("img/Chess_Icon.png").getImage());
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = (int) screenSize.getHeight();
		int screenWidth = (int) screenSize.getWidth();
		setSize(screenHeight, screenHeight);
		setLocation((screenWidth - this.getSize().width) / 2, (screenHeight - this.getSize().height) / 2);
		
		JFrame frame = this;
		
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				checkSquared(frame);
			}

			private void checkSquared(final JFrame frame){
				
				// controlla se le dimensioni del frame sono cambiate
				if (frame.getWidth() == frame.getHeight())
					// le dimensioni non sono cambiate percio' termina qui
					return;
				
				// le dimensioni sono cambiate
				// newDim contiene la nuova dimensione
				int newDim = (frame.getHeight() + frame.getWidth()) / 2;
				
				// se l'utente ha scelto di massimizzare la finestra
				// non ci opponiamo a mantenere il frame quadrato
				if ( newDim > screenHeight )
					return;
				
				// imposta la nuova dimensione
				frame.setSize(newDim, newDim);
				
				// posiziona il frame al centro dello schermo
				setLocation((screenWidth - frame.getSize().width) / 2, (screenHeight - frame.getSize().height) / 2);
				
			}
		});
	}

	private void addButtons() {
		JPanel panel = new JPanel();
		
		// NUOVO GIOCO
		JButton newGame = new JButton("New game");
		newGame.addActionListener(event -> controller.newGame());
		newGame.setMnemonic('N');
		panel.add(newGame);
		
		// ESCI
		JButton exit = new JButton("Exit");
		exit.addActionListener(event -> System.exit(0));
		exit.setMnemonic('E');
		panel.add(exit);
		
		// ETICHETTA TURNO
		   //stringa Turn
		JLabel turn = new JLabel("Turn:  ");
		panel.add(turn);
		   //stringa colore
		lblTurn.setFont(new Font(lblTurn.getFont().getFontName(), Font.BOLD, 15));
		setLblTurn();
		panel.add(lblTurn);
		
		add(panel, BorderLayout.NORTH);
	}

	/**
	 * Imposta l'etichetta del turno.
	 */
	// Imposta testo e colore della label del turno
	public void setLblTurn() {
		Colour turn = model.getChessboard().getTurn();
		lblTurn.setText(turn.toString());
		lblTurn.setForeground( turn.equals(Colour.BLACK) ? Color.BLACK : Color.WHITE);
	}

	private View addChessboard() {
		ChessboardPanel panel = new ChessboardPanel(model, this);
		
		add(panel, BorderLayout.CENTER);
		
		return panel;
	}
	
}
