package abl.actions;

import game.Chaser;
import game.Constants_singleton;
import game.Character;

import java.awt.Point;
/**
 * Sets the trajectory of the chaser. 
 * 
 * @author Ben Weber 3-7-11
 */
public class MoveLeft extends BaseAction {

	/**
	 * Sets the trajectory of the player to move left.
	 */
	public void execute(Object[] args) {
		            Character to_move = (Character)Chaser.getInstance().get_game_object_with_id((Integer)args[0]);
            to_move.setDx(-Constants_singleton.hero_move_speed);
//Chaser.getInstance().setPlayerTrajectory(new Point(-Chaser.ChaserSpeed, 0));
	}
}
