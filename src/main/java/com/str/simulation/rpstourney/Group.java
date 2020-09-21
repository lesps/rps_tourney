package com.str.simulation.rpstourney;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Spencer Lee
 * Represents a group of players for rock paper scissors.
 */
class Group {
	
	/**
	 * Random number generator for determining the number of players.
	 */
	private static final Random _rndGenerator = new Random();
	
	private int _numPlayers;
	private List<Player> _players;
	private ILogger _logger;
	
	Group(ILogger logger)
	{
		this(logger, _rndGenerator.nextInt(9) + 2);
	}
	
	Group(ILogger logger, int numPlayers)
	{
		_logger = logger;
		
		//Generate random number of players from 2 to 10
		_numPlayers = numPlayers;
		
		//Initialize players list
		_players = new LinkedList<Player>();
		
		for(int i = 0; i < _numPlayers; i++)
		{
			_players.add(new Player(i));
		}
	}
	
	/**
	 * @return The number of players left in the game
	 */
	int getNumPlayers()
	{
		return _players.size();
	}
	
	/**
	 * @return True if there is one player remaining; false otherwise.
	 */
	boolean hasWinner()
	{
		return _players.size() == 1;
	}
	
	/**
	 * @return The winning player if there is one; otherwise null
	 */
	Player getWinner()
	{
		if(getNumPlayers() == 1)
		{
			return _players.get(0);
		}
		
		return null;
	}
	
	/**
	 * Eliminate losing players from the game.
	 * @param record The GameRecord to process.
	 */
	private void processElimination(GameRecord record)
	{
		String winningMove = record.getWinningMove().toString();
		String losingMove = record.getLosingMove().toString().toLowerCase();
		
		//Format winning move for printing
		winningMove = winningMove.substring(0,1) + winningMove.substring(1).toLowerCase();
		
		_logger.log(String.format("\n%s beats %s.", winningMove, losingMove));
		
		int numPlayersBefore = getNumPlayers();
		_players.removeIf(p -> p.isLoser(record.getLosingMove()));
		
		int numPlayersEliminated = numPlayersBefore - getNumPlayers();
		
		if(numPlayersEliminated > 0)
		{
			_logger.log(String.format("Eliminated: %d.", numPlayersEliminated));
		}
	}
	
	/**
	 * Plays a round of rock paper scissors and eliminates losers.
	 * @return The GameRecord chronicling the round.
	 */
	GameRecord playRound()
	{
		GameRecord record = new GameRecord();
		
		//Add moves for each player to the record
		for(Player p : _players)
		{
			Move nextMove = p.shoot();
			_logger.log(String.format("Player %c threw %s", p.getId(), nextMove.name().toLowerCase()));
			record.addMove(nextMove);
		}
		
		//If there is a winner, purge all losers... mercilessly
		if(record.hasWinner())
		{
			processElimination(record);
		}
		else
		{
			_logger.log("\nNo eliminations this round.");
		}
		
		//Return the record for this round
		return record;
	}
}
