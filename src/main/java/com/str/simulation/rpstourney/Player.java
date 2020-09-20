package com.str.simulation.rpstourney;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Spencer Lee
 * Represents a single player in a rock paper scissors game.
 */
public class Player
{
	//Store previous moves in a list in case we want to make more complex strategies.
	private List<Move> _record;
	
	private MoveManager _brain;
	private int _id;
	
    /**
     * @param id The player's ID, 0-based.
     */
    public Player(int id)
    {
    	_record = new ArrayList<Move>();
    	_brain = new MoveManager();
    	_id = id;
    }
    
    /**
     * @return The player's ID as a character, starting from A.
     */
    public char getId()
    {
    	return (char)(_id + 'A');
    }
    
    /**
     * @return The move that this player is making.
     */
    public Move shoot()
    {
    	Move myMove = _brain.shoot();
    	_record.add(myMove);
    	return myMove;
    }
    
    /**
     * @return The last move the player made.
     */
    public Move getLastMove()
    {
    	return _record.get(_record.size() - 1);
    }
    
    /**
     * @param loser The losing move
     * @return True if this player is a loser; false otherwise
     */
    public boolean isLoser(Move loser)
    {
    	return getLastMove() == loser;
    }
}
