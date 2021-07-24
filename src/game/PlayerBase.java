/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;

/**
 * A player base is where the player starts the game at.
 * When a player dies, he will respawn at the base after some time with full health
 * a player base is supposed to heal the player whenever he's partly or fully inside the base (it's not doing that right now)
 * @author vuxua
 */
public class PlayerBase extends GameObject {
    public PlayerBase() {
        // initialize
        super(120,120,Constants_singleton.base_location.x, Constants_singleton.base_location.y,0,0,0,true,Color.GRAY);
        add_to_world();
    }
    
    /*@Override
    public double getX() {
        return (x + size_width/2);
    }
        
    @Override
    public double getY() {
        return (y + size_height/2);
    }*/
}
