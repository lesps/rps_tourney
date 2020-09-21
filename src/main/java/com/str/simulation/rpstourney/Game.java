package com.str.simulation.rpstourney;

import java.util.ArrayList;

/**
 * @author Spencer Lee
 * Contains and runs a game of Rock Paper Scissors.
 */
public class Game {
	
	private Group _group;
	private ArrayList<GameRecord> _records;
	private ILogger _logger;
	
	/**
	 * Constant line that prints between sections of the output.
	 */
	private final static String ROUND_SEPARATOR = "---------------------------------------";
	
	/**
	 * @param logger The ILogger to use for output.
	 */
	public Game(ILogger logger)
	{
		_logger = logger;
		_group = new Group(_logger);
		_records = new ArrayList<GameRecord>();
	}
	
	/**
	 * @param logger The ILogger to use for output.
	 * @param numPlayers The number of players, if specified.
	 */
	public Game(ILogger logger, int numPlayers)
	{
		_logger = logger;
		_group = new Group(_logger, numPlayers);
		_records = new ArrayList<GameRecord>();
	}
	
	/**
	 * Runs a tournament with the given game group.
	 */
	public void runTournament()
	{
		_logger.log(String.format("Beginning game with %d players.", _group.getNumPlayers()));
		_logger.log(ROUND_SEPARATOR);
		
		while(!_group.hasWinner())
		{
			_records.add(_group.playRound());
			_logger.log(Game.ROUND_SEPARATOR);
		}
		
		_logger.log(String.format("Player %c is the winner!", _group.getWinner().getId()));
	}
}
