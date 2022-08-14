import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class helpButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class helpButton extends Button
{
    /**
     * Act - do whatever the helpButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    HelpMessage message = new HelpMessage();
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
            this.getWorld().addObject(message, 350, 350);
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
            this.getWorld().removeObject(message);
    }
}
