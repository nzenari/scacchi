package test;
import static org.junit.Assert.*;
import model.ChessboardMatrix;
import moves.Rules;

import org.junit.Test;

import pieces.Coordinates;


public class TestCheckMate {

	/*
	 * Questo test
	 */
	
	@Test
	public void test() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(6,4), new Coordinates(5,4));
		rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(1,5), new Coordinates(2,5));
		rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(5,4), new Coordinates(4,4));
		rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(1,6), new Coordinates(2,6));
		rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(6,0), new Coordinates(5,0));
		rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(2,6), new Coordinates(3,6));
		rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(7,3), new Coordinates(3,7));
		rules = new Rules(chessboard);
		
		assertTrue(rules.kingOnCheck() && rules.getHeroesPositions().isEmpty() && rules.getSafetyPositions(chessboard.getTurnKing()).isEmpty());
	}

}
