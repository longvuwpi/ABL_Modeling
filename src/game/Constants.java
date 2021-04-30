package game;

import java.awt.Point;

public interface Constants {
	public final int offset = 20;
	
	public static int width = 640;
	public static int height = 480;
	
	public static int laneStart_x = 150;
	public static int laneStart_y = 300;
	public static int laneLength_x = 300;
	public static int laneLength_y = 50;
	
	public static int baitInitialPositionLength = 80;
	public static int gankPositionLength = 60;
	
	public static Point baitPoint = new Point(laneStart_x + baitInitialPositionLength - offset, laneStart_y + laneLength_y/2);
	
        //simulation specific stats
        public static int hero_width = 10;
        public static int hero_height = 10;
        public static int hero_health = 600;
        public static int hero_damage = 70;
        
        public static int creep_width = 5;
        public static int creep_height = 5;
        public static int creep_health = 500;
        public static int creep_damage = 20;
        public static int creep_gold_bounty = 50;
        
        public static int ancientcreep_width = 25;
        public static int ancientcreep_height = 25;
        public static int ancientcreep_health = 700;
        public static int ancientcreep_damage = 80;
        public static int ancientcreep_gold_bounty = 80;
	
//	public static int ChaserSpeed = 2;	
}
