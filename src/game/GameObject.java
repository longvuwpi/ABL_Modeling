/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

/**
 *
 * @author vuxua
 */
public class GameObject {

    private int game_object_id;

    protected Rectangle bounding_box;

    /**
     * position of the bullet
     */
    protected double x;
    protected double y;

    protected double size_width;
    protected double size_height;

    protected Color color;

    /**
     * trajectory of the bullet
     */
    protected double dx;
    protected double dy;

    /**
     * is the bullet motionless?
     */
    protected boolean idle = false;

    //default layer is 0
    // 0 is for environment (creep camps, base)
    // 1 is for other things (player, creep, bullets)
    private int layer = 0;
    
    /**
     * bullet speed
     */
    protected double speed = 10.0;

    /**
     * Creates a new game object
     */
    public GameObject(double new_width, double new_height, double new_x, double new_y, double new_dx, double new_dy, double new_speed, boolean new_idle, Color new_color) {
        x = new_x;
        y = new_y;

        size_width = new_width;
        size_height = new_height;

        dx = new_dx;
        dy = new_dy;

        idle = new_idle;
        speed = new_speed;

        color = new_color;

        game_object_id = Constants_singleton.getInstance().get_next_object_id();

        bounding_box = new Rectangle((int) x, (int) y, (int) size_width, (int) size_height);
        //add_to_world();
    }

    //add itself to the game world
    public void add_to_world() {
        Chaser.getInstance().queue_addObject(this);
        //Chaser.getInstance().addObject(this);
    }

    //remove itself from the game world
    public void remove_from_world() {
        Chaser.getInstance().queue_removeObject(this);
        //Chaser.getInstance().removeObject(this);
    }

    /**
     * Updates the position if moving
     */
    public void update() {
        if (!idle) {
            x += dx;
            y += dy;
            bounding_box.setLocation((int) x, (int) y);
        }
        //System.out.println("Updateing object " + game_object_id + "at " + x + "," + y + "size " + size_width + "," + size_height);                               
    }

    //paint self
    public void paintObject(Graphics g) {
        g.setColor(color);
        g.fillRect((int) x, (int) y, (int) size_width, (int) size_height);
    }

    /**
     * Is the object motionless?
     */
    public boolean isIdle() {
        return idle;
    }

    /**
     * Returns the x location of the bullet (in pixels).
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y location of the bullet (in pixels).
     */
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setIdle(boolean idle) {
        this.idle = idle;
    }

    public double getSize_width() {
        return size_width;
    }

    public void setSize_width(double size_width) {
        this.size_width = size_width;
    }

    public double getSize_height() {
        return size_height;
    }

    public void setSize_height(double size_height) {
        this.size_height = size_height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
        checkIdle();
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
        checkIdle();
    }

    private void checkIdle() {
        if ((dx == 0.0) && (dy == 0.0)) {
            idle = true;
        } else {
            idle = false;
        }
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    //set self to head to the specified point
    public void set_target(double target_x, double target_y) {
        double to_target_x = target_x - (x + (getSize_width()/2));
        double to_target_y = target_y - (y + (getSize_height()/2));
        double to_target_distance = Math.sqrt((to_target_x * to_target_x) + (to_target_y * to_target_y));
        double ratio = speed / to_target_distance;
        double newdx = ratio * to_target_x;
        double newdy = ratio * to_target_y;

        //System.out.print("New dx is " + Double.toString(newdx) + " and new dy is " + Double.toString(newdy));
        setDx(newdx);
        setDy(newdy);
        
    }
    
    //set self to head towards the target object
    public void set_target(GameObject target) {
        set_target(target.getX() + (target.getSize_width() / 2), target.getY() + (target.getSize_height()/2));
    }

    public int getGame_object_id() {
        return game_object_id;
    }

    public Rectangle getBounding_box() {
        return bounding_box;
    }

    public void set_layer(int newlayer) {
        layer = newlayer;
    }
    
    public int get_layer(){
        return layer;
    }
    
    public int get_estimated_strength() {
        return 0;
    }
}
