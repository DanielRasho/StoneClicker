import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class helpButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class helpButton extends Button
{
    HelpMessage message = new HelpMessage();
    
    /**
     * If the mouse hover on this button it will show a help message in the
     * middle of the screen.
     */
    public void act()
    {
        if (Greenfoot.mouseMoved(this))
            this.getWorld().addObject(message, 350, 350);
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this))
            this.getWorld().removeObject(message);
    }
}
