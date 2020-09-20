package com.str.simulation.rpstourney;

import java.util.Random;

/**
 * @author Spencer Lee
 * 
 * Defines the possible moves that can be taken in this game.
 */
class MoveManager {
	
	private final Random _rndGenerator;
	
	private static final Move[] _values = Move.values();
	
	MoveManager()
	{ //Each manager has its own random number generator with its own random seed.
		_rndGenerator = new Random();
	}
	
	/**
	 * @return A random, valid move for rock paper scissors.
	 */
	Move shoot()
	{
		return _values[_rndGenerator.nextInt(3)];
	}
	
	/**
	 * Convenience class method to determine a losing enum value for a corresponding winner.
	 * @param winningMove The move to find the loser for
	 * @return The corresponding losing move
	 */
	static Move getLosingMove(Move winningMove)
	{
		return _values[((winningMove.ordinal()) + 1) % _values.length];
	}
}
