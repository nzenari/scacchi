package test;
import static org.junit.Assert.*;
import model.ChessboardMatrix;
import moves.Rules;

import org.junit.Test;

import pieces.Coordinates;


public class TestQueen {
	/*
	 * Questi test servono solo per verificare il corretto comportamento della regina.
	 * Bypassiamo i controlli di movimento per crearci ad hoc uno schema utile 
	 * ai nostri test (usiamo il metodo move della classe ChessboardMatrix) 
	 * 
	 */
	
	/*
	 * Test per verificare una mossa valida della regina
	 */
	@Test
	public void testValidMove1() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo la regina al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,3), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(3,3));
		
		chessboard2 = chessboard2.move(new Coordinates(7,3), new Coordinates(3,3));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida della regina
	 */
	@Test
	public void testValidMove2() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo la regina al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,3), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(3,5));
		
		chessboard2 = chessboard2.move(new Coordinates(7,3), new Coordinates(3,5));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida della regina
	 */
	@Test
	public void testValidMove3() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo la regina al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,3), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(5,5));
		
		chessboard2 = chessboard2.move(new Coordinates(7,3), new Coordinates(5,5));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida della regina
	 */
	@Test
	public void testValidMove4() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo la regina al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,3), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(5,3));
		
		chessboard2 = chessboard2.move(new Coordinates(7,3), new Coordinates(5,3));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	
	/*
	 * Test per verificare una mossa valida della regina
	 */
	@Test
	public void testValidMove5() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo la regina al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,3), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(3,4));
		
		chessboard2 = chessboard2.move(new Coordinates(7,3), new Coordinates(3,4));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida della regina
	 */
	@Test
	public void testValidMove6() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo la regina al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,3), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(4,0));
		
		chessboard2 = chessboard2.move(new Coordinates(7,3), new Coordinates(4,0));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida della regina
	 */
	@Test
	public void testValidMove7() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo la regina al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,3), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(4,7));
		
		chessboard2 = chessboard2.move(new Coordinates(7,3), new Coordinates(4,7));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida della regina
	 */
	@Test
	public void testValidMove8() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo la regina al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,3), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(5,4));
		
		chessboard2 = chessboard2.move(new Coordinates(7,3), new Coordinates(5,4));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}

	/*
	 * Test per verificare che la regina non puo' mangiare una pedina del suo stesso colore
	 */
	@Test
	public void testNotEat1() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo la regina al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,3), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(6,4));
		
		chessboard2 = chessboard2.move(new Coordinates(7,3), new Coordinates(4,4));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare che la regina puo' mangiare una pedina avversaria
	 */
	@Test
	public void testEat1() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo la regina al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,3), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(1,4));
		
		chessboard2 = chessboard2.move(new Coordinates(7,3), new Coordinates(1,4));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare che la regina non puo' mangiare una pedina del suo stesso colore
	 */
	@Test
	public void testNotEat2() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo la regina al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,3), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(6,6));
		
		chessboard2 = chessboard2.move(new Coordinates(7,3), new Coordinates(4,4));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare che la regina puo' mangiare una pedina avversaria
	 */
	@Test
	public void testEat2() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo la regina al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,3), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(1,1));
		
		chessboard2 = chessboard2.move(new Coordinates(7,3), new Coordinates(1,1));
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa non valida della regina.
	 */
	@Test
	public void testNotValidMove() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(7, 2), new Coordinates(5,0));
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(3,2));
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(5,7));
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(5,6));
		
		assertTrue(chessboard.equals(chessboard2));
	
	}
	
	/*
	 * Test per verificare una mossa non valida della regina.
	 * Nel suo percorso non ci deve essere alcuna pedina
	 */
	@Test
	public void testNotValidMove2() {

		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(7, 3), new Coordinates(5,3));
		
		
		
		assertTrue(chessboard.equals(chessboard2));
		
	}

}
