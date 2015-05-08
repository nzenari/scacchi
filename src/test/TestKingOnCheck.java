package test;
import static org.junit.Assert.*;
import model.ChessboardMatrix;
import moves.Rules;

import org.junit.Test;

import pieces.Coordinates;



public class TestKingOnCheck {

	/*
	 * Questo verfica il corretto funzionamento del metodo che controlla la presenza
	 * dello scacco
	 */
	@Test
	public void test() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(6,4), new Coordinates(5,4));
		rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(1,5), new Coordinates(2,5));
		rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(7,3), new Coordinates(3,7));
		rules = new Rules(chessboard);
		
		assertTrue(rules.kingOnCheck());
		
	}

}
