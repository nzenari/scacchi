package test;
import static org.junit.Assert.*;
import model.ChessboardMatrix;

import moves.Rules;

import org.junit.Test;

import pieces.Colour;
import pieces.Coordinates;
import pieces.Rook;


public class TestPromotion {
	
	/*
	 * Secondo la nostra implementazione la funzione PawnTrip ritorna true se
	 * un pedone arriva "al capolinea" e alcune pedine (eccetto i pedoni stessi)
	 * dello stesso colore sono state mangiate.
	 * Questo test verifica quanto soprascritto.
	 */
	@Test
	public void testPawnTrip() {
		ChessboardMatrix chessboard = new ChessboardMatrix();
		
		/* 
		 * Simuliamo una mossa che mangia una pedina
		 */
		chessboard = chessboard.move(new Coordinates(1,7), new Coordinates(7,7));
		
		// Il pedone bianco arriva al capolinea 
		chessboard = chessboard.move(new Coordinates(6,3), new Coordinates(0,3));
		
		Rules rules = new Rules(chessboard);
		
		assertTrue(rules.pawnTrip(new Coordinates(0,3)));
	}

	/*
	 * Questo test verifica che se non sono state mangiate pedine (eccetto i pedoni)
	 * il metodo PawnTrip ritorna false
	 */
	@Test
	public void testPawnTripFalse(){
		ChessboardMatrix chessboard = new ChessboardMatrix();
		
		// Il pedone bianco arriva al capolinea 
		chessboard = chessboard.move(new Coordinates(6,3), new Coordinates(0,3));
		
		Rules rules = new Rules(chessboard);
		
		assertFalse(rules.pawnTrip(new Coordinates(0,3)));
	}
	
	@Test
	public void testPawnPromotion(){
		ChessboardMatrix chessboard = new ChessboardMatrix();
		
		// Simulazione: cavallo nero mangia torre bianca
		chessboard = chessboard.move(new Coordinates(0,6), new Coordinates(7,7));
		
		//ripesco dalle pedine mangiate la torre bianca e la metto nella posizione 0,6
		chessboard = chessboard.swap(new Coordinates(0,6), chessboard.getWhiteLostPieces().get(0));
		
		//verifico che lo scambio venga effettuato effettivamente
		assertTrue( chessboard.at(new Coordinates(0,6)) instanceof Rook &&
				chessboard.at(new Coordinates(0,6)).getColour().equals(Colour.WHITE));
	}
}
