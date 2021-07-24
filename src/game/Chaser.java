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
import static java.lang.System.currentTimeMillis;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Simple "game" for showing how to interface an ABL agent.
 *
 * @author Ben Weber 3-7-11
 */
public class Chaser extends JPanel implements KeyListener {

    /**
     * scene dimensions
     */
    private Point dimensions = new Point(Constants_singleton.getInstance().width, Constants_singleton.getInstance().height);

    /**
     * keys held down
     */
    private boolean[] keyPresses = new boolean[256];

    /**
     * a reference to the game
     */
    private static Chaser chaser;

    /**
     * bullets which have been fired by both players
     */
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    private HashMap<Integer, GameObject> gameObjects = new HashMap<Integer, GameObject>();
    private HashMap<Integer, ArrayList<GameObject>> layers = new HashMap<Integer, ArrayList<GameObject>>();

    //private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<NeutralCreep> creeps = new ArrayList<NeutralCreep>();
    private ArrayList<NeutralCreepCamp> camps = new ArrayList<NeutralCreepCamp>();
    
    private LinkedList<GameObject> queue_add = new LinkedList<GameObject>();
    private LinkedList<GameObject> queue_remove = new LinkedList<GameObject>();

    long start_time_millis;
    int elapsed_minutes;
    int elapsed_seconds;

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
                    } catch (Exception e) {
                    }
                }
            }
        }.start();
    }

    /**
     * Starts the ABL agent.
     *
     * Note: this method does not return, the ABL agent decision cycle claims
     * the thread.
     */
    public void startAgent() {
        //GameObject base = new GameObject(120,120,Constants_singleton.base_location.x, Constants_singleton.base_location.y,0,0,0,true,Color.GRAY);
        //base.add_to_world();
        ArrayList<GameObject> layer_0 = new ArrayList<GameObject>();
        ArrayList<GameObject> layer_1 = new ArrayList<GameObject>();
        layers.put(0, layer_0);
        layers.put(1, layer_1);
        
        PlayerBase base = new PlayerBase();
        NeutralCreepCamp creep_camp = new NeutralCreepCamp(100, 100, 60, 400);
        NeutralCreepCamp creep_camp2 = new NeutralCreepCamp(100, 100, 1000, 650);

        Player player = new Player(base);
        //Character creep = new Character(Constants_singleton.getInstance().creep_width, Constants_singleton.getInstance().creep_height,creep_camp.getX(), creep_camp.getY(), CharacterType.CREEP);

        System.out.println("hero id is " + player.getGame_object_id());
        //System.out.println("creep id is " + creep.getGame_object_id());
        add_objects_in_queue();
        start_time_millis = currentTimeMillis();
        ChaserAgent agent = new ChaserAgent();
        agent.startBehaving();

    }

    public void queue_addObject(GameObject new_object) {
        if (new_object == null) System.out.println("something weird is happening");
        queue_add.add(new_object);
    }

    public void queue_removeObject(GameObject new_object) {
        queue_remove.add(new_object);
    }

    private void add_objects_in_queue() {
        while (!queue_add.isEmpty()) {
            GameObject current = queue_add.poll();
            if (current != null) addObject(current);
        }
    }

    private void remove_objects_in_queue() {
        while (!queue_remove.isEmpty()) {
            GameObject current = queue_remove.poll();
            if (current != null) removeObject(current);
        }
    }

    public void addObject(GameObject new_object) {
        //gameObjects.add(new_object);
        gameObjects.put(new_object.getGame_object_id(), new_object);
        layers.get(new_object.get_layer()).add(new_object);
        
        if (new_object instanceof Bullet) {
            bullets.add((Bullet) new_object);
        }
        if (new_object instanceof Player) {
            players.add((Player) new_object);
        }
        if (new_object instanceof NeutralCreep) {
            creeps.add((NeutralCreep) new_object);
        }
        if (new_object instanceof NeutralCreepCamp) {
            camps.add((NeutralCreepCamp) new_object);
        }
    }

    public void removeObject(GameObject object_to_remove) {
        gameObjects.remove(object_to_remove.getGame_object_id());
        layers.get(object_to_remove.get_layer()).remove(object_to_remove);
        
        //gameObjects.remove(object_to_remove);
        if (object_to_remove instanceof Bullet) {
            bullets.remove((Bullet) object_to_remove);
        }
        if (object_to_remove instanceof Player) {
            players.remove((Player) object_to_remove);
        }
        if (object_to_remove instanceof NeutralCreep) {
            creeps.remove((NeutralCreep) object_to_remove);
        }
    }

    //public ArrayList<GameObject> getGameObjects() {
    //    return gameObjects;
    //}
    public GameObject get_game_object_with_id(int the_id) {
        return gameObjects.get(the_id);
    }

    public ArrayList<Player> getListOfPlayers() {
        return players;
    }

    public ArrayList<NeutralCreep> getListOfCreeps() {
        return creeps;
    }

    public ArrayList<NeutralCreepCamp> getListOfCamps() {
        return camps;
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
        
        for (GameObject object : layers.get(0)) {
            object.paintObject(g);
        }
        
        for (GameObject object : layers.get(1)) {
            object.paintObject(g);
        }

        long elapsed_time = currentTimeMillis() - start_time_millis;
        elapsed_minutes = (int) (elapsed_time / 60000);
        elapsed_seconds = (int) (elapsed_time / 1000) - (elapsed_minutes * 60);

        String time_todraw = Integer.toString(elapsed_minutes) + ":" + Integer.toString(elapsed_seconds);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        g.drawString(time_todraw, Constants_singleton.width / 2, 30);
    }

    public int getElapsed_minutes() {
        return elapsed_minutes;
    }

    public int getElapsed_seconds() {
        return elapsed_seconds;
    }

    /**
     * Returns the location of the player.
     */
    public Point getPlayerLocation() {
        //return playerLocation;
        Point result = new Point((int)gameObjects.get(0).getX(), (int)gameObjects.get(0).getY());
        return result;
    }

    /**
     * Returns the trajectory of the player.
     */
    public Point getPlayerTrajectory() {
        Point result = new Point((int) gameObjects.get(0).getDx(), (int) gameObjects.get(0).getDy());
        return result;
        //return playerTrajectory;
    }

    /**
     * Returns the trajectory of the chaser.
     */
    public Point getChaserTrajectory() {
        //return chaserTrajectory;
        Point result = new Point((int) gameObjects.get(1).getDx(), (int) gameObjects.get(1).getDy());
        return result;
    }

    /**
     * Records keystate.
     *
     * Note: tracks presses and releases with a boolean value to avoid duplicate
     * key presses.
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

    public void keyTyped(KeyEvent e) {
    }
}
