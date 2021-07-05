package app.game;

/**
 * An agent to come in and finish the game when user is disconnected. It must
 * follow the rules of the game, but doesn't need to be smart.
 *
 * @author bo.wang1
 *
 */
public interface Agent {
	void nextAction(Game game);
}