 package game;

import java.awt.Point;

public class Constants_singleton {
    
        private static int next_object_id = 0;
        
	public static final int offset = 20;
	
	public static int width = 1920;
	public static int height = 1080;
	
	public static int laneStart_x = 150;
	public static int laneStart_y = 300;
	public static int laneLength_x = 300;
	public static int laneLength_y = 50;
	
	public static int baitInitialPositionLength = 80;
	public static int gankPositionLength = 60;
	
        public static Point base_location = new Point(700,200);
        public static int base_heal_per_second = 60;
        
        public static Point creep_camp_position = new Point(100,300);
        
	public static Point baitPoint = new Point(laneStart_x + baitInitialPositionLength - offset, laneStart_y + laneLength_y/2);
	
        //simulation specific stats
        public static int hero_width = 50;
        public static int hero_height = 50;
        public static int hero_health = 600;
        public static int hero_damage = 80;
        public static int hero_atk_range = 175;
        public static double hero_move_speed = 5.5;
        public static int hero_vision_diameter = 525;
        
        public static int creep_respawn_time = 30;
        
        public static int creep_width = 30;
        public static int creep_height = 30;
        public static int creep_health = 250;
        public static int creep_damage = 8;
        public static int creep_gold_bounty = 50;
        public static int creep_atk_range = 225;
        
        public static int ancientcreep_width = 25;
        public static int ancientcreep_height = 25;
        public static int ancientcreep_health = 700;
        public static int ancientcreep_damage = 80;
        public static int ancientcreep_gold_bounty = 80;
	
//	public static int ChaserSpeed = 2;	
        private static Constants_singleton constants_singleton;

       	public static Constants_singleton getInstance() {
            if (constants_singleton == null) {
                constants_singleton = new Constants_singleton();
            }
            return constants_singleton;
	}
        
        private Constants_singleton(){
            
        }
        
        public int get_next_object_id() {
            int new_object = next_object_id;
            next_object_id++;
            return new_object;
        }
}
