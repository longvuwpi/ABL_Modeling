/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author vuxua
 */
public class NeutralCreepCamp extends GameObject {

    private ArrayList<NeutralCreep> creeps = new ArrayList<NeutralCreep>();
    boolean is_triggered;
    boolean has_alive_creeps;

    public NeutralCreepCamp(double width, double height, double x, double y) {
        super(width, height, x, y, 0, 0, 0, true, Color.GREEN);
        is_triggered = false;
        has_alive_creeps = false;
        add_to_world();
    }

    @Override
    public void update() {
        super.update();

        // This logic needs improvement because it only checks for the creeps that belongs to this camp.
        // if creeps from other camps or players get in the camp then it still does not spawn creeps.
        // creeps are only spawn when no player or no creep exists inside the camp.
        // Right now it only checks for creeps, because the players are not walking inside the creep camps anyway
        if ((Chaser.getInstance().getElapsed_seconds() % Constants_singleton.creep_respawn_time) == 3) {
            boolean spawn = true;
            for (NeutralCreep creep : creeps) {
                if (creep.bounding_box.intersects(bounding_box)) {
                    spawn = false;
                    break;
                }
            }
            if (spawn) {
                spawn_creep();
            }
        }

    }

    public void spawn_creep() {
        NeutralCreep creep1 = new NeutralCreep(this, getX(), getY());
        NeutralCreep creep2 = new NeutralCreep(this, getX() - 5.0, getY() + 50.0);
        NeutralCreep creep3 = new NeutralCreep(this, getX() + 40.0, getY() + 30.0);
        creeps.add(creep1);
        creeps.add(creep2);
        creeps.add(creep3);

        has_alive_creeps = true;
    }

    public void remove_creep(NeutralCreep creep) {
        creeps.remove(creep);
        if (creeps.isEmpty()) {
            has_alive_creeps = false;
            is_triggered = false;
        }
    }

    public void trigger_aggro(Player damage_dealer) {
        is_triggered = true;
        for (NeutralCreep creep : creeps) {
            creep.TakeDamageFrom(damage_dealer, 0);
        }
    }

    public void de_aggro() {
        is_triggered = false;
        for (NeutralCreep creep : creeps) {
            creep.de_aggro();
        }
    }

    public ArrayList<NeutralCreep> getCreeps() {
        return creeps;
    }

    public boolean getIs_triggered() {
        return is_triggered;
    }

    public boolean getHas_alive_creeps() {
        return has_alive_creeps;
    }

}
