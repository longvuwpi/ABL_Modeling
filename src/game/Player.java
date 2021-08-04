/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import static java.lang.System.currentTimeMillis;
import java.util.HashMap;

/**
 *
 * @author vuxua
 */
public class Player extends Character {

    private PlayerBase base;
    private int gold = 0;
    private boolean is_dead;
    private int dead_time = 5;
    private long dead_time_marker;

    private long base_heal_marker = 0;

    private int vision_diameter;
    private Ellipse2D vision;
    
    public HashMap<NeutralCreepCamp, Integer> belief;
    private int last_belief_update_minute = 0;
    private int last_belief_update_second = 0;
    
    //initialize values of the player
    public Player(PlayerBase new_base) {
        super(Constants_singleton.getInstance().hero_width, Constants_singleton.getInstance().hero_height, new_base.getX(), new_base.getY());
        setColor(Color.DARK_GRAY);
        health = Constants_singleton.getInstance().hero_health;
        is_dead = false;
        max_health = health;
        damage = Constants_singleton.getInstance().hero_damage;
        gold = 100;
        setIdle(false);
        setSpeed(Constants_singleton.hero_move_speed);
        set_attack_range(Constants_singleton.hero_atk_range);
        base = new_base;
        vision_diameter = Constants_singleton.hero_vision_diameter;
        vision = new Ellipse2D.Double(getX() + getSize_width()/2 - vision_diameter/2, getY() + getSize_height()/2 - vision_diameter/2, vision_diameter, vision_diameter);
        
        belief = new HashMap<NeutralCreepCamp, Integer>();
        //for (NeutralCreepCamp camp : Chaser.getInstance().getListOfCamps()) {
        //    belief.put(camp, 0);
        //}
        
        add_to_world();

    }

    // earn gold from killing creeps
    public void EarnGold(int gold_amount) {
        gold += gold_amount;
    }

    // when player dies, he does not get removed from the world
    // but only becomes idle and then respawn in the base
    @Override
    public void die() {
        is_dead = true;
        // 
        dead_time_marker = currentTimeMillis();
    }

    
    //each update tick
    //if the player is dead then the dead time count down is calculated so the player respawn when it is time
    //if the player is alive then he heals when he is in the base
    //also update his belief on all the existing creep camps
    @Override
    public void update() {
        super.update();
        if (is_dead) {
            int dead_time_passed = (int) ((currentTimeMillis() - dead_time_marker) / 1000);
            if (dead_time_passed > dead_time) {
                spawn();
            }
        } else {
            vision.setFrame(getX() + getSize_width()/2 - vision_diameter/2, getY() + getSize_height()/2 - vision_diameter/2, vision_diameter, vision_diameter);
            
            if (bounding_box.intersects(base.bounding_box)) {
                if ((currentTimeMillis() - base_heal_marker) >= 1000.0) {
                    health += Constants_singleton.base_heal_per_second;
                    base_heal_marker = currentTimeMillis();
                    if (health >= max_health) {
                        health = max_health;
                    }
                }
            }
        }
        
        update_belief();
    }

    
    //update belief about the creep camps
    //if it is creep spawning time, the player will assume that the camps that were killed before will have 3 creeps
    //the player will remember the camps that were not killed before and have the same belief about those camps
    //if the player is having vision of a creep camp, then the belief about that camp is updated with actual values
        public void update_belief() {
        int current_time_second = Chaser.getInstance().getElapsed_seconds();
        int current_time_minute = Chaser.getInstance().getElapsed_minutes();

        if (((current_time_second % Constants_singleton.creep_respawn_time) == 3)
                && ((current_time_second != last_belief_update_second)
                || (current_time_minute != last_belief_update_minute))) {
            for (NeutralCreepCamp camp : belief.keySet()) {
                if (belief.get(camp) == 0) {
                    belief.replace(camp, Constants_singleton.creep_health * Constants_singleton.creep_damage * 9);
                                System.out.println("updated value for camp");

                }
            }
            last_belief_update_second = current_time_second;
            last_belief_update_minute = current_time_minute;
        }

            for (NeutralCreepCamp camp : belief.keySet()) {
            if (is_object_in_vision(camp)) {
                belief.replace(camp, camp.get_estimated_strength());
            }
        }

    }
        
    //only attacks target when not dead
    @Override
    public boolean NormalAttackAtTarget(Character target) {
        if (!is_dead) {
            return super.NormalAttackAtTarget(target);
        } else {
            return false;
        }
    }

    //spawn in base with max health
    public void spawn() {
        health = max_health;
        is_dead = false;
        setX(Constants_singleton.base_location.x);
        setY(Constants_singleton.base_location.y);
    }

    @Override
    public void paintObject(Graphics g) {
        if (!is_dead) { //if not dead then draw the vision around the player
            Color vision_color = new Color(140, 255, 0, 110);
            g.setColor(vision_color);
            g.fillOval((int)vision.getX(), (int)vision.getY(), vision_diameter, vision_diameter);
            super.paintObject(g);
        } else {
            // draw the dead time counter on the screen when the player is dead
            g.setColor(Color.GRAY);
            int count_down = dead_time - (int) ((currentTimeMillis() - dead_time_marker) / 1000);
            String dead = "PLAYER DIED";
            String time = Integer.toString(count_down);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g.drawString(dead, 560, 150);
            g.drawString(time, 600, 180);
        }
        
        //draw how much gold the player has
        g.setColor(Color.BLACK);
        g.fillRect(25, 20, 175, 50);
        g.setColor(Color.orange);
        String gold_todraw = "GOLD: " + Integer.toString(gold);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g.drawString(gold_todraw, 50, 50);
    }

    public boolean is_dead() {
        return is_dead;
    }
    
    public void set_target_to_base(){
        set_target(this.base);
    }
    
    public PlayerBase get_base() {
        return base;
    }
    
    //check if the object is in the player's vision
    public boolean is_object_in_vision(GameObject game_object) {
        //return vision.intersects(game_object.bounding_box);
        return vision.contains(game_object.getX() + game_object.getSize_width()/2, game_object.getY() + game_object.getSize_height()/2);
    }
}
