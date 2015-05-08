package test;
import static org.junit.Assert.*;
import model.ChessboardMatrix;
import moves.Rules;

import org.junit.Test;

import pieces.Coordinates;


public class TestPawn {
	/*
	 * Questi test servono solo per verificare il corretto comportamento del pedone.
	 * Bypassiamo i controlli di movimento per crearci ad hoc uno schema utile 
	 * ai nostri test (usiamo il metodo move della classe ChessboardMatrix) 
	 */
	
	/*
	 * Test per verificare una mossa valida del pedone
	 */
	@Test
	public void testValidMove() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(6, 0), new Coordinates(5,0));
		
		chessboard2 = chessboard2.move(new Coordinates(6,0), new Coordinates(5,0));
		
		
		assertTrue(chessboard.equals(chessboard2));
	}
	
	
	/*
	 * Test per verificare una mossa non valida del pedone
	 */
	@Test
	public void testNotValidMove() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(6, 0), new Coordinates(4,0));
		
		
		
		assertTrue(chessboard.equals(chessboard2));
	}
	
	/*
	 * Test per verificare che i pedoni non possono tornare indietro
	 */
	@Test
	public void testNotValidMoveBack() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(6, 0), new Coordinates(5,0));
		chessboard = rules.nextMove(new Coordinates(1, 0), new Coordinates(2,0));
		
		chessboard = rules.nextMove(new Coordinates(5, 0), new Coordinates(6,0));
		chessboard = rules.nextMove(new Coordinates(2, 0), new Coordinates(1,0));
		
		chessboard2.move(new Coordinates(6,0), new Coordinates(5,0));
		chessboard2.move(new Coordinates(1,0), new Coordinates(2,0));
		
		
		
		assertTrue(chessboard.equals(chessboard2));
	}
	
	/*
	 * Test per verificare una mossa non valida (diagonale dx) del pedone
	 */
	@Test
	public void testNotValidMoveDx() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(6, 0), new Coordinates(5,1));
		
		
		
		assertTrue(chessboard.equals(chessboard2));
	}
	
	/*
	 * Test per verificare una mossa non valida (diagonale) del pedone
	 */
	@Test
	public void testNotValidMoveSx() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(6, 1), new Coordinates(5,0));
		
		
		
		assertTrue(chessboard.equals(chessboard2));
	}

	/*
	 * Test per verificare che il pedone puo' mangiare in diagonale dx
	 */
	@Test
	public void testValidEatDx() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo direttamente un pedone avversario in una posizione in cui puo' essere mangiato
		chessboard.move(new Coordinates(1,0), new Coordinates(5,1));
		
		Rules rules = new Rules(chessboard);
		
		// Il pedone bianco mangia il pedone nero
		chessboard = rules.nextMove(new Coordinates(6,0), new Coordinates(5,1));
		
		chessboard2.move(new Coordinates(1,0), new Coordinates(5,1));
		chessboard2.move(new Coordinates(6,0), new Coordinates(5,1));
		
		
		assertTrue(chessboard.equals(chessboard2));
	}

	/*
	 * Test per verificare che il pedone puo' mangiare in diagonale sx
	 */
	@Test
	public void testValidEatSx() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo direttamente un pedone avversario in una posizione in cui puo' essere mangiato
		chessboard.move(new Coordinates(1,0), new Coordinates(5,0));
		
		Rules rules = new Rules(chessboard);
		
		// Il pedone bianco mangia il pedone nero
		chessboard = rules.nextMove(new Coordinates(6,1), new Coordinates(5,0));
		
		chessboard2.move(new Coordinates(1,0), new Coordinates(5,0));
		chessboard2.move(new Coordinates(6,1), new Coordinates(5,0));
		
		
		assertTrue(chessboard.equals(chessboard2));
	}

	/*
	 * Test per verificare che il pedone non puo' muovere due volte consecutive
	 */
	@Test
	public void testNotConsecutive() {
		
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(6, 0), new Coordinates(5,0));
		chessboard = rules.nextMove(new Coordinates(5, 0), new Coordinates(4,0));
		
		chessboard2.move(new Coordinates(6,0), new Coordinates(5,0));
				
		assertTrue(chessboard.equals(chessboard2));
	}

}
