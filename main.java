import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main extends World
{

    /**
     * Constructor for objects of class main.
     * 
     */
    public main()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 700, 1);
        prepare();
    }
    
    private void prepare()
    {
        mainButton mainButton = new mainButton();
        addObject(mainButton,300,100);
        mainButton.setLocation(385,321);
        exitButton exitButton = new exitButton();
        addObject(exitButton,655,39);
        helpButton helpButton = new helpButton();
        addObject(helpButton,655,656);
        mainButton.setLocation(374,347);
        Counter counter = new Counter();
        addObject(counter, 250, 50);
    }
}
