package game;



import JPanels.Menu;
import JPanels.ControlPanel;
import UserViewPackage.Background;
import Level.GameLevel;
import CollisionAndEventHandler.CaptainAttack;
import CollisionAndEventHandler.HulkAttack;
import CollisionAndEventHandler.IronmanAttack;
import CollisionAndEventHandler.*;
import EventHandler.CapController;
import EventHandler.GameController;
import EventHandler.HulkController;
import EventHandler.IMController;
import EventHandler.ThorController;
import JPanels.Loading;
import JPanels.Login;

import Level.*;
import city.cs.engine.SoundClip;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;


/**
 *Main class runs the game
 * @author Sai, Uppinakuduru, Sai.Uppinakuduru@city.ac.uk
 * @version current version of the program: 1.3
 * @since version 1.0
*/
public class Game {
    
    /**
     * Title logo
     */
    public BufferedImage logo;
    /** The World in which the bodies move and interact. */
    public GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    public Background view;

    /**
     *  screen size
     */
    public int i = 878;

    /**
     * screen size
     */
    public int j = 500;

    /**
     * JFrame for view
     */
    public JFrame frame,quick;

    /**
     * to keep track of level
     */
    public int level; 

    /**
     * Team Ironman score
     */
    public int p1win = 0;

    /**
     * Team Captain America score
     */
    public int p2win= 0;
    
    /**
     * next level tracker
     */
    public boolean next;
    
    /**
     * Ironman Controller 
     */
    public IMController imcontroller; 

    /**
     * Captain America Controller
     */
    public CapController capcontroller; 

    /**
     * Hulk Controller
     */
    public HulkController hulkcontroller; 

    /**
     * Thor Controller
     */
    public ThorController thorcontroller; 
    
    /**
     * IronmanAttack object
     */
    public IronmanAttack ironmanAttack;

    /**
     * CaptainAttack object
     */
    public CaptainAttack captainAttack;

    /**
     * ThorAttack object
     */
    public ThorAttack thorAttack;

    /**
     * HulkAttack object
     */
    public HulkAttack hulkAttack;

    /**
     * Ironman2Attack object
     */
    public Ironman2Attack ironman2Attack;

    /**
     * Captain2Attack object
     */
    public Captain2Attack captain2Attack;

    /**
     * Thor2Attack object
     */
    public Thor2Attack thor2Attack;

    /**
     * Hulk2Attack object
     */
    public Hulk2Attack hulk2Attack;
    
    /**
     * ControlPanel JPanel instance
     */
    public ControlPanel cp;

    /**
     * Menu JPanel instance
     */
    public Menu ip;
    
    /**
     * Sound clips for background
     */
    public  static SoundClip sp;
    
    /**
     * Login JPanel instance
     */
    public Login ln;
    
    
     /**
     * Store Username
     */
    public String user = "Admin";
    
     /**
     * Reset password
     */
    public String password = "password";
    
    /** Initialise a new Game. */
    public Game()  {
             
         try {
             logo=ImageIO.read(new File("data/Logo.png"));
         } catch (IOException ex) {
             Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
         }
       
        cp = new ControlPanel(this);
        
       
        // display the view in a frame
        frame = new JFrame("Civil War");

        //  Logo for titlebar
        frame.setIconImage(logo);
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.getContentPane().add(cp);
       // frame.add(view);
        
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        
        // make the window visiblew
        frame.setVisible(true);
        
        // make the window visiblew
        
        
       
    }
    /**
     * starts Game Menu
     */
   
