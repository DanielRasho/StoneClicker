import greenfoot.*;
import java.lang.Math;

public class mainButton extends Button
{
    UpgradeButton upgradeButton = new UpgradeButton();
    Counter humansRevivedCounter = new Counter();
    Counter energyCounter = new Counter();
    int frameCounter = 0;
    int populationBonus = 0;
    int autoAddSpeed = 29;
    int clickValue = 1;
    
    /** mainButton - instantiate mainButton object which carrie out the count
     * for every click and upgrade made.
     */
    public mainButton(){
        this.humansRevivedCounter.setValue(1);
        this.energyCounter.setValue(1);
    }
    
    /**
     * Recalculate the value of counters, check if button has been pressed or
     * if an upgrade was bought.
     */
        public void act()
    {
        isClicked();
        hasUpgraded();
        autoAdd();
        isUpgradeAvailable();
    }
    
    /**
     * addedToWorld - create counters for population revived, energy and 
     * and an upgrade Button within the given world.
     */
    @Override
    protected void addedToWorld(World world){
        world.addObject(this.humansRevivedCounter, 250, 50);
        world.addObject(this.energyCounter, 250, 120);
        world.addObject(this.upgradeButton,370,630);
    }
    
    /**
     * Checks if the object has been pressed and adds to the population counter.
     */
    private void isClicked(){
        if(Greenfoot.mousePressed(this)){
            this.humansRevivedCounter.add(this.clickValue);
            this.setImage("EarthClicked.png");
        }
        else{
            this.setImage("Earth.png");
        }
    }
    
    /**
     * Checks if the player has attempted to buy and upgrade and if it has the right
     * energy it will increase the number of upgrades by one and the clickValue by
     * 5.
     */    
    private void hasUpgraded(){
        if(Greenfoot.mouseClicked(this.upgradeButton) 
            && this.upgradeButton.getActivated()){
    
            upgradeButton.buyUpgrade(this);
            this.clickValue += 5;
        }
    }
    
    /** Sets the new "energyCounter" value based on the amount of humans
     * revived. Increasing its value adding a 5% of the total humans revived
     * each time it is called.
     */
    public void calculateEnergy(){
        double newEnergy = ((humansRevivedCounter.getValue()*5)/100)
        + energyCounter.getValue();
        energyCounter.setValue((int) Math.floor(newEnergy));
    }
    
    /** Sets the new "humansRevivedValue" attribute value based on the number of
     * upgrades the player has bought with energy.
     */
    public void calculatePopulation(){
        int populationBonus = 2 * this.upgradeButton.getNumUpgrades() ;
        humansRevivedCounter.add(populationBonus);
    }
    
    /** Reduces "energy" attribute value by the given value.
     */
    public void reduceEnergy(int value){
        this.energyCounter.substract(value);
    }
    
    /**
     * It adds a bonus value to the "energy" and "population" counter every 
     * 30 frames.
     */
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
    
    /**
     * If players has enough energy, it will change the appereance of the
     * upgradeButton.
     */
    public void isUpgradeAvailable(){
        if(this.energyCounter.getValue() >= upgradeButton.getCost()){
            upgradeButton.setActivated(true);
        }
        else{
            this.upgradeButton.setActivated(false);
        }
    }
}
