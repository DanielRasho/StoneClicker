import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

/**
 * Write a description of class upgradeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UpgradeButton extends Button
{
    int cost = 25;
    int numUpgrades = 0;
    boolean activated = true;
    Counter costCounter = new Counter();
    
    public UpgradeButton(){
        this.costCounter.setValue(this.cost);
    }
    
    public void act()
    {
        if(activated == true){
            this.setImage("upgradeButton.png");
        
        }
        else{
            this.setImage("upgradeButtonOff.png");
        }
    }
    
    @Override
    protected void addedToWorld(World world){
        world.addObject(this.costCounter, this.getX(), this.getY()+10);
    }
    
    public void buyUpgrade(mainButton button){
        this.numUpgrades ++;
        button.reduceEnergy(this.cost);
        this.cost = this.cost * (int)(Math.pow(1.15,this.numUpgrades));
        this.costCounter.setValue(this.cost);
    }
    public void setActivated(boolean value){
        this.activated = value;
    }
    
    public boolean getActivated(){
        return this.activated;
    }
    public int getCost(){
        return this.cost;
    }
    public int getNumUpgrades(){
        return this.numUpgrades;
    }
}
