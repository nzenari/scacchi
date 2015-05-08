package test;
import static org.junit.Assert.*;
import model.ChessboardMatrix;
import moves.Rules;

import org.junit.Test;

import pieces.Coordinates;


public class TestRook {
	/*
	 * Questi test servono solo per verificare il corretto comportamento della torre.
	 * Bypassiamo i controlli di movimento per crearci ad hoc uno schema utile 
	 * ai nostri test (usiamo il metodo move della classe ChessboardMatrix) 
	 * 
	 */
	
	/*
	 * Test per verificare una mossa valida della torre
	 */
	@Test
	public void testValidMove() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo l'alfiere al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,0), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(3,4));
		
		chessboard2 = chessboard2.move(new Coordinates(7,0), new Coordinates(3,4));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida della torre
	 */
	@Test
	public void testValidMove2() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo l'alfiere al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,0), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(4,0));
		
		chessboard2 = chessboard2.move(new Coordinates(7,0), new Coordinates(4,0));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida della torre
	 */
	@Test
	public void testValidMove3() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo l'alfiere al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,0), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(4,7));
		
		chessboard2 = chessboard2.move(new Coordinates(7,0), new Coordinates(4,7));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida della torre
	 */
	@Test
	public void testValidMove4() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo l'alfiere al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,0), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(5,4));
		
		chessboard2 = chessboard2.move(new Coordinates(7,0), new Coordinates(5,4));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare che la torre non puo' mangiare una pedina del suo stesso colore
	 */
	@Test
	public void testNotEat() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo l'alfiere al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,0), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(6,4));
		
		chessboard2 = chessboard2.move(new Coordinates(7,0), new Coordinates(4,4));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare che la torre puo' mangiare una pedina avversaria
	 */
	@Test
	public void testEat() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo l'alfiere al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,0), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(1,4));
		
		chessboard2 = chessboard2.move(new Coordinates(7,0), new Coordinates(1,4));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa non valida della torre.
	 * Nel suo percorso non ci deve essere una pedina
	 */
	@Test
	public void testNotValidMove() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(7, 0), new Coordinates(5,0));
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa non valida della torre
	 * Non puo' andare in diagonale
	 */
	@Test
	public void testNotValidMove2() {

		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo l'alfiere al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,0), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(3,3));
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(3,5));
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(5,3));
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(5,5));
		
		chessboard2 = chessboard2.move(new Coordinates(7,0), new Coordinates(4,4));
		
		assertTrue(chessboard.equals(chessboard2));
		
	}

}
