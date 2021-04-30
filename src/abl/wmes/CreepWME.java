package abl.wmes;

import game.Chaser;
import game.Character;
import java.awt.Point;
import game.Constants_singleton;

import wm.WME;

/**
 * Stores information about the chaser.
 *
 * @author Ben Weber 3-7-11
 */
public class CreepWME extends WME implements game.Constants {

    private int creep_object_id;
    /**
     * Location of the chaser
     */
    private boolean is_aggroed;
    private boolean is_dead;
    private Character attacker;

    /**
     * Instantiates a working memory element for tracking the chaser.
     */
    /*public CreepWME(Point location, Point trajectory) {
		this.location = location;
		this.trajactory = trajectory;
	}*/
    public CreepWME() {
        creep_object_id = Constants_singleton.creep_object_id;
        is_aggroed = false;
        attacker = null;
        updateAndStore();
    }

    public boolean getIsInBaitLocation() {
//		if(location.x > laneStart_x && location.x < (laneStart_x + baitInitialPositionLength)
//				&& location.y > laneStart_y && location.y < (laneStart_y + laneLength_y)) {
//					return true;
//				}   

        return false;
    }

    public int getCreep_object_id() {
        return creep_object_id;
    }

    public boolean getIs_aggroed() {
        return is_aggroed;
    }

    public boolean getIs_dead() {
        return is_dead;
    }

    public void updateAndStore() {
        if (Chaser.getInstance().getListOfCreeps().isEmpty()) {
            is_dead = true;
            is_aggroed = false;
        }
        if (!is_dead) {
            Character creep = (Character) Chaser.getInstance().get_game_object_with_id(creep_object_id);
            if (creep.getAggro_unit() != null) {
                is_aggroed = true;
                attacker = creep.getAggro_unit();
            } else is_aggroed = false;
            if (creep.getHealth() <= 0) {
                is_dead = true;
                is_aggroed = false;
            }
            if (is_dead) {
                System.out.println("creep is dead");
            } else {
                System.out.println("Creep is not dead");
            }
        }
    }

    public int getAttacker_object_id() {
        if (attacker != null) {
            return attacker.getGame_object_id();
        } else {
            return -1;
        }
    }
}
