package app.game;

/**
 *
 * the current mode of the game, e.g. 1v1, 2v2, 1v1v1, ...
 *
 * the number of players in this game. This can be different based on modes
 *
 * @author bo.wang1
 *
 * @param <T> Class that implements Game
 * @param <K> Action that the game takes
 */
public interface Game {
	/**
	 * Mode of the current game
	 *
	 * @return
	 */
	String getMode();

	/**
	 * Number of players required for the current game
	 *
	 * @return
	 */
	int getPlayers();

	/**
	 * Get all player ids
	 *
	 * @return
	 */
	String[] getPlayerIds();

	/**
	 * If player is still online
	 *
	 * @param player
	 * @return
	 */
	boolean isOnline(String player);
}