    /**
     * Initiate next level
     */
    public void goNextLevel() {
         
        world.stop();
        level++;
       
        if (level == 2) {
            
            frame.removeKeyListener(imcontroller);
            frame.removeKeyListener(capcontroller);
            frame.removeKeyListener(ironmanAttack);
            frame.removeKeyListener(captainAttack);
            
            
            
            world = new Level2(); 
           
            world.populate(this);
           view.setBackground(level);
           
            
            hulkcontroller = new HulkController(world.getPlayer2());
            thorcontroller = new ThorController(world.getPlayer1());
            thorAttack = new ThorAttack(world.getPlayer1(),world.getPlayer2(),this);
            hulkAttack = new HulkAttack(world.getPlayer1(),world.getPlayer2(),this);
            
            frame.addKeyListener(hulkcontroller); 
            frame.addKeyListener(thorcontroller); 
            frame.addKeyListener(thorAttack);
            frame.addKeyListener(hulkAttack);
        
         } else if(level ==3 ) {
            
            frame.removeKeyListener(hulkcontroller);
            frame.removeKeyListener(thorcontroller);
            frame.removeKeyListener(hulkAttack);
            frame.removeKeyListener(thorAttack);
           
            world = new Level3(); 
            world.populate(this);
            
            view.setBackground(level);
            
            imcontroller =new IMController(world.getPlayer1());
            ironman2Attack = new Ironman2Attack(world.getPlayer1(),world.getPlayer2(),this);
            hulkcontroller = new HulkController(world.getPlayer2());
            hulk2Attack = new Hulk2Attack(world.getPlayer1(),world.getPlayer2(),this);
            
            frame.addKeyListener(imcontroller);
            frame.addKeyListener(ironman2Attack);
            frame.addKeyListener(hulkcontroller);
            frame.addKeyListener(hulk2Attack);
            
        } else if(level ==4 ) {
            frame.removeKeyListener(imcontroller);
            frame.removeKeyListener(ironman2Attack);
            frame.removeKeyListener(hulkcontroller);
            frame.removeKeyListener(hulk2Attack);
            
            
            world = new Level4(); 
            world.populate(this);
            view.setBackground(level);
            
            thorcontroller = new ThorController(world.getPlayer1());
            thor2Attack = new Thor2Attack(world.getPlayer1(),world.getPlayer2(),this);
            capcontroller = new CapController(world.getPlayer2());
            captain2Attack = new Captain2Attack(world.getPlayer1(),world.getPlayer2(),this);
            frame.addKeyListener(thorcontroller);
            frame.addKeyListener(thor2Attack);
            frame.addKeyListener(capcontroller);      
            frame.addKeyListener(captain2Attack);
            
        } else if( level==5){
            world = new Level5(); 
            world.populate(this);
           
        }

        
           // show the new world in the view
           // view.set
         view.setWorld(world);
           
            world.start();
        }
    
    /**
     * starts level 1
     */
    public void startLevel1(){
        
        frame.setVisible(false);
        frame.removeAll();
        level = 1;
        world = new Level1();
            next = true;
          world.populate(this);
          frame = new JFrame("Civil War");
        view = new Background(world,this,i,j);
        
       common();
        
        imcontroller =new IMController(world.getPlayer1());
        capcontroller = new CapController(world.getPlayer2());
        ironmanAttack = new IronmanAttack(world.getPlayer1(),world.getPlayer2(),this);
        captainAttack = new CaptainAttack(world.getPlayer1(),world.getPlayer2(),this);
        
        // receive keyboard events
        frame.addKeyListener(imcontroller); 
        frame.addKeyListener(capcontroller); 
        frame.addKeyListener(ironmanAttack);
        frame.addKeyListener(captainAttack);
        frame.addKeyListener(new GameController(this));
 
        world.start();
      
    }

    /**
     * Common frame contents
     */
    public void common(){
         
         //  Logo for titlebar
        frame.setIconImage(logo);
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(false);
     
        frame.add(view);
        
       // size the game window to fit the world view
         frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        
        frame.requestFocus();
        // make the window visiblew
        frame.setVisible(true);
         // uncomment this to make a debugging view
   //   JFrame debugView = new DebugViewer(world, i, j);
       // don't let the game window be resized
       
        
       
        
    }
    
    /**
     * Ironman vs Captain America match game
     */
    public void imvscap(){
        frame.setVisible(false);
        frame.removeAll();
        level = 1;
        boolean next = false;
        world = new Level1();
        
        world.populate(this);
        frame = new JFrame("Civil War");
        view = new Background(world,this,i,j);
        view.setBackground(4);
        common();
        
        // receive keyboard events
        imcontroller =new IMController(world.getPlayer1());
        capcontroller = new CapController(world.getPlayer2());
        ironmanAttack = new IronmanAttack(world.getPlayer1(),world.getPlayer2(),this);
        captainAttack = new CaptainAttack(world.getPlayer1(),world.getPlayer2(),this);
        
        frame.addKeyListener(imcontroller); 
        frame.addKeyListener(capcontroller); 
        frame.addKeyListener(ironmanAttack);
        frame.addKeyListener(captainAttack);
    
        world.start();
   } 
   
    /**
     * Hulk vs Thor match game
     */
    public void thorvshulk(){
        frame.setVisible(false);
        frame.removeAll();
        level = 4;
        boolean next = false;
        world = new Level2();
        
        world.populate(this);
        frame = new JFrame("Civil War");
        view = new Background(world,this,i,j);
        view.setBackground(level);
        common();
        
        // receive keyboard events
            hulkcontroller = new HulkController(world.getPlayer2());
            thorcontroller = new ThorController(world.getPlayer1());
            thorAttack = new ThorAttack(world.getPlayer1(),world.getPlayer2(),this);
            hulkAttack = new HulkAttack(world.getPlayer1(),world.getPlayer2(),this);
            
            frame.addKeyListener(hulkcontroller); 
            frame.addKeyListener(thorcontroller); 
            frame.addKeyListener(thorAttack);
            frame.addKeyListener(hulkAttack);
    
        world.start();
   } 
   
