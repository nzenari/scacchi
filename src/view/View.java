package view;

import java.util.ArrayList;
import pieces.Coordinates;
import controller.Controller;
import model.Model;

/**
 * Interfaccia che dichiara i metodi utili alla vista.
 * 
 * @author Benati Mirco VR382673
 * @author Castagna Daniele VR380514
 * @author Zenari Nicolo' VR378661
 */
public interface View {
	Model getModel();
	void setController(Controller controller);
	
	void showEndDialog();
	void showPromotionDialog();
	void showDrawDialog();
	void onChessboardChange();
	void showValidPositions(ArrayList<Coordinates> array);
	void noColour();
	void colorKing();
}
