package test;
import static org.junit.Assert.*;
import model.ChessboardMatrix;
import moves.Rules;

import org.junit.Test;

import pieces.Coordinates;


public class TestKnight {
	/*
	 * Questi test servono solo per verificare il corretto comportamento del cavallo
	 * Bypassiamo i controlli di movimento per crearci ad hoc uno schema utile 
	 * ai nostri test (usiamo il metodo move della classe ChessboardMatrix) 
	 * 
	 */
	
	/*
	 * Test per verificare una mossa valida del cavallo
	 */
	@Test
	public void testValidMove() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// sposto il cavallo in 3,4
		chessboard = chessboard.move(new Coordinates(7,6), new Coordinates(3,4));
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(3, 4), new Coordinates(5,3));
		
		chessboard2 = chessboard2.move(new Coordinates(7,6), new Coordinates(5,3));
		
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}

	/*
	 * Test per verificare una mossa valida del cavallo
	 */
	@Test
	public void testValidMove2() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// sposto il cavallo in 3,4
		chessboard = chessboard.move(new Coordinates(7,6), new Coordinates(3,4));

		Rules rules = new Rules(chessboard);

		chessboard = rules.nextMove(new Coordinates(3, 4), new Coordinates(5,5));

		chessboard2 = chessboard2.move(new Coordinates(7,6), new Coordinates(5,5));

		

		assertTrue(chessboard.equals(chessboard2));
		
	}

	/*
	 * Test per verificare una mossa valida del cavallo
	 */
	@Test
	public void testValidMove3() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// sposto il cavallo in 4,4
		chessboard = chessboard.move(new Coordinates(7,6), new Coordinates(4,4));

		Rules rules = new Rules(chessboard);

		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(5,2));

		chessboard2 = chessboard2.move(new Coordinates(7,6), new Coordinates(5,2));

		

		assertTrue(chessboard.equals(chessboard2));
		
	}	
	
	/*
	 * Test per verificare una mossa valida del cavallo
	 */
	@Test
	public void testValidMove4() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// sposto il cavallo in 4,4
		chessboard = chessboard.move(new Coordinates(7,6), new Coordinates(4,4));

		Rules rules = new Rules(chessboard);

		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(3,2));

		chessboard2 = chessboard2.move(new Coordinates(7,6), new Coordinates(3,2));

		

		assertTrue(chessboard.equals(chessboard2));
		
	}		
	
	/*
	 * Test per verificare una mossa valida del cavallo
	 */
	@Test
	public void testValidMove5() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// sposto il cavallo in 4,4
		chessboard = chessboard.move(new Coordinates(7,6), new Coordinates(4,4));

		Rules rules = new Rules(chessboard);

		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(2,3));

		chessboard2 = chessboard2.move(new Coordinates(7,6), new Coordinates(2,3));

		

		assertTrue(chessboard.equals(chessboard2));
		
	}	
	
	/*
	 * Test per verificare una mossa valida del cavallo
	 */
	@Test
	public void testValidMove6() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// sposto il cavallo in 4,4
		chessboard = chessboard.move(new Coordinates(7,6), new Coordinates(4,4));

		Rules rules = new Rules(chessboard);

		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(2,5));

		chessboard2 = chessboard2.move(new Coordinates(7,6), new Coordinates(2,5));

		

		assertTrue(chessboard.equals(chessboard2));
		
	}	
	
	/*
	 * Test per verificare una mossa valida del cavallo
	 */
	@Test
	public void testValidMove7() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// sposto il cavallo in 4,4
		chessboard = chessboard.move(new Coordinates(7,6), new Coordinates(4,4));

		Rules rules = new Rules(chessboard);

		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(3,6));

		chessboard2 = chessboard2.move(new Coordinates(7,6), new Coordinates(3,6));

		

		assertTrue(chessboard.equals(chessboard2));
		
	}	
	
	/*
	 * Test per verificare una mossa valida del cavallo
	 */
	@Test
	public void testValidMove8() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// sposto il cavallo in 4,4
		chessboard = chessboard.move(new Coordinates(7,6), new Coordinates(4,4));

		Rules rules = new Rules(chessboard);

		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(5,6));

		chessboard2 = chessboard2.move(new Coordinates(7,6), new Coordinates(5,6));

		

		assertTrue(chessboard.equals(chessboard2));
		
	}	
	/*
	 * Test per verificare che il cavallo non puo' mangiare una pedina del suo stesso colore
	 */
	@Test
	public void testNotEat() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo l'alfiere al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,6), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(6,5));
		
		chessboard2 = chessboard2.move(new Coordinates(7,6), new Coordinates(4,4));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare che il cavallo puo' mangiare una pedina avversaria
	 */
	@Test
	public void testEat() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo l'alfiere al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,6), new Coordinates(3,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(3, 4), new Coordinates(1,5));
		
		chessboard2 = chessboard2.move(new Coordinates(7,6), new Coordinates(1,5));
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare piu' mosse non valide del cavallo
	 */
	@Test
	public void testNotValidMove1() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// sposto il cavallo in 4,4
		chessboard = chessboard.move(new Coordinates(7,6), new Coordinates(4,4));

		Rules rules = new Rules(chessboard);

		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(4,6));
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(3,6));
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(1,0));
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(4,3));
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(4,5));
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(7,7));
		
		chessboard2 = chessboard2.move(new Coordinates(7,6), new Coordinates(4,4));

		

		assertTrue(chessboard.equals(chessboard2));

	}
}
