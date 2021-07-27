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
public class Bullet extends GameObject {

    private Character owner;
    private Character target;
    private double damage;

    /**
     * bullet speed
     */
    public double BulletSpeed = 16.0;
    public static double bullet_size = 4;

    /**
     * Creates a bullet that will move towards the target location.
     */
    public Bullet(Character new_owner, Character new_target) {
        super(bullet_size, bullet_size, 0, 0, 0, 0, 0, false, Color.BLACK);
        owner = new_owner;
        target = new_target;
        
        setX(new_owner.getX() + (new_owner.getSize_width() / 2.0));
        setY(new_owner.getY() + (new_owner.getSize_height() / 2.0));

        updatePathing();

        set_layer(1);
        
        add_to_world();
    }

    public void updatePathing() {
        if (target.getHealth() > 0) {

            dx = target.x + (target.getSize_width() / 2) - getX();
            dy = target.y + (target.getSize_height() / 2) - getY();
            double magnitude = Math.sqrt(dx * dx + dy * dy);

            if (magnitude > 0) {
                dx = BulletSpeed * dx / magnitude;
                dy = BulletSpeed * dy / magnitude;
                idle = false;
            } else {
                idle = true;
            }
        } else {
            remove_from_world();
        }
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    @Override
    public void update() {
        super.update();
        if (target.getHealth() > 0) {
            if (getBounding_box().intersects(target.getBounding_box()) && (target.getHealth() > 0)) {
                owner.DealDamageTo(target);
                remove_from_world();
            }
        }

        if ((getX() < 0) || (getX() > Constants_singleton.getInstance().width)
                || (getY() < 0) || (getY() > Constants_singleton.getInstance().height)) {
            remove_from_world();
        }

        //owner = (Character) Chaser.getInstance().get_game_object_with_id(owner.getGame_object_id());
        //target = (Character) Chaser.getInstance().get_game_object_with_id(target.getGame_object_id());
        updatePathing();
        
    }
    
    @Override
    public void paintObject(Graphics g) {
        super.paintObject(g);
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        String todraw = (owner instanceof Player) ? "pl" : "cr";
        g.drawString(todraw, (int) getX(), (int) getY());
    }

}
