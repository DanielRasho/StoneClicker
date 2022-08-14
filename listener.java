import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class listener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class listener extends Actor
{
    
    String key;
    World world;
    
    /** listener - instantiate a listener object, for setting a new world, whenever
     * a given key is pressed.
     */
    public listener(String key, World world){
        this.key = key;
        this.world = world;
    }
    
    /**
     * Act - do whatever the listener wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */  
    public void act()
    {
        if(Greenfoot.isKeyDown(this.key)){
            Greenfoot.setWorld(world);
        }
    }
}
