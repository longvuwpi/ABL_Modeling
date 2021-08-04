/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author vuxua
 */
public class NeutralCreepCamp extends GameObject {

    //keeps track of all creeps that are alive in the camp
    private ArrayList<NeutralCreep> creeps = new ArrayList<NeutralCreep>();
    
    //whether the camp is being attacked by a player
    boolean is_triggered;
    
    boolean has_alive_creeps;

    //constructor for a neutral creep camp
    public NeutralCreepCamp(double width, double height, double x, double y) {
        super(width, height, x, y, 0, 0, 0, true, Color.GREEN);
        is_triggered = false;
        has_alive_creeps = false;
        add_to_world();
    }

    //if anything is in the creep camp, it does not spawn more creeps
    //otherwise, spawn more creeps
    @Override
    public void update() {
        super.update();

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

    //spawns 3 new creeps, randomly can spawn 2 extra creeps 
    public void spawn_creep() {
        NeutralCreep creep1 = new NeutralCreep(this, getX(), getY());
        NeutralCreep creep2 = new NeutralCreep(this, getX() - 5.0, getY() + 50.0);
        NeutralCreep creep3 = new NeutralCreep(this, getX() + 40.0, getY() + 30.0);
        creeps.add(creep1);
        creeps.add(creep2);
        creeps.add(creep3);

        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        if (randomNum >= 1) {
            NeutralCreep creep4 = new NeutralCreep(this, getX()+50, getY() + 50);
            creeps.add(creep4);
                        NeutralCreep creep5 = new NeutralCreep(this, getX() + 80, getY() + 80);
            creeps.add(creep5);
            //NeutralCreep creep6 = new NeutralCreep(this, getX() + 105, getY() + 105);
            //creeps.add(creep6);
        }

        
        has_alive_creeps = true;
    }

    //remove the creep from the camp
    //if no other alive creep exists in the camp then stop being aggroed
    public void remove_creep(NeutralCreep creep) {
        creeps.remove(creep);
        if (creeps.isEmpty()) {
            has_alive_creeps = false;
            is_triggered = false;
        }
    }

    //trigger aggro and let all the creeps in the camp attack the player who attacked the camp
    public void trigger_aggro(Player damage_dealer) {
        is_triggered = true;
        for (NeutralCreep creep : creeps) {
            creep.TakeDamageFrom(damage_dealer, 0);
        }
    }

    //stop attacking
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
        return (!creeps.isEmpty());
    }

    //estimate the current strength of the camp
    @Override
    public int get_estimated_strength() {
        int sum = 0;
        for (NeutralCreep creep : creeps) {
            sum += creep.get_estimated_strength();
        }
        
        sum *= creeps.size();
        //sum = creeps.size() * Constants_singleton.creep_damage * Constants_singleton.creep_health;
        
        
        return sum;
    }
}
