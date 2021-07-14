/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import static java.lang.System.currentTimeMillis;

/**
 *
 * @author vuxua
 */
public class Player extends Character {

    private int gold = 0;
    private boolean is_dead;
    private int dead_time = 5;
    private long dead_time_marker;

    //initialize values of the player
    public Player() {
        super(Constants_singleton.getInstance().hero_width, Constants_singleton.getInstance().hero_height, Constants_singleton.base_location.x, Constants_singleton.base_location.y);
        setColor(Color.DARK_GRAY);
        health = Constants_singleton.getInstance().hero_health;
        is_dead = false;
        max_health = health;
        damage = Constants_singleton.getInstance().hero_damage;
        gold = 100;
        setIdle(false);
        setSpeed(Constants_singleton.hero_move_speed);
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
        }
    }

    @Override
    public void NormalAttackAtTarget(Character target) {
        if (!is_dead) {
            super.NormalAttackAtTarget(target);
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
            super.paintObject(g);
        } else {
            g.setColor(Color.GRAY);
            int count_down = dead_time - (int) ((currentTimeMillis() - dead_time_marker) / 1000);
            String dead = "PLAYER DIED";
            String time = Integer.toString(count_down);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
            g.drawString(dead, 560, 150);
            g.drawString(time, 600, 180);
        }
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
}
