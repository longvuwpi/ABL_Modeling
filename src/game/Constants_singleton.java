 package game;

import java.awt.Point;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

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
	
        public static Point base_location = new Point(1000,150);
        public static int base_heal_per_second = 60;
        
        public static Point creep_camp_position = new Point(100,300);
        
	public static Point baitPoint = new Point(laneStart_x + baitInitialPositionLength - offset, laneStart_y + laneLength_y/2);
	
        //simulation specific stats
        public static int hero_width = 50;
        public static int hero_height = 50;
        public static int hero_health = 750;
        public static int hero_damage = 70;
        public static int hero_atk_range = 175;
        public static double hero_move_speed = 5.5;
        public static int hero_vision_diameter = 525;
        
        public static int creep_respawn_time = 30;
        
        public static int creep_width = 30;
        public static int creep_height = 30;
        public static int creep_health = 210;
        public static int creep_damage = 8;
        public static int creep_gold_bounty = 50;
        public static int creep_atk_range = 270;
        
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
        
        //utility function to get the next unique object id
        public int get_next_object_id() {
            int new_object = next_object_id;
            next_object_id++;
            return new_object;
        }
        
        //utility function to get the distance between 2 objects
        public double get_distance_between_objects(GameObject first, GameObject second) {
            double distance = sqrt(pow((first.getX() + first.getSize_width()/2) - (second.getX() + second.getSize_width()/2), 2.0) + pow((first.getY() + first.getSize_height()/2) - (second.getY() + second.getSize_height()/2), 2.0));
            return distance;
        }
}
