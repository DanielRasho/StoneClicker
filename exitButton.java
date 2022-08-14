import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class exitButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class exitButton extends Button
{
    /**
    * If pressed it will stop game execution.
    */
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            stopGameScreen world = new stopGameScreen();
            Greenfoot.setWorld(world);
            Greenfoot.stop();
        }
    }
}
