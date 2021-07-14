package abl.wmes;

import game.Chaser;
import game.Character;
import java.awt.Point;
import game.Constants_singleton;
import game.NeutralCreepCamp;
import java.util.ArrayList;

import wm.WME;

/**
 * Stores information about the chaser.
 *
 * @author Ben Weber 3-7-11
 */
public class CreepWME extends WME implements game.Constants {

    private boolean is_aggroed;

    /**
     * Instantiates a working memory element for tracking the chaser.
     */
    /*public CreepWME(Point location, Point trajectory) {
		this.location = location;
		this.trajactory = trajectory;
	}*/
    public CreepWME() {
        is_aggroed = false;
        updateAndStore();
    }

    public boolean getIsInBaitLocation() {
//		if(location.x > laneStart_x && location.x < (laneStart_x + baitInitialPositionLength)
//				&& location.y > laneStart_y && location.y < (laneStart_y + laneLength_y)) {
//					return true;
//				}   

        return false;
    }

    public boolean getIs_aggroed() {
        return is_aggroed;
    }
    
    public void updateAndStore() {
        ArrayList<NeutralCreepCamp> camps = Chaser.getInstance().getListOfCamps();
        is_aggroed = false;
        for (NeutralCreepCamp camp : camps) {
            is_aggroed = is_aggroed || camp.getIs_triggered();
        }
    }

}
