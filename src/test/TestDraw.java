package test;
import static org.junit.Assert.*;
import model.ChessboardMatrix;
import model.SquaresModel;
import moves.Mover;

import org.junit.Test;

import pieces.Coordinates;


public class TestDraw {

	/*
	 * Test che verifica la presenza della patta
	 * Re cotro Re
	 */
	@Test
	public void test1() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		
		//eliminiano un po' di pezzi neri
		for (int i=0; i<8; i++){
			if ( i==4 )
				chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(1,4));
			else{
				chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(0,i));
				chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(1,i));
			}
		}
	
		//eliminiano i pedoni bianchi
		for (int i=0; i<8; i++)
			chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(6,i));
		
		//eliminiamo i pezzi bianchi in piu'
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,0));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,1));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,2));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,3));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,5));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,6));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,7));
		chessboard.setTurn();
		Mover mover = new Mover(new SquaresModel(chessboard));
		
		assertTrue(mover.isDraw());		
	}
	
	/*
	 * Test che verifica la presenza della patta
	 * Re e Cavallo contro Re
	 */
	@Test
	public void test2() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		
		//eliminiano un po' di pezzi neri
		for (int i=0; i<8; i++){
			if ( i==4 )
				chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(1,4));
			else{
				chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(0,i));
				chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(1,i));
			}
		}
	
		//eliminiano i pedoni bianchi
		for (int i=0; i<8; i++)
			chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(6,i));
		//eliminiamo i pezzi bianchi in piu'
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,0));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,2));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,3));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,5));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,6));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,7));
		chessboard.setTurn();
		Mover mover = new Mover(new SquaresModel(chessboard));
		
		assertTrue(mover.isDraw());		
	}

	/*
	 * Test che verifica la presenza della patta
	 * Re e Alfiere contro Re
	 */
	@Test
	public void test3() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		
		//eliminiano un po' di pezzi neri
		for (int i=0; i<8; i++){
			if ( i==4 )
				chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(1,4));
			else{
				chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(0,i));
				chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(1,i));
			}
		}
	
		//eliminiano i pedoni bianchi
		for (int i=0; i<8; i++)
			chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(6,i));
		//eliminiamo i pezzi bianchi in piu'
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,0));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,1));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,3));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,5));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,6));
		chessboard = chessboard.move(new Coordinates(3,3), new Coordinates(7,7));
		chessboard.setTurn();
		Mover mover = new Mover(new SquaresModel(chessboard));
		
		assertTrue(mover.isDraw());		
	}
	
}
