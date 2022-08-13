import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class story here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class story extends World
{

    /**
     * Constructor for objects of class story.
     * 
     */
    public story()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 700, 1);
        prepare();
    }
    private void prepare(){
        listener startButton = new listener("ENTER", new main());
        this.addObject(startButton, 0,0);
    }
}
