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

class MoveToPointThread extends Thread {

    GameObject to_move;

    public void run() {
        System.out.println("Hello from a thread!");
    }

}

public class MoveToPoint extends BaseAction {

    /**
     * Sets the trajectory of the player to move down.
     */
    public void execute(Object[] args) {
        Character to_move = (Character) Chaser.getInstance().get_game_object_with_id((Integer) args[0]);

        if (to_move == null) {
            return;
        }

        if (args.length == 2) {
            GameObject target = Chaser.getInstance().get_game_object_with_id((Integer) args[1]);
            to_move.set_target(target);
        } else if (args.length == 3) {
            to_move.set_target((Double) args[1], (Double) args[2]);
        }
//Chaser.getInstance().setPlayerTrajectory(new Point(0,Chaser.ChaserSpeed));
    }

    @Override
    public synchronized int getCompletionStatus() {
        completionStatus = NOT_COMPLETE;
        return completionStatus;
    }
}
