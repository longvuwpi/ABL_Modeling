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

class CreepAggroThread extends Thread {

    NeutralCreepCamp the_camp;
    CreepAggro the_action;
    volatile boolean running = false;

    CreepAggroThread(NeutralCreepCamp thecamp, CreepAggro theaction) {
        the_camp = thecamp;
        the_action = theaction;
        running = true;
    }

    public void run() {
        boolean success = false;
        while (running) {
            //System.out.println("Im still trying to shoot over here");
            if (!the_camp.getIs_triggered()) {
                running = false;
                success = true;
            }
        }

        the_action.set_complete(true);

    }

}

public class CreepAggro extends BaseAction {

    /**
     * Fires a bullet at the target location.
     *
     * Args: - 0: object id of the attacker - 1: object id of the target
     */
    public void execute(Object[] args) {
        if (Chaser.getInstance().getListOfCreeps().isEmpty()) {
            return;
        }
        ArrayList<NeutralCreepCamp> camps = Chaser.getInstance().getListOfCamps();

        NeutralCreepCamp the_camp = null;
        //completionStatus = NOT_COMPLETE;
        for (NeutralCreepCamp camp : camps) {
            if (!camp.getHas_alive_creeps()) {
                continue;
            }
            if (camp.getIs_triggered()) {
                the_camp = camp;
                //for (NeutralCreep creep : camp.getCreeps()) {
                //    boolean is = creep.NormalAttackAtTarget(creep.getAggro_unit());
                //}
            }
        }
        
        completionStatus = NOT_COMPLETE;
        
        CreepAggroThread new_thread = new CreepAggroThread(the_camp, this);
        new_thread.start();
        //Chaser.getInstance().fireChaserBullet(
        //		new Point((Integer)args[0], (Integer)args[1]), 
        //		new Point((Integer)args[2], (Integer)args[3]));
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
