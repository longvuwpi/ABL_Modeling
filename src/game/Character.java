package game;

import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * Records the location and trajectory of a bullet.
 * 
 * @author Ben Weber 3-7-11
 */

enum CharacterType {
    CREEP,
    PLAYER;
}

public class Character extends GameObject{
        private CharacterType character_type;
        private int gold = 0;
        private int gold_bounty = 0;
        
        private boolean is_taking_dmg;
        private Character aggro_unit = null;
        
        private int countdown_taking_dmg;
        private int countdown_taking_dmg_total = 3;
        
        private int countdown_attack_total = 10;
        private int countdown_attack = 0;
        
        int health = 0;
        int damage = 0;
        
	/** bullet speed */
	/**
	 * Creates a bullet that will move towards the target location. 
	 */
	public Character(double width, double height,double location_x, double location_y, CharacterType new_character_type) {
            super(width, height, location_x,location_y,0,0,0,true, Color.BLACK);
            character_type = new_character_type;
            if (new_character_type == CharacterType.CREEP) {
                setColor(Color.PINK);
                health = Constants_singleton.getInstance().creep_health;
                damage = Constants_singleton.getInstance().creep_damage;
                gold_bounty = Constants_singleton.getInstance().creep_gold_bounty;
                setSize_width(Constants_singleton.getInstance().creep_width);
                setSize_height(Constants_singleton.getInstance().creep_height);
            } else {
                setColor(Color.DARK_GRAY);
                health = Constants_singleton.getInstance().hero_health;
                damage = Constants_singleton.getInstance().hero_damage;
                setSize_width(Constants_singleton.getInstance().hero_width);
                setSize_height(Constants_singleton.getInstance().hero_height);
                gold = 100;
                setIdle(false);
            }
           
            add_to_world();
	}
        
        @Override
        public void update(){
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
        public void paintObject(Graphics g){
            super.paintObject(g);
            if (countdown_taking_dmg > 0) {
                g.setColor(Color.RED);
		g.fillRect((int)x,(int)y,(int)size_width,(int)size_height);
            }
            String health_todraw = Integer.toString(health);
            g.setColor(Color.BLACK);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20)); 
            g.drawString(health_todraw, (int)getX(), (int)getY());
            if (character_type == CharacterType.PLAYER) {
                g.setColor(Color.BLACK);
                g.fillRect(25,20, 175, 50);
                g.setColor(Color.orange);
                String gold_todraw = "GOLD: " + Integer.toString(gold);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 25)); 
                g.drawString(gold_todraw, 50,50);
            }
        }
        
            public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public CharacterType getCharacter_type() {
        return character_type;
    }
    
    public void NormalAttackAtTarget(Character target){
        if (countdown_attack == 0) {
        Bullet bullet = new Bullet(this, target);
        bullet.setDamage(damage);
        countdown_attack = countdown_attack_total;
        }
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
        
        ///if (character_type == CharacterType.CREEP) {
        //    setDx(0);
         //   setDy(3);
        //}
        
        setIdle(false);
        if (health <= 0) {
            if (damage_dealer.character_type == CharacterType.PLAYER) {
                damage_dealer.EarnGold(gold_bounty);
            }
            remove_from_world();
        }
    }

    public Character getAggro_unit() {
        return aggro_unit;
    }
    
    public void EarnGold(int gold_amount) {
        gold += gold_amount;
    }
}
