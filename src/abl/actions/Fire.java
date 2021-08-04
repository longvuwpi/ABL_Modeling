package abl.actions;

import game.Chaser;
import game.Character;
import game.GameObject;
import game.NeutralCreepCamp;

import java.awt.Point;

/**
 * Fires a bullet.
 *
 * @author Ben Weber 3-7-11
 */

class FireThread extends Thread {

    Character to_fire;
    NeutralCreepCamp target;
    Fire the_action;
    protected volatile boolean running = false;
    
    FireThread(Character tofire, NeutralCreepCamp tar, Fire theaction) {
        to_fire = tofire;
        target = tar;
        the_action = theaction;
        running = true;
    }

    public void run() {
        boolean success = false;
        if (!target.getHas_alive_creeps()) running = false;
        while (running) {
            if (target.getHas_alive_creeps())
            {
                to_fire.NormalAttackAtTarget(target.getCreeps().get(0));
            }
            //System.out.println("Im still trying to shoot over here");
            else {
                running = false;
                success = true;
            }
        }

        success = target.getHas_alive_creeps();
        the_action.set_complete(success);

    }

}

public class Fire extends BaseAction {

    FireThread execution_thread;
    
    /**
     * Fires a bullet at the target location.
     *
     * Args: - 0: object id of the attacker - 1: object id of the target
     */
    public void execute(Object[] args) {
        if (Chaser.getInstance().getListOfCreeps().isEmpty()) {
            return;
        }
        Character attacker = (Character) Chaser.getInstance().get_game_object_with_id((Integer) args[0]);
        NeutralCreepCamp target = (NeutralCreepCamp) Chaser.getInstance().get_game_object_with_id((Integer) args[1]);
        if ((attacker == null) || (target == null)) {
            return;
        }
        //attacker.NormalAttackAtTarget(target);
        completionStatus = NOT_COMPLETE;
        execution_thread = new FireThread(attacker,target,this);
        execution_thread.start();
        //Chaser.getInstance().fireChaserBullet(
        //		new Point((Integer)args[0], (Integer)args[1]), 
        //		new Point((Integer)args[2], (Integer)args[3]));
    }

    @Override
    public void abort() {
        execution_thread.running = false;
    }
    
    public void set_complete(boolean succeeded) {
        //System.out.println("I'm set to complete moving");
        if (succeeded) {
            completionStatus = SUCCESS;
        } else {
            completionStatus = FAILURE;
        }
    }

    @Override
    public synchronized int getCompletionStatus() {
        //completionStatus = NOT_COMPLETE;
        /*if (completionStatus == NOT_COMPLETE) {
            System.out.println("not done firing");
        } else {
            System.out.println("Is already done firing");
        }*/
        return completionStatus;
    }
}
