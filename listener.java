import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class listener here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class listener extends Actor
{
    /**
     * Act - do whatever the listener wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    String key;
    World world;
    
    public listener(String key, World world){
        this.key = key;
        this.world = world;
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown(this.key)){
            Greenfoot.setWorld(world);
        }
    }
}
