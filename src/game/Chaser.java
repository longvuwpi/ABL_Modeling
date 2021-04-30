package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import abl.generated.ChaserAgent;
import java.awt.Font;
import java.util.HashMap;
import java.util.LinkedList;
/**
 *  Simple "game" for showing how to interface an ABL agent.
 *
 * @author Ben Weber 3-7-11
 */
public class Chaser extends JPanel implements KeyListener {
	/** scene dimensions */
	private Point dimensions = new Point(Constants_singleton.getInstance().width, Constants_singleton.getInstance().height);

	/** location of the player character */
	//private Point playerLocation = new Point((int)(dimensions.x*Math.random()), (int)(dimensions.y*Math.random()));
        private Point playerLocation = Constants_singleton.getInstance().base_location;
        
	/** trajectory of the player character */
	private Point playerTrajectory = new Point(0, 0);

	/** location of the chaser */
	private Point chaserLocation = new Point((int)(dimensions.x*Math.random()), (int)(dimensions.y*Math.random()));

	/** trajectory of the chaser */
	private Point chaserTrajectory = new Point(0, 0);

	/** size of the player character */
	private static final int playerSize = 10;

	/** size of the bullets */
	private static final int bulletSize = 4;

	/** speed of the player character */
	private static final int PlayerSpeed = 4;

	/** speed of the player character */
	public static final int ChaserSpeed = 2;

	/** keys held down */
	private boolean[] keyPresses = new boolean[256];

	/** a reference to the game */
	private static Chaser chaser;

	/** did the player fire a bullet */
	private boolean spawnBullet = false;

	/** bullets which have been fired by both players */
	private ArrayList<Bullet> bullets = new ArrayList<Bullet>();
        
	/** spawn a chaser bullet? */
	private boolean spawnChaserBullet = false;

	/** source position of the chaser bullet */
	private Point chaserBulletSource;

	/** target position of the chaser bullet */
	private Point chaserBulletTarget;

        private HashMap<Integer,GameObject> gameObjects = new HashMap<Integer,GameObject>();
        
        //private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
        private ArrayList<Character> players = new ArrayList<Character>();
        private ArrayList<Character> creeps = new ArrayList<Character>();
        private LinkedList<GameObject> queue_add = new LinkedList<GameObject>();
        private LinkedList<GameObject> queue_remove = new LinkedList<GameObject>();
        
	/**
	 * Starts the game.
	 */
	public static void main(String[] args) {
		chaser = new Chaser();
		chaser.startAgent();
	}

	/**
	 * Returns a reference to the game.
	 */
	public static Chaser getInstance() {
		return chaser;
	}

	/**
	 * Instantiates the game and places the instance in a JFrame.
	 */
	public Chaser() {
		setPreferredSize(new Dimension(dimensions.x, dimensions.y));
		JFrame frame = new JFrame("ABL Chaser");
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
		frame.setResizable(false);
		frame.setVisible(true);

		// spawn an update thread
		new Thread() {
			public void run() {
				while (true) {
					try {
						repaint();
						Thread.sleep(50);
					}
					catch (Exception e) {}
				}
			}
		}.start();
	}

        public void queue_addObject(GameObject new_object) {
            queue_add.add(new_object);
        }
        
        public void queue_removeObject(GameObject new_object) {
            queue_remove.add(new_object);
        }
        
        private void add_objects_in_queue(){
            while (!queue_add.isEmpty()) {
                addObject(queue_add.poll());
            }
        }
        
        private void remove_objects_in_queue() {
            while (!queue_remove.isEmpty()) {
                removeObject(queue_remove.poll());
            }
        }
        
        public void addObject(GameObject new_object) {
            //gameObjects.add(new_object);
            gameObjects.put(new_object.getGame_object_id(), new_object);
            if (new_object instanceof Bullet) {
                bullets.add((Bullet)new_object);
            }
            if (new_object instanceof Character) {
                System.out.println("added a character");
                if (((Character)new_object).getCharacter_type() == CharacterType.PLAYER) players.add((Character)new_object);
                else creeps.add((Character)new_object);
            }
        }
        
