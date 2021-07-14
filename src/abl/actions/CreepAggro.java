package abl.actions;

import game.Chaser;
import game.Character;
import game.NeutralCreep;
import game.NeutralCreepCamp;
import game.Player;

import java.awt.Point;
import java.util.ArrayList;
/**
 * Fires a bullet. 
 * 
 * @author Ben Weber 3-7-11
 */
public class CreepAggro extends BaseAction {

	/**
	 * Fires a bullet at the target location.
	 * 
	 * Args:
	 *  - 0: object id of the attacker
	 *  - 1: object id of the target
	 */
	public void execute(Object[] args) {
            if (Chaser.getInstance().getListOfCreeps().isEmpty()) return;
            ArrayList<NeutralCreepCamp> camps = Chaser.getInstance().getListOfCamps();
            
            for (NeutralCreepCamp camp : camps) {
                if (!camp.getHas_alive_creeps()) continue;
                if (camp.getIs_triggered()) {
                    for (NeutralCreep creep: camp.getCreeps()) {
                        creep.NormalAttackAtTarget(creep.getAggro_unit());
                    }
                }
            }
		//Chaser.getInstance().fireChaserBullet(
		//		new Point((Integer)args[0], (Integer)args[1]), 
		//		new Point((Integer)args[2], (Integer)args[3]));
	}
}
