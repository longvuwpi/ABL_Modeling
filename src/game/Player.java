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
        add_to_world();

    }

    // earn gold from killing creeps
    public void EarnGold(int gold_amount) {
        gold += gold_amount;
    }

    // when player dies, he does not get removed
    // but only becomes idle and then respawn in the base
    @Override
    public void die() {
        is_dead = true;
        // 
        dead_time_marker = currentTimeMillis();
    }

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
    }

    @Override
    public boolean NormalAttackAtTarget(Character target) {
        if (!is_dead) {
            return super.NormalAttackAtTarget(target);
        } else {
            return false;
        }
    }

    public void spawn() {
        health = max_health;
        is_dead = false;
        setX(Constants_singleton.base_location.x);
        setY(Constants_singleton.base_location.y);
    }

    @Override
    public void paintObject(Graphics g) {
        if (!is_dead) {
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
    
    public boolean is_object_in_vision(GameObject game_object) {
        return vision.intersects(game_object.bounding_box);
    }
}
