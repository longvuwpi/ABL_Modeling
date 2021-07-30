package game;

import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Records the location and trajectory of a bullet.
 *
 * @author Ben Weber 3-7-11
 */
enum CharacterType {
    CREEP,
    PLAYER;
}

public class Character extends GameObject {

    private boolean is_taking_dmg;
    private Character aggro_unit = null;

    private int countdown_taking_dmg;
    private int countdown_taking_dmg_total = 3;

    private int countdown_attack_total = 10;
    private int countdown_attack = 0;

    private double attack_range = 0;

    int health = 0;
    int max_health = 0;
    int damage = 0;

    /**
     * bullet speed
     */
    /**
     * Creates a bullet that will move towards the target location.
     */
    public Character(double width, double height, double location_x, double location_y) {
        super(width, height, location_x, location_y, 0, 0, 0, true, Color.BLACK);
        set_layer(1);
        //character_type = new_character_type;

    }

    @Override
    public void update() {
        super.update();
        if (countdown_attack > 0) {
            countdown_attack--;
        }
        if (countdown_taking_dmg > 0) {
            countdown_taking_dmg--;
        }
        //if (character_type == CharacterType.PLAYER) {
        //    System.out.println("Player is at " + getX() + "," + getY());
        //}
    }

    @Override
    public void paintObject(Graphics g) {
        super.paintObject(g);
        if (countdown_taking_dmg > 0) {
            g.setColor(Color.RED);
            g.fillRect((int) x, (int) y, (int) size_width, (int) size_height);
        }
        String health_todraw = Integer.toString(health);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString(health_todraw, (int) getX(), (int) getY());
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return max_health;
    }
    
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean NormalAttackAtTarget(Character target) {
        if (countdown_attack == 0) {
            Bullet bullet = new Bullet(this, target);
            bullet.setDamage(damage);
            countdown_attack = countdown_attack_total;
            return true;
        } else return false;
    }

    public void DealDamageTo(Character target) {
        target.TakeDamageFrom(this, damage);
    }

    public void TakeDamageFrom(Character damage_dealer, int damage) {
        health -= damage;
        countdown_taking_dmg = countdown_taking_dmg_total;
        if (aggro_unit == null) {
            is_taking_dmg = true;
            aggro_unit = damage_dealer;
        }

        //if (character_type == CharacterType.CREEP) {
        //    setDx(0);
        //    setDy(3);
        //}
        setIdle(false);
        if (health <= 0) {
            die();
        }
    }

    public void die() {
        remove_from_world();
    }

    public Character getAggro_unit() {
        return aggro_unit;
    }

    public void setAggro_unit(Character unit) {
        aggro_unit = unit;
    }

    public void set_attack_range(double range) {
        attack_range = range;
    }

    public boolean is_object_in_attack_range(GameObject the_object) {
        double distance = Constants_singleton.getInstance().get_distance_between_objects(this, the_object);
        return (distance <= attack_range);
    }
    
    @Override
    public int get_estimated_strength() {
        return (health * damage);
    }
}
