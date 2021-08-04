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
import java.util.concurrent.ConcurrentLinkedQueue;

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

    //keeps track of bullets
    private ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    //keeps track of all game objects in the game, each associated with its own unique object id number
    private HashMap<Integer, GameObject> gameObjects = new HashMap<Integer, GameObject>();
    
    //distinguish between different objects. environmental objects like creep camps or base is layer 0, players and creeps are layer 1
    //the game world is drawn from lowest to highest layers, so that players and creeps are drawn on top of the environment
    private HashMap<Integer, ArrayList<GameObject>> layers = new HashMap<Integer, ArrayList<GameObject>>();
    
    //keeps track of different kinds of object in the game world
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<NeutralCreep> creeps = new ArrayList<NeutralCreep>();
    private ArrayList<NeutralCreepCamp> camps = new ArrayList<NeutralCreepCamp>();
    
    //keeps track of objects that are newly created to add to the correct collection
    private ConcurrentLinkedQueue<GameObject> queue_add = new ConcurrentLinkedQueue<GameObject>();
    
    //keeps track of objects that should be removed from the game world
    private ConcurrentLinkedQueue<GameObject> queue_remove = new ConcurrentLinkedQueue<GameObject>();

    //for the calculation of the current time in the game
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
        //initialize two layers
        //layer 0 for environmental objects
        //layer 1 for actionable objects such as creeps, players, bullets
        ArrayList<GameObject> layer_0 = new ArrayList<GameObject>();
        ArrayList<GameObject> layer_1 = new ArrayList<GameObject>();
        layers.put(0, layer_0);
        layers.put(1, layer_1);
        
        //initialize player base
        PlayerBase base = new PlayerBase();
        
        //initialize 3 creep camps
        NeutralCreepCamp creep_camp = new NeutralCreepCamp(150, 150, 250, 350);
        NeutralCreepCamp creep_camp2 = new NeutralCreepCamp(150, 150, 1100, 750);
        NeutralCreepCamp creep_camp3 = new NeutralCreepCamp(150,150, 600, 650);
        
        //initialize 1 player
        Player player = new Player(base);
        //Character creep = new Character(Constants_singleton.getInstance().creep_width, Constants_singleton.getInstance().creep_height,creep_camp.getX(), creep_camp.getY(), CharacterType.CREEP);
        
        //put creep camps in the player's belief system
        player.belief.put(creep_camp, 0);
        player.belief.put(creep_camp2, 0);
        player.belief.put(creep_camp3, 0);

        
        System.out.println("hero id is " + player.getGame_object_id());
        //System.out.println("creep id is " + creep.getGame_object_id());
        
        //add all initial objects to the game world
        add_objects_in_queue();
        
        //mark the start time of the game
        start_time_millis = currentTimeMillis();
        
        //start the ABL behaviors
        ChaserAgent agent = new ChaserAgent();
        agent.startBehaving();

    }

    //queue up new object to be added to the game world
    public void queue_addObject(GameObject new_object) {
        if (new_object == null) System.out.println("something weird is happening");
        //add the object to the queue
        queue_add.add(new_object);
    }

    //queue up an object to be removed from the game world
    public void queue_removeObject(GameObject new_object) {
        //add the object to the queue
        queue_remove.add(new_object);
    }

    //each update cycle, all new objects are added to the game world
    private void add_objects_in_queue() {
        while (!queue_add.isEmpty()) {
            GameObject current = queue_add.poll();
            addObject(current);
        }
        
    }

    //each update cycle, all objects that should be removed from the game world will be removed (such as a bullet that already hit its target)
    private void remove_objects_in_queue() {
        while (!queue_remove.isEmpty()) {
            GameObject current = queue_remove.poll();
            removeObject(current);
        }
        
    }

    //Add 1 object to the game world
    public void addObject(GameObject new_object) {
        //gameObjects.add(new_object);
        gameObjects.put(new_object.getGame_object_id(), new_object);
        layers.get(new_object.get_layer()).add(new_object);
        
        //Add the object to the corresponding collection for book keeping
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

    //Remove 1 object from the game world
    public void removeObject(GameObject object_to_remove) {
        gameObjects.remove(object_to_remove.getGame_object_id());
        layers.get(object_to_remove.get_layer()).remove(object_to_remove);
        
        //Remove the object from the corresponding collection
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

    //return the object with the correct object ID
    public GameObject get_game_object_with_id(int the_id) {
        return gameObjects.get(the_id);
    }

    //return list of all players
    public ArrayList<Player> getListOfPlayers() {
        return players;
    }
   
    //return list of all creeps
    public ArrayList<NeutralCreep> getListOfCreeps() {
        return creeps;
    }

    //return list of all creep camps
    public ArrayList<NeutralCreepCamp> getListOfCamps() {
        return camps;
    }

    //Each update cycle
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //First, let all objects in the world update
        updateWorld();

        //Add all new objects to the game world
        add_objects_in_queue();
        
        //Remove objects that need to be removed from the game world
        remove_objects_in_queue();
        
        //Paint all objects in the world
        paintWorld(g);
    }

    //Tell each object in the world to update itself
    public void updateWorld() {
        for (GameObject object : gameObjects.values()) {
            object.update();
            //object.paintObject(g);
        }
    }

    //Paint the world
    public void paintWorld(Graphics g) {
        
        //paint environmental objects first
        for (GameObject object : layers.get(0)) {
            object.paintObject(g);
        }
        
        //paint other objects next
        for (GameObject object : layers.get(1)) {
            object.paintObject(g);
        }

        //Calculate the elapsed time
        long elapsed_time = currentTimeMillis() - start_time_millis;
        elapsed_minutes = (int) (elapsed_time / 60000);
        elapsed_seconds = (int) (elapsed_time / 1000) - (elapsed_minutes * 60);

        //Draw the time on the top of the screen
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

    
    
    //****************************************************************//
    //UNUSED OLD CODE, SHOULD REMOVE
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