        public void removeObject(GameObject object_to_remove) {
            gameObjects.remove(object_to_remove.getGame_object_id());
            //gameObjects.remove(object_to_remove);
            if (object_to_remove instanceof Bullet) {
                bullets.remove((Bullet)object_to_remove);
            }
            if (object_to_remove instanceof Character) {
                if (((Character)object_to_remove).getCharacter_type() == CharacterType.PLAYER) players.remove((Character)object_to_remove);
                else creeps.remove((Character)object_to_remove);
            }
        }
        
        //public ArrayList<GameObject> getGameObjects() {
        //    return gameObjects;
        //}
        
        public GameObject get_game_object_with_id(int the_id) {
            return gameObjects.get(the_id);
        }
        
	/**
	 * Starts the ABL agent.
	 *
	 * Note: this method does not return, the ABL agent decision cycle claims the thread.
	 */
	public void startAgent() {
            //GameObject base = new GameObject(120,120,Constants_singleton.base_location.x, Constants_singleton.base_location.y,0,0,0,true,Color.GRAY);
            //base.add_to_world();
            PlayerBase base = new PlayerBase();
            GameObject creep_camp = new GameObject(100,100,Constants_singleton.creep_camp_position.x, Constants_singleton.creep_camp_position.y,0,0,0,true,Color.GREEN);
            creep_camp.add_to_world();
            
            Character player = new Character(Constants_singleton.getInstance().hero_width, Constants_singleton.getInstance().hero_height,playerLocation.x, playerLocation.y, CharacterType.PLAYER);
            Character creep = new Character(Constants_singleton.getInstance().creep_width, Constants_singleton.getInstance().creep_height,creep_camp.getX(), creep_camp.getY(), CharacterType.CREEP);

         
            System.out.println("hero id is " + player.getGame_object_id());
            System.out.println("creep id is " + creep.getGame_object_id());
            add_objects_in_queue();
            ChaserAgent agent = new ChaserAgent();
            agent.startBehaving();
	}
        
        public ArrayList<Character> getListOfPlayers() {
            return players;
        }
        
        public ArrayList<Character> getListOfCreeps() {
            return creeps;
        }
        
	/**
	 * Updates the positions of objects, and draws the scene.
	 */
	public void drawLanePosition(Graphics g) {
		//g.setColor(Color.cyan);
		//g.fillRect(laneStart_x, laneStart_y, laneLength_x, laneLength_y);
		//g.setColor(Color.GREEN);
		//g.fillRect(laneStart_x, laneStart_y, baitInitialPositionLength, laneLength_y);
		//g.setColor(Color.ORANGE);
		//g.fillRect(laneStart_x + laneLength_x - gankPositionLength, laneStart_y, gankPositionLength, laneLength_y);
	}
	
	@Override
	public void paint(Graphics g) {
                            super.paint(g);
		//drawLanePosition(g);

		updateLocations();
		updateWorld(g);
		
                add_objects_in_queue();
                remove_objects_in_queue();
                paintWorld(g);
//		if(playerLocation.x > laneStart_x && playerLocation.x < (laneStart_x + baitInitialPositionLength)
//				&& playerLocation.y > laneStart_y && playerLocation.y < (laneStart_y + laneLength_y)) {
//					System.out.println("Target in bait initial position");
//				}
//		else{
//			System.out.println("not in position");
//		}
		
		// draw lane

		//g.setColor(Color.BLUE);
		//g.fillRect(playerLocation.x, playerLocation.y, playerSize, playerSize);

		//g.setColor(Color.RED);
		//g.fillRect(chaserLocation.x, chaserLocation.y, playerSize, playerSize);
		
		//g.setColor(Color.BLACK);
		//g.fillRect(baitPoint.x, baitPoint.y, playerSize/4, playerSize/4);

		//g.setColor(Color.BLACK);
		//for (Bullet bullet : bullets) {
		//	g.fillRect(bullet.getX() + (playerSize - bulletSize)/2, bullet.getY() + (playerSize - bulletSize)/2, bulletSize, bulletSize);
		//}
	}

        public void updateWorld(Graphics g) {
            for (GameObject object : gameObjects.values()) {
                object.update();
                //object.paintObject(g);
            }
        }
        
        public void paintWorld(Graphics g) {
            for (GameObject object: gameObjects.values()) {
                object.paintObject(g);
            }
        }

