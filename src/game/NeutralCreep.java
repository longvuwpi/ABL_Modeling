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

    private NeutralCreepCamp camp;
    private int gold_bounty = 0;

    public NeutralCreep(NeutralCreepCamp camp, double position_x, double position_y) {
        super(Constants_singleton.getInstance().creep_width, Constants_singleton.getInstance().creep_height, position_x, position_y);

        this.camp = camp;
        setColor(Color.PINK);
        health = Constants_singleton.getInstance().creep_health;
        damage = Constants_singleton.getInstance().creep_damage;
        gold_bounty = Constants_singleton.getInstance().creep_gold_bounty;

        add_to_world();
    }

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

    public void de_aggro() {
        setAggro_unit(null);
    }

    @Override
    public boolean NormalAttackAtTarget(Character target) {
        if (target == null) {
            return false;
        }
        if (((Player) target).is_dead()) {
            camp.de_aggro();
            return false;
        }
        return super.NormalAttackAtTarget(target);
    }

    @Override
    public void remove_from_world() {
        super.remove_from_world();
        camp.remove_creep(this);
    }

    @Override
    public void update() {
        super.update();
        
        if (getAggro_unit() != null) {
            boolean is = NormalAttackAtTarget(getAggro_unit());
        }
    }
    
    public int getGold_bounty() {
        return gold_bounty;
    }

    public NeutralCreepCamp getCamp() {
        return camp;
    }

}
