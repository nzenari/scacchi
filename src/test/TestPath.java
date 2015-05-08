package test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pieces.Colour;
import pieces.Coordinates;
import pieces.Queen;


public class TestPath {
	/*
	 * Test funzione getPath che date due coordinate (from e to) trova le posizioni che si trovano tra il from
	 * ed to esclusi. 
	 * Questo metodo è capace di calcolare il Path in obliquo, verticale ed in orizzontale.
	 */
	@Test
	public void testVertical() {
		Queen queen = new Queen(Colour.WHITE);
		ArrayList<Coordinates> man = new ArrayList<>();
		ArrayList<Coordinates> calc = queen.getPath(new Coordinates(5,5), new Coordinates(1,5));
		
		man.add(new Coordinates(4,5));
		man.add(new Coordinates(3,5));
		man.add(new Coordinates(2,5));
		
		assertTrue(calc.equals(man));
	}
	
	@Test
	public void testOrizzontal() {
		Queen queen = new Queen(Colour.WHITE);
		ArrayList<Coordinates> man = new ArrayList<>();
		ArrayList<Coordinates> calc = queen.getPath(new Coordinates(5,5), new Coordinates(5,1));
		
		man.add(new Coordinates(5,4));
		man.add(new Coordinates(5,3));
		man.add(new Coordinates(5,2));
		
		assertTrue(calc.equals(man));
	}
	
	@Test
	public void testOblique() {
		Queen queen = new Queen(Colour.WHITE);
		ArrayList<Coordinates> man = new ArrayList<>();
		ArrayList<Coordinates> calc = queen.getPath(new Coordinates(5,5), new Coordinates(1,1));
		
		man.add(new Coordinates(4,4));
		man.add(new Coordinates(3,3));
		man.add(new Coordinates(2,2));
		
		assertTrue(calc.equals(man));
	}

}
