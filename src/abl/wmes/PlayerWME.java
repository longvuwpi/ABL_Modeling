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

    private int player_location_x;
    private int player_location_y;
    private int player_trajectory_dx;
    private int player_trajectory_dy;

    private int creep_object_id;
    private int creep_location_x;
    private int creep_location_y;
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
        player_object_id = Constants_singleton.hero_object_id;
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

    public int getPlayer_location_x() {
        return player_location_x;
    }

    public int getPlayer_location_y() {
        return player_location_y;
    }

    public int getPlayer_trajectory_dx() {
        return player_trajectory_dx;
    }

    public int getPlayer_trajectory_dy() {
        return player_trajectory_dy;
    }

    public int getCreep_location_x() {
        return creep_location_x;
    }

    public int getCreep_location_y() {
        return creep_location_y;
    }

    public boolean getCreep_exists() {
        return creep_exists;
    }

    public int getCreep_object_id() {
        return creep_object_id;
    }

    public boolean getIsPlayerHealthy() {
        Character player = (Character) Chaser.getInstance().get_game_object_with_id(player_object_id);
        return (player.getHealth() >= player.)
    }
    public boolean getIsInRangeOfCreep() {
        if (Chaser.getInstance().getListOfCreeps().isEmpty()) {
            return false;
        }

        Character player = Chaser.getInstance().getListOfPlayers().get(0);
        Character creep = Chaser.getInstance().getListOfCreeps().get(0);

        double distance = sqrt(pow(player.getX() - creep.getX(), 2) + pow(player.getY() - creep.getY(), 2));
        boolean result = distance <= Constants_singleton.getInstance().hero_atk_range;
        if (result) {
            System.out.println(distance + "is in range");
        } else {
            System.out.println(distance + "Is not in range");
        }
        return result;
    }

    public void updateAndStore() {
        Character player = Chaser.getInstance().getListOfPlayers().get(0);

        player_location_x = player.getX();
        player_location_y = player.getY();
        player_trajectory_dx = (int) player.getDx();
        player_trajectory_dy = (int) player.getDy();

        if (!Chaser.getInstance().getListOfCreeps().isEmpty()) {
            Character creep = Chaser.getInstance().getListOfCreeps().get(0);

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
