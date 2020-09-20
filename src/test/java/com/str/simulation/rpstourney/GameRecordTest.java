/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.str.simulation.rpstourney;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class GameRecordTest {
	private GameRecord _record;
	
    @Before 
    public void setUp() {
        _record = new GameRecord();
    }
    
    @Test
    public void testSingleEntry()
    {
    	_record.addMove(Move.PAPER);
    	
    	assertFalse(_record.hasWinner());
    }
    
    @Test
    public void testTwoOfSameEntries()
    {
    	_record.addMove(Move.PAPER);
    	
    	assertFalse(_record.hasWinner());
    }
    
    @Test
    public void testTwoDifferentEntries()
    {
    	_record.addMove(Move.PAPER);
    	_record.addMove(Move.SCISSORS);
    	
    	assertTrue(_record.hasWinner());
    	assertEquals(_record.getWinningMove(), Move.SCISSORS);
    	assertEquals(_record.getLosingMove(), Move.PAPER);
    }
    
    @Test
    public void testThreeOfSameEntries()
    {
    	_record.addMove(Move.ROCK);
    	_record.addMove(Move.ROCK);
    	_record.addMove(Move.ROCK);
    	
    	assertFalse(_record.hasWinner());
    }
    
    @Test
    public void testTwoOfLosingEntry()
    {
    	_record.addMove(Move.ROCK);
    	_record.addMove(Move.SCISSORS);
    	_record.addMove(Move.SCISSORS);
    	
    	assertTrue(_record.hasWinner());
    	assertEquals(_record.getWinningMove(), Move.ROCK);
    	assertEquals(_record.getLosingMove(), Move.SCISSORS);
    }
    
    @Test
    public void testThreeDifferentEntries()
    {
    	_record.addMove(Move.ROCK);
    	_record.addMove(Move.SCISSORS);
    	_record.addMove(Move.PAPER);
    	
    	assertFalse(_record.hasWinner());
    }
    
    @Test
    public void testFourEntriesWithWinner()
    {
    	_record.addMove(Move.ROCK);
    	_record.addMove(Move.SCISSORS);
    	_record.addMove(Move.SCISSORS);
    	_record.addMove(Move.PAPER);
    	
    	assertTrue(_record.hasWinner());
    	assertEquals(_record.getWinningMove(), Move.SCISSORS);
    	assertEquals(_record.getLosingMove(), Move.PAPER);
    }
    
    @Test
    public void testFourEntriesWithSameNumberEntries()
    {
    	_record.addMove(Move.ROCK);
    	_record.addMove(Move.ROCK);
    	_record.addMove(Move.SCISSORS);
    	_record.addMove(Move.SCISSORS);
    	
    	assertTrue(_record.hasWinner());
    	assertEquals(_record.getWinningMove(), Move.ROCK);
    	assertEquals(_record.getLosingMove(), Move.SCISSORS);
    }
    
    @Test
    public void testSixEntriesWithTie()
    {
    	_record.addMove(Move.ROCK);
    	_record.addMove(Move.ROCK);
    	_record.addMove(Move.SCISSORS);
    	_record.addMove(Move.SCISSORS);
    	_record.addMove(Move.PAPER);
    	_record.addMove(Move.PAPER);
    	
    	assertFalse(_record.hasWinner());
    }
    
    @Test
    public void testSixEntriesWithWinner()
    {
    	_record.addMove(Move.ROCK);
    	_record.addMove(Move.ROCK);
    	_record.addMove(Move.ROCK);
    	_record.addMove(Move.SCISSORS);
    	_record.addMove(Move.PAPER);
    	_record.addMove(Move.PAPER);
    	
    	assertTrue(_record.hasWinner());
    	assertEquals(_record.getWinningMove(), Move.ROCK);
    	assertEquals(_record.getLosingMove(), Move.SCISSORS);
    }
    
}
