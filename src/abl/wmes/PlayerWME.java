package abl.wmes;

import game.Constants_singleton;

import game.Character;

import java.awt.Point;
import wm.WME;
import java.util.ArrayList;
import game.*;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

/**
 * Stores information about the player character.
 *
 * In ABL: WME = Working memory element. WMEs are used to provide the agent with
 * game state.
 *
 * Note: ABL code can access WME properties using standard Java Bean naming
 * conventions Example: locationX in ABL invoked getLocationX()
 *
 * @author Ben Weber 3-7-11
 */
public class PlayerWME extends WME {

    private int player_object_id;

    private double player_location_x;
    private double player_location_y;
    private double player_trajectory_dx;
    private double player_trajectory_dy;

    private int creep_object_id;
    private double creep_location_x;
    private double creep_location_y;
    private boolean creep_exists;

    /**
     * Instantiates a working memory element for tracking the player character.
     */
    public PlayerWME(/*Point location, Point trajectory*/) {
        //this.location = location;
        //this.trajactory = trajectory;

//		Point dimensions = new Point(width, height);
//		this.targetPoint = new Point((int)(dimensions.x*Math.random()), (int)(dimensions.y*Math.random()));
        //targetPoint = new Point(400,400);
        player_object_id = Chaser.getInstance().getListOfPlayers().get(0).getGame_object_id();
        updateAndStore();
    }

    public boolean getIsInBaitLocation() {
//		if(location.x > laneStart_x && location.x < (laneStart_x + baitInitialPositionLength)
//				&& location.y > laneStart_y && location.y < (laneStart_y + laneLength_y)) {
//					System.out.println("Target in bait initial position");
//					this.targetPoint = new Point(baitPoint);
//					System.out.println(""+ targetPoint.x + ", " + targetPoint.y);
        return true;
//				}   

//		System.out.println("out of position");
//		Point dimensions = new Point(width, height);
//		targetPoint = new Point((int)(dimensions.x*Math.random()), (int)(dimensions.y*Math.random()));
//		return false;
    }

    public int getPlayer_object_id() {
        return player_object_id;
    }

    public double getPlayer_location_x() {
        return player_location_x;
    }

    public double getPlayer_location_y() {
        return player_location_y;
    }

    public double getPlayer_trajectory_dx() {
        return player_trajectory_dx;
    }

    public double getPlayer_trajectory_dy() {
        return player_trajectory_dy;
    }

    public double getCreep_location_x() {
        return creep_location_x;
    }

    public double getCreep_location_y() {
        return creep_location_y;
    }

    public boolean getCreep_exists() {
        return creep_exists;
    }

    public int getCreep_object_id() {
        return creep_object_id;
    }

    public boolean getIsInRangeOfCreep() {
        if (Chaser.getInstance().getListOfCreeps().isEmpty()) {
            return false;
        }

        Player player = Chaser.getInstance().getListOfPlayers().get(0);
        NeutralCreep creep = (NeutralCreep) Chaser.getInstance().get_game_object_with_id(creep_object_id);

        while (creep == null) updateAndStore();

        return player.is_object_in_attack_range(creep);
    }

    public void updateAndStore() {
        Character player = Chaser.getInstance().getListOfPlayers().get(0);

        player_location_x = player.getX();
        player_location_y = player.getY();
        player_trajectory_dx = (int) player.getDx();
        player_trajectory_dy = (int) player.getDy();

        if (!Chaser.getInstance().getListOfCreeps().isEmpty()) {
            NeutralCreep creep = Chaser.getInstance().getListOfCreeps().get(0);
            ArrayList<NeutralCreepCamp> camps = Chaser.getInstance().getListOfCamps();
            
            double min_distance = Integer.MAX_VALUE;
            NeutralCreepCamp closest_camp = creep.getCamp();
            
            for (NeutralCreepCamp camp : camps)
            {
                if (!camp.getHas_alive_creeps()) {
                    continue;
                }
                double distance = sqrt(pow(player.getX() - camp.getX(), 2.0) + pow(player.getY() - camp.getY(), 2.0));
                if (distance <= min_distance) {
                    min_distance = distance;
                    closest_camp = camp;
                }
            
            }
            
            creep = closest_camp.getCreeps().get(0);
            
            creep_location_x = creep.getX();
            creep_location_y = creep.getY();
            creep_exists = true;
            creep_object_id = creep.getGame_object_id();
        } else {
            creep_exists = false;
            creep_object_id = -1;
        }
    }
}