	/**
	 * Updates the positions of objects in the scene based on their trajectories and the dimensions of the scene.
	 */
	public void updateLocations() {

		// compute the player trajectory
		int dx = 0;
		int dy = 0;

		if (keyPresses[KeyEvent.VK_LEFT]) {
			dx -= PlayerSpeed;
		}
		if (keyPresses[KeyEvent.VK_RIGHT]) {
			dx += PlayerSpeed;
		}
		if (keyPresses[KeyEvent.VK_UP]) {
			dy -= PlayerSpeed;
		}
		if (keyPresses[KeyEvent.VK_DOWN]) {
			dy += PlayerSpeed;
		}

		playerTrajectory = new Point(dx, dy);

		// update player location
		int playerX = playerLocation.x + playerTrajectory.x;
		playerX = Math.max(0, playerX);
		playerX = Math.min(dimensions.x, playerX);

		int playerY = playerLocation.y + playerTrajectory.y;
		playerY = Math.max(0, playerY);
		playerY = Math.min(dimensions.y, playerY);

		playerLocation = new Point(playerX, playerY);

		// update chaser location
		int chaserX = chaserLocation.x + chaserTrajectory.x;
		chaserX = Math.max(0, chaserX);
		chaserX = Math.min(dimensions.x, chaserX);

		int chaserY = chaserLocation.y + chaserTrajectory.y;
		chaserY = Math.max(0, chaserY);
		chaserY = Math.min(dimensions.y, chaserY);

		chaserLocation = new Point(chaserX, chaserY);
	}

	/**
	 * Sets the trajectory of the chaser object.
	 *
	 * Note: This is invoked via ABL physical acts
	 */
	public void setChaserTrajectory(Point trajectory) {
		chaserTrajectory = trajectory;
                
                gameObjects.get(1).setDx(trajectory.x);
                gameObjects.get(1).setDy(trajectory.y);
	}

        public void setPlayerTrajectory(Point trajectory) {
		playerTrajectory = trajectory;
                GameObject player = players.get(0);
                
                player.setDx(trajectory.x);
                player.setDy(trajectory.y);
                if ((trajectory.x == 0) && (trajectory.y == 0)) {
                    player.setIdle(true);
                } else player.setIdle(false);
	}
        
	/**
	 * Fires a bullet from the chaser at the player.
	 */
	public void fireChaserBullet(Point source, Point target) {
		chaserBulletSource = source;
		chaserBulletTarget = target;
		spawnChaserBullet = true;
	}

	/**
	 * Returns the location of the player.
	 */
	public Point getPlayerLocation() {
		//return playerLocation;
                Point result = new Point(gameObjects.get(0).getX(), gameObjects.get(0).getY());
                return result;
	}

	/**
	 * Returns the trajectory of the player.
	 */
	public Point getPlayerTrajectory() {
                Point result = new Point((int)gameObjects.get(0).getDx(), (int)gameObjects.get(0).getDy());
                return result;
		//return playerTrajectory;
	}

	/**
	 * Returns the location of the chaser.
	 */
	public Point getChaserLocation() {
		//return chaserLocation;
                                Point result = new Point(gameObjects.get(1).getX(), gameObjects.get(1).getY());
                return result;
	}

	/**
	 * Returns the trajectory of the chaser.
	 */
	public Point getChaserTrajectory() {
		//return chaserTrajectory;
                                Point result = new Point((int)gameObjects.get(1).getDx(), (int)gameObjects.get(1).getDy());
                return result;
	}

	/**
	 * Records keystate.
	 *
	 * Note: tracks presses and releases with a boolean value to avoid duplicate key presses.
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}

		//if (e.getKeyCode() == KeyEvent.VK_SPACE && keyPresses[KeyEvent.VK_SPACE] == false) {
		//	spawnBullet = true;
		//}

		//if (e.getKeyCode() < keyPresses.length) {
		//	keyPresses[e.getKeyCode()] = true;
		//}
	}

	/**
	 * Release key state.
	 */
	public void keyReleased(KeyEvent e) {
		//if (e.getKeyCode() < keyPresses.length) {
		//	keyPresses[e.getKeyCode()] = false;
		//}
	}

	public void keyTyped(KeyEvent e) {}
}
