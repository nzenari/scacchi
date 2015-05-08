package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import pieces.Pieces;
import controller.Controller;

/**
 * Implementa la finestra di dialogo di promozione del pedone.
 * <p>Contiene un insieme di bottoni pari al numero di elementi contenuti
 * nell'ArrayList dei pezzi persi.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */
public class PromotionDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private Controller controller;
	
	/**
	 * Costruttore della finestra.
	 * @param owner La finestra principale.
	 * @param controller Il controllore.
	 * @param lostPieces L'ArrayList dei pezzi mangiati.
	 */
	public PromotionDialog(JFrame owner, Controller controller, ArrayList<Pieces> lostPieces) {
		super(owner, "Promotion", true);
		this.controller = controller;
		
		add(new JLabel("<html><h2>Select a piece</h2></html>"), BorderLayout.NORTH);
		add(lostPiecesPanel(lostPieces), BorderLayout.CENTER);
		
		pack();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = (int) screenSize.getHeight();
		int screenWidth = (int) screenSize.getWidth();
		setLocation((screenWidth - this.getSize().width) / 2, (screenHeight - this.getSize().height) / 2);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		setVisible(true);
	}
	
	private JPanel lostPiecesPanel(ArrayList<Pieces> lostPieces) {
		JPanel panel = new JPanel();
		
		panel.setLayout(new GridLayout(1, lostPieces.size()));
		for(Pieces piece : lostPieces) {
			panel.add(makeButton(piece));
		}
		
		return panel;
	}
	
	private JButton makeButton(Pieces piece) {
		JButton button = new JButton(piece.getImage());
		
		button.addActionListener(event -> {
			controller.promotion(piece);
			this.dispose();
		});
		
		return button;
	}
}
