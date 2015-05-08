package test;
import static org.junit.Assert.*;
import model.ChessboardMatrix;
import moves.Rules;

import org.junit.Test;

import pieces.Coordinates;


public class TestRules {

	@Test
	/*
	 * Questo test controlla se la pedina viene mossa
	 */
	public void testNextMove() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(6, 0), new Coordinates(5,0));
		
		chessboard2 = chessboard2.move(new Coordinates(6,0), new Coordinates(5,0));
		chessboard2.setTurn();
		
		assertTrue(chessboard.equals(chessboard2));
	}
	
	@Test
	/*
	 * Questo test, dopo alcune mosse, controlla se il RE nero è in scacco
	 */
	public void testKingOnCheck(){
		ChessboardMatrix chessboard = new ChessboardMatrix();
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(6, 4), new Coordinates(5,4));
		rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(1, 5), new Coordinates(2,5));
		rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(7, 3), new Coordinates(3,7));
		rules = new Rules(chessboard);
		
		assertTrue(rules.kingOnCheck());
	}
	
	@Test
	/*
	 * Questo test mette in scacco il re nero e controlla che il re non abbia
	 * posizioni in cui scappare
	 */
	public void testGetSafetyPositions(){
		ChessboardMatrix chessboard = new ChessboardMatrix();
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(6, 4), new Coordinates(5,4));
		rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(1, 5), new Coordinates(2,5));
		rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(7, 3), new Coordinates(3,7));
		rules = new Rules(chessboard);
		
		assertTrue(rules.getSafetyPositions(chessboard.getTurnKing()).isEmpty());
	}

	@Test
	/*
	 * Questo test mette in scacco il re nero e controlla che ci siano delle posizioni
	 * in cui le pedine possono muoversi per togliere il proprio re dallo scacco
	 */
	public void testGetHeroesPositions(){
		ChessboardMatrix chessboard = new ChessboardMatrix();
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(6, 4), new Coordinates(5,4));
		rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(1, 5), new Coordinates(2,5));
		rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(7, 3), new Coordinates(3,7));
		rules = new Rules(chessboard);
		
		assertTrue(!rules.getHeroesPositions().isEmpty());
	}
	
	@Test
	/*
	 * Questo test controlla le varie posizioni valide o meno in cui spostare le pedine 
	 */
	public void testCheckMove(){
		ChessboardMatrix chessboard = new ChessboardMatrix();
		Rules rules = new Rules(chessboard);
		
		// Pedone da (6,0) a (5,0)
		assertTrue(rules.checkMove(new Coordinates(6,0), new Coordinates(5,0)));
		// Pedone da (6,0) a (5,1)
		assertFalse(rules.checkMove(new Coordinates(6,0), new Coordinates(5,1)));
		// Cavallo da (7,1) a (5,3): La posizione non e' valida
		assertFalse(rules.checkMove(new Coordinates(7,1), new Coordinates(5,3)));
		// Cavallo da (7,1) a (5,2)
		assertTrue(rules.checkMove(new Coordinates(7,1), new Coordinates(5,2)));
		// Torre da (7,0) a (5,0): La posizione sarebbe valida ma c'e' un pezzo nel tragitto
		assertFalse(rules.checkMove(new Coordinates(7,0), new Coordinates(5,0)));
		
		chessboard = rules.nextMove(new Coordinates(6, 4), new Coordinates(5,4));
		rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(1, 5), new Coordinates(2,5));
		rules = new Rules(chessboard);
		// Alfiere da (7,5) a (6,4)
		assertTrue(rules.checkMove(new Coordinates(7,5), new Coordinates(6,4)));
		// Regina da (7,3) a (3,7)
		assertTrue(rules.checkMove(new Coordinates(7,3), new Coordinates(3,7)));
		// Re da (7,4) a (6,4)
		assertTrue(rules.checkMove(new Coordinates(7,4), new Coordinates(6,4)));
		// Re da (7,4) a (7,3): La posizione sarebbe valida ma e' occupata dalla regina
		assertFalse(rules.checkMove(new Coordinates(7,4), new Coordinates(7,3)));
	}
	
}
 