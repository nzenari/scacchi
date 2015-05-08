package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import controller.Controller;

/**
 * Implementa la finesta di dialogo della patta.
 * <p>Ha due bottoni che permettono di iniziare una nuova partita
 * o di uscire dal gioco.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */
public class DrawDialog extends JDialog{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Costruttore della finestra.
	 * @param owner La finestra principale.
	 * @param controller Il controllore.
	 */
	public DrawDialog(JFrame owner, Controller controller) {
		super(owner, "End game!", true);
		
		JLabel label = new JLabel("<html><h2>Draw!</h2></html>");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label, BorderLayout.NORTH);
		
		JButton newGame = new JButton("New game");
		newGame.setMnemonic('N');
		newGame.addActionListener(event -> {
			controller.newGame();
			this.dispose();
		});
		
		JButton exit = new JButton("Exit");
		exit.setMnemonic('E');
		exit.addActionListener(event -> {
			System.exit(0);
		});
		
		JPanel panel = new JPanel();
		panel.add(newGame);
		panel.add(exit);
		add(panel, BorderLayout.SOUTH);
		
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
}
