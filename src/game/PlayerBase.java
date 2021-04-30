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
public class PlayerBase extends GameObject {
    public PlayerBase() {
        super(120,120,Constants_singleton.base_location.x, Constants_singleton.base_location.y,0,0,0,true,Color.GRAY);
        add_to_world();
    }
    
    @Override
    public int getX() {
        return (int)(x + size_width/2);
    }
        
    @Override
    public int getY() {
        return (int)(y + size_height/2);
    }
}
