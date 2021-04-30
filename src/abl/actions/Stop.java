package abl.actions;

import game.Chaser;
import game.Character;

import java.awt.Point;
/**
 * Stops the chaser. 
 * 
 * @author Ben Weber 3-7-11
 */
public class Stop extends BaseAction {

	/**
	 * Stops the chaser.
	 */
	public void execute(Object[] args) {
            Character to_move = (Character)Chaser.getInstance().get_game_object_with_id((Integer)args[0]);
            to_move.setDx(0);
            to_move.setDy(0);
            //Chaser.getInstance().setPlayerTrajectory(new Point(0,0));
	}
}
