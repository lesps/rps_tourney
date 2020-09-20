package com.str.simulation.rpstourney;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Spencer Lee
 * Contains pertinent information for a single round of rock paper scissors.
 */
public class GameRecord {
	
	private Map<Move,Integer> _record;
	
	private boolean _hasWinner;
	private Move _winningMove;
	private int _maxCount;
	
	/**
	 * Constructs a new GameRecord.
	 */
	public GameRecord()
	{
		_record = new HashMap<Move,Integer>();
		_hasWinner = false;
		_maxCount = 0;
	}
	
	/**
	 * Record a new move and update winner if necessary
	 */
	public void addMove(Move newMove)
	{
		int count = _record.getOrDefault(newMove, 0);
		count += 1;
		
		_record.put(newMove, count);
		
		if(count == _maxCount)
		{
			_hasWinner = false;
			_winningMove = null;
		}
		else if(count > _maxCount)
		{
			_hasWinner = true;
			_maxCount = count;
			_winningMove = newMove;
		}
	}
	
	/**
	 * Cleans up the running tally method of detecting a winner.
	 */
	private void resolveWinner()
	{
		Set<Move> moves = _record.keySet();
		
		if(moves.size() < 2)
		{ 
			_hasWinner = false;
			_winningMove = null;
			return;
		}
		
		if(moves.size() > 2)
		{
			return;
		}
		
		for(Move move : moves)
		{
			if(moves.contains(MoveManager.getLosingMove(move)))
			{
				_winningMove = move;
				_hasWinner = true;
				break;
			}
		}
	}
	
	/**
	 * @return True if there is a winner; false otherwise
	 */
	public boolean hasWinner()
	{
		resolveWinner();
		
		return _hasWinner;
	}
	
	/**
	 * @throws IllegalStateException If called when there is no winner
	 * @return The winning move
	 */
	public Move getWinningMove()
	{
		if(!_hasWinner)
		{
			throw new IllegalStateException("Cannot have a winner if there is a tie.");
		}
		
		return _winningMove;
	}
	
	/**
	 * @throws IllegalStateException If called when there is no winner
	 * @return The losing move
	 */
	public Move getLosingMove()
	{
		if(!_hasWinner)
		{
			throw new IllegalStateException("Cannot have a loser if there is a tie.");
		}
		
		return MoveManager.getLosingMove(_winningMove);
	}
}
