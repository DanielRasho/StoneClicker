import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class imageStart extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public imageStart()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 700, 1);
        prepare();
        playMusic();
    }
    
    private void prepare(){
        listener startButton = new listener("ENTER", new story());
        this.addObject(startButton, 0,0);
    }
    
    private void playMusic(){
        GreenfootSound backgroundMusic = new GreenfootSound("soundtrack.mp3");
        backgroundMusic.playLoop();
    }

}
