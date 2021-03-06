/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;

/**
 *
 * @author vuxua
 */
public class NeutralCreep extends Character {

    //the camp that this creep is in
    private NeutralCreepCamp camp;
    private int gold_bounty = 0;

    //constructor for a neutral creep
    public NeutralCreep(NeutralCreepCamp camp, double position_x, double position_y) {
        super(Constants_singleton.getInstance().creep_width, Constants_singleton.getInstance().creep_height, position_x, position_y);

        this.camp = camp;
        setColor(Color.PINK);
        health = Constants_singleton.getInstance().creep_health;
        damage = Constants_singleton.getInstance().creep_damage;
        gold_bounty = Constants_singleton.getInstance().creep_gold_bounty;

        set_attack_range(Constants_singleton.creep_atk_range);
        
        add_to_world();
    }

    //when the creep takes damage, it aggros the other creeps in the same camp
    //if the creep dies, the player earns gold
    @Override
    public void TakeDamageFrom(Character damage_dealer, int damage) {
        super.TakeDamageFrom(damage_dealer, damage);
        if (damage != 0) {
            camp.trigger_aggro((Player) damage_dealer);
        }
        if (health <= 0) {
            ((Player) damage_dealer).EarnGold(getGold_bounty());
            remove_from_world();
        }
    }

    //stop the creep from attacking
    public void de_aggro() {
        setAggro_unit(null);
    }

    //attack at target
    @Override
    public boolean NormalAttackAtTarget(Character target) {
        if (target == null) {
            return false;
        }
        
        //if target is dead then stop attacking
        if (((Player) target).is_dead()) {
            camp.de_aggro();
            return false;
        }
        
        //try to fire a bullet at the target
        return super.NormalAttackAtTarget(target);
    }

    //removes self from the world and from the camp
    @Override
    public void remove_from_world() {
        super.remove_from_world();
        camp.remove_creep(this);
    }

    //each update cycle, the creep attacks the target automatically if it is aggroed.
    //otherwise stop attacking
    @Override
    public void update() {
        super.update();
        
        if (getAggro_unit() != null) {
            if (is_object_in_attack_range(getAggro_unit())) {
            boolean is = NormalAttackAtTarget(getAggro_unit());
            } else {
                camp.de_aggro();
            }
        }
    }
    
    public int getGold_bounty() {
        return gold_bounty;
    }

    public NeutralCreepCamp getCamp() {
        return camp;
    }

}
