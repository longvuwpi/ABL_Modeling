package abl.actions;

import game.Chaser;
import game.Character;
import game.Constants_singleton;
import game.GameObject;
import java.awt.Point;

/**
 * Sets the trajectory of the chaser.
 *
 * @author Ben Weber 3-7-11
 */

class MoveToObjectThread extends Thread {

    Character to_move;
    GameObject destination;
    MoveToObject the_action;
    volatile boolean running = false;
    MoveToObjectThread(Character tomove, GameObject dest, MoveToObject theaction) {
        to_move = tomove;
        destination = dest;
        the_action = theaction;
        running = true;
    }

    public void run() {
        boolean success = false;
        while (running) {
            if (to_move.is_object_in_attack_range(destination)) {
                running = false;
                            //System.out.println("Stop moving");

            }
        }
        to_move.setDx(0.0);
        to_move.setDy(0.0);
        the_action.set_complete();

    }

}

public class MoveToObject extends BaseAction {

        Character to_move = null;
    GameObject destination;
    MoveToObject the_action;
    /**
     * Sets the trajectory of the player to move down.
     */
    public void execute(Object[] args) {
        to_move = (Character) Chaser.getInstance().get_game_object_with_id((Integer) args[0]);

        if (to_move == null) {
            return;
        }

        GameObject target = Chaser.getInstance().get_game_object_with_id((Integer) args[1]);
        to_move.set_target(target);

        completionStatus = NOT_COMPLETE;
        
        MoveToObjectThread new_thread = new MoveToObjectThread(to_move, target, this);
        new_thread.start();
//Chaser.getInstance().setPlayerTrajectory(new Point(0,Chaser.ChaserSpeed));
        destination = target;
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