    /**
     * Ironman vs Hulk match game
     */
    public void imvshulk(){
        frame.setVisible(false);
        frame.removeAll();
        level = 2;
        boolean next = false;
        world = new Level3();
        
        world.populate(this);
        frame = new JFrame("Civil War");
        view = new Background(world,this,i,j);
        view.setBackground(level);
        common();
        
        // receive keyboard events
          imcontroller =new IMController(world.getPlayer1());
            ironman2Attack = new Ironman2Attack(world.getPlayer1(),world.getPlayer2(),this);
            hulkcontroller = new HulkController(world.getPlayer2());
            hulk2Attack = new Hulk2Attack(world.getPlayer1(),world.getPlayer2(),this);
            
            frame.addKeyListener(imcontroller);
            frame.addKeyListener(ironman2Attack);
            frame.addKeyListener(hulkcontroller);
            frame.addKeyListener(hulk2Attack);   
    
        world.start();
   } 
    
    /**
     * Thor vs Captain America match game
     */
    public void thorvscap(){
        frame.setVisible(false);
        frame.removeAll();
        level = 3;
        boolean next = false;
        world = new Level4();
        
        world.populate(this);
        frame = new JFrame("Civil War");
        view = new Background(world,this,i,j);
        //view.setBackground(level);
        common();
        
        // receive keyboard events
          thorcontroller = new ThorController(world.getPlayer1());
            thor2Attack = new Thor2Attack(world.getPlayer1(),world.getPlayer2(),this);
            capcontroller = new CapController(world.getPlayer2());
            captain2Attack = new Captain2Attack(world.getPlayer1(),world.getPlayer2(),this);
            frame.addKeyListener(thorcontroller);
            frame.addKeyListener(thor2Attack);
            frame.addKeyListener(capcontroller);      
            frame.addKeyListener(captain2Attack);
            
        world.start();
   }
    
    /**
     *Menu  JPanel connector
     */
    public void openpanel(){
        frame.setVisible(false);
        frame.removeAll();
           try {
             logo=ImageIO.read(new File("data/Logo.png"));
         } catch (IOException ex) {
             Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
         }
        sound();
        
        ip = new Menu(this);
       
        // display the view in a frame
        frame = new JFrame("Civil War");

        //  Logo for titlebar
        frame.setIconImage(logo);
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.getContentPane().add(ip);
       // frame.add(view);
        
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        
        // make the window visiblew
        frame.setVisible(true);
   }
   
    /**
     * CheatCode activator
     * @param a
     * @param b
     */
    public void cheat( int a, int b){
            p1win = a;
           p2win = b;
           level = 4;
           goNextLevel();
           
   }

    /**
     * Login JPanel connector
     */
    public void login(){
       frame.setVisible(false);
       frame.removeAll();
       ln=  new Login(this); 
       try {
             logo=ImageIO.read(new File("data/Logo.png"));
         } catch (IOException ex) {
             Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
         }
       frame = new JFrame("Civil War");
        //  Logo for titlebar
        frame.setIconImage(logo);
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(false);
     
         frame.getContentPane().add(ln);
        
       // size the game window to fit the world view
         frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        
        frame.requestFocus();
        // make the window visiblew
        frame.setVisible(true);
    
}
    
    /**
     * Starts sound for menu
     */
    public void sound(){
        try {
          sp = new SoundClip("data/theme.wav");
          sp.loop();
          sp.play();
          }catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }   
    }

    /**
     * Stops sound
     */
    public void stopsound(){
        sp.close();
    }
    
    /**
     * Password reset
     * @param password
     */
    public void reset(String password){
        this.password = password;
    }
    
    /**
     * it connects loading to jframe
     */
    public void loading(){
        
         frame.setVisible(false);
        frame.removeAll();
         try {
             logo=ImageIO.read(new File("data/Logo.png"));
         } catch (IOException ex) {
             Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
         }
        Loading l = new Loading(this);
        
       
        // display the view in a frame
        frame = new JFrame("Civil War");

        //  Logo for titlebar
        frame.setIconImage(logo);
        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.getContentPane().add(l);
       // frame.add(view);
        
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        
        // make the window visiblew
        frame.setVisible(true);
        
    }
   
    /** Run the Game.
     * @param args */
    public static void main(String[] args)  {
        
         Game game = new Game();
        
        
    }
}
