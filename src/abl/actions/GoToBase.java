package abl.actions;

import game.Chaser;
import game.Character;
import game.Constants_singleton;
import game.GameObject;
import game.Player;
import java.awt.Point;

/**
 * Sets the trajectory of the chaser.
 *
 * @author Ben Weber 3-7-11
 */

class GoToBaseThread extends Thread {

    Player to_move;
    GoToBase the_action;
    volatile boolean running = false;
    GoToBaseThread(Player tomove, GoToBase theaction) {
        to_move = tomove;
        the_action = theaction;
        running = true;
    }

    public void run() {
        boolean success = false;
        Point in_base = new Point((int)(to_move.get_base().getX() + (to_move.get_base().getSize_width() / 2)), (int)(to_move.get_base().getY() + (to_move.get_base().getSize_height()/2)));
        while (running) {
            if (to_move.getBounding_box().contains(in_base)) {
                to_move.setDx(0);
                to_move.setDy(0);
            }
            if (to_move.getHealth() >= (to_move.getMaxHealth() * 90 / 100)) {
                running = false;
                            //System.out.println("Stop moving");
            }
        }

        the_action.set_complete();

    }

}

public class GoToBase extends BaseAction {

    /**
     * Sets the trajectory of the player to move down.
     */
    public void execute(Object[] args) {
        Player to_move = (Player) Chaser.getInstance().get_game_object_with_id((Integer) args[0]);

        if (to_move == null) {
            return;
        }

        to_move.set_target_to_base();

        completionStatus = NOT_COMPLETE;
        
        GoToBaseThread new_thread = new GoToBaseThread(to_move, this);
        new_thread.start();

    }

    @Override
    public synchronized int getCompletionStatus() {
        //completionStatus = NOT_COMPLETE;
        /*if (completionStatus == NOT_COMPLETE) {
            System.out.println("not done moving");
        } else {
            System.out.println("Is already done moving");
        }*/
        return completionStatus;
    }

    public void set_complete() {
        //System.out.println("I'm set to complete moving");
        completionStatus = SUCCESS;
    }
}
