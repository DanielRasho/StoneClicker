import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

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
    
    /**
     * Adds the cost Counter to the given world.
     */
    @Override
    protected void addedToWorld(World world){
        world.addObject(this.costCounter, this.getX(), this.getY()+10);
    }
    
    /**
     * Increase the number of upgrades by 1. And reduces the Energy counter from
     * the given mainButton object. 
     * Then it calculate the new cost for the next upgrade.
     */
    public void buyUpgrade(mainButton button){
        this.numUpgrades ++;
        button.reduceEnergy(this.cost);
        this.cost = this.cost * (int)(Math.pow(1.15,this.numUpgrades));
        this.costCounter.setValue(this.cost);
    }
    /**
     * Sets "Activated" value.
     */
    public void setActivated(boolean value){
        this.activated = value;
    }
    /**
     * returns "Activated" value;
     */
    public boolean getActivated(){
        return this.activated;
    }
    /**
     * returns "cost" value;
     */
    public int getCost(){
        return this.cost;
    }
    /**
     * returns "NumUpgrades" value;
     */
    public int getNumUpgrades(){
        return this.numUpgrades;
    }
}
