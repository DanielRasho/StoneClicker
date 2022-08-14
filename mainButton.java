import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class mainButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class mainButton extends Button
{
    /**
     * Act - do whatever the mainButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    Counter humansRevived = new Counter();
    
    public mainButton(){
        this.humansRevived.add(1);
    }
    
    @Override
    protected void addedToWorld(World world){
        world.addObject(this.humansRevived, 250, 50);
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            this.humansRevived.add(1);
        }
    }
}
