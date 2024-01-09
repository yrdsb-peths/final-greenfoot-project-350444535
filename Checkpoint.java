import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Checkpoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Checkpoint extends Actor
{
    /**
     * Act - do whatever the Checkpoint wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] activating = new GreenfootImage[26];
    SimpleTimer activatingTimer = new SimpleTimer();
    int activatingimageIndex = 0;
    GreenfootImage[] activated = new GreenfootImage[10];
    SimpleTimer activatedTimer = new SimpleTimer();
    int activatedImageIndex = 0;
    int checkpointVarX = 0;
    int checkpointVarY = 0;
    int checkpointVarZ = 0;
    public Checkpoint()
    {
        for(int y = 0; y < activating.length; y++)
        {
            activating[y] = new GreenfootImage("images/Checkpoint-AG/AG" + y + ".png");
        }
        activatingTimer.mark();
        
        for(int z = 0; z < activated.length; z++)
        {
            activated[z] = new GreenfootImage("images/Checkpoint-AD/AD" + z + ".png");
        }
        activatedTimer.mark();
    }
    public void animateActivating()
    {
        if(checkpointVarY == 0)
        {
            if(activatingTimer.millisElapsed() < 60)
            {
                return;
            }
            activatingTimer.mark();
            setImage(activating[activatingimageIndex]);
            activatingimageIndex = (activatingimageIndex + 1) % activating.length;
            checkpointVarZ++;
            if(checkpointVarZ >= 25)
            {
                checkpointVarY++;
            }
        }
        if(checkpointVarY >= 1)
        {
            if(activatedTimer.millisElapsed() < 60)
            {
                return;
            }
            activatedTimer.mark();
            setImage(activated[activatedImageIndex]);
            activatedImageIndex = (activatedImageIndex + 1) % activated.length;
        }
    }
    public void act()
    {
        // Add your action code here.
        if(isTouching(playerCharacter.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            checkpointVarX++;
        }
    
        if(checkpointVarX >= 1)
        {
            animateActivating();
        }
    }
}
