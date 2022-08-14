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
    
    UpgradeButton upgradeButton = new UpgradeButton();
    Counter humansRevivedCounter = new Counter();
    Counter energyCounter = new Counter();
    int frameCounter = 0;
    int populationBonus = 0;
    int autoAddSpeed = 29;
    int clickValue = 1;
    
    public mainButton(){
        this.humansRevivedCounter.setValue(1);
        this.energyCounter.setValue(1);
    }
    
    @Override
    protected void addedToWorld(World world){
        world.addObject(this.humansRevivedCounter, 250, 50);
        world.addObject(this.energyCounter, 250, 120);
        world.addObject(this.energyCounter, 250, 120);
        world.addObject(this.upgradeButton,370,630);
    }

    public void act()
    {
        isClicked();
        hasUpgraded();
        autoAdd();
        isUpgradeAvailable();
    }
    
    private void isClicked(){
        if(Greenfoot.mousePressed(this)){
            this.humansRevivedCounter.add(this.clickValue);
            this.setImage("EarthClicked.png");
        }
        else{
            this.setImage("Earth.png");
        }
    }
    
    private void hasUpgraded(){
        if(Greenfoot.mouseClicked(this.upgradeButton) 
            && this.upgradeButton.getActivated()){
    
            upgradeButton.buyUpgrade(this);
            this.clickValue += 5;
        }
    }
    
    public void calculateEnergy(){
        double newEnergy = ((humansRevivedCounter.getValue()*5)/100)
        + energyCounter.getValue();
        energyCounter.setValue((int) Math.floor(newEnergy));
    }
    
    public void calculatePopulation(){
        int populationBonus = 2 * this.upgradeButton.getNumUpgrades() ;
        humansRevivedCounter.add(populationBonus);
    }
    
    public void reduceEnergy(int value){
        this.energyCounter.substract(value);
    }
    
    public void autoAdd(){
        if(this.frameCounter < this.autoAddSpeed){
            this.frameCounter ++;
        }
        else{
            this.frameCounter = 0;
            calculateEnergy();
            calculatePopulation();
        }
    }
    
    public void isUpgradeAvailable(){
        if(this.energyCounter.getValue() >= upgradeButton.getCost()){
            upgradeButton.setActivated(true);
        }
        else{
            this.upgradeButton.setActivated(false);
        }
    }
}
