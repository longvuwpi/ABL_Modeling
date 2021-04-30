package abl.actions;

import game.Chaser;
import game.Character;

import java.awt.Point;
/**
 * Fires a bullet. 
 * 
 * @author Ben Weber 3-7-11
 */
public class Fire extends BaseAction {

	/**
	 * Fires a bullet at the target location.
	 * 
	 * Args:
	 *  - 0: object id of the attacker
	 *  - 1: object id of the target
	 */
	public void execute(Object[] args) {
            if (Chaser.getInstance().getListOfCreeps().isEmpty()) return;
            Character attacker = (Character)Chaser.getInstance().get_game_object_with_id((Integer)args[0]);
            Character target = (Character)Chaser.getInstance().get_game_object_with_id((Integer)args[1]);
            if ((attacker == null) || (target == null)) return;
            attacker.NormalAttackAtTarget(target);
		//Chaser.getInstance().fireChaserBullet(
		//		new Point((Integer)args[0], (Integer)args[1]), 
		//		new Point((Integer)args[2], (Integer)args[3]));
	}
}
