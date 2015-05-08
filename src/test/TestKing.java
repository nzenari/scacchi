package test;
import static org.junit.Assert.*;
import model.ChessboardMatrix;
import moves.Rules;

import org.junit.Test;

import pieces.Coordinates;


public class TestKing {
	/*
	 * Questi test servono solo per verificare il corretto comportamento del re.
	 * Bypassiamo i controlli di movimento per crearci ad hoc uno schema utile 
	 * ai nostri test (usiamo il metodo move della classe ChessboardMatrix) 
	 * 
	 */
	
	/*
	 * Test per verificare una mossa valida del re
	 */
	@Test
	public void testValidMove1() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo il re al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,4), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(3,3));
		
		chessboard2 = chessboard2.move(new Coordinates(7,4), new Coordinates(3,3));
		chessboard2.setTurn();
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida del re
	 */
	@Test
	public void testValidMove2() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo il re al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,4), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(3,4));
		
		chessboard2 = chessboard2.move(new Coordinates(7,4), new Coordinates(3,4));
		chessboard2.setTurn();
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida del re
	 */
	@Test
	public void testValidMove3() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo il re al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,4), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(3,5));
		
		chessboard2 = chessboard2.move(new Coordinates(7,4), new Coordinates(3,5));
		chessboard2.setTurn();
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida del re
	 */
	@Test
	public void testValidMove4() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo il re al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,4), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(4,3));
		
		chessboard2 = chessboard2.move(new Coordinates(7,4), new Coordinates(4,3));
		chessboard2.setTurn();
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida del re
	 */
	@Test
	public void testValidMove5() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo il re al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,4), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(4,5));
		
		chessboard2 = chessboard2.move(new Coordinates(7,4), new Coordinates(4,5));
		chessboard2.setTurn();
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida del re
	 */
	@Test
	public void testValidMove6() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo il re al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,4), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(5,3));
		
		chessboard2 = chessboard2.move(new Coordinates(7,4), new Coordinates(5,3));
		chessboard2.setTurn();
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida del re
	 */
	@Test
	public void testValidMove7() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo il re al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,4), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(5,5));
		
		chessboard2 = chessboard2.move(new Coordinates(7,4), new Coordinates(5,5));
		chessboard2.setTurn();
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare una mossa valida del re
	 */
	@Test
	public void testValidMove8() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo il re al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,4), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(5,5));
		
		chessboard2 = chessboard2.move(new Coordinates(7,4), new Coordinates(5,5));
		chessboard2.setTurn();
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare che il re non puo' mangiare una pedina del suo stesso colore
	 */
	@Test
	public void testNotInCheck() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(7, 4), new Coordinates(6,4));
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare che il re non puo' mangiare una pedina del suo stesso colore
	 */
	@Test
	public void testEat() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		chessboard.move(new Coordinates(1,7), new Coordinates(3,3));
		chessboard.move(new Coordinates(7,4), new Coordinates(4,3));
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(4,3), new Coordinates(3,3));
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
	/*
	 * Test per verificare delle mosse non valide del re.
	 */
	@Test
	public void testNotValidMove1() {

		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix chessboard2 = new ChessboardMatrix();
		
		// Spostiamo  re al centro della schacchiera
		chessboard = chessboard.move(new Coordinates(7,4), new Coordinates(4,4));
		
		Rules rules = new Rules(chessboard);
		
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(2,4));
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(1,5));
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(7,7));
		chessboard = rules.nextMove(new Coordinates(4, 4), new Coordinates(2,0));
		
		chessboard2 = chessboard2.move(new Coordinates(7,4), new Coordinates(4,4));
		
		assertTrue(chessboard.equals(chessboard2));
		
	}
	
}
