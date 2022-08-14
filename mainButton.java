import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

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
    
    Counter humansRevivedCounter = new Counter();
    Counter energyCounter = new Counter();
    int frameCounter = 0;
    int populationBonus = 0;
    int numUpgrades = 1;
    
    public mainButton(){
        this.humansRevivedCounter.setValue(1);
        this.energyCounter.setValue(1);
    }
    
    @Override
    protected void addedToWorld(World world){
        world.addObject(this.humansRevivedCounter, 250, 50);
        world.addObject(this.energyCounter, 250, 120);
    }

    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            this.humansRevivedCounter.add(1);
        }
        if(frameCounter < 29){
            frameCounter ++;
        }
        else{
            frameCounter = 0;
            calculateEnergy();
            calculatePopulation();
        }
    }
    
    public void calculateEnergy(){
        double newEnergy = ((humansRevivedCounter.getValue()*5)/100)
        + energyCounter.getValue();
        energyCounter.setValue((int) Math.floor(newEnergy));
    }
    
    public void calculatePopulation(){
        int populationBonus = numUpgrades * 2;
        humansRevivedCounter.add(populationBonus);
    }
}
