package test;
import static org.junit.Assert.*;
import model.ChessboardMatrix;
import model.SquaresModel;
import moves.Mover;
import org.junit.Test;
import pieces.Coordinates;


public class TestMover {

	@Test
	/*
	 * Questo test verifica che il nero non puo' muovere per primo
	 */
	public void testBlackNotFirst() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix expectedChessboard = new ChessboardMatrix();
		
		Mover mover = new Mover(new SquaresModel(chessboard));
		
		mover.click(new Coordinates(1,0));
		mover.click(new Coordinates(2,0));
		
		assertTrue(expectedChessboard.equals(chessboard));
	}
	
	@Test
	/*
	 * Questo test verifica che il bianco non puo' muovere due volte consecutive
	 */
	public void testWhite() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix expectedChessboard = new ChessboardMatrix();
		
		Mover mover = new Mover(new SquaresModel(chessboard));
		
		mover.click(new Coordinates(6,0));
		mover.click(new Coordinates(5,0));
		mover.click(new Coordinates(5,0));
		mover.click(new Coordinates(4,0));
		
		expectedChessboard.move(new Coordinates(6,0), new Coordinates(5,0));
		
		assertTrue(expectedChessboard.equals(chessboard));
	}
	
	@Test
	/*
	 * QUesto test controlla che i turni vengono rispettati
	 */
	public void testClick() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		ChessboardMatrix expectedChessboard = new ChessboardMatrix();
		
		Mover mover = new Mover(new SquaresModel(chessboard));
		
		// prima mossa: bianco
		mover.click(new Coordinates(6,0));
		mover.click(new Coordinates(5,0));
		
		// seconda mossa: nero
		mover.click(new Coordinates(1,0));
		mover.click(new Coordinates(2,0));
		
		expectedChessboard.move(new Coordinates(6,0), new Coordinates(5,0));
		expectedChessboard.move(new Coordinates(1,0), new Coordinates(2,0));
		
		assertTrue(chessboard.equals(expectedChessboard));
	}
}